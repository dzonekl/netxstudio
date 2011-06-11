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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-'", "'+'", "'false'", "'count()'", "'sum()'", "'min()'", "'max()'", "'mean()'", "'deviation()'", "'mod'", "'import'", "'def'", "'('", "')'", "','", "'{'", "'}'", "';'", "'return'", "'if'", "'else'", "'while'", "'var'", "'='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'*'", "'/'", "'%'", "'['", "']'", "'.'", "'this'", "'->'", "'Res'", "'Link'", "'!'", "'true'"
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


    // $ANTLR start "entryRuleNumberLiteral"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:683:1: entryRuleNumberLiteral : ruleNumberLiteral EOF ;
    public final void entryRuleNumberLiteral() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:684:1: ( ruleNumberLiteral EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:685:1: ruleNumberLiteral EOF
            {
             before(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1386);
            ruleNumberLiteral();

            state._fsp--;

             after(grammarAccess.getNumberLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral1393); 

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
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:692:1: ruleNumberLiteral : ( ( rule__NumberLiteral__Group__0 ) ) ;
    public final void ruleNumberLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:696:2: ( ( ( rule__NumberLiteral__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:697:1: ( ( rule__NumberLiteral__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:697:1: ( ( rule__NumberLiteral__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:698:1: ( rule__NumberLiteral__Group__0 )
            {
             before(grammarAccess.getNumberLiteralAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:699:1: ( rule__NumberLiteral__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:699:2: rule__NumberLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Group__0_in_ruleNumberLiteral1419);
            rule__NumberLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:711:1: entryRuleParenthesizedExpression : ruleParenthesizedExpression EOF ;
    public final void entryRuleParenthesizedExpression() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:712:1: ( ruleParenthesizedExpression EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:713:1: ruleParenthesizedExpression EOF
            {
             before(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1446);
            ruleParenthesizedExpression();

            state._fsp--;

             after(grammarAccess.getParenthesizedExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression1453); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:720:1: ruleParenthesizedExpression : ( ( rule__ParenthesizedExpression__Group__0 ) ) ;
    public final void ruleParenthesizedExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:724:2: ( ( ( rule__ParenthesizedExpression__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:725:1: ( ( rule__ParenthesizedExpression__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:725:1: ( ( rule__ParenthesizedExpression__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:726:1: ( rule__ParenthesizedExpression__Group__0 )
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:727:1: ( rule__ParenthesizedExpression__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:727:2: rule__ParenthesizedExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0_in_ruleParenthesizedExpression1479);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:739:1: entryRuleFunctionCall : ruleFunctionCall EOF ;
    public final void entryRuleFunctionCall() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:740:1: ( ruleFunctionCall EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:741:1: ruleFunctionCall EOF
            {
             before(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall1506);
            ruleFunctionCall();

            state._fsp--;

             after(grammarAccess.getFunctionCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall1513); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:748:1: ruleFunctionCall : ( ( rule__FunctionCall__Group__0 ) ) ;
    public final void ruleFunctionCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:752:2: ( ( ( rule__FunctionCall__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:753:1: ( ( rule__FunctionCall__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:753:1: ( ( rule__FunctionCall__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:754:1: ( rule__FunctionCall__Group__0 )
            {
             before(grammarAccess.getFunctionCallAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:755:1: ( rule__FunctionCall__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:755:2: rule__FunctionCall__Group__0
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__0_in_ruleFunctionCall1539);
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


    // $ANTLR start "entryRuleIndexedCall"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:767:1: entryRuleIndexedCall : ruleIndexedCall EOF ;
    public final void entryRuleIndexedCall() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:768:1: ( ruleIndexedCall EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:769:1: ruleIndexedCall EOF
            {
             before(grammarAccess.getIndexedCallRule()); 
            pushFollow(FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall1566);
            ruleIndexedCall();

            state._fsp--;

             after(grammarAccess.getIndexedCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexedCall1573); 

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
    // $ANTLR end "entryRuleIndexedCall"


    // $ANTLR start "ruleIndexedCall"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:776:1: ruleIndexedCall : ( ( rule__IndexedCall__Group__0 ) ) ;
    public final void ruleIndexedCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:780:2: ( ( ( rule__IndexedCall__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:781:1: ( ( rule__IndexedCall__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:781:1: ( ( rule__IndexedCall__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:782:1: ( rule__IndexedCall__Group__0 )
            {
             before(grammarAccess.getIndexedCallAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:783:1: ( rule__IndexedCall__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:783:2: rule__IndexedCall__Group__0
            {
            pushFollow(FOLLOW_rule__IndexedCall__Group__0_in_ruleIndexedCall1599);
            rule__IndexedCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIndexedCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIndexedCall"


    // $ANTLR start "entryRuleVarOrArgumentCall"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:795:1: entryRuleVarOrArgumentCall : ruleVarOrArgumentCall EOF ;
    public final void entryRuleVarOrArgumentCall() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:796:1: ( ruleVarOrArgumentCall EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:797:1: ruleVarOrArgumentCall EOF
            {
             before(grammarAccess.getVarOrArgumentCallRule()); 
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall1626);
            ruleVarOrArgumentCall();

            state._fsp--;

             after(grammarAccess.getVarOrArgumentCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarOrArgumentCall1633); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:804:1: ruleVarOrArgumentCall : ( ( rule__VarOrArgumentCall__Group__0 ) ) ;
    public final void ruleVarOrArgumentCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:808:2: ( ( ( rule__VarOrArgumentCall__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:809:1: ( ( rule__VarOrArgumentCall__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:809:1: ( ( rule__VarOrArgumentCall__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:810:1: ( rule__VarOrArgumentCall__Group__0 )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:811:1: ( rule__VarOrArgumentCall__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:811:2: rule__VarOrArgumentCall__Group__0
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__0_in_ruleVarOrArgumentCall1659);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:823:1: entryRuleNativeExpression : ruleNativeExpression EOF ;
    public final void entryRuleNativeExpression() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:824:1: ( ruleNativeExpression EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:825:1: ruleNativeExpression EOF
            {
             before(grammarAccess.getNativeExpressionRule()); 
            pushFollow(FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression1686);
            ruleNativeExpression();

            state._fsp--;

             after(grammarAccess.getNativeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNativeExpression1693); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:832:1: ruleNativeExpression : ( ( rule__NativeExpression__Group__0 ) ) ;
    public final void ruleNativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:836:2: ( ( ( rule__NativeExpression__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:837:1: ( ( rule__NativeExpression__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:837:1: ( ( rule__NativeExpression__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:838:1: ( rule__NativeExpression__Group__0 )
            {
             before(grammarAccess.getNativeExpressionAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:839:1: ( rule__NativeExpression__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:839:2: rule__NativeExpression__Group__0
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__0_in_ruleNativeExpression1719);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:851:1: entryRuleRange : ruleRange EOF ;
    public final void entryRuleRange() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:852:1: ( ruleRange EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:853:1: ruleRange EOF
            {
             before(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange1746);
            ruleRange();

            state._fsp--;

             after(grammarAccess.getRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange1753); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:860:1: ruleRange : ( ruleRangeLiteral ) ;
    public final void ruleRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:864:2: ( ( ruleRangeLiteral ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:865:1: ( ruleRangeLiteral )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:865:1: ( ruleRangeLiteral )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:866:1: ruleRangeLiteral
            {
             before(grammarAccess.getRangeAccess().getRangeLiteralParserRuleCall()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_ruleRange1779);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:879:1: entryRuleRangeLiteral : ruleRangeLiteral EOF ;
    public final void entryRuleRangeLiteral() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:880:1: ( ruleRangeLiteral EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:881:1: ruleRangeLiteral EOF
            {
             before(grammarAccess.getRangeLiteralRule()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral1805);
            ruleRangeLiteral();

            state._fsp--;

             after(grammarAccess.getRangeLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeLiteral1812); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:888:1: ruleRangeLiteral : ( ( rule__RangeLiteral__Group__0 ) ) ;
    public final void ruleRangeLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:892:2: ( ( ( rule__RangeLiteral__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:893:1: ( ( rule__RangeLiteral__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:893:1: ( ( rule__RangeLiteral__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:894:1: ( rule__RangeLiteral__Group__0 )
            {
             before(grammarAccess.getRangeLiteralAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:895:1: ( rule__RangeLiteral__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:895:2: rule__RangeLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__0_in_ruleRangeLiteral1838);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:907:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:908:1: ( ruleReference EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:909:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1865);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1872); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:916:1: ruleReference : ( ruleContextRef ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:920:2: ( ( ruleContextRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:921:1: ( ruleContextRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:921:1: ( ruleContextRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:922:1: ruleContextRef
            {
             before(grammarAccess.getReferenceAccess().getContextRefParserRuleCall()); 
            pushFollow(FOLLOW_ruleContextRef_in_ruleReference1898);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:935:1: entryRuleContextRef : ruleContextRef EOF ;
    public final void entryRuleContextRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:936:1: ( ruleContextRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:937:1: ruleContextRef EOF
            {
             before(grammarAccess.getContextRefRule()); 
            pushFollow(FOLLOW_ruleContextRef_in_entryRuleContextRef1924);
            ruleContextRef();

            state._fsp--;

             after(grammarAccess.getContextRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextRef1931); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:944:1: ruleContextRef : ( ( rule__ContextRef__Group__0 ) ) ;
    public final void ruleContextRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:948:2: ( ( ( rule__ContextRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:949:1: ( ( rule__ContextRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:949:1: ( ( rule__ContextRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:950:1: ( rule__ContextRef__Group__0 )
            {
             before(grammarAccess.getContextRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:951:1: ( rule__ContextRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:951:2: rule__ContextRef__Group__0
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__0_in_ruleContextRef1957);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:963:1: entryRuleNodeRef : ruleNodeRef EOF ;
    public final void entryRuleNodeRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:964:1: ( ruleNodeRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:965:1: ruleNodeRef EOF
            {
             before(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef1984);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef1991); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:972:1: ruleNodeRef : ( ( rule__NodeRef__Group__0 ) ) ;
    public final void ruleNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:976:2: ( ( ( rule__NodeRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:977:1: ( ( rule__NodeRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:977:1: ( ( rule__NodeRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:978:1: ( rule__NodeRef__Group__0 )
            {
             before(grammarAccess.getNodeRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:979:1: ( rule__NodeRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:979:2: rule__NodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef2017);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:991:1: entryRulePrimaryNodeRef : rulePrimaryNodeRef EOF ;
    public final void entryRulePrimaryNodeRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:992:1: ( rulePrimaryNodeRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:993:1: rulePrimaryNodeRef EOF
            {
             before(grammarAccess.getPrimaryNodeRefRule()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef2044);
            rulePrimaryNodeRef();

            state._fsp--;

             after(grammarAccess.getPrimaryNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryNodeRef2051); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1000:1: rulePrimaryNodeRef : ( ( rule__PrimaryNodeRef__Group__0 ) ) ;
    public final void rulePrimaryNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1004:2: ( ( ( rule__PrimaryNodeRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1005:1: ( ( rule__PrimaryNodeRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1005:1: ( ( rule__PrimaryNodeRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1006:1: ( rule__PrimaryNodeRef__Group__0 )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1007:1: ( rule__PrimaryNodeRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1007:2: rule__PrimaryNodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__0_in_rulePrimaryNodeRef2077);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1019:1: entryRuleLeafRef : ruleLeafRef EOF ;
    public final void entryRuleLeafRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1020:1: ( ruleLeafRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1021:1: ruleLeafRef EOF
            {
             before(grammarAccess.getLeafRefRule()); 
            pushFollow(FOLLOW_ruleLeafRef_in_entryRuleLeafRef2104);
            ruleLeafRef();

            state._fsp--;

             after(grammarAccess.getLeafRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLeafRef2111); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1028:1: ruleLeafRef : ( ( rule__LeafRef__Alternatives ) ) ;
    public final void ruleLeafRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1032:2: ( ( ( rule__LeafRef__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1033:1: ( ( rule__LeafRef__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1033:1: ( ( rule__LeafRef__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1034:1: ( rule__LeafRef__Alternatives )
            {
             before(grammarAccess.getLeafRefAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1035:1: ( rule__LeafRef__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1035:2: rule__LeafRef__Alternatives
            {
            pushFollow(FOLLOW_rule__LeafRef__Alternatives_in_ruleLeafRef2137);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1047:1: entryRuleResourceRef : ruleResourceRef EOF ;
    public final void entryRuleResourceRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1048:1: ( ruleResourceRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1049:1: ruleResourceRef EOF
            {
             before(grammarAccess.getResourceRefRule()); 
            pushFollow(FOLLOW_ruleResourceRef_in_entryRuleResourceRef2164);
            ruleResourceRef();

            state._fsp--;

             after(grammarAccess.getResourceRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceRef2171); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1056:1: ruleResourceRef : ( ( rule__ResourceRef__Group__0 ) ) ;
    public final void ruleResourceRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1060:2: ( ( ( rule__ResourceRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1061:1: ( ( rule__ResourceRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1061:1: ( ( rule__ResourceRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1062:1: ( rule__ResourceRef__Group__0 )
            {
             before(grammarAccess.getResourceRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1063:1: ( rule__ResourceRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1063:2: rule__ResourceRef__Group__0
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__0_in_ruleResourceRef2197);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1075:1: entryRuleLinkRef : ruleLinkRef EOF ;
    public final void entryRuleLinkRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1076:1: ( ruleLinkRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1077:1: ruleLinkRef EOF
            {
             before(grammarAccess.getLinkRefRule()); 
            pushFollow(FOLLOW_ruleLinkRef_in_entryRuleLinkRef2224);
            ruleLinkRef();

            state._fsp--;

             after(grammarAccess.getLinkRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkRef2231); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1084:1: ruleLinkRef : ( ( rule__LinkRef__Group__0 ) ) ;
    public final void ruleLinkRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1088:2: ( ( ( rule__LinkRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1089:1: ( ( rule__LinkRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1089:1: ( ( rule__LinkRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1090:1: ( rule__LinkRef__Group__0 )
            {
             before(grammarAccess.getLinkRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1091:1: ( rule__LinkRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1091:2: rule__LinkRef__Group__0
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__0_in_ruleLinkRef2257);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1104:1: ruleNativeFunction : ( ( rule__NativeFunction__Alternatives ) ) ;
    public final void ruleNativeFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1108:1: ( ( ( rule__NativeFunction__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1109:1: ( ( rule__NativeFunction__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1109:1: ( ( rule__NativeFunction__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1110:1: ( rule__NativeFunction__Alternatives )
            {
             before(grammarAccess.getNativeFunctionAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1111:1: ( rule__NativeFunction__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1111:2: rule__NativeFunction__Alternatives
            {
            pushFollow(FOLLOW_rule__NativeFunction__Alternatives_in_ruleNativeFunction2294);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1122:1: rule__Mod__Alternatives_2 : ( ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) ) | ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) ) );
    public final void rule__Mod__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1126:1: ( ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) ) | ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==23) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID||LA3_0==RULE_NUMBER||(LA3_0>=12 && LA3_0<=14)||LA3_0==24||LA3_0==27||(LA3_0>=30 && LA3_0<=31)||(LA3_0>=33 && LA3_0<=34)||LA3_0==47||LA3_0==50||(LA3_0>=54 && LA3_0<=55)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1127:1: ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1127:1: ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1128:1: ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1128:1: ( ( rule__Mod__FunctionsAssignment_2_0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1129:1: ( rule__Mod__FunctionsAssignment_2_0 )
                    {
                     before(grammarAccess.getModAccess().getFunctionsAssignment_2_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1130:1: ( rule__Mod__FunctionsAssignment_2_0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1130:2: rule__Mod__FunctionsAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22331);
                    rule__Mod__FunctionsAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModAccess().getFunctionsAssignment_2_0()); 

                    }

                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1133:1: ( ( rule__Mod__FunctionsAssignment_2_0 )* )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1134:1: ( rule__Mod__FunctionsAssignment_2_0 )*
                    {
                     before(grammarAccess.getModAccess().getFunctionsAssignment_2_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1135:1: ( rule__Mod__FunctionsAssignment_2_0 )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==23) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1135:2: rule__Mod__FunctionsAssignment_2_0
                    	    {
                    	    pushFollow(FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22343);
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1140:6: ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1140:6: ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1141:1: ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1141:1: ( ( rule__Mod__StatementsAssignment_2_1 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1142:1: ( rule__Mod__StatementsAssignment_2_1 )
                    {
                     before(grammarAccess.getModAccess().getStatementsAssignment_2_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1143:1: ( rule__Mod__StatementsAssignment_2_1 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1143:2: rule__Mod__StatementsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22366);
                    rule__Mod__StatementsAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModAccess().getStatementsAssignment_2_1()); 

                    }

                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1146:1: ( ( rule__Mod__StatementsAssignment_2_1 )* )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1147:1: ( rule__Mod__StatementsAssignment_2_1 )*
                    {
                     before(grammarAccess.getModAccess().getStatementsAssignment_2_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1148:1: ( rule__Mod__StatementsAssignment_2_1 )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==RULE_NUMBER||(LA2_0>=12 && LA2_0<=14)||LA2_0==24||LA2_0==27||(LA2_0>=30 && LA2_0<=31)||(LA2_0>=33 && LA2_0<=34)||LA2_0==47||LA2_0==50||(LA2_0>=54 && LA2_0<=55)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1148:2: rule__Mod__StatementsAssignment_2_1
                    	    {
                    	    pushFollow(FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22378);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1159:1: rule__Statement__Alternatives : ( ( ( rule__Statement__Group_0__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleBlock ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1163:1: ( ( ( rule__Statement__Group_0__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleBlock ) )
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
            case 47:
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1164:1: ( ( rule__Statement__Group_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1164:1: ( ( rule__Statement__Group_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1165:1: ( rule__Statement__Group_0__0 )
                    {
                     before(grammarAccess.getStatementAccess().getGroup_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1166:1: ( rule__Statement__Group_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1166:2: rule__Statement__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Statement__Group_0__0_in_rule__Statement__Alternatives2415);
                    rule__Statement__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatementAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1170:6: ( ruleIfStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1170:6: ( ruleIfStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1171:1: ruleIfStatement
                    {
                     before(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIfStatement_in_rule__Statement__Alternatives2433);
                    ruleIfStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1176:6: ( ruleWhileStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1176:6: ( ruleWhileStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1177:1: ruleWhileStatement
                    {
                     before(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleWhileStatement_in_rule__Statement__Alternatives2450);
                    ruleWhileStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1182:6: ( ruleBlock )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1182:6: ( ruleBlock )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1183:1: ruleBlock
                    {
                     before(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleBlock_in_rule__Statement__Alternatives2467);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1193:1: rule__Statement__Alternatives_0_0 : ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) );
    public final void rule__Statement__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1197:1: ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) )
            int alt5=5;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1198:1: ( ruleVariableStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1198:1: ( ruleVariableStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1199:1: ruleVariableStatement
                    {
                     before(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 
                    pushFollow(FOLLOW_ruleVariableStatement_in_rule__Statement__Alternatives_0_02499);
                    ruleVariableStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1204:6: ( ruleAssignmentStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1204:6: ( ruleAssignmentStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1205:1: ruleAssignmentStatement
                    {
                     before(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 
                    pushFollow(FOLLOW_ruleAssignmentStatement_in_rule__Statement__Alternatives_0_02516);
                    ruleAssignmentStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1210:6: ( ruleReferenceAssignmentStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1210:6: ( ruleReferenceAssignmentStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1211:1: ruleReferenceAssignmentStatement
                    {
                     before(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 
                    pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_rule__Statement__Alternatives_0_02533);
                    ruleReferenceAssignmentStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1216:6: ( ( rule__Statement__ExpressionAssignment_0_0_3 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1216:6: ( ( rule__Statement__ExpressionAssignment_0_0_3 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1217:1: ( rule__Statement__ExpressionAssignment_0_0_3 )
                    {
                     before(grammarAccess.getStatementAccess().getExpressionAssignment_0_0_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1218:1: ( rule__Statement__ExpressionAssignment_0_0_3 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1218:2: rule__Statement__ExpressionAssignment_0_0_3
                    {
                    pushFollow(FOLLOW_rule__Statement__ExpressionAssignment_0_0_3_in_rule__Statement__Alternatives_0_02550);
                    rule__Statement__ExpressionAssignment_0_0_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatementAccess().getExpressionAssignment_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1222:6: ( ruleReturnStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1222:6: ( ruleReturnStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1223:1: ruleReturnStatement
                    {
                     before(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_4()); 
                    pushFollow(FOLLOW_ruleReturnStatement_in_rule__Statement__Alternatives_0_02568);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1233:1: rule__Logical__Alternatives_1_0 : ( ( ( rule__Logical__Group_1_0_0__0 ) ) | ( ( rule__Logical__Group_1_0_1__0 ) ) );
    public final void rule__Logical__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1237:1: ( ( ( rule__Logical__Group_1_0_0__0 ) ) | ( ( rule__Logical__Group_1_0_1__0 ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1238:1: ( ( rule__Logical__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1238:1: ( ( rule__Logical__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1239:1: ( rule__Logical__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getLogicalAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1240:1: ( rule__Logical__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1240:2: rule__Logical__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Logical__Group_1_0_0__0_in_rule__Logical__Alternatives_1_02600);
                    rule__Logical__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLogicalAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1244:6: ( ( rule__Logical__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1244:6: ( ( rule__Logical__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1245:1: ( rule__Logical__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getLogicalAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1246:1: ( rule__Logical__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1246:2: rule__Logical__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Logical__Group_1_0_1__0_in_rule__Logical__Alternatives_1_02618);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1255:1: rule__Equality__Alternatives_1_0 : ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) );
    public final void rule__Equality__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1259:1: ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1260:1: ( ( rule__Equality__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1260:1: ( ( rule__Equality__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1261:1: ( rule__Equality__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1262:1: ( rule__Equality__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1262:2: rule__Equality__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Equality__Group_1_0_0__0_in_rule__Equality__Alternatives_1_02651);
                    rule__Equality__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1266:6: ( ( rule__Equality__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1266:6: ( ( rule__Equality__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1267:1: ( rule__Equality__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getEqualityAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1268:1: ( rule__Equality__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1268:2: rule__Equality__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Equality__Group_1_0_1__0_in_rule__Equality__Alternatives_1_02669);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1277:1: rule__Comparison__Alternatives_1_0 : ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) );
    public final void rule__Comparison__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1281:1: ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1282:1: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1282:1: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1283:1: ( rule__Comparison__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1284:1: ( rule__Comparison__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1284:2: rule__Comparison__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__0_in_rule__Comparison__Alternatives_1_02702);
                    rule__Comparison__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1288:6: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1288:6: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1289:1: ( rule__Comparison__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1290:1: ( rule__Comparison__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1290:2: rule__Comparison__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__0_in_rule__Comparison__Alternatives_1_02720);
                    rule__Comparison__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1294:6: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1294:6: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1295:1: ( rule__Comparison__Group_1_0_2__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1296:1: ( rule__Comparison__Group_1_0_2__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1296:2: rule__Comparison__Group_1_0_2__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__0_in_rule__Comparison__Alternatives_1_02738);
                    rule__Comparison__Group_1_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1300:6: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1300:6: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1301:1: ( rule__Comparison__Group_1_0_3__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1302:1: ( rule__Comparison__Group_1_0_3__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1302:2: rule__Comparison__Group_1_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__0_in_rule__Comparison__Alternatives_1_02756);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1311:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1315:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1316:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1316:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1317:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1318:1: ( rule__Addition__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1318:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_02789);
                    rule__Addition__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1322:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1322:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1323:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1324:1: ( rule__Addition__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1324:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_02807);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1333:1: rule__Multiplication__Alternatives_1_0 : ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) | ( ( rule__Multiplication__Group_1_0_2__0 ) ) );
    public final void rule__Multiplication__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1337:1: ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) | ( ( rule__Multiplication__Group_1_0_2__0 ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1338:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1338:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1339:1: ( rule__Multiplication__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1340:1: ( rule__Multiplication__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1340:2: rule__Multiplication__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_02840);
                    rule__Multiplication__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1344:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1344:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1345:1: ( rule__Multiplication__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1346:1: ( rule__Multiplication__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1346:2: rule__Multiplication__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_02858);
                    rule__Multiplication__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1350:6: ( ( rule__Multiplication__Group_1_0_2__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1350:6: ( ( rule__Multiplication__Group_1_0_2__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1351:1: ( rule__Multiplication__Group_1_0_2__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1352:1: ( rule__Multiplication__Group_1_0_2__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1352:2: rule__Multiplication__Group_1_0_2__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__0_in_rule__Multiplication__Alternatives_1_02876);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1361:1: rule__Unary__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__Unary__Group_1__0 ) ) );
    public final void rule__Unary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1365:1: ( ( rulePrimaryExpression ) | ( ( rule__Unary__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==RULE_NUMBER||LA11_0==14||LA11_0==24||LA11_0==47||LA11_0==50||LA11_0==55) ) {
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1366:1: ( rulePrimaryExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1366:1: ( rulePrimaryExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1367:1: rulePrimaryExpression
                    {
                     before(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Unary__Alternatives2909);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1372:6: ( ( rule__Unary__Group_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1372:6: ( ( rule__Unary__Group_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1373:1: ( rule__Unary__Group_1__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1374:1: ( rule__Unary__Group_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1374:2: rule__Unary__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1__0_in_rule__Unary__Alternatives2926);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1383:1: rule__Unary__Alternatives_1_0 : ( ( ( rule__Unary__Group_1_0_0__0 ) ) | ( ( rule__Unary__Group_1_0_1__0 ) ) );
    public final void rule__Unary__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1387:1: ( ( ( rule__Unary__Group_1_0_0__0 ) ) | ( ( rule__Unary__Group_1_0_1__0 ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1388:1: ( ( rule__Unary__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1388:1: ( ( rule__Unary__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1389:1: ( rule__Unary__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1390:1: ( rule__Unary__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1390:2: rule__Unary__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1_0_0__0_in_rule__Unary__Alternatives_1_02959);
                    rule__Unary__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1394:6: ( ( rule__Unary__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1394:6: ( ( rule__Unary__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1395:1: ( rule__Unary__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1396:1: ( rule__Unary__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1396:2: rule__Unary__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1_0_1__0_in_rule__Unary__Alternatives_1_02977);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1405:1: rule__UnaryOperator__Alternatives : ( ( '-' ) | ( '+' ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1409:1: ( ( '-' ) | ( '+' ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1410:1: ( '-' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1410:1: ( '-' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1411:1: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__UnaryOperator__Alternatives3011); 
                     after(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1418:6: ( '+' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1418:6: ( '+' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1419:1: '+'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__UnaryOperator__Alternatives3031); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1431:1: rule__PrimaryExpression__Alternatives : ( ( ruleLiteral ) | ( ruleRange ) | ( ruleNativeExpression ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleIndexedCall ) | ( ruleParenthesizedExpression ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1435:1: ( ( ruleLiteral ) | ( ruleRange ) | ( ruleNativeExpression ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleIndexedCall ) | ( ruleParenthesizedExpression ) )
            int alt14=7;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1436:1: ( ruleLiteral )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1436:1: ( ruleLiteral )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1437:1: ruleLiteral
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__PrimaryExpression__Alternatives3065);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1442:6: ( ruleRange )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1442:6: ( ruleRange )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1443:1: ruleRange
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getRangeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRange_in_rule__PrimaryExpression__Alternatives3082);
                    ruleRange();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getRangeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1448:6: ( ruleNativeExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1448:6: ( ruleNativeExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1449:1: ruleNativeExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getNativeExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleNativeExpression_in_rule__PrimaryExpression__Alternatives3099);
                    ruleNativeExpression();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getNativeExpressionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1454:6: ( ruleReference )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1454:6: ( ruleReference )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1455:1: ruleReference
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__PrimaryExpression__Alternatives3116);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1460:6: ( ruleFunctionCall )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1460:6: ( ruleFunctionCall )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1461:1: ruleFunctionCall
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleFunctionCall_in_rule__PrimaryExpression__Alternatives3133);
                    ruleFunctionCall();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1466:6: ( ruleIndexedCall )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1466:6: ( ruleIndexedCall )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1467:1: ruleIndexedCall
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getIndexedCallParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleIndexedCall_in_rule__PrimaryExpression__Alternatives3150);
                    ruleIndexedCall();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getIndexedCallParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1472:6: ( ruleParenthesizedExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1472:6: ( ruleParenthesizedExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1473:1: ruleParenthesizedExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives3167);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1483:1: rule__Literal__Alternatives : ( ( ruleNumberLiteral ) | ( ( rule__Literal__Group_1__0 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1487:1: ( ( ruleNumberLiteral ) | ( ( rule__Literal__Group_1__0 ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1488:1: ( ruleNumberLiteral )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1488:1: ( ruleNumberLiteral )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1489:1: ruleNumberLiteral
                    {
                     before(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives3199);
                    ruleNumberLiteral();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1494:6: ( ( rule__Literal__Group_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1494:6: ( ( rule__Literal__Group_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1495:1: ( rule__Literal__Group_1__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1496:1: ( rule__Literal__Group_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1496:2: rule__Literal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Literal__Group_1__0_in_rule__Literal__Alternatives3216);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1505:1: rule__Literal__Alternatives_1_1 : ( ( ( rule__Literal__ConditionAssignment_1_1_0 ) ) | ( 'false' ) );
    public final void rule__Literal__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1509:1: ( ( ( rule__Literal__ConditionAssignment_1_1_0 ) ) | ( 'false' ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1510:1: ( ( rule__Literal__ConditionAssignment_1_1_0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1510:1: ( ( rule__Literal__ConditionAssignment_1_1_0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1511:1: ( rule__Literal__ConditionAssignment_1_1_0 )
                    {
                     before(grammarAccess.getLiteralAccess().getConditionAssignment_1_1_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1512:1: ( rule__Literal__ConditionAssignment_1_1_0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1512:2: rule__Literal__ConditionAssignment_1_1_0
                    {
                    pushFollow(FOLLOW_rule__Literal__ConditionAssignment_1_1_0_in_rule__Literal__Alternatives_1_13249);
                    rule__Literal__ConditionAssignment_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getConditionAssignment_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1516:6: ( 'false' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1516:6: ( 'false' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1517:1: 'false'
                    {
                     before(grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Literal__Alternatives_1_13268); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1529:1: rule__NativeExpression__Alternatives_1 : ( ( ( rule__NativeExpression__RangeAssignment_1_0 ) ) | ( ( rule__NativeExpression__RefAssignment_1_1 ) ) );
    public final void rule__NativeExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1533:1: ( ( ( rule__NativeExpression__RangeAssignment_1_0 ) ) | ( ( rule__NativeExpression__RefAssignment_1_1 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==47) ) {
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1534:1: ( ( rule__NativeExpression__RangeAssignment_1_0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1534:1: ( ( rule__NativeExpression__RangeAssignment_1_0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1535:1: ( rule__NativeExpression__RangeAssignment_1_0 )
                    {
                     before(grammarAccess.getNativeExpressionAccess().getRangeAssignment_1_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1536:1: ( rule__NativeExpression__RangeAssignment_1_0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1536:2: rule__NativeExpression__RangeAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__NativeExpression__RangeAssignment_1_0_in_rule__NativeExpression__Alternatives_13302);
                    rule__NativeExpression__RangeAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNativeExpressionAccess().getRangeAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1540:6: ( ( rule__NativeExpression__RefAssignment_1_1 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1540:6: ( ( rule__NativeExpression__RefAssignment_1_1 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1541:1: ( rule__NativeExpression__RefAssignment_1_1 )
                    {
                     before(grammarAccess.getNativeExpressionAccess().getRefAssignment_1_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1542:1: ( rule__NativeExpression__RefAssignment_1_1 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1542:2: rule__NativeExpression__RefAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__NativeExpression__RefAssignment_1_1_in_rule__NativeExpression__Alternatives_13320);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1551:1: rule__LeafRef__Alternatives : ( ( ruleResourceRef ) | ( ruleLinkRef ) );
    public final void rule__LeafRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1555:1: ( ( ruleResourceRef ) | ( ruleLinkRef ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1556:1: ( ruleResourceRef )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1556:1: ( ruleResourceRef )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1557:1: ruleResourceRef
                    {
                     before(grammarAccess.getLeafRefAccess().getResourceRefParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResourceRef_in_rule__LeafRef__Alternatives3353);
                    ruleResourceRef();

                    state._fsp--;

                     after(grammarAccess.getLeafRefAccess().getResourceRefParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1562:6: ( ruleLinkRef )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1562:6: ( ruleLinkRef )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1563:1: ruleLinkRef
                    {
                     before(grammarAccess.getLeafRefAccess().getLinkRefParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleLinkRef_in_rule__LeafRef__Alternatives3370);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1573:1: rule__NativeFunction__Alternatives : ( ( ( 'count()' ) ) | ( ( 'sum()' ) ) | ( ( 'min()' ) ) | ( ( 'max()' ) ) | ( ( 'mean()' ) ) | ( ( 'deviation()' ) ) );
    public final void rule__NativeFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1577:1: ( ( ( 'count()' ) ) | ( ( 'sum()' ) ) | ( ( 'min()' ) ) | ( ( 'max()' ) ) | ( ( 'mean()' ) ) | ( ( 'deviation()' ) ) )
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
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1578:1: ( ( 'count()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1578:1: ( ( 'count()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1579:1: ( 'count()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1580:1: ( 'count()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1580:3: 'count()'
                    {
                    match(input,15,FOLLOW_15_in_rule__NativeFunction__Alternatives3403); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1585:6: ( ( 'sum()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1585:6: ( ( 'sum()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1586:1: ( 'sum()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1587:1: ( 'sum()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1587:3: 'sum()'
                    {
                    match(input,16,FOLLOW_16_in_rule__NativeFunction__Alternatives3424); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1592:6: ( ( 'min()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1592:6: ( ( 'min()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1593:1: ( 'min()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1594:1: ( 'min()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1594:3: 'min()'
                    {
                    match(input,17,FOLLOW_17_in_rule__NativeFunction__Alternatives3445); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1599:6: ( ( 'max()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1599:6: ( ( 'max()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1600:1: ( 'max()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1601:1: ( 'max()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1601:3: 'max()'
                    {
                    match(input,18,FOLLOW_18_in_rule__NativeFunction__Alternatives3466); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1606:6: ( ( 'mean()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1606:6: ( ( 'mean()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1607:1: ( 'mean()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1608:1: ( 'mean()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1608:3: 'mean()'
                    {
                    match(input,19,FOLLOW_19_in_rule__NativeFunction__Alternatives3487); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1613:6: ( ( 'deviation()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1613:6: ( ( 'deviation()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1614:1: ( 'deviation()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1615:1: ( 'deviation()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1615:3: 'deviation()'
                    {
                    match(input,20,FOLLOW_20_in_rule__NativeFunction__Alternatives3508); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1627:1: rule__Mod__Group__0 : rule__Mod__Group__0__Impl rule__Mod__Group__1 ;
    public final void rule__Mod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1631:1: ( rule__Mod__Group__0__Impl rule__Mod__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1632:2: rule__Mod__Group__0__Impl rule__Mod__Group__1
            {
            pushFollow(FOLLOW_rule__Mod__Group__0__Impl_in_rule__Mod__Group__03541);
            rule__Mod__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group__1_in_rule__Mod__Group__03544);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1639:1: rule__Mod__Group__0__Impl : ( ( rule__Mod__Group_0__0 )? ) ;
    public final void rule__Mod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1643:1: ( ( ( rule__Mod__Group_0__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1644:1: ( ( rule__Mod__Group_0__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1644:1: ( ( rule__Mod__Group_0__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1645:1: ( rule__Mod__Group_0__0 )?
            {
             before(grammarAccess.getModAccess().getGroup_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1646:1: ( rule__Mod__Group_0__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1646:2: rule__Mod__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Mod__Group_0__0_in_rule__Mod__Group__0__Impl3571);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1656:1: rule__Mod__Group__1 : rule__Mod__Group__1__Impl rule__Mod__Group__2 ;
    public final void rule__Mod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1660:1: ( rule__Mod__Group__1__Impl rule__Mod__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1661:2: rule__Mod__Group__1__Impl rule__Mod__Group__2
            {
            pushFollow(FOLLOW_rule__Mod__Group__1__Impl_in_rule__Mod__Group__13602);
            rule__Mod__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group__2_in_rule__Mod__Group__13605);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1668:1: rule__Mod__Group__1__Impl : ( ( rule__Mod__ImportsAssignment_1 )* ) ;
    public final void rule__Mod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1672:1: ( ( ( rule__Mod__ImportsAssignment_1 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1673:1: ( ( rule__Mod__ImportsAssignment_1 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1673:1: ( ( rule__Mod__ImportsAssignment_1 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1674:1: ( rule__Mod__ImportsAssignment_1 )*
            {
             before(grammarAccess.getModAccess().getImportsAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1675:1: ( rule__Mod__ImportsAssignment_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1675:2: rule__Mod__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Mod__ImportsAssignment_1_in_rule__Mod__Group__1__Impl3632);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1685:1: rule__Mod__Group__2 : rule__Mod__Group__2__Impl ;
    public final void rule__Mod__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1689:1: ( rule__Mod__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1690:2: rule__Mod__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Mod__Group__2__Impl_in_rule__Mod__Group__23663);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1696:1: rule__Mod__Group__2__Impl : ( ( rule__Mod__Alternatives_2 ) ) ;
    public final void rule__Mod__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1700:1: ( ( ( rule__Mod__Alternatives_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1701:1: ( ( rule__Mod__Alternatives_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1701:1: ( ( rule__Mod__Alternatives_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1702:1: ( rule__Mod__Alternatives_2 )
            {
             before(grammarAccess.getModAccess().getAlternatives_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1703:1: ( rule__Mod__Alternatives_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1703:2: rule__Mod__Alternatives_2
            {
            pushFollow(FOLLOW_rule__Mod__Alternatives_2_in_rule__Mod__Group__2__Impl3690);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1719:1: rule__Mod__Group_0__0 : rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1 ;
    public final void rule__Mod__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1723:1: ( rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1724:2: rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1
            {
            pushFollow(FOLLOW_rule__Mod__Group_0__0__Impl_in_rule__Mod__Group_0__03726);
            rule__Mod__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group_0__1_in_rule__Mod__Group_0__03729);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1731:1: rule__Mod__Group_0__0__Impl : ( 'mod' ) ;
    public final void rule__Mod__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1735:1: ( ( 'mod' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1736:1: ( 'mod' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1736:1: ( 'mod' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1737:1: 'mod'
            {
             before(grammarAccess.getModAccess().getModKeyword_0_0()); 
            match(input,21,FOLLOW_21_in_rule__Mod__Group_0__0__Impl3757); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1750:1: rule__Mod__Group_0__1 : rule__Mod__Group_0__1__Impl ;
    public final void rule__Mod__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1754:1: ( rule__Mod__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1755:2: rule__Mod__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Mod__Group_0__1__Impl_in_rule__Mod__Group_0__13788);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1761:1: rule__Mod__Group_0__1__Impl : ( ( rule__Mod__NameAssignment_0_1 ) ) ;
    public final void rule__Mod__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1765:1: ( ( ( rule__Mod__NameAssignment_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1766:1: ( ( rule__Mod__NameAssignment_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1766:1: ( ( rule__Mod__NameAssignment_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1767:1: ( rule__Mod__NameAssignment_0_1 )
            {
             before(grammarAccess.getModAccess().getNameAssignment_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1768:1: ( rule__Mod__NameAssignment_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1768:2: rule__Mod__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Mod__NameAssignment_0_1_in_rule__Mod__Group_0__1__Impl3815);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1783:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1787:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1788:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03850);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03853);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1795:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1799:1: ( ( 'import' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1800:1: ( 'import' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1800:1: ( 'import' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1801:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Import__Group__0__Impl3881); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1814:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1818:1: ( rule__Import__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1819:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13912);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1825:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1829:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1830:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1830:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1831:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1832:1: ( rule__Import__ImportURIAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1832:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl3939);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1846:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1850:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1851:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__03973);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__1_in_rule__Function__Group__03976);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1858:1: rule__Function__Group__0__Impl : ( 'def' ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1862:1: ( ( 'def' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1863:1: ( 'def' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1863:1: ( 'def' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1864:1: 'def'
            {
             before(grammarAccess.getFunctionAccess().getDefKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__Function__Group__0__Impl4004); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1877:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1881:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1882:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__14035);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__2_in_rule__Function__Group__14038);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1889:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1893:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1894:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1894:1: ( ( rule__Function__NameAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1895:1: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1896:1: ( rule__Function__NameAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1896:2: rule__Function__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl4065);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1906:1: rule__Function__Group__2 : rule__Function__Group__2__Impl rule__Function__Group__3 ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1910:1: ( rule__Function__Group__2__Impl rule__Function__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1911:2: rule__Function__Group__2__Impl rule__Function__Group__3
            {
            pushFollow(FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__24095);
            rule__Function__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__3_in_rule__Function__Group__24098);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1918:1: rule__Function__Group__2__Impl : ( '(' ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1922:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1923:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1923:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1924:1: '('
            {
             before(grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__Function__Group__2__Impl4126); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1937:1: rule__Function__Group__3 : rule__Function__Group__3__Impl rule__Function__Group__4 ;
    public final void rule__Function__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1941:1: ( rule__Function__Group__3__Impl rule__Function__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1942:2: rule__Function__Group__3__Impl rule__Function__Group__4
            {
            pushFollow(FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__34157);
            rule__Function__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__4_in_rule__Function__Group__34160);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1949:1: rule__Function__Group__3__Impl : ( ( rule__Function__Group_3__0 )? ) ;
    public final void rule__Function__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1953:1: ( ( ( rule__Function__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1954:1: ( ( rule__Function__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1954:1: ( ( rule__Function__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1955:1: ( rule__Function__Group_3__0 )?
            {
             before(grammarAccess.getFunctionAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1956:1: ( rule__Function__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1956:2: rule__Function__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Function__Group_3__0_in_rule__Function__Group__3__Impl4187);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1966:1: rule__Function__Group__4 : rule__Function__Group__4__Impl rule__Function__Group__5 ;
    public final void rule__Function__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1970:1: ( rule__Function__Group__4__Impl rule__Function__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1971:2: rule__Function__Group__4__Impl rule__Function__Group__5
            {
            pushFollow(FOLLOW_rule__Function__Group__4__Impl_in_rule__Function__Group__44218);
            rule__Function__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__5_in_rule__Function__Group__44221);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1978:1: rule__Function__Group__4__Impl : ( ')' ) ;
    public final void rule__Function__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1982:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1983:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1983:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1984:1: ')'
            {
             before(grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__Function__Group__4__Impl4249); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1997:1: rule__Function__Group__5 : rule__Function__Group__5__Impl ;
    public final void rule__Function__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2001:1: ( rule__Function__Group__5__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2002:2: rule__Function__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group__5__Impl_in_rule__Function__Group__54280);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2008:1: rule__Function__Group__5__Impl : ( ( rule__Function__BlockAssignment_5 ) ) ;
    public final void rule__Function__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2012:1: ( ( ( rule__Function__BlockAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2013:1: ( ( rule__Function__BlockAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2013:1: ( ( rule__Function__BlockAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2014:1: ( rule__Function__BlockAssignment_5 )
            {
             before(grammarAccess.getFunctionAccess().getBlockAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2015:1: ( rule__Function__BlockAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2015:2: rule__Function__BlockAssignment_5
            {
            pushFollow(FOLLOW_rule__Function__BlockAssignment_5_in_rule__Function__Group__5__Impl4307);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2037:1: rule__Function__Group_3__0 : rule__Function__Group_3__0__Impl rule__Function__Group_3__1 ;
    public final void rule__Function__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2041:1: ( rule__Function__Group_3__0__Impl rule__Function__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2042:2: rule__Function__Group_3__0__Impl rule__Function__Group_3__1
            {
            pushFollow(FOLLOW_rule__Function__Group_3__0__Impl_in_rule__Function__Group_3__04349);
            rule__Function__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group_3__1_in_rule__Function__Group_3__04352);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2049:1: rule__Function__Group_3__0__Impl : ( ( rule__Function__ArgsAssignment_3_0 ) ) ;
    public final void rule__Function__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2053:1: ( ( ( rule__Function__ArgsAssignment_3_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2054:1: ( ( rule__Function__ArgsAssignment_3_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2054:1: ( ( rule__Function__ArgsAssignment_3_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2055:1: ( rule__Function__ArgsAssignment_3_0 )
            {
             before(grammarAccess.getFunctionAccess().getArgsAssignment_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2056:1: ( rule__Function__ArgsAssignment_3_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2056:2: rule__Function__ArgsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__Function__ArgsAssignment_3_0_in_rule__Function__Group_3__0__Impl4379);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2066:1: rule__Function__Group_3__1 : rule__Function__Group_3__1__Impl ;
    public final void rule__Function__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2070:1: ( rule__Function__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2071:2: rule__Function__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group_3__1__Impl_in_rule__Function__Group_3__14409);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2077:1: rule__Function__Group_3__1__Impl : ( ( rule__Function__Group_3_1__0 )* ) ;
    public final void rule__Function__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2081:1: ( ( ( rule__Function__Group_3_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2082:1: ( ( rule__Function__Group_3_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2082:1: ( ( rule__Function__Group_3_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2083:1: ( rule__Function__Group_3_1__0 )*
            {
             before(grammarAccess.getFunctionAccess().getGroup_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2084:1: ( rule__Function__Group_3_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2084:2: rule__Function__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Function__Group_3_1__0_in_rule__Function__Group_3__1__Impl4436);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2098:1: rule__Function__Group_3_1__0 : rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1 ;
    public final void rule__Function__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2102:1: ( rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2103:2: rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Function__Group_3_1__0__Impl_in_rule__Function__Group_3_1__04471);
            rule__Function__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group_3_1__1_in_rule__Function__Group_3_1__04474);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2110:1: rule__Function__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__Function__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2114:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2115:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2115:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2116:1: ','
            {
             before(grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0()); 
            match(input,26,FOLLOW_26_in_rule__Function__Group_3_1__0__Impl4502); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2129:1: rule__Function__Group_3_1__1 : rule__Function__Group_3_1__1__Impl ;
    public final void rule__Function__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2133:1: ( rule__Function__Group_3_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2134:2: rule__Function__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group_3_1__1__Impl_in_rule__Function__Group_3_1__14533);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2140:1: rule__Function__Group_3_1__1__Impl : ( ( rule__Function__ArgsAssignment_3_1_1 ) ) ;
    public final void rule__Function__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2144:1: ( ( ( rule__Function__ArgsAssignment_3_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2145:1: ( ( rule__Function__ArgsAssignment_3_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2145:1: ( ( rule__Function__ArgsAssignment_3_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2146:1: ( rule__Function__ArgsAssignment_3_1_1 )
            {
             before(grammarAccess.getFunctionAccess().getArgsAssignment_3_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2147:1: ( rule__Function__ArgsAssignment_3_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2147:2: rule__Function__ArgsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Function__ArgsAssignment_3_1_1_in_rule__Function__Group_3_1__1__Impl4560);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2161:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2165:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2166:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__04594);
            rule__Block__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__1_in_rule__Block__Group__04597);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2173:1: rule__Block__Group__0__Impl : ( () ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2177:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2178:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2178:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2179:1: ()
            {
             before(grammarAccess.getBlockAccess().getBlockAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2180:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2182:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2192:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2196:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2197:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__14655);
            rule__Block__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__2_in_rule__Block__Group__14658);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2204:1: rule__Block__Group__1__Impl : ( '{' ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2208:1: ( ( '{' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2209:1: ( '{' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2209:1: ( '{' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2210:1: '{'
            {
             before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,27,FOLLOW_27_in_rule__Block__Group__1__Impl4686); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2223:1: rule__Block__Group__2 : rule__Block__Group__2__Impl rule__Block__Group__3 ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2227:1: ( rule__Block__Group__2__Impl rule__Block__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2228:2: rule__Block__Group__2__Impl rule__Block__Group__3
            {
            pushFollow(FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__24717);
            rule__Block__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__3_in_rule__Block__Group__24720);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2235:1: rule__Block__Group__2__Impl : ( ( rule__Block__StatementsAssignment_2 )* ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2239:1: ( ( ( rule__Block__StatementsAssignment_2 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2240:1: ( ( rule__Block__StatementsAssignment_2 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2240:1: ( ( rule__Block__StatementsAssignment_2 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2241:1: ( rule__Block__StatementsAssignment_2 )*
            {
             before(grammarAccess.getBlockAccess().getStatementsAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2242:1: ( rule__Block__StatementsAssignment_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||LA24_0==RULE_NUMBER||(LA24_0>=12 && LA24_0<=14)||LA24_0==24||LA24_0==27||(LA24_0>=30 && LA24_0<=31)||(LA24_0>=33 && LA24_0<=34)||LA24_0==47||LA24_0==50||(LA24_0>=54 && LA24_0<=55)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2242:2: rule__Block__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Block__StatementsAssignment_2_in_rule__Block__Group__2__Impl4747);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2252:1: rule__Block__Group__3 : rule__Block__Group__3__Impl ;
    public final void rule__Block__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2256:1: ( rule__Block__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2257:2: rule__Block__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__34778);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2263:1: rule__Block__Group__3__Impl : ( '}' ) ;
    public final void rule__Block__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2267:1: ( ( '}' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2268:1: ( '}' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2268:1: ( '}' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2269:1: '}'
            {
             before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__Block__Group__3__Impl4806); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2290:1: rule__Statement__Group_0__0 : rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 ;
    public final void rule__Statement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2294:1: ( rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2295:2: rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1
            {
            pushFollow(FOLLOW_rule__Statement__Group_0__0__Impl_in_rule__Statement__Group_0__04845);
            rule__Statement__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statement__Group_0__1_in_rule__Statement__Group_0__04848);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2302:1: rule__Statement__Group_0__0__Impl : ( ( rule__Statement__Alternatives_0_0 ) ) ;
    public final void rule__Statement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2306:1: ( ( ( rule__Statement__Alternatives_0_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2307:1: ( ( rule__Statement__Alternatives_0_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2307:1: ( ( rule__Statement__Alternatives_0_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2308:1: ( rule__Statement__Alternatives_0_0 )
            {
             before(grammarAccess.getStatementAccess().getAlternatives_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2309:1: ( rule__Statement__Alternatives_0_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2309:2: rule__Statement__Alternatives_0_0
            {
            pushFollow(FOLLOW_rule__Statement__Alternatives_0_0_in_rule__Statement__Group_0__0__Impl4875);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2319:1: rule__Statement__Group_0__1 : rule__Statement__Group_0__1__Impl ;
    public final void rule__Statement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2323:1: ( rule__Statement__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2324:2: rule__Statement__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Statement__Group_0__1__Impl_in_rule__Statement__Group_0__14905);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2330:1: rule__Statement__Group_0__1__Impl : ( ';' ) ;
    public final void rule__Statement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2334:1: ( ( ';' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2335:1: ( ';' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2335:1: ( ';' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2336:1: ';'
            {
             before(grammarAccess.getStatementAccess().getSemicolonKeyword_0_1()); 
            match(input,29,FOLLOW_29_in_rule__Statement__Group_0__1__Impl4933); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2353:1: rule__ReturnStatement__Group__0 : rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 ;
    public final void rule__ReturnStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2357:1: ( rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2358:2: rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__0__Impl_in_rule__ReturnStatement__Group__04968);
            rule__ReturnStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReturnStatement__Group__1_in_rule__ReturnStatement__Group__04971);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2365:1: rule__ReturnStatement__Group__0__Impl : ( () ) ;
    public final void rule__ReturnStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2369:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2370:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2370:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2371:1: ()
            {
             before(grammarAccess.getReturnStatementAccess().getReturnAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2372:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2374:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2384:1: rule__ReturnStatement__Group__1 : rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 ;
    public final void rule__ReturnStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2388:1: ( rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2389:2: rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__1__Impl_in_rule__ReturnStatement__Group__15029);
            rule__ReturnStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReturnStatement__Group__2_in_rule__ReturnStatement__Group__15032);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2396:1: rule__ReturnStatement__Group__1__Impl : ( 'return' ) ;
    public final void rule__ReturnStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2400:1: ( ( 'return' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2401:1: ( 'return' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2401:1: ( 'return' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2402:1: 'return'
            {
             before(grammarAccess.getReturnStatementAccess().getReturnKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__ReturnStatement__Group__1__Impl5060); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2415:1: rule__ReturnStatement__Group__2 : rule__ReturnStatement__Group__2__Impl ;
    public final void rule__ReturnStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2419:1: ( rule__ReturnStatement__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2420:2: rule__ReturnStatement__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__2__Impl_in_rule__ReturnStatement__Group__25091);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2426:1: rule__ReturnStatement__Group__2__Impl : ( ( rule__ReturnStatement__ExpressionAssignment_2 )? ) ;
    public final void rule__ReturnStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2430:1: ( ( ( rule__ReturnStatement__ExpressionAssignment_2 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2431:1: ( ( rule__ReturnStatement__ExpressionAssignment_2 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2431:1: ( ( rule__ReturnStatement__ExpressionAssignment_2 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2432:1: ( rule__ReturnStatement__ExpressionAssignment_2 )?
            {
             before(grammarAccess.getReturnStatementAccess().getExpressionAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2433:1: ( rule__ReturnStatement__ExpressionAssignment_2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||LA25_0==RULE_NUMBER||(LA25_0>=12 && LA25_0<=14)||LA25_0==24||LA25_0==47||LA25_0==50||(LA25_0>=54 && LA25_0<=55)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2433:2: rule__ReturnStatement__ExpressionAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ReturnStatement__ExpressionAssignment_2_in_rule__ReturnStatement__Group__2__Impl5118);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2449:1: rule__IfStatement__Group__0 : rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 ;
    public final void rule__IfStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2453:1: ( rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2454:2: rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__05155);
            rule__IfStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__05158);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2461:1: rule__IfStatement__Group__0__Impl : ( () ) ;
    public final void rule__IfStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2465:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2466:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2466:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2467:1: ()
            {
             before(grammarAccess.getIfStatementAccess().getIfAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2468:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2470:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2480:1: rule__IfStatement__Group__1 : rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 ;
    public final void rule__IfStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2484:1: ( rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2485:2: rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__15216);
            rule__IfStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__15219);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2492:1: rule__IfStatement__Group__1__Impl : ( 'if' ) ;
    public final void rule__IfStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2496:1: ( ( 'if' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2497:1: ( 'if' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2497:1: ( 'if' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2498:1: 'if'
            {
             before(grammarAccess.getIfStatementAccess().getIfKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__IfStatement__Group__1__Impl5247); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2511:1: rule__IfStatement__Group__2 : rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 ;
    public final void rule__IfStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2515:1: ( rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2516:2: rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__25278);
            rule__IfStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__25281);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2523:1: rule__IfStatement__Group__2__Impl : ( '(' ) ;
    public final void rule__IfStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2527:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2528:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2528:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2529:1: '('
            {
             before(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__IfStatement__Group__2__Impl5309); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2542:1: rule__IfStatement__Group__3 : rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 ;
    public final void rule__IfStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2546:1: ( rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2547:2: rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__35340);
            rule__IfStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__35343);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2554:1: rule__IfStatement__Group__3__Impl : ( ( rule__IfStatement__IfAssignment_3 ) ) ;
    public final void rule__IfStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2558:1: ( ( ( rule__IfStatement__IfAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2559:1: ( ( rule__IfStatement__IfAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2559:1: ( ( rule__IfStatement__IfAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2560:1: ( rule__IfStatement__IfAssignment_3 )
            {
             before(grammarAccess.getIfStatementAccess().getIfAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2561:1: ( rule__IfStatement__IfAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2561:2: rule__IfStatement__IfAssignment_3
            {
            pushFollow(FOLLOW_rule__IfStatement__IfAssignment_3_in_rule__IfStatement__Group__3__Impl5370);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2571:1: rule__IfStatement__Group__4 : rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 ;
    public final void rule__IfStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2575:1: ( rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2576:2: rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__45400);
            rule__IfStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__5_in_rule__IfStatement__Group__45403);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2583:1: rule__IfStatement__Group__4__Impl : ( ')' ) ;
    public final void rule__IfStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2587:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2588:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2588:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2589:1: ')'
            {
             before(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__IfStatement__Group__4__Impl5431); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2602:1: rule__IfStatement__Group__5 : rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6 ;
    public final void rule__IfStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2606:1: ( rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2607:2: rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__5__Impl_in_rule__IfStatement__Group__55462);
            rule__IfStatement__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__6_in_rule__IfStatement__Group__55465);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2614:1: rule__IfStatement__Group__5__Impl : ( ( rule__IfStatement__ThenAssignment_5 ) ) ;
    public final void rule__IfStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2618:1: ( ( ( rule__IfStatement__ThenAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2619:1: ( ( rule__IfStatement__ThenAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2619:1: ( ( rule__IfStatement__ThenAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2620:1: ( rule__IfStatement__ThenAssignment_5 )
            {
             before(grammarAccess.getIfStatementAccess().getThenAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2621:1: ( rule__IfStatement__ThenAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2621:2: rule__IfStatement__ThenAssignment_5
            {
            pushFollow(FOLLOW_rule__IfStatement__ThenAssignment_5_in_rule__IfStatement__Group__5__Impl5492);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2631:1: rule__IfStatement__Group__6 : rule__IfStatement__Group__6__Impl ;
    public final void rule__IfStatement__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2635:1: ( rule__IfStatement__Group__6__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2636:2: rule__IfStatement__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__6__Impl_in_rule__IfStatement__Group__65522);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2642:1: rule__IfStatement__Group__6__Impl : ( ( rule__IfStatement__Group_6__0 )? ) ;
    public final void rule__IfStatement__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2646:1: ( ( ( rule__IfStatement__Group_6__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2647:1: ( ( rule__IfStatement__Group_6__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2647:1: ( ( rule__IfStatement__Group_6__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2648:1: ( rule__IfStatement__Group_6__0 )?
            {
             before(grammarAccess.getIfStatementAccess().getGroup_6()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2649:1: ( rule__IfStatement__Group_6__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2649:2: rule__IfStatement__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__IfStatement__Group_6__0_in_rule__IfStatement__Group__6__Impl5549);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2673:1: rule__IfStatement__Group_6__0 : rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1 ;
    public final void rule__IfStatement__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2677:1: ( rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2678:2: rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1
            {
            pushFollow(FOLLOW_rule__IfStatement__Group_6__0__Impl_in_rule__IfStatement__Group_6__05594);
            rule__IfStatement__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group_6__1_in_rule__IfStatement__Group_6__05597);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2685:1: rule__IfStatement__Group_6__0__Impl : ( 'else' ) ;
    public final void rule__IfStatement__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2689:1: ( ( 'else' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2690:1: ( 'else' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2690:1: ( 'else' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2691:1: 'else'
            {
             before(grammarAccess.getIfStatementAccess().getElseKeyword_6_0()); 
            match(input,32,FOLLOW_32_in_rule__IfStatement__Group_6__0__Impl5625); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2704:1: rule__IfStatement__Group_6__1 : rule__IfStatement__Group_6__1__Impl ;
    public final void rule__IfStatement__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2708:1: ( rule__IfStatement__Group_6__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2709:2: rule__IfStatement__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__IfStatement__Group_6__1__Impl_in_rule__IfStatement__Group_6__15656);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2715:1: rule__IfStatement__Group_6__1__Impl : ( ( rule__IfStatement__ElseAssignment_6_1 ) ) ;
    public final void rule__IfStatement__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2719:1: ( ( ( rule__IfStatement__ElseAssignment_6_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2720:1: ( ( rule__IfStatement__ElseAssignment_6_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2720:1: ( ( rule__IfStatement__ElseAssignment_6_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2721:1: ( rule__IfStatement__ElseAssignment_6_1 )
            {
             before(grammarAccess.getIfStatementAccess().getElseAssignment_6_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2722:1: ( rule__IfStatement__ElseAssignment_6_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2722:2: rule__IfStatement__ElseAssignment_6_1
            {
            pushFollow(FOLLOW_rule__IfStatement__ElseAssignment_6_1_in_rule__IfStatement__Group_6__1__Impl5683);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2736:1: rule__WhileStatement__Group__0 : rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 ;
    public final void rule__WhileStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2740:1: ( rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2741:2: rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__0__Impl_in_rule__WhileStatement__Group__05717);
            rule__WhileStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__1_in_rule__WhileStatement__Group__05720);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2748:1: rule__WhileStatement__Group__0__Impl : ( () ) ;
    public final void rule__WhileStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2752:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2753:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2753:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2754:1: ()
            {
             before(grammarAccess.getWhileStatementAccess().getWhileAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2755:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2757:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2767:1: rule__WhileStatement__Group__1 : rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 ;
    public final void rule__WhileStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2771:1: ( rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2772:2: rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__1__Impl_in_rule__WhileStatement__Group__15778);
            rule__WhileStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__2_in_rule__WhileStatement__Group__15781);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2779:1: rule__WhileStatement__Group__1__Impl : ( 'while' ) ;
    public final void rule__WhileStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2783:1: ( ( 'while' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2784:1: ( 'while' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2784:1: ( 'while' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2785:1: 'while'
            {
             before(grammarAccess.getWhileStatementAccess().getWhileKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__WhileStatement__Group__1__Impl5809); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2798:1: rule__WhileStatement__Group__2 : rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 ;
    public final void rule__WhileStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2802:1: ( rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2803:2: rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__2__Impl_in_rule__WhileStatement__Group__25840);
            rule__WhileStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__3_in_rule__WhileStatement__Group__25843);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2810:1: rule__WhileStatement__Group__2__Impl : ( '(' ) ;
    public final void rule__WhileStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2814:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2815:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2815:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2816:1: '('
            {
             before(grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__WhileStatement__Group__2__Impl5871); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2829:1: rule__WhileStatement__Group__3 : rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 ;
    public final void rule__WhileStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2833:1: ( rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2834:2: rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__3__Impl_in_rule__WhileStatement__Group__35902);
            rule__WhileStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__4_in_rule__WhileStatement__Group__35905);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2841:1: rule__WhileStatement__Group__3__Impl : ( ( rule__WhileStatement__PredicateAssignment_3 ) ) ;
    public final void rule__WhileStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2845:1: ( ( ( rule__WhileStatement__PredicateAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2846:1: ( ( rule__WhileStatement__PredicateAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2846:1: ( ( rule__WhileStatement__PredicateAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2847:1: ( rule__WhileStatement__PredicateAssignment_3 )
            {
             before(grammarAccess.getWhileStatementAccess().getPredicateAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2848:1: ( rule__WhileStatement__PredicateAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2848:2: rule__WhileStatement__PredicateAssignment_3
            {
            pushFollow(FOLLOW_rule__WhileStatement__PredicateAssignment_3_in_rule__WhileStatement__Group__3__Impl5932);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2858:1: rule__WhileStatement__Group__4 : rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5 ;
    public final void rule__WhileStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2862:1: ( rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2863:2: rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__4__Impl_in_rule__WhileStatement__Group__45962);
            rule__WhileStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__5_in_rule__WhileStatement__Group__45965);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2870:1: rule__WhileStatement__Group__4__Impl : ( ')' ) ;
    public final void rule__WhileStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2874:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2875:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2875:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2876:1: ')'
            {
             before(grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__WhileStatement__Group__4__Impl5993); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2889:1: rule__WhileStatement__Group__5 : rule__WhileStatement__Group__5__Impl ;
    public final void rule__WhileStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2893:1: ( rule__WhileStatement__Group__5__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2894:2: rule__WhileStatement__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__5__Impl_in_rule__WhileStatement__Group__56024);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2900:1: rule__WhileStatement__Group__5__Impl : ( ( rule__WhileStatement__BodyAssignment_5 ) ) ;
    public final void rule__WhileStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2904:1: ( ( ( rule__WhileStatement__BodyAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2905:1: ( ( rule__WhileStatement__BodyAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2905:1: ( ( rule__WhileStatement__BodyAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2906:1: ( rule__WhileStatement__BodyAssignment_5 )
            {
             before(grammarAccess.getWhileStatementAccess().getBodyAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2907:1: ( rule__WhileStatement__BodyAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2907:2: rule__WhileStatement__BodyAssignment_5
            {
            pushFollow(FOLLOW_rule__WhileStatement__BodyAssignment_5_in_rule__WhileStatement__Group__5__Impl6051);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2929:1: rule__VariableStatement__Group__0 : rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1 ;
    public final void rule__VariableStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2933:1: ( rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2934:2: rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__0__Impl_in_rule__VariableStatement__Group__06093);
            rule__VariableStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__1_in_rule__VariableStatement__Group__06096);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2941:1: rule__VariableStatement__Group__0__Impl : ( () ) ;
    public final void rule__VariableStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2945:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2946:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2946:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2947:1: ()
            {
             before(grammarAccess.getVariableStatementAccess().getVariableAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2948:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2950:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2960:1: rule__VariableStatement__Group__1 : rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2 ;
    public final void rule__VariableStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2964:1: ( rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2965:2: rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__1__Impl_in_rule__VariableStatement__Group__16154);
            rule__VariableStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__2_in_rule__VariableStatement__Group__16157);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2972:1: rule__VariableStatement__Group__1__Impl : ( 'var' ) ;
    public final void rule__VariableStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2976:1: ( ( 'var' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2977:1: ( 'var' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2977:1: ( 'var' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2978:1: 'var'
            {
             before(grammarAccess.getVariableStatementAccess().getVarKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__VariableStatement__Group__1__Impl6185); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2991:1: rule__VariableStatement__Group__2 : rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3 ;
    public final void rule__VariableStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2995:1: ( rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2996:2: rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__2__Impl_in_rule__VariableStatement__Group__26216);
            rule__VariableStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__3_in_rule__VariableStatement__Group__26219);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3003:1: rule__VariableStatement__Group__2__Impl : ( ( rule__VariableStatement__NameAssignment_2 ) ) ;
    public final void rule__VariableStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3007:1: ( ( ( rule__VariableStatement__NameAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3008:1: ( ( rule__VariableStatement__NameAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3008:1: ( ( rule__VariableStatement__NameAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3009:1: ( rule__VariableStatement__NameAssignment_2 )
            {
             before(grammarAccess.getVariableStatementAccess().getNameAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3010:1: ( rule__VariableStatement__NameAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3010:2: rule__VariableStatement__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableStatement__NameAssignment_2_in_rule__VariableStatement__Group__2__Impl6246);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3020:1: rule__VariableStatement__Group__3 : rule__VariableStatement__Group__3__Impl ;
    public final void rule__VariableStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3024:1: ( rule__VariableStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3025:2: rule__VariableStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__3__Impl_in_rule__VariableStatement__Group__36276);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3031:1: rule__VariableStatement__Group__3__Impl : ( ( rule__VariableStatement__Group_3__0 )? ) ;
    public final void rule__VariableStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3035:1: ( ( ( rule__VariableStatement__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3036:1: ( ( rule__VariableStatement__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3036:1: ( ( rule__VariableStatement__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3037:1: ( rule__VariableStatement__Group_3__0 )?
            {
             before(grammarAccess.getVariableStatementAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3038:1: ( rule__VariableStatement__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3038:2: rule__VariableStatement__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__VariableStatement__Group_3__0_in_rule__VariableStatement__Group__3__Impl6303);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3056:1: rule__VariableStatement__Group_3__0 : rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1 ;
    public final void rule__VariableStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3060:1: ( rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3061:2: rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group_3__0__Impl_in_rule__VariableStatement__Group_3__06342);
            rule__VariableStatement__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group_3__1_in_rule__VariableStatement__Group_3__06345);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3068:1: rule__VariableStatement__Group_3__0__Impl : ( '=' ) ;
    public final void rule__VariableStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3072:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3073:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3073:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3074:1: '='
            {
             before(grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0()); 
            match(input,35,FOLLOW_35_in_rule__VariableStatement__Group_3__0__Impl6373); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3087:1: rule__VariableStatement__Group_3__1 : rule__VariableStatement__Group_3__1__Impl ;
    public final void rule__VariableStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3091:1: ( rule__VariableStatement__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3092:2: rule__VariableStatement__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group_3__1__Impl_in_rule__VariableStatement__Group_3__16404);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3098:1: rule__VariableStatement__Group_3__1__Impl : ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) ) ;
    public final void rule__VariableStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3102:1: ( ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3103:1: ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3103:1: ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3104:1: ( rule__VariableStatement__ExpressionAssignment_3_1 )
            {
             before(grammarAccess.getVariableStatementAccess().getExpressionAssignment_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3105:1: ( rule__VariableStatement__ExpressionAssignment_3_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3105:2: rule__VariableStatement__ExpressionAssignment_3_1
            {
            pushFollow(FOLLOW_rule__VariableStatement__ExpressionAssignment_3_1_in_rule__VariableStatement__Group_3__1__Impl6431);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3119:1: rule__AssignmentStatement__Group__0 : rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1 ;
    public final void rule__AssignmentStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3123:1: ( rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3124:2: rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__0__Impl_in_rule__AssignmentStatement__Group__06465);
            rule__AssignmentStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__1_in_rule__AssignmentStatement__Group__06468);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3131:1: rule__AssignmentStatement__Group__0__Impl : ( () ) ;
    public final void rule__AssignmentStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3135:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3136:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3136:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3137:1: ()
            {
             before(grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3138:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3140:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3150:1: rule__AssignmentStatement__Group__1 : rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2 ;
    public final void rule__AssignmentStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3154:1: ( rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3155:2: rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__1__Impl_in_rule__AssignmentStatement__Group__16526);
            rule__AssignmentStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__2_in_rule__AssignmentStatement__Group__16529);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3162:1: rule__AssignmentStatement__Group__1__Impl : ( ( rule__AssignmentStatement__VarAssignment_1 ) ) ;
    public final void rule__AssignmentStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3166:1: ( ( ( rule__AssignmentStatement__VarAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3167:1: ( ( rule__AssignmentStatement__VarAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3167:1: ( ( rule__AssignmentStatement__VarAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3168:1: ( rule__AssignmentStatement__VarAssignment_1 )
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3169:1: ( rule__AssignmentStatement__VarAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3169:2: rule__AssignmentStatement__VarAssignment_1
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__VarAssignment_1_in_rule__AssignmentStatement__Group__1__Impl6556);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3179:1: rule__AssignmentStatement__Group__2 : rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3 ;
    public final void rule__AssignmentStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3183:1: ( rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3184:2: rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__2__Impl_in_rule__AssignmentStatement__Group__26586);
            rule__AssignmentStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__3_in_rule__AssignmentStatement__Group__26589);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3191:1: rule__AssignmentStatement__Group__2__Impl : ( '=' ) ;
    public final void rule__AssignmentStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3195:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3196:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3196:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3197:1: '='
            {
             before(grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__AssignmentStatement__Group__2__Impl6617); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3210:1: rule__AssignmentStatement__Group__3 : rule__AssignmentStatement__Group__3__Impl ;
    public final void rule__AssignmentStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3214:1: ( rule__AssignmentStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3215:2: rule__AssignmentStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__3__Impl_in_rule__AssignmentStatement__Group__36648);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3221:1: rule__AssignmentStatement__Group__3__Impl : ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) ) ;
    public final void rule__AssignmentStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3225:1: ( ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3226:1: ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3226:1: ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3227:1: ( rule__AssignmentStatement__ExpressionAssignment_3 )
            {
             before(grammarAccess.getAssignmentStatementAccess().getExpressionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3228:1: ( rule__AssignmentStatement__ExpressionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3228:2: rule__AssignmentStatement__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__ExpressionAssignment_3_in_rule__AssignmentStatement__Group__3__Impl6675);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3246:1: rule__ReferenceAssignmentStatement__Group__0 : rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1 ;
    public final void rule__ReferenceAssignmentStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3250:1: ( rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3251:2: rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__0__Impl_in_rule__ReferenceAssignmentStatement__Group__06713);
            rule__ReferenceAssignmentStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__1_in_rule__ReferenceAssignmentStatement__Group__06716);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3258:1: rule__ReferenceAssignmentStatement__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceAssignmentStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3262:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3263:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3263:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3264:1: ()
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignementAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3265:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3267:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3277:1: rule__ReferenceAssignmentStatement__Group__1 : rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2 ;
    public final void rule__ReferenceAssignmentStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3281:1: ( rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3282:2: rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__1__Impl_in_rule__ReferenceAssignmentStatement__Group__16774);
            rule__ReferenceAssignmentStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__2_in_rule__ReferenceAssignmentStatement__Group__16777);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3289:1: rule__ReferenceAssignmentStatement__Group__1__Impl : ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) ) ;
    public final void rule__ReferenceAssignmentStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3293:1: ( ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3294:1: ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3294:1: ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3295:1: ( rule__ReferenceAssignmentStatement__RefAssignment_1 )
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3296:1: ( rule__ReferenceAssignmentStatement__RefAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3296:2: rule__ReferenceAssignmentStatement__RefAssignment_1
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__RefAssignment_1_in_rule__ReferenceAssignmentStatement__Group__1__Impl6804);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3306:1: rule__ReferenceAssignmentStatement__Group__2 : rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3 ;
    public final void rule__ReferenceAssignmentStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3310:1: ( rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3311:2: rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__2__Impl_in_rule__ReferenceAssignmentStatement__Group__26834);
            rule__ReferenceAssignmentStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__3_in_rule__ReferenceAssignmentStatement__Group__26837);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3318:1: rule__ReferenceAssignmentStatement__Group__2__Impl : ( '=' ) ;
    public final void rule__ReferenceAssignmentStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3322:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3323:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3323:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3324:1: '='
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__ReferenceAssignmentStatement__Group__2__Impl6865); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3337:1: rule__ReferenceAssignmentStatement__Group__3 : rule__ReferenceAssignmentStatement__Group__3__Impl ;
    public final void rule__ReferenceAssignmentStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3341:1: ( rule__ReferenceAssignmentStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3342:2: rule__ReferenceAssignmentStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__3__Impl_in_rule__ReferenceAssignmentStatement__Group__36896);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3348:1: rule__ReferenceAssignmentStatement__Group__3__Impl : ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) ) ;
    public final void rule__ReferenceAssignmentStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3352:1: ( ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3353:1: ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3353:1: ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3354:1: ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 )
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3355:1: ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3355:2: rule__ReferenceAssignmentStatement__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__ExpressionAssignment_3_in_rule__ReferenceAssignmentStatement__Group__3__Impl6923);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3373:1: rule__Logical__Group__0 : rule__Logical__Group__0__Impl rule__Logical__Group__1 ;
    public final void rule__Logical__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3377:1: ( rule__Logical__Group__0__Impl rule__Logical__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3378:2: rule__Logical__Group__0__Impl rule__Logical__Group__1
            {
            pushFollow(FOLLOW_rule__Logical__Group__0__Impl_in_rule__Logical__Group__06961);
            rule__Logical__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group__1_in_rule__Logical__Group__06964);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3385:1: rule__Logical__Group__0__Impl : ( ruleEquality ) ;
    public final void rule__Logical__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3389:1: ( ( ruleEquality ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3390:1: ( ruleEquality )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3390:1: ( ruleEquality )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3391:1: ruleEquality
            {
             before(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleEquality_in_rule__Logical__Group__0__Impl6991);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3402:1: rule__Logical__Group__1 : rule__Logical__Group__1__Impl ;
    public final void rule__Logical__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3406:1: ( rule__Logical__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3407:2: rule__Logical__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group__1__Impl_in_rule__Logical__Group__17020);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3413:1: rule__Logical__Group__1__Impl : ( ( rule__Logical__Group_1__0 )* ) ;
    public final void rule__Logical__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3417:1: ( ( ( rule__Logical__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3418:1: ( ( rule__Logical__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3418:1: ( ( rule__Logical__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3419:1: ( rule__Logical__Group_1__0 )*
            {
             before(grammarAccess.getLogicalAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3420:1: ( rule__Logical__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=36 && LA28_0<=37)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3420:2: rule__Logical__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Logical__Group_1__0_in_rule__Logical__Group__1__Impl7047);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3434:1: rule__Logical__Group_1__0 : rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1 ;
    public final void rule__Logical__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3438:1: ( rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3439:2: rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1__0__Impl_in_rule__Logical__Group_1__07082);
            rule__Logical__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1__1_in_rule__Logical__Group_1__07085);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3446:1: rule__Logical__Group_1__0__Impl : ( ( rule__Logical__Alternatives_1_0 ) ) ;
    public final void rule__Logical__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3450:1: ( ( ( rule__Logical__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3451:1: ( ( rule__Logical__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3451:1: ( ( rule__Logical__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3452:1: ( rule__Logical__Alternatives_1_0 )
            {
             before(grammarAccess.getLogicalAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3453:1: ( rule__Logical__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3453:2: rule__Logical__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Logical__Alternatives_1_0_in_rule__Logical__Group_1__0__Impl7112);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3463:1: rule__Logical__Group_1__1 : rule__Logical__Group_1__1__Impl ;
    public final void rule__Logical__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3467:1: ( rule__Logical__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3468:2: rule__Logical__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1__1__Impl_in_rule__Logical__Group_1__17142);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3474:1: rule__Logical__Group_1__1__Impl : ( ( rule__Logical__RightAssignment_1_1 ) ) ;
    public final void rule__Logical__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3478:1: ( ( ( rule__Logical__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3479:1: ( ( rule__Logical__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3479:1: ( ( rule__Logical__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3480:1: ( rule__Logical__RightAssignment_1_1 )
            {
             before(grammarAccess.getLogicalAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3481:1: ( rule__Logical__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3481:2: rule__Logical__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Logical__RightAssignment_1_1_in_rule__Logical__Group_1__1__Impl7169);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3495:1: rule__Logical__Group_1_0_0__0 : rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1 ;
    public final void rule__Logical__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3499:1: ( rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3500:2: rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__0__Impl_in_rule__Logical__Group_1_0_0__07203);
            rule__Logical__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__1_in_rule__Logical__Group_1_0_0__07206);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3507:1: rule__Logical__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Logical__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3511:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3512:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3512:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3513:1: ()
            {
             before(grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3514:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3516:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3526:1: rule__Logical__Group_1_0_0__1 : rule__Logical__Group_1_0_0__1__Impl ;
    public final void rule__Logical__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3530:1: ( rule__Logical__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3531:2: rule__Logical__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__1__Impl_in_rule__Logical__Group_1_0_0__17264);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3537:1: rule__Logical__Group_1_0_0__1__Impl : ( '&&' ) ;
    public final void rule__Logical__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3541:1: ( ( '&&' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3542:1: ( '&&' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3542:1: ( '&&' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3543:1: '&&'
            {
             before(grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1()); 
            match(input,36,FOLLOW_36_in_rule__Logical__Group_1_0_0__1__Impl7292); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3560:1: rule__Logical__Group_1_0_1__0 : rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1 ;
    public final void rule__Logical__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3564:1: ( rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3565:2: rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__0__Impl_in_rule__Logical__Group_1_0_1__07327);
            rule__Logical__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__1_in_rule__Logical__Group_1_0_1__07330);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3572:1: rule__Logical__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Logical__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3576:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3577:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3577:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3578:1: ()
            {
             before(grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3579:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3581:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3591:1: rule__Logical__Group_1_0_1__1 : rule__Logical__Group_1_0_1__1__Impl ;
    public final void rule__Logical__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3595:1: ( rule__Logical__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3596:2: rule__Logical__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__1__Impl_in_rule__Logical__Group_1_0_1__17388);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3602:1: rule__Logical__Group_1_0_1__1__Impl : ( '||' ) ;
    public final void rule__Logical__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3606:1: ( ( '||' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3607:1: ( '||' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3607:1: ( '||' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3608:1: '||'
            {
             before(grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1()); 
            match(input,37,FOLLOW_37_in_rule__Logical__Group_1_0_1__1__Impl7416); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3625:1: rule__Equality__Group__0 : rule__Equality__Group__0__Impl rule__Equality__Group__1 ;
    public final void rule__Equality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3629:1: ( rule__Equality__Group__0__Impl rule__Equality__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3630:2: rule__Equality__Group__0__Impl rule__Equality__Group__1
            {
            pushFollow(FOLLOW_rule__Equality__Group__0__Impl_in_rule__Equality__Group__07451);
            rule__Equality__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group__1_in_rule__Equality__Group__07454);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3637:1: rule__Equality__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__Equality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3641:1: ( ( ruleComparison ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3642:1: ( ruleComparison )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3642:1: ( ruleComparison )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3643:1: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleComparison_in_rule__Equality__Group__0__Impl7481);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3654:1: rule__Equality__Group__1 : rule__Equality__Group__1__Impl ;
    public final void rule__Equality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3658:1: ( rule__Equality__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3659:2: rule__Equality__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group__1__Impl_in_rule__Equality__Group__17510);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3665:1: rule__Equality__Group__1__Impl : ( ( rule__Equality__Group_1__0 )* ) ;
    public final void rule__Equality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3669:1: ( ( ( rule__Equality__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3670:1: ( ( rule__Equality__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3670:1: ( ( rule__Equality__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3671:1: ( rule__Equality__Group_1__0 )*
            {
             before(grammarAccess.getEqualityAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3672:1: ( rule__Equality__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=38 && LA29_0<=39)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3672:2: rule__Equality__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Equality__Group_1__0_in_rule__Equality__Group__1__Impl7537);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3686:1: rule__Equality__Group_1__0 : rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 ;
    public final void rule__Equality__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3690:1: ( rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3691:2: rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1__0__Impl_in_rule__Equality__Group_1__07572);
            rule__Equality__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1__1_in_rule__Equality__Group_1__07575);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3698:1: rule__Equality__Group_1__0__Impl : ( ( rule__Equality__Alternatives_1_0 ) ) ;
    public final void rule__Equality__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3702:1: ( ( ( rule__Equality__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3703:1: ( ( rule__Equality__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3703:1: ( ( rule__Equality__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3704:1: ( rule__Equality__Alternatives_1_0 )
            {
             before(grammarAccess.getEqualityAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3705:1: ( rule__Equality__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3705:2: rule__Equality__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Equality__Alternatives_1_0_in_rule__Equality__Group_1__0__Impl7602);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3715:1: rule__Equality__Group_1__1 : rule__Equality__Group_1__1__Impl ;
    public final void rule__Equality__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3719:1: ( rule__Equality__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3720:2: rule__Equality__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1__1__Impl_in_rule__Equality__Group_1__17632);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3726:1: rule__Equality__Group_1__1__Impl : ( ( rule__Equality__RightAssignment_1_1 ) ) ;
    public final void rule__Equality__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3730:1: ( ( ( rule__Equality__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3731:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3731:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3732:1: ( rule__Equality__RightAssignment_1_1 )
            {
             before(grammarAccess.getEqualityAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3733:1: ( rule__Equality__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3733:2: rule__Equality__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Equality__RightAssignment_1_1_in_rule__Equality__Group_1__1__Impl7659);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3747:1: rule__Equality__Group_1_0_0__0 : rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 ;
    public final void rule__Equality__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3751:1: ( rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3752:2: rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__0__Impl_in_rule__Equality__Group_1_0_0__07693);
            rule__Equality__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__1_in_rule__Equality__Group_1_0_0__07696);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3759:1: rule__Equality__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3763:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3764:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3764:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3765:1: ()
            {
             before(grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3766:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3768:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3778:1: rule__Equality__Group_1_0_0__1 : rule__Equality__Group_1_0_0__1__Impl ;
    public final void rule__Equality__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3782:1: ( rule__Equality__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3783:2: rule__Equality__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__1__Impl_in_rule__Equality__Group_1_0_0__17754);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3789:1: rule__Equality__Group_1_0_0__1__Impl : ( '==' ) ;
    public final void rule__Equality__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3793:1: ( ( '==' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3794:1: ( '==' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3794:1: ( '==' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3795:1: '=='
            {
             before(grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1()); 
            match(input,38,FOLLOW_38_in_rule__Equality__Group_1_0_0__1__Impl7782); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3812:1: rule__Equality__Group_1_0_1__0 : rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 ;
    public final void rule__Equality__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3816:1: ( rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3817:2: rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__0__Impl_in_rule__Equality__Group_1_0_1__07817);
            rule__Equality__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__1_in_rule__Equality__Group_1_0_1__07820);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3824:1: rule__Equality__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3828:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3829:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3829:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3830:1: ()
            {
             before(grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3831:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3833:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3843:1: rule__Equality__Group_1_0_1__1 : rule__Equality__Group_1_0_1__1__Impl ;
    public final void rule__Equality__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3847:1: ( rule__Equality__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3848:2: rule__Equality__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__1__Impl_in_rule__Equality__Group_1_0_1__17878);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3854:1: rule__Equality__Group_1_0_1__1__Impl : ( '!=' ) ;
    public final void rule__Equality__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3858:1: ( ( '!=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3859:1: ( '!=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3859:1: ( '!=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3860:1: '!='
            {
             before(grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1()); 
            match(input,39,FOLLOW_39_in_rule__Equality__Group_1_0_1__1__Impl7906); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3877:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3881:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3882:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__07941);
            rule__Comparison__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__07944);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3889:1: rule__Comparison__Group__0__Impl : ( ruleAddition ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3893:1: ( ( ruleAddition ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3894:1: ( ruleAddition )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3894:1: ( ruleAddition )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3895:1: ruleAddition
            {
             before(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl7971);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3906:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3910:1: ( rule__Comparison__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3911:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__18000);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3917:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3921:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3922:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3922:1: ( ( rule__Comparison__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3923:1: ( rule__Comparison__Group_1__0 )*
            {
             before(grammarAccess.getComparisonAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3924:1: ( rule__Comparison__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=40 && LA30_0<=43)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3924:2: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl8027);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3938:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3942:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3943:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__08062);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__08065);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3950:1: rule__Comparison__Group_1__0__Impl : ( ( rule__Comparison__Alternatives_1_0 ) ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3954:1: ( ( ( rule__Comparison__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3955:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3955:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3956:1: ( rule__Comparison__Alternatives_1_0 )
            {
             before(grammarAccess.getComparisonAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3957:1: ( rule__Comparison__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3957:2: rule__Comparison__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Comparison__Alternatives_1_0_in_rule__Comparison__Group_1__0__Impl8092);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3967:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3971:1: ( rule__Comparison__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3972:2: rule__Comparison__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__18122);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3978:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__RightAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3982:1: ( ( ( rule__Comparison__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3983:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3983:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3984:1: ( rule__Comparison__RightAssignment_1_1 )
            {
             before(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3985:1: ( rule__Comparison__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3985:2: rule__Comparison__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl8149);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3999:1: rule__Comparison__Group_1_0_0__0 : rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 ;
    public final void rule__Comparison__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4003:1: ( rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4004:2: rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__0__Impl_in_rule__Comparison__Group_1_0_0__08183);
            rule__Comparison__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__1_in_rule__Comparison__Group_1_0_0__08186);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4011:1: rule__Comparison__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4015:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4016:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4016:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4017:1: ()
            {
             before(grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4018:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4020:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4030:1: rule__Comparison__Group_1_0_0__1 : rule__Comparison__Group_1_0_0__1__Impl ;
    public final void rule__Comparison__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4034:1: ( rule__Comparison__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4035:2: rule__Comparison__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__1__Impl_in_rule__Comparison__Group_1_0_0__18244);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4041:1: rule__Comparison__Group_1_0_0__1__Impl : ( '<' ) ;
    public final void rule__Comparison__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4045:1: ( ( '<' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4046:1: ( '<' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4046:1: ( '<' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4047:1: '<'
            {
             before(grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1()); 
            match(input,40,FOLLOW_40_in_rule__Comparison__Group_1_0_0__1__Impl8272); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4064:1: rule__Comparison__Group_1_0_1__0 : rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 ;
    public final void rule__Comparison__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4068:1: ( rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4069:2: rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__0__Impl_in_rule__Comparison__Group_1_0_1__08307);
            rule__Comparison__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__1_in_rule__Comparison__Group_1_0_1__08310);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4076:1: rule__Comparison__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4080:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4081:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4081:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4082:1: ()
            {
             before(grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4083:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4085:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4095:1: rule__Comparison__Group_1_0_1__1 : rule__Comparison__Group_1_0_1__1__Impl ;
    public final void rule__Comparison__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4099:1: ( rule__Comparison__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4100:2: rule__Comparison__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__1__Impl_in_rule__Comparison__Group_1_0_1__18368);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4106:1: rule__Comparison__Group_1_0_1__1__Impl : ( '<=' ) ;
    public final void rule__Comparison__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4110:1: ( ( '<=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4111:1: ( '<=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4111:1: ( '<=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4112:1: '<='
            {
             before(grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1()); 
            match(input,41,FOLLOW_41_in_rule__Comparison__Group_1_0_1__1__Impl8396); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4129:1: rule__Comparison__Group_1_0_2__0 : rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 ;
    public final void rule__Comparison__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4133:1: ( rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4134:2: rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__0__Impl_in_rule__Comparison__Group_1_0_2__08431);
            rule__Comparison__Group_1_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__1_in_rule__Comparison__Group_1_0_2__08434);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4141:1: rule__Comparison__Group_1_0_2__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4145:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4146:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4146:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4147:1: ()
            {
             before(grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4148:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4150:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4160:1: rule__Comparison__Group_1_0_2__1 : rule__Comparison__Group_1_0_2__1__Impl ;
    public final void rule__Comparison__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4164:1: ( rule__Comparison__Group_1_0_2__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4165:2: rule__Comparison__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__1__Impl_in_rule__Comparison__Group_1_0_2__18492);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4171:1: rule__Comparison__Group_1_0_2__1__Impl : ( '>' ) ;
    public final void rule__Comparison__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4175:1: ( ( '>' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4176:1: ( '>' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4176:1: ( '>' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4177:1: '>'
            {
             before(grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1()); 
            match(input,42,FOLLOW_42_in_rule__Comparison__Group_1_0_2__1__Impl8520); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4194:1: rule__Comparison__Group_1_0_3__0 : rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 ;
    public final void rule__Comparison__Group_1_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4198:1: ( rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4199:2: rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__0__Impl_in_rule__Comparison__Group_1_0_3__08555);
            rule__Comparison__Group_1_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__1_in_rule__Comparison__Group_1_0_3__08558);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4206:1: rule__Comparison__Group_1_0_3__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4210:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4211:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4211:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4212:1: ()
            {
             before(grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4213:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4215:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4225:1: rule__Comparison__Group_1_0_3__1 : rule__Comparison__Group_1_0_3__1__Impl ;
    public final void rule__Comparison__Group_1_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4229:1: ( rule__Comparison__Group_1_0_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4230:2: rule__Comparison__Group_1_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__1__Impl_in_rule__Comparison__Group_1_0_3__18616);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4236:1: rule__Comparison__Group_1_0_3__1__Impl : ( '>=' ) ;
    public final void rule__Comparison__Group_1_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4240:1: ( ( '>=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4241:1: ( '>=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4241:1: ( '>=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4242:1: '>='
            {
             before(grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1()); 
            match(input,43,FOLLOW_43_in_rule__Comparison__Group_1_0_3__1__Impl8644); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4259:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4263:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4264:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__08679);
            rule__Addition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__08682);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4271:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4275:1: ( ( ruleMultiplication ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4276:1: ( ruleMultiplication )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4276:1: ( ruleMultiplication )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4277:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl8709);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4288:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4292:1: ( rule__Addition__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4293:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__18738);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4299:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4303:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4304:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4304:1: ( ( rule__Addition__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4305:1: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4306:1: ( rule__Addition__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=12 && LA31_0<=13)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4306:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl8765);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4320:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4324:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4325:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__08800);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__08803);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4332:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4336:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4337:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4337:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4338:1: ( rule__Addition__Alternatives_1_0 )
            {
             before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4339:1: ( rule__Addition__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4339:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl8830);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4349:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4353:1: ( rule__Addition__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4354:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__18860);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4360:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4364:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4365:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4365:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4366:1: ( rule__Addition__RightAssignment_1_1 )
            {
             before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4367:1: ( rule__Addition__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4367:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl8887);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4381:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4385:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4386:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__08921);
            rule__Addition__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__08924);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4393:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4397:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4398:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4398:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4399:1: ()
            {
             before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4400:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4402:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4412:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4416:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4417:2: rule__Addition__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__18982);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4423:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4427:1: ( ( '+' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4428:1: ( '+' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4428:1: ( '+' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4429:1: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            match(input,13,FOLLOW_13_in_rule__Addition__Group_1_0_0__1__Impl9010); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4446:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4450:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4451:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__09045);
            rule__Addition__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__09048);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4458:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4462:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4463:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4463:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4464:1: ()
            {
             before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4465:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4467:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4477:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4481:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4482:2: rule__Addition__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__19106);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4488:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4492:1: ( ( '-' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4493:1: ( '-' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4493:1: ( '-' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4494:1: '-'
            {
             before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            match(input,12,FOLLOW_12_in_rule__Addition__Group_1_0_1__1__Impl9134); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4511:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4515:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4516:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__09169);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__09172);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4523:1: rule__Multiplication__Group__0__Impl : ( ruleUnary ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4527:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4528:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4528:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4529:1: ruleUnary
            {
             before(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Multiplication__Group__0__Impl9199);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4540:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4544:1: ( rule__Multiplication__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4545:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__19228);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4551:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4555:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4556:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4556:1: ( ( rule__Multiplication__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4557:1: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4558:1: ( rule__Multiplication__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=44 && LA32_0<=46)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4558:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl9255);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4572:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4576:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4577:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__09290);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__09293);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4584:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Alternatives_1_0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4588:1: ( ( ( rule__Multiplication__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4589:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4589:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4590:1: ( rule__Multiplication__Alternatives_1_0 )
            {
             before(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4591:1: ( rule__Multiplication__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4591:2: rule__Multiplication__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__0__Impl9320);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4601:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4605:1: ( rule__Multiplication__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4606:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__19350);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4612:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4616:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4617:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4617:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4618:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4619:1: ( rule__Multiplication__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4619:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl9377);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4633:1: rule__Multiplication__Group_1_0_0__0 : rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 ;
    public final void rule__Multiplication__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4637:1: ( rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4638:2: rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__0__Impl_in_rule__Multiplication__Group_1_0_0__09411);
            rule__Multiplication__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__09414);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4645:1: rule__Multiplication__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4649:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4650:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4650:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4651:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4652:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4654:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4664:1: rule__Multiplication__Group_1_0_0__1 : rule__Multiplication__Group_1_0_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4668:1: ( rule__Multiplication__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4669:2: rule__Multiplication__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__1__Impl_in_rule__Multiplication__Group_1_0_0__19472);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4675:1: rule__Multiplication__Group_1_0_0__1__Impl : ( '*' ) ;
    public final void rule__Multiplication__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4679:1: ( ( '*' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4680:1: ( '*' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4680:1: ( '*' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4681:1: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 
            match(input,44,FOLLOW_44_in_rule__Multiplication__Group_1_0_0__1__Impl9500); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4698:1: rule__Multiplication__Group_1_0_1__0 : rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 ;
    public final void rule__Multiplication__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4702:1: ( rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4703:2: rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__0__Impl_in_rule__Multiplication__Group_1_0_1__09535);
            rule__Multiplication__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__09538);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4710:1: rule__Multiplication__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4714:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4715:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4715:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4716:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4717:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4719:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4729:1: rule__Multiplication__Group_1_0_1__1 : rule__Multiplication__Group_1_0_1__1__Impl ;
    public final void rule__Multiplication__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4733:1: ( rule__Multiplication__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4734:2: rule__Multiplication__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__1__Impl_in_rule__Multiplication__Group_1_0_1__19596);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4740:1: rule__Multiplication__Group_1_0_1__1__Impl : ( '/' ) ;
    public final void rule__Multiplication__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4744:1: ( ( '/' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4745:1: ( '/' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4745:1: ( '/' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4746:1: '/'
            {
             before(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 
            match(input,45,FOLLOW_45_in_rule__Multiplication__Group_1_0_1__1__Impl9624); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4763:1: rule__Multiplication__Group_1_0_2__0 : rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1 ;
    public final void rule__Multiplication__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4767:1: ( rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4768:2: rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__0__Impl_in_rule__Multiplication__Group_1_0_2__09659);
            rule__Multiplication__Group_1_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__1_in_rule__Multiplication__Group_1_0_2__09662);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4775:1: rule__Multiplication__Group_1_0_2__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4779:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4780:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4780:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4781:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4782:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4784:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4794:1: rule__Multiplication__Group_1_0_2__1 : rule__Multiplication__Group_1_0_2__1__Impl ;
    public final void rule__Multiplication__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4798:1: ( rule__Multiplication__Group_1_0_2__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4799:2: rule__Multiplication__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__1__Impl_in_rule__Multiplication__Group_1_0_2__19720);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4805:1: rule__Multiplication__Group_1_0_2__1__Impl : ( '%' ) ;
    public final void rule__Multiplication__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4809:1: ( ( '%' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:1: ( '%' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:1: ( '%' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4811:1: '%'
            {
             before(grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1()); 
            match(input,46,FOLLOW_46_in_rule__Multiplication__Group_1_0_2__1__Impl9748); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4828:1: rule__Unary__Group_1__0 : rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1 ;
    public final void rule__Unary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4832:1: ( rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4833:2: rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1__0__Impl_in_rule__Unary__Group_1__09783);
            rule__Unary__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1__1_in_rule__Unary__Group_1__09786);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4840:1: rule__Unary__Group_1__0__Impl : ( ( rule__Unary__Alternatives_1_0 ) ) ;
    public final void rule__Unary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4844:1: ( ( ( rule__Unary__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4845:1: ( ( rule__Unary__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4845:1: ( ( rule__Unary__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4846:1: ( rule__Unary__Alternatives_1_0 )
            {
             before(grammarAccess.getUnaryAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4847:1: ( rule__Unary__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4847:2: rule__Unary__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Unary__Alternatives_1_0_in_rule__Unary__Group_1__0__Impl9813);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4857:1: rule__Unary__Group_1__1 : rule__Unary__Group_1__1__Impl ;
    public final void rule__Unary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4861:1: ( rule__Unary__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4862:2: rule__Unary__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1__1__Impl_in_rule__Unary__Group_1__19843);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4868:1: rule__Unary__Group_1__1__Impl : ( ( rule__Unary__RightAssignment_1_1 ) ) ;
    public final void rule__Unary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4872:1: ( ( ( rule__Unary__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4873:1: ( ( rule__Unary__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4873:1: ( ( rule__Unary__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4874:1: ( rule__Unary__RightAssignment_1_1 )
            {
             before(grammarAccess.getUnaryAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4875:1: ( rule__Unary__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4875:2: rule__Unary__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Unary__RightAssignment_1_1_in_rule__Unary__Group_1__1__Impl9870);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4889:1: rule__Unary__Group_1_0_0__0 : rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1 ;
    public final void rule__Unary__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4893:1: ( rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4894:2: rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__0__Impl_in_rule__Unary__Group_1_0_0__09904);
            rule__Unary__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__1_in_rule__Unary__Group_1_0_0__09907);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4901:1: rule__Unary__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Unary__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4905:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4906:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4906:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4907:1: ()
            {
             before(grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4908:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4910:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4920:1: rule__Unary__Group_1_0_0__1 : rule__Unary__Group_1_0_0__1__Impl ;
    public final void rule__Unary__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4924:1: ( rule__Unary__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4925:2: rule__Unary__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__1__Impl_in_rule__Unary__Group_1_0_0__19965);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4931:1: rule__Unary__Group_1_0_0__1__Impl : ( ( rule__Unary__OpAssignment_1_0_0_1 ) ) ;
    public final void rule__Unary__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4935:1: ( ( ( rule__Unary__OpAssignment_1_0_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4936:1: ( ( rule__Unary__OpAssignment_1_0_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4936:1: ( ( rule__Unary__OpAssignment_1_0_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4937:1: ( rule__Unary__OpAssignment_1_0_0_1 )
            {
             before(grammarAccess.getUnaryAccess().getOpAssignment_1_0_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4938:1: ( rule__Unary__OpAssignment_1_0_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4938:2: rule__Unary__OpAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__Unary__OpAssignment_1_0_0_1_in_rule__Unary__Group_1_0_0__1__Impl9992);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4952:1: rule__Unary__Group_1_0_1__0 : rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1 ;
    public final void rule__Unary__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4956:1: ( rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4957:2: rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__0__Impl_in_rule__Unary__Group_1_0_1__010026);
            rule__Unary__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__1_in_rule__Unary__Group_1_0_1__010029);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4964:1: rule__Unary__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Unary__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4968:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4969:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4969:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4970:1: ()
            {
             before(grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4971:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4973:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4983:1: rule__Unary__Group_1_0_1__1 : rule__Unary__Group_1_0_1__1__Impl ;
    public final void rule__Unary__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4987:1: ( rule__Unary__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4988:2: rule__Unary__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__1__Impl_in_rule__Unary__Group_1_0_1__110087);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4994:1: rule__Unary__Group_1_0_1__1__Impl : ( ( rule__Unary__OpAssignment_1_0_1_1 ) ) ;
    public final void rule__Unary__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4998:1: ( ( ( rule__Unary__OpAssignment_1_0_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4999:1: ( ( rule__Unary__OpAssignment_1_0_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4999:1: ( ( rule__Unary__OpAssignment_1_0_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5000:1: ( rule__Unary__OpAssignment_1_0_1_1 )
            {
             before(grammarAccess.getUnaryAccess().getOpAssignment_1_0_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5001:1: ( rule__Unary__OpAssignment_1_0_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5001:2: rule__Unary__OpAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_rule__Unary__OpAssignment_1_0_1_1_in_rule__Unary__Group_1_0_1__1__Impl10114);
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


    // $ANTLR start "rule__Literal__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5015:1: rule__Literal__Group_1__0 : rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 ;
    public final void rule__Literal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5019:1: ( rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5020:2: rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1
            {
            pushFollow(FOLLOW_rule__Literal__Group_1__0__Impl_in_rule__Literal__Group_1__010148);
            rule__Literal__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Literal__Group_1__1_in_rule__Literal__Group_1__010151);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5027:1: rule__Literal__Group_1__0__Impl : ( () ) ;
    public final void rule__Literal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5031:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5032:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5032:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5033:1: ()
            {
             before(grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5034:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5036:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5046:1: rule__Literal__Group_1__1 : rule__Literal__Group_1__1__Impl ;
    public final void rule__Literal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5050:1: ( rule__Literal__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5051:2: rule__Literal__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Literal__Group_1__1__Impl_in_rule__Literal__Group_1__110209);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5057:1: rule__Literal__Group_1__1__Impl : ( ( rule__Literal__Alternatives_1_1 ) ) ;
    public final void rule__Literal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5061:1: ( ( ( rule__Literal__Alternatives_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5062:1: ( ( rule__Literal__Alternatives_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5062:1: ( ( rule__Literal__Alternatives_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5063:1: ( rule__Literal__Alternatives_1_1 )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5064:1: ( rule__Literal__Alternatives_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5064:2: rule__Literal__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_1_1_in_rule__Literal__Group_1__1__Impl10236);
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


    // $ANTLR start "rule__NumberLiteral__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5078:1: rule__NumberLiteral__Group__0 : rule__NumberLiteral__Group__0__Impl rule__NumberLiteral__Group__1 ;
    public final void rule__NumberLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5082:1: ( rule__NumberLiteral__Group__0__Impl rule__NumberLiteral__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5083:2: rule__NumberLiteral__Group__0__Impl rule__NumberLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Group__0__Impl_in_rule__NumberLiteral__Group__010270);
            rule__NumberLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NumberLiteral__Group__1_in_rule__NumberLiteral__Group__010273);
            rule__NumberLiteral__Group__1();

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
    // $ANTLR end "rule__NumberLiteral__Group__0"


    // $ANTLR start "rule__NumberLiteral__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5090:1: rule__NumberLiteral__Group__0__Impl : ( () ) ;
    public final void rule__NumberLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5094:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5095:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5095:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5096:1: ()
            {
             before(grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5097:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5099:1: 
            {
            }

             after(grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Group__0__Impl"


    // $ANTLR start "rule__NumberLiteral__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5109:1: rule__NumberLiteral__Group__1 : rule__NumberLiteral__Group__1__Impl ;
    public final void rule__NumberLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5113:1: ( rule__NumberLiteral__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5114:2: rule__NumberLiteral__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumberLiteral__Group__1__Impl_in_rule__NumberLiteral__Group__110331);
            rule__NumberLiteral__Group__1__Impl();

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
    // $ANTLR end "rule__NumberLiteral__Group__1"


    // $ANTLR start "rule__NumberLiteral__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5120:1: rule__NumberLiteral__Group__1__Impl : ( ( rule__NumberLiteral__ValueAssignment_1 ) ) ;
    public final void rule__NumberLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5124:1: ( ( ( rule__NumberLiteral__ValueAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5125:1: ( ( rule__NumberLiteral__ValueAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5125:1: ( ( rule__NumberLiteral__ValueAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5126:1: ( rule__NumberLiteral__ValueAssignment_1 )
            {
             before(grammarAccess.getNumberLiteralAccess().getValueAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5127:1: ( rule__NumberLiteral__ValueAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5127:2: rule__NumberLiteral__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__NumberLiteral__ValueAssignment_1_in_rule__NumberLiteral__Group__1__Impl10358);
            rule__NumberLiteral__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5141:1: rule__ParenthesizedExpression__Group__0 : rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 ;
    public final void rule__ParenthesizedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5145:1: ( rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5146:2: rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__010392);
            rule__ParenthesizedExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__010395);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5153:1: rule__ParenthesizedExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5157:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5158:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5158:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5159:1: '('
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__ParenthesizedExpression__Group__0__Impl10423); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5172:1: rule__ParenthesizedExpression__Group__1 : rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 ;
    public final void rule__ParenthesizedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5176:1: ( rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5177:2: rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__110454);
            rule__ParenthesizedExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__110457);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5184:1: rule__ParenthesizedExpression__Group__1__Impl : ( ruleExpression ) ;
    public final void rule__ParenthesizedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5188:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5189:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5189:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5190:1: ruleExpression
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__Group__1__Impl10484);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5201:1: rule__ParenthesizedExpression__Group__2 : rule__ParenthesizedExpression__Group__2__Impl ;
    public final void rule__ParenthesizedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5205:1: ( rule__ParenthesizedExpression__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5206:2: rule__ParenthesizedExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__210513);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5212:1: rule__ParenthesizedExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5216:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5217:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5217:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5218:1: ')'
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_25_in_rule__ParenthesizedExpression__Group__2__Impl10541); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5237:1: rule__FunctionCall__Group__0 : rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 ;
    public final void rule__FunctionCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5241:1: ( rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5242:2: rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__0__Impl_in_rule__FunctionCall__Group__010578);
            rule__FunctionCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__1_in_rule__FunctionCall__Group__010581);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5249:1: rule__FunctionCall__Group__0__Impl : ( () ) ;
    public final void rule__FunctionCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5253:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5254:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5254:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5255:1: ()
            {
             before(grammarAccess.getFunctionCallAccess().getFunctionCallAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5256:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5258:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5268:1: rule__FunctionCall__Group__1 : rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 ;
    public final void rule__FunctionCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5272:1: ( rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5273:2: rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__1__Impl_in_rule__FunctionCall__Group__110639);
            rule__FunctionCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__2_in_rule__FunctionCall__Group__110642);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5280:1: rule__FunctionCall__Group__1__Impl : ( ( rule__FunctionCall__FuncAssignment_1 ) ) ;
    public final void rule__FunctionCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5284:1: ( ( ( rule__FunctionCall__FuncAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5285:1: ( ( rule__FunctionCall__FuncAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5285:1: ( ( rule__FunctionCall__FuncAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5286:1: ( rule__FunctionCall__FuncAssignment_1 )
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5287:1: ( rule__FunctionCall__FuncAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5287:2: rule__FunctionCall__FuncAssignment_1
            {
            pushFollow(FOLLOW_rule__FunctionCall__FuncAssignment_1_in_rule__FunctionCall__Group__1__Impl10669);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5297:1: rule__FunctionCall__Group__2 : rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 ;
    public final void rule__FunctionCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5301:1: ( rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5302:2: rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__2__Impl_in_rule__FunctionCall__Group__210699);
            rule__FunctionCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__3_in_rule__FunctionCall__Group__210702);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5309:1: rule__FunctionCall__Group__2__Impl : ( '(' ) ;
    public final void rule__FunctionCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5313:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5314:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5314:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5315:1: '('
            {
             before(grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__FunctionCall__Group__2__Impl10730); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5328:1: rule__FunctionCall__Group__3 : rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 ;
    public final void rule__FunctionCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5332:1: ( rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5333:2: rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__3__Impl_in_rule__FunctionCall__Group__310761);
            rule__FunctionCall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__4_in_rule__FunctionCall__Group__310764);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5340:1: rule__FunctionCall__Group__3__Impl : ( ( rule__FunctionCall__Group_3__0 )? ) ;
    public final void rule__FunctionCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5344:1: ( ( ( rule__FunctionCall__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5345:1: ( ( rule__FunctionCall__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5345:1: ( ( rule__FunctionCall__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5346:1: ( rule__FunctionCall__Group_3__0 )?
            {
             before(grammarAccess.getFunctionCallAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5347:1: ( rule__FunctionCall__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID||LA33_0==RULE_NUMBER||(LA33_0>=12 && LA33_0<=14)||LA33_0==24||LA33_0==47||LA33_0==50||(LA33_0>=54 && LA33_0<=55)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5347:2: rule__FunctionCall__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FunctionCall__Group_3__0_in_rule__FunctionCall__Group__3__Impl10791);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5357:1: rule__FunctionCall__Group__4 : rule__FunctionCall__Group__4__Impl ;
    public final void rule__FunctionCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5361:1: ( rule__FunctionCall__Group__4__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5362:2: rule__FunctionCall__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__4__Impl_in_rule__FunctionCall__Group__410822);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5368:1: rule__FunctionCall__Group__4__Impl : ( ')' ) ;
    public final void rule__FunctionCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5372:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5373:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5373:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5374:1: ')'
            {
             before(grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__FunctionCall__Group__4__Impl10850); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5397:1: rule__FunctionCall__Group_3__0 : rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 ;
    public final void rule__FunctionCall__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5401:1: ( rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5402:2: rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3__0__Impl_in_rule__FunctionCall__Group_3__010891);
            rule__FunctionCall__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group_3__1_in_rule__FunctionCall__Group_3__010894);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5409:1: rule__FunctionCall__Group_3__0__Impl : ( ( rule__FunctionCall__ArgsAssignment_3_0 ) ) ;
    public final void rule__FunctionCall__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5413:1: ( ( ( rule__FunctionCall__ArgsAssignment_3_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5414:1: ( ( rule__FunctionCall__ArgsAssignment_3_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5414:1: ( ( rule__FunctionCall__ArgsAssignment_3_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5415:1: ( rule__FunctionCall__ArgsAssignment_3_0 )
            {
             before(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5416:1: ( rule__FunctionCall__ArgsAssignment_3_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5416:2: rule__FunctionCall__ArgsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__FunctionCall__ArgsAssignment_3_0_in_rule__FunctionCall__Group_3__0__Impl10921);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5426:1: rule__FunctionCall__Group_3__1 : rule__FunctionCall__Group_3__1__Impl ;
    public final void rule__FunctionCall__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5430:1: ( rule__FunctionCall__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5431:2: rule__FunctionCall__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3__1__Impl_in_rule__FunctionCall__Group_3__110951);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5437:1: rule__FunctionCall__Group_3__1__Impl : ( ( rule__FunctionCall__Group_3_1__0 )* ) ;
    public final void rule__FunctionCall__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5441:1: ( ( ( rule__FunctionCall__Group_3_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5442:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5442:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5443:1: ( rule__FunctionCall__Group_3_1__0 )*
            {
             before(grammarAccess.getFunctionCallAccess().getGroup_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5444:1: ( rule__FunctionCall__Group_3_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==26) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5444:2: rule__FunctionCall__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__0_in_rule__FunctionCall__Group_3__1__Impl10978);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5458:1: rule__FunctionCall__Group_3_1__0 : rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 ;
    public final void rule__FunctionCall__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5462:1: ( rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5463:2: rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__0__Impl_in_rule__FunctionCall__Group_3_1__011013);
            rule__FunctionCall__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__1_in_rule__FunctionCall__Group_3_1__011016);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5470:1: rule__FunctionCall__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__FunctionCall__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5474:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5475:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5475:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5476:1: ','
            {
             before(grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0()); 
            match(input,26,FOLLOW_26_in_rule__FunctionCall__Group_3_1__0__Impl11044); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5489:1: rule__FunctionCall__Group_3_1__1 : rule__FunctionCall__Group_3_1__1__Impl ;
    public final void rule__FunctionCall__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5493:1: ( rule__FunctionCall__Group_3_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5494:2: rule__FunctionCall__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__1__Impl_in_rule__FunctionCall__Group_3_1__111075);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5500:1: rule__FunctionCall__Group_3_1__1__Impl : ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) ) ;
    public final void rule__FunctionCall__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5504:1: ( ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5505:1: ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5505:1: ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5506:1: ( rule__FunctionCall__ArgsAssignment_3_1_1 )
            {
             before(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5507:1: ( rule__FunctionCall__ArgsAssignment_3_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5507:2: rule__FunctionCall__ArgsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__FunctionCall__ArgsAssignment_3_1_1_in_rule__FunctionCall__Group_3_1__1__Impl11102);
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


    // $ANTLR start "rule__IndexedCall__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5521:1: rule__IndexedCall__Group__0 : rule__IndexedCall__Group__0__Impl rule__IndexedCall__Group__1 ;
    public final void rule__IndexedCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5525:1: ( rule__IndexedCall__Group__0__Impl rule__IndexedCall__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5526:2: rule__IndexedCall__Group__0__Impl rule__IndexedCall__Group__1
            {
            pushFollow(FOLLOW_rule__IndexedCall__Group__0__Impl_in_rule__IndexedCall__Group__011136);
            rule__IndexedCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IndexedCall__Group__1_in_rule__IndexedCall__Group__011139);
            rule__IndexedCall__Group__1();

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
    // $ANTLR end "rule__IndexedCall__Group__0"


    // $ANTLR start "rule__IndexedCall__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5533:1: rule__IndexedCall__Group__0__Impl : ( ruleVarOrArgumentCall ) ;
    public final void rule__IndexedCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5537:1: ( ( ruleVarOrArgumentCall ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5538:1: ( ruleVarOrArgumentCall )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5538:1: ( ruleVarOrArgumentCall )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5539:1: ruleVarOrArgumentCall
            {
             before(grammarAccess.getIndexedCallAccess().getVarOrArgumentCallParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_rule__IndexedCall__Group__0__Impl11166);
            ruleVarOrArgumentCall();

            state._fsp--;

             after(grammarAccess.getIndexedCallAccess().getVarOrArgumentCallParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexedCall__Group__0__Impl"


    // $ANTLR start "rule__IndexedCall__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5550:1: rule__IndexedCall__Group__1 : rule__IndexedCall__Group__1__Impl ;
    public final void rule__IndexedCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5554:1: ( rule__IndexedCall__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5555:2: rule__IndexedCall__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IndexedCall__Group__1__Impl_in_rule__IndexedCall__Group__111195);
            rule__IndexedCall__Group__1__Impl();

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
    // $ANTLR end "rule__IndexedCall__Group__1"


    // $ANTLR start "rule__IndexedCall__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5561:1: rule__IndexedCall__Group__1__Impl : ( ( rule__IndexedCall__Group_1__0 )? ) ;
    public final void rule__IndexedCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5565:1: ( ( ( rule__IndexedCall__Group_1__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5566:1: ( ( rule__IndexedCall__Group_1__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5566:1: ( ( rule__IndexedCall__Group_1__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5567:1: ( rule__IndexedCall__Group_1__0 )?
            {
             before(grammarAccess.getIndexedCallAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5568:1: ( rule__IndexedCall__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==47) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5568:2: rule__IndexedCall__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__IndexedCall__Group_1__0_in_rule__IndexedCall__Group__1__Impl11222);
                    rule__IndexedCall__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIndexedCallAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexedCall__Group__1__Impl"


    // $ANTLR start "rule__IndexedCall__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5582:1: rule__IndexedCall__Group_1__0 : rule__IndexedCall__Group_1__0__Impl rule__IndexedCall__Group_1__1 ;
    public final void rule__IndexedCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5586:1: ( rule__IndexedCall__Group_1__0__Impl rule__IndexedCall__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5587:2: rule__IndexedCall__Group_1__0__Impl rule__IndexedCall__Group_1__1
            {
            pushFollow(FOLLOW_rule__IndexedCall__Group_1__0__Impl_in_rule__IndexedCall__Group_1__011257);
            rule__IndexedCall__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IndexedCall__Group_1__1_in_rule__IndexedCall__Group_1__011260);
            rule__IndexedCall__Group_1__1();

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
    // $ANTLR end "rule__IndexedCall__Group_1__0"


    // $ANTLR start "rule__IndexedCall__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5594:1: rule__IndexedCall__Group_1__0__Impl : ( '[' ) ;
    public final void rule__IndexedCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5598:1: ( ( '[' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5599:1: ( '[' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5599:1: ( '[' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5600:1: '['
            {
             before(grammarAccess.getIndexedCallAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,47,FOLLOW_47_in_rule__IndexedCall__Group_1__0__Impl11288); 
             after(grammarAccess.getIndexedCallAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexedCall__Group_1__0__Impl"


    // $ANTLR start "rule__IndexedCall__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5613:1: rule__IndexedCall__Group_1__1 : rule__IndexedCall__Group_1__1__Impl rule__IndexedCall__Group_1__2 ;
    public final void rule__IndexedCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5617:1: ( rule__IndexedCall__Group_1__1__Impl rule__IndexedCall__Group_1__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5618:2: rule__IndexedCall__Group_1__1__Impl rule__IndexedCall__Group_1__2
            {
            pushFollow(FOLLOW_rule__IndexedCall__Group_1__1__Impl_in_rule__IndexedCall__Group_1__111319);
            rule__IndexedCall__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IndexedCall__Group_1__2_in_rule__IndexedCall__Group_1__111322);
            rule__IndexedCall__Group_1__2();

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
    // $ANTLR end "rule__IndexedCall__Group_1__1"


    // $ANTLR start "rule__IndexedCall__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5625:1: rule__IndexedCall__Group_1__1__Impl : ( ( rule__IndexedCall__IndexAssignment_1_1 ) ) ;
    public final void rule__IndexedCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5629:1: ( ( ( rule__IndexedCall__IndexAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5630:1: ( ( rule__IndexedCall__IndexAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5630:1: ( ( rule__IndexedCall__IndexAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5631:1: ( rule__IndexedCall__IndexAssignment_1_1 )
            {
             before(grammarAccess.getIndexedCallAccess().getIndexAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5632:1: ( rule__IndexedCall__IndexAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5632:2: rule__IndexedCall__IndexAssignment_1_1
            {
            pushFollow(FOLLOW_rule__IndexedCall__IndexAssignment_1_1_in_rule__IndexedCall__Group_1__1__Impl11349);
            rule__IndexedCall__IndexAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIndexedCallAccess().getIndexAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexedCall__Group_1__1__Impl"


    // $ANTLR start "rule__IndexedCall__Group_1__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5642:1: rule__IndexedCall__Group_1__2 : rule__IndexedCall__Group_1__2__Impl ;
    public final void rule__IndexedCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5646:1: ( rule__IndexedCall__Group_1__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5647:2: rule__IndexedCall__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__IndexedCall__Group_1__2__Impl_in_rule__IndexedCall__Group_1__211379);
            rule__IndexedCall__Group_1__2__Impl();

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
    // $ANTLR end "rule__IndexedCall__Group_1__2"


    // $ANTLR start "rule__IndexedCall__Group_1__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5653:1: rule__IndexedCall__Group_1__2__Impl : ( ']' ) ;
    public final void rule__IndexedCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5657:1: ( ( ']' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5658:1: ( ']' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5658:1: ( ']' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5659:1: ']'
            {
             before(grammarAccess.getIndexedCallAccess().getRightSquareBracketKeyword_1_2()); 
            match(input,48,FOLLOW_48_in_rule__IndexedCall__Group_1__2__Impl11407); 
             after(grammarAccess.getIndexedCallAccess().getRightSquareBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexedCall__Group_1__2__Impl"


    // $ANTLR start "rule__VarOrArgumentCall__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5678:1: rule__VarOrArgumentCall__Group__0 : rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1 ;
    public final void rule__VarOrArgumentCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5682:1: ( rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5683:2: rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__0__Impl_in_rule__VarOrArgumentCall__Group__011444);
            rule__VarOrArgumentCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__1_in_rule__VarOrArgumentCall__Group__011447);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5690:1: rule__VarOrArgumentCall__Group__0__Impl : ( () ) ;
    public final void rule__VarOrArgumentCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5694:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5695:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5695:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5696:1: ()
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5697:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5699:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5709:1: rule__VarOrArgumentCall__Group__1 : rule__VarOrArgumentCall__Group__1__Impl ;
    public final void rule__VarOrArgumentCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5713:1: ( rule__VarOrArgumentCall__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5714:2: rule__VarOrArgumentCall__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__1__Impl_in_rule__VarOrArgumentCall__Group__111505);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5720:1: rule__VarOrArgumentCall__Group__1__Impl : ( ( rule__VarOrArgumentCall__CallAssignment_1 ) ) ;
    public final void rule__VarOrArgumentCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5724:1: ( ( ( rule__VarOrArgumentCall__CallAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5725:1: ( ( rule__VarOrArgumentCall__CallAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5725:1: ( ( rule__VarOrArgumentCall__CallAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5726:1: ( rule__VarOrArgumentCall__CallAssignment_1 )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5727:1: ( rule__VarOrArgumentCall__CallAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5727:2: rule__VarOrArgumentCall__CallAssignment_1
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__CallAssignment_1_in_rule__VarOrArgumentCall__Group__1__Impl11532);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5741:1: rule__NativeExpression__Group__0 : rule__NativeExpression__Group__0__Impl rule__NativeExpression__Group__1 ;
    public final void rule__NativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5745:1: ( rule__NativeExpression__Group__0__Impl rule__NativeExpression__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5746:2: rule__NativeExpression__Group__0__Impl rule__NativeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__0__Impl_in_rule__NativeExpression__Group__011566);
            rule__NativeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NativeExpression__Group__1_in_rule__NativeExpression__Group__011569);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5753:1: rule__NativeExpression__Group__0__Impl : ( () ) ;
    public final void rule__NativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5757:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5758:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5758:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5759:1: ()
            {
             before(grammarAccess.getNativeExpressionAccess().getNativeExpressionAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5760:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5762:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5772:1: rule__NativeExpression__Group__1 : rule__NativeExpression__Group__1__Impl rule__NativeExpression__Group__2 ;
    public final void rule__NativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5776:1: ( rule__NativeExpression__Group__1__Impl rule__NativeExpression__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5777:2: rule__NativeExpression__Group__1__Impl rule__NativeExpression__Group__2
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__1__Impl_in_rule__NativeExpression__Group__111627);
            rule__NativeExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NativeExpression__Group__2_in_rule__NativeExpression__Group__111630);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5784:1: rule__NativeExpression__Group__1__Impl : ( ( rule__NativeExpression__Alternatives_1 ) ) ;
    public final void rule__NativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5788:1: ( ( ( rule__NativeExpression__Alternatives_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5789:1: ( ( rule__NativeExpression__Alternatives_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5789:1: ( ( rule__NativeExpression__Alternatives_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5790:1: ( rule__NativeExpression__Alternatives_1 )
            {
             before(grammarAccess.getNativeExpressionAccess().getAlternatives_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5791:1: ( rule__NativeExpression__Alternatives_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5791:2: rule__NativeExpression__Alternatives_1
            {
            pushFollow(FOLLOW_rule__NativeExpression__Alternatives_1_in_rule__NativeExpression__Group__1__Impl11657);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5801:1: rule__NativeExpression__Group__2 : rule__NativeExpression__Group__2__Impl rule__NativeExpression__Group__3 ;
    public final void rule__NativeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5805:1: ( rule__NativeExpression__Group__2__Impl rule__NativeExpression__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5806:2: rule__NativeExpression__Group__2__Impl rule__NativeExpression__Group__3
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__2__Impl_in_rule__NativeExpression__Group__211687);
            rule__NativeExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NativeExpression__Group__3_in_rule__NativeExpression__Group__211690);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5813:1: rule__NativeExpression__Group__2__Impl : ( '.' ) ;
    public final void rule__NativeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5817:1: ( ( '.' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5818:1: ( '.' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5818:1: ( '.' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5819:1: '.'
            {
             before(grammarAccess.getNativeExpressionAccess().getFullStopKeyword_2()); 
            match(input,49,FOLLOW_49_in_rule__NativeExpression__Group__2__Impl11718); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5832:1: rule__NativeExpression__Group__3 : rule__NativeExpression__Group__3__Impl ;
    public final void rule__NativeExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5836:1: ( rule__NativeExpression__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5837:2: rule__NativeExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__3__Impl_in_rule__NativeExpression__Group__311749);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5843:1: rule__NativeExpression__Group__3__Impl : ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) ) ;
    public final void rule__NativeExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5847:1: ( ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5848:1: ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5848:1: ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5849:1: ( rule__NativeExpression__NativeFunctionAssignment_3 )
            {
             before(grammarAccess.getNativeExpressionAccess().getNativeFunctionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5850:1: ( rule__NativeExpression__NativeFunctionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5850:2: rule__NativeExpression__NativeFunctionAssignment_3
            {
            pushFollow(FOLLOW_rule__NativeExpression__NativeFunctionAssignment_3_in_rule__NativeExpression__Group__3__Impl11776);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5868:1: rule__RangeLiteral__Group__0 : rule__RangeLiteral__Group__0__Impl rule__RangeLiteral__Group__1 ;
    public final void rule__RangeLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5872:1: ( rule__RangeLiteral__Group__0__Impl rule__RangeLiteral__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5873:2: rule__RangeLiteral__Group__0__Impl rule__RangeLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__0__Impl_in_rule__RangeLiteral__Group__011814);
            rule__RangeLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__1_in_rule__RangeLiteral__Group__011817);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5880:1: rule__RangeLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RangeLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5884:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5885:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5885:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5886:1: ()
            {
             before(grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5887:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5889:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5899:1: rule__RangeLiteral__Group__1 : rule__RangeLiteral__Group__1__Impl rule__RangeLiteral__Group__2 ;
    public final void rule__RangeLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5903:1: ( rule__RangeLiteral__Group__1__Impl rule__RangeLiteral__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5904:2: rule__RangeLiteral__Group__1__Impl rule__RangeLiteral__Group__2
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__1__Impl_in_rule__RangeLiteral__Group__111875);
            rule__RangeLiteral__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__2_in_rule__RangeLiteral__Group__111878);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5911:1: rule__RangeLiteral__Group__1__Impl : ( '[' ) ;
    public final void rule__RangeLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5915:1: ( ( '[' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5916:1: ( '[' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5916:1: ( '[' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5917:1: '['
            {
             before(grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1()); 
            match(input,47,FOLLOW_47_in_rule__RangeLiteral__Group__1__Impl11906); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5930:1: rule__RangeLiteral__Group__2 : rule__RangeLiteral__Group__2__Impl rule__RangeLiteral__Group__3 ;
    public final void rule__RangeLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5934:1: ( rule__RangeLiteral__Group__2__Impl rule__RangeLiteral__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5935:2: rule__RangeLiteral__Group__2__Impl rule__RangeLiteral__Group__3
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__2__Impl_in_rule__RangeLiteral__Group__211937);
            rule__RangeLiteral__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__3_in_rule__RangeLiteral__Group__211940);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5942:1: rule__RangeLiteral__Group__2__Impl : ( ( rule__RangeLiteral__ValuesAssignment_2 ) ) ;
    public final void rule__RangeLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5946:1: ( ( ( rule__RangeLiteral__ValuesAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5947:1: ( ( rule__RangeLiteral__ValuesAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5947:1: ( ( rule__RangeLiteral__ValuesAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5948:1: ( rule__RangeLiteral__ValuesAssignment_2 )
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5949:1: ( rule__RangeLiteral__ValuesAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5949:2: rule__RangeLiteral__ValuesAssignment_2
            {
            pushFollow(FOLLOW_rule__RangeLiteral__ValuesAssignment_2_in_rule__RangeLiteral__Group__2__Impl11967);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5959:1: rule__RangeLiteral__Group__3 : rule__RangeLiteral__Group__3__Impl rule__RangeLiteral__Group__4 ;
    public final void rule__RangeLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5963:1: ( rule__RangeLiteral__Group__3__Impl rule__RangeLiteral__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5964:2: rule__RangeLiteral__Group__3__Impl rule__RangeLiteral__Group__4
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__3__Impl_in_rule__RangeLiteral__Group__311997);
            rule__RangeLiteral__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__4_in_rule__RangeLiteral__Group__312000);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5971:1: rule__RangeLiteral__Group__3__Impl : ( ( rule__RangeLiteral__Group_3__0 )* ) ;
    public final void rule__RangeLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5975:1: ( ( ( rule__RangeLiteral__Group_3__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5976:1: ( ( rule__RangeLiteral__Group_3__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5976:1: ( ( rule__RangeLiteral__Group_3__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5977:1: ( rule__RangeLiteral__Group_3__0 )*
            {
             before(grammarAccess.getRangeLiteralAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5978:1: ( rule__RangeLiteral__Group_3__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==26) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5978:2: rule__RangeLiteral__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__RangeLiteral__Group_3__0_in_rule__RangeLiteral__Group__3__Impl12027);
            	    rule__RangeLiteral__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5988:1: rule__RangeLiteral__Group__4 : rule__RangeLiteral__Group__4__Impl ;
    public final void rule__RangeLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5992:1: ( rule__RangeLiteral__Group__4__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5993:2: rule__RangeLiteral__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__4__Impl_in_rule__RangeLiteral__Group__412058);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5999:1: rule__RangeLiteral__Group__4__Impl : ( ']' ) ;
    public final void rule__RangeLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6003:1: ( ( ']' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6004:1: ( ']' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6004:1: ( ']' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6005:1: ']'
            {
             before(grammarAccess.getRangeLiteralAccess().getRightSquareBracketKeyword_4()); 
            match(input,48,FOLLOW_48_in_rule__RangeLiteral__Group__4__Impl12086); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6028:1: rule__RangeLiteral__Group_3__0 : rule__RangeLiteral__Group_3__0__Impl rule__RangeLiteral__Group_3__1 ;
    public final void rule__RangeLiteral__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6032:1: ( rule__RangeLiteral__Group_3__0__Impl rule__RangeLiteral__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6033:2: rule__RangeLiteral__Group_3__0__Impl rule__RangeLiteral__Group_3__1
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group_3__0__Impl_in_rule__RangeLiteral__Group_3__012127);
            rule__RangeLiteral__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group_3__1_in_rule__RangeLiteral__Group_3__012130);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6040:1: rule__RangeLiteral__Group_3__0__Impl : ( ',' ) ;
    public final void rule__RangeLiteral__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6044:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6045:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6045:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6046:1: ','
            {
             before(grammarAccess.getRangeLiteralAccess().getCommaKeyword_3_0()); 
            match(input,26,FOLLOW_26_in_rule__RangeLiteral__Group_3__0__Impl12158); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6059:1: rule__RangeLiteral__Group_3__1 : rule__RangeLiteral__Group_3__1__Impl ;
    public final void rule__RangeLiteral__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6063:1: ( rule__RangeLiteral__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6064:2: rule__RangeLiteral__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group_3__1__Impl_in_rule__RangeLiteral__Group_3__112189);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6070:1: rule__RangeLiteral__Group_3__1__Impl : ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) ) ;
    public final void rule__RangeLiteral__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6074:1: ( ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6075:1: ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6075:1: ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6076:1: ( rule__RangeLiteral__ValuesAssignment_3_1 )
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesAssignment_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6077:1: ( rule__RangeLiteral__ValuesAssignment_3_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6077:2: rule__RangeLiteral__ValuesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__RangeLiteral__ValuesAssignment_3_1_in_rule__RangeLiteral__Group_3__1__Impl12216);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6091:1: rule__ContextRef__Group__0 : rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1 ;
    public final void rule__ContextRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6095:1: ( rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6096:2: rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__0__Impl_in_rule__ContextRef__Group__012250);
            rule__ContextRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextRef__Group__1_in_rule__ContextRef__Group__012253);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6103:1: rule__ContextRef__Group__0__Impl : ( 'this' ) ;
    public final void rule__ContextRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6107:1: ( ( 'this' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6108:1: ( 'this' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6108:1: ( 'this' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6109:1: 'this'
            {
             before(grammarAccess.getContextRefAccess().getThisKeyword_0()); 
            match(input,50,FOLLOW_50_in_rule__ContextRef__Group__0__Impl12281); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6122:1: rule__ContextRef__Group__1 : rule__ContextRef__Group__1__Impl ;
    public final void rule__ContextRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6126:1: ( rule__ContextRef__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6127:2: rule__ContextRef__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__1__Impl_in_rule__ContextRef__Group__112312);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6133:1: rule__ContextRef__Group__1__Impl : ( ruleNodeRef ) ;
    public final void rule__ContextRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6137:1: ( ( ruleNodeRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6138:1: ( ruleNodeRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6138:1: ( ruleNodeRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6139:1: ruleNodeRef
            {
             before(grammarAccess.getContextRefAccess().getNodeRefParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleNodeRef_in_rule__ContextRef__Group__1__Impl12339);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6154:1: rule__NodeRef__Group__0 : rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 ;
    public final void rule__NodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6158:1: ( rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6159:2: rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__012372);
            rule__NodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__012375);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6166:1: rule__NodeRef__Group__0__Impl : ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) ) ;
    public final void rule__NodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6170:1: ( ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6171:1: ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6171:1: ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6172:1: ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6172:1: ( ( rule__NodeRef__NodesAssignment_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6173:1: ( rule__NodeRef__NodesAssignment_0 )
            {
             before(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6174:1: ( rule__NodeRef__NodesAssignment_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6174:2: rule__NodeRef__NodesAssignment_0
            {
            pushFollow(FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl12404);
            rule__NodeRef__NodesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 

            }

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6177:1: ( ( rule__NodeRef__NodesAssignment_0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6178:1: ( rule__NodeRef__NodesAssignment_0 )*
            {
             before(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6179:1: ( rule__NodeRef__NodesAssignment_0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==49) ) {
                    int LA37_2 = input.LA(2);

                    if ( (LA37_2==RULE_ID) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6179:2: rule__NodeRef__NodesAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl12416);
            	    rule__NodeRef__NodesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6190:1: rule__NodeRef__Group__1 : rule__NodeRef__Group__1__Impl ;
    public final void rule__NodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6194:1: ( rule__NodeRef__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6195:2: rule__NodeRef__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__112449);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6201:1: rule__NodeRef__Group__1__Impl : ( ( rule__NodeRef__Group_1__0 )? ) ;
    public final void rule__NodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6205:1: ( ( ( rule__NodeRef__Group_1__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6206:1: ( ( rule__NodeRef__Group_1__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6206:1: ( ( rule__NodeRef__Group_1__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6207:1: ( rule__NodeRef__Group_1__0 )?
            {
             before(grammarAccess.getNodeRefAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6208:1: ( rule__NodeRef__Group_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==51) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6208:2: rule__NodeRef__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__NodeRef__Group_1__0_in_rule__NodeRef__Group__1__Impl12476);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6222:1: rule__NodeRef__Group_1__0 : rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1 ;
    public final void rule__NodeRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6226:1: ( rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6227:2: rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group_1__0__Impl_in_rule__NodeRef__Group_1__012511);
            rule__NodeRef__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group_1__1_in_rule__NodeRef__Group_1__012514);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6234:1: rule__NodeRef__Group_1__0__Impl : ( '->' ) ;
    public final void rule__NodeRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6238:1: ( ( '->' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6239:1: ( '->' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6239:1: ( '->' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6240:1: '->'
            {
             before(grammarAccess.getNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0()); 
            match(input,51,FOLLOW_51_in_rule__NodeRef__Group_1__0__Impl12542); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6253:1: rule__NodeRef__Group_1__1 : rule__NodeRef__Group_1__1__Impl ;
    public final void rule__NodeRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6257:1: ( rule__NodeRef__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6258:2: rule__NodeRef__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group_1__1__Impl_in_rule__NodeRef__Group_1__112573);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6264:1: rule__NodeRef__Group_1__1__Impl : ( ( rule__NodeRef__RefAssignment_1_1 ) ) ;
    public final void rule__NodeRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6268:1: ( ( ( rule__NodeRef__RefAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6269:1: ( ( rule__NodeRef__RefAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6269:1: ( ( rule__NodeRef__RefAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6270:1: ( rule__NodeRef__RefAssignment_1_1 )
            {
             before(grammarAccess.getNodeRefAccess().getRefAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6271:1: ( rule__NodeRef__RefAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6271:2: rule__NodeRef__RefAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NodeRef__RefAssignment_1_1_in_rule__NodeRef__Group_1__1__Impl12600);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6285:1: rule__PrimaryNodeRef__Group__0 : rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1 ;
    public final void rule__PrimaryNodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6289:1: ( rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6290:2: rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__0__Impl_in_rule__PrimaryNodeRef__Group__012634);
            rule__PrimaryNodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__1_in_rule__PrimaryNodeRef__Group__012637);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6297:1: rule__PrimaryNodeRef__Group__0__Impl : ( () ) ;
    public final void rule__PrimaryNodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6301:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6302:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6302:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6303:1: ()
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6304:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6306:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6316:1: rule__PrimaryNodeRef__Group__1 : rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2 ;
    public final void rule__PrimaryNodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6320:1: ( rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6321:2: rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__1__Impl_in_rule__PrimaryNodeRef__Group__112695);
            rule__PrimaryNodeRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__2_in_rule__PrimaryNodeRef__Group__112698);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6328:1: rule__PrimaryNodeRef__Group__1__Impl : ( '.' ) ;
    public final void rule__PrimaryNodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6332:1: ( ( '.' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6333:1: ( '.' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6333:1: ( '.' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6334:1: '.'
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getFullStopKeyword_1()); 
            match(input,49,FOLLOW_49_in_rule__PrimaryNodeRef__Group__1__Impl12726); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6347:1: rule__PrimaryNodeRef__Group__2 : rule__PrimaryNodeRef__Group__2__Impl ;
    public final void rule__PrimaryNodeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6351:1: ( rule__PrimaryNodeRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6352:2: rule__PrimaryNodeRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__2__Impl_in_rule__PrimaryNodeRef__Group__212757);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6358:1: rule__PrimaryNodeRef__Group__2__Impl : ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) ) ;
    public final void rule__PrimaryNodeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6362:1: ( ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6363:1: ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6363:1: ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6364:1: ( rule__PrimaryNodeRef__NodeAssignment_2 )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6365:1: ( rule__PrimaryNodeRef__NodeAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6365:2: rule__PrimaryNodeRef__NodeAssignment_2
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__NodeAssignment_2_in_rule__PrimaryNodeRef__Group__2__Impl12784);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6381:1: rule__ResourceRef__Group__0 : rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1 ;
    public final void rule__ResourceRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6385:1: ( rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6386:2: rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__0__Impl_in_rule__ResourceRef__Group__012820);
            rule__ResourceRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResourceRef__Group__1_in_rule__ResourceRef__Group__012823);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6393:1: rule__ResourceRef__Group__0__Impl : ( () ) ;
    public final void rule__ResourceRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6397:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6398:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6398:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6399:1: ()
            {
             before(grammarAccess.getResourceRefAccess().getResourceRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6400:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6402:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6412:1: rule__ResourceRef__Group__1 : rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2 ;
    public final void rule__ResourceRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6416:1: ( rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6417:2: rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__1__Impl_in_rule__ResourceRef__Group__112881);
            rule__ResourceRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResourceRef__Group__2_in_rule__ResourceRef__Group__112884);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6424:1: rule__ResourceRef__Group__1__Impl : ( 'Res' ) ;
    public final void rule__ResourceRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6428:1: ( ( 'Res' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6429:1: ( 'Res' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6429:1: ( 'Res' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6430:1: 'Res'
            {
             before(grammarAccess.getResourceRefAccess().getResKeyword_1()); 
            match(input,52,FOLLOW_52_in_rule__ResourceRef__Group__1__Impl12912); 
             after(grammarAccess.getResourceRefAccess().getResKeyword_1()); 

            }


            }

        }
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6443:1: rule__ResourceRef__Group__2 : rule__ResourceRef__Group__2__Impl ;
    public final void rule__ResourceRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6447:1: ( rule__ResourceRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6448:2: rule__ResourceRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__2__Impl_in_rule__ResourceRef__Group__212943);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6454:1: rule__ResourceRef__Group__2__Impl : ( ( rule__ResourceRef__ResourceAssignment_2 ) ) ;
    public final void rule__ResourceRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6458:1: ( ( ( rule__ResourceRef__ResourceAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6459:1: ( ( rule__ResourceRef__ResourceAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6459:1: ( ( rule__ResourceRef__ResourceAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6460:1: ( rule__ResourceRef__ResourceAssignment_2 )
            {
             before(grammarAccess.getResourceRefAccess().getResourceAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6461:1: ( rule__ResourceRef__ResourceAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6461:2: rule__ResourceRef__ResourceAssignment_2
            {
            pushFollow(FOLLOW_rule__ResourceRef__ResourceAssignment_2_in_rule__ResourceRef__Group__2__Impl12970);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6477:1: rule__LinkRef__Group__0 : rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1 ;
    public final void rule__LinkRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6481:1: ( rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6482:2: rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__0__Impl_in_rule__LinkRef__Group__013006);
            rule__LinkRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LinkRef__Group__1_in_rule__LinkRef__Group__013009);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6489:1: rule__LinkRef__Group__0__Impl : ( () ) ;
    public final void rule__LinkRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6493:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6494:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6494:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6495:1: ()
            {
             before(grammarAccess.getLinkRefAccess().getLinkRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6496:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6498:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6508:1: rule__LinkRef__Group__1 : rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2 ;
    public final void rule__LinkRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6512:1: ( rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6513:2: rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__1__Impl_in_rule__LinkRef__Group__113067);
            rule__LinkRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LinkRef__Group__2_in_rule__LinkRef__Group__113070);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6520:1: rule__LinkRef__Group__1__Impl : ( 'Link' ) ;
    public final void rule__LinkRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6524:1: ( ( 'Link' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6525:1: ( 'Link' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6525:1: ( 'Link' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6526:1: 'Link'
            {
             before(grammarAccess.getLinkRefAccess().getLinkKeyword_1()); 
            match(input,53,FOLLOW_53_in_rule__LinkRef__Group__1__Impl13098); 
             after(grammarAccess.getLinkRefAccess().getLinkKeyword_1()); 

            }


            }

        }
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6539:1: rule__LinkRef__Group__2 : rule__LinkRef__Group__2__Impl ;
    public final void rule__LinkRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6543:1: ( rule__LinkRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6544:2: rule__LinkRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__2__Impl_in_rule__LinkRef__Group__213129);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6550:1: rule__LinkRef__Group__2__Impl : ( ( rule__LinkRef__LinkAssignment_2 ) ) ;
    public final void rule__LinkRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6554:1: ( ( ( rule__LinkRef__LinkAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6555:1: ( ( rule__LinkRef__LinkAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6555:1: ( ( rule__LinkRef__LinkAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6556:1: ( rule__LinkRef__LinkAssignment_2 )
            {
             before(grammarAccess.getLinkRefAccess().getLinkAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6557:1: ( rule__LinkRef__LinkAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6557:2: rule__LinkRef__LinkAssignment_2
            {
            pushFollow(FOLLOW_rule__LinkRef__LinkAssignment_2_in_rule__LinkRef__Group__2__Impl13156);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6574:1: rule__Mod__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Mod__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6578:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6579:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6579:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6580:1: RULE_ID
            {
             before(grammarAccess.getModAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Mod__NameAssignment_0_113197); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6589:1: rule__Mod__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Mod__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6593:1: ( ( ruleImport ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6594:1: ( ruleImport )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6594:1: ( ruleImport )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6595:1: ruleImport
            {
             before(grammarAccess.getModAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Mod__ImportsAssignment_113228);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6604:1: rule__Mod__FunctionsAssignment_2_0 : ( ruleFunction ) ;
    public final void rule__Mod__FunctionsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6608:1: ( ( ruleFunction ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6609:1: ( ruleFunction )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6609:1: ( ruleFunction )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6610:1: ruleFunction
            {
             before(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleFunction_in_rule__Mod__FunctionsAssignment_2_013259);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6619:1: rule__Mod__StatementsAssignment_2_1 : ( ruleStatement ) ;
    public final void rule__Mod__StatementsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6623:1: ( ( ruleStatement ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6624:1: ( ruleStatement )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6624:1: ( ruleStatement )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6625:1: ruleStatement
            {
             before(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Mod__StatementsAssignment_2_113290);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6635:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6639:1: ( ( RULE_STRING ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6640:1: ( RULE_STRING )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6640:1: ( RULE_STRING )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6641:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_113322); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6650:1: rule__Function__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6654:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6655:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6655:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6656:1: RULE_ID
            {
             before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Function__NameAssignment_113353); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6665:1: rule__Function__ArgsAssignment_3_0 : ( ruleArgument ) ;
    public final void rule__Function__ArgsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6669:1: ( ( ruleArgument ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6670:1: ( ruleArgument )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6670:1: ( ruleArgument )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6671:1: ruleArgument
            {
             before(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_013384);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6680:1: rule__Function__ArgsAssignment_3_1_1 : ( ruleArgument ) ;
    public final void rule__Function__ArgsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6684:1: ( ( ruleArgument ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6685:1: ( ruleArgument )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6685:1: ( ruleArgument )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6686:1: ruleArgument
            {
             before(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_1_113415);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6695:1: rule__Function__BlockAssignment_5 : ( ruleBlock ) ;
    public final void rule__Function__BlockAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6699:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6700:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6700:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6701:1: ruleBlock
            {
             before(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__Function__BlockAssignment_513446);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6710:1: rule__Argument__NameAssignment : ( RULE_ID ) ;
    public final void rule__Argument__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6714:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6715:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6715:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6716:1: RULE_ID
            {
             before(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Argument__NameAssignment13477); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6725:1: rule__Block__StatementsAssignment_2 : ( ruleStatement ) ;
    public final void rule__Block__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6729:1: ( ( ruleStatement ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6730:1: ( ruleStatement )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6730:1: ( ruleStatement )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6731:1: ruleStatement
            {
             before(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Block__StatementsAssignment_213508);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6740:1: rule__Statement__ExpressionAssignment_0_0_3 : ( ruleExpression ) ;
    public final void rule__Statement__ExpressionAssignment_0_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6744:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6745:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6745:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6746:1: ruleExpression
            {
             before(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_0_0_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Statement__ExpressionAssignment_0_0_313539);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6755:1: rule__ReturnStatement__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__ReturnStatement__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6759:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6760:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6760:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6761:1: ruleExpression
            {
             before(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ReturnStatement__ExpressionAssignment_213570);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6770:1: rule__IfStatement__IfAssignment_3 : ( ruleLogical ) ;
    public final void rule__IfStatement__IfAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6774:1: ( ( ruleLogical ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6775:1: ( ruleLogical )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6775:1: ( ruleLogical )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6776:1: ruleLogical
            {
             before(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLogical_in_rule__IfStatement__IfAssignment_313601);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6785:1: rule__IfStatement__ThenAssignment_5 : ( ruleBlock ) ;
    public final void rule__IfStatement__ThenAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6789:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6790:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6790:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6791:1: ruleBlock
            {
             before(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__IfStatement__ThenAssignment_513632);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6800:1: rule__IfStatement__ElseAssignment_6_1 : ( ruleBlock ) ;
    public final void rule__IfStatement__ElseAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6804:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6805:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6805:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6806:1: ruleBlock
            {
             before(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__IfStatement__ElseAssignment_6_113663);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6815:1: rule__WhileStatement__PredicateAssignment_3 : ( ruleLogical ) ;
    public final void rule__WhileStatement__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6819:1: ( ( ruleLogical ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6820:1: ( ruleLogical )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6820:1: ( ruleLogical )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6821:1: ruleLogical
            {
             before(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLogical_in_rule__WhileStatement__PredicateAssignment_313694);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6830:1: rule__WhileStatement__BodyAssignment_5 : ( ruleBlock ) ;
    public final void rule__WhileStatement__BodyAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6834:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6835:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6835:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6836:1: ruleBlock
            {
             before(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__WhileStatement__BodyAssignment_513725);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6845:1: rule__VariableStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VariableStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6849:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6850:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6850:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6851:1: RULE_ID
            {
             before(grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableStatement__NameAssignment_213756); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6860:1: rule__VariableStatement__ExpressionAssignment_3_1 : ( ruleExpression ) ;
    public final void rule__VariableStatement__ExpressionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6864:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6865:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6865:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6866:1: ruleExpression
            {
             before(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableStatement__ExpressionAssignment_3_113787);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6875:1: rule__AssignmentStatement__VarAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AssignmentStatement__VarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6879:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6880:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6880:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6881:1: ( RULE_ID )
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6882:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6883:1: RULE_ID
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AssignmentStatement__VarAssignment_113822); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6894:1: rule__AssignmentStatement__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__AssignmentStatement__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6898:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6899:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6899:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6900:1: ruleExpression
            {
             before(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__AssignmentStatement__ExpressionAssignment_313857);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6909:1: rule__ReferenceAssignmentStatement__RefAssignment_1 : ( ruleContextRef ) ;
    public final void rule__ReferenceAssignmentStatement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6913:1: ( ( ruleContextRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6914:1: ( ruleContextRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6914:1: ( ruleContextRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6915:1: ruleContextRef
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefContextRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleContextRef_in_rule__ReferenceAssignmentStatement__RefAssignment_113888);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6924:1: rule__ReferenceAssignmentStatement__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__ReferenceAssignmentStatement__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6928:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6929:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6929:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6930:1: ruleExpression
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ReferenceAssignmentStatement__ExpressionAssignment_313919);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6939:1: rule__Logical__RightAssignment_1_1 : ( ruleEquality ) ;
    public final void rule__Logical__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6943:1: ( ( ruleEquality ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6944:1: ( ruleEquality )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6944:1: ( ruleEquality )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6945:1: ruleEquality
            {
             before(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEquality_in_rule__Logical__RightAssignment_1_113950);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6954:1: rule__Equality__RightAssignment_1_1 : ( ruleComparison ) ;
    public final void rule__Equality__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6958:1: ( ( ruleComparison ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6959:1: ( ruleComparison )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6959:1: ( ruleComparison )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6960:1: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleComparison_in_rule__Equality__RightAssignment_1_113981);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6969:1: rule__Comparison__RightAssignment_1_1 : ( ruleAddition ) ;
    public final void rule__Comparison__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6973:1: ( ( ruleAddition ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6974:1: ( ruleAddition )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6974:1: ( ruleAddition )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6975:1: ruleAddition
            {
             before(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_114012);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6984:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6988:1: ( ( ruleMultiplication ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6989:1: ( ruleMultiplication )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6989:1: ( ruleMultiplication )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6990:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_114043);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6999:1: rule__Multiplication__RightAssignment_1_1 : ( ruleUnary ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7003:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7004:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7004:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7005:1: ruleUnary
            {
             before(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Multiplication__RightAssignment_1_114074);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7014:1: rule__Unary__OpAssignment_1_0_0_1 : ( ( '!' ) ) ;
    public final void rule__Unary__OpAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7018:1: ( ( ( '!' ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7019:1: ( ( '!' ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7019:1: ( ( '!' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7020:1: ( '!' )
            {
             before(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7021:1: ( '!' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7022:1: '!'
            {
             before(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 
            match(input,54,FOLLOW_54_in_rule__Unary__OpAssignment_1_0_0_114110); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7037:1: rule__Unary__OpAssignment_1_0_1_1 : ( ruleUnaryOperator ) ;
    public final void rule__Unary__OpAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7041:1: ( ( ruleUnaryOperator ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7042:1: ( ruleUnaryOperator )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7042:1: ( ruleUnaryOperator )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7043:1: ruleUnaryOperator
            {
             before(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__Unary__OpAssignment_1_0_1_114149);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7052:1: rule__Unary__RightAssignment_1_1 : ( ruleUnary ) ;
    public final void rule__Unary__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7056:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7057:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7057:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7058:1: ruleUnary
            {
             before(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Unary__RightAssignment_1_114180);
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


    // $ANTLR start "rule__Literal__ConditionAssignment_1_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7067:1: rule__Literal__ConditionAssignment_1_1_0 : ( ( 'true' ) ) ;
    public final void rule__Literal__ConditionAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7071:1: ( ( ( 'true' ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7072:1: ( ( 'true' ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7072:1: ( ( 'true' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7073:1: ( 'true' )
            {
             before(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7074:1: ( 'true' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7075:1: 'true'
            {
             before(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 
            match(input,55,FOLLOW_55_in_rule__Literal__ConditionAssignment_1_1_014216); 
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


    // $ANTLR start "rule__NumberLiteral__ValueAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7090:1: rule__NumberLiteral__ValueAssignment_1 : ( RULE_NUMBER ) ;
    public final void rule__NumberLiteral__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7094:1: ( ( RULE_NUMBER ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7095:1: ( RULE_NUMBER )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7095:1: ( RULE_NUMBER )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7096:1: RULE_NUMBER
            {
             before(grammarAccess.getNumberLiteralAccess().getValueNUMBERTerminalRuleCall_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__NumberLiteral__ValueAssignment_114255); 
             after(grammarAccess.getNumberLiteralAccess().getValueNUMBERTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteral__ValueAssignment_1"


    // $ANTLR start "rule__FunctionCall__FuncAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7105:1: rule__FunctionCall__FuncAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__FunctionCall__FuncAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7109:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7110:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7110:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7111:1: ( RULE_ID )
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7112:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7113:1: RULE_ID
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FunctionCall__FuncAssignment_114290); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7124:1: rule__FunctionCall__ArgsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7128:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7129:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7129:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7130:1: ruleExpression
            {
             before(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_014325);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7139:1: rule__FunctionCall__ArgsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7143:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7144:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7144:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7145:1: ruleExpression
            {
             before(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_1_114356);
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


    // $ANTLR start "rule__IndexedCall__IndexAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7154:1: rule__IndexedCall__IndexAssignment_1_1 : ( ruleExpression ) ;
    public final void rule__IndexedCall__IndexAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7158:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7159:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7159:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7160:1: ruleExpression
            {
             before(grammarAccess.getIndexedCallAccess().getIndexExpressionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__IndexedCall__IndexAssignment_1_114387);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getIndexedCallAccess().getIndexExpressionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IndexedCall__IndexAssignment_1_1"


    // $ANTLR start "rule__VarOrArgumentCall__CallAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7169:1: rule__VarOrArgumentCall__CallAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VarOrArgumentCall__CallAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7173:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7174:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7174:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7175:1: ( RULE_ID )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7176:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7177:1: RULE_ID
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VarOrArgumentCall__CallAssignment_114422); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7188:1: rule__NativeExpression__RangeAssignment_1_0 : ( ruleRangeLiteral ) ;
    public final void rule__NativeExpression__RangeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7192:1: ( ( ruleRangeLiteral ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7193:1: ( ruleRangeLiteral )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7193:1: ( ruleRangeLiteral )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7194:1: ruleRangeLiteral
            {
             before(grammarAccess.getNativeExpressionAccess().getRangeRangeLiteralParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_rule__NativeExpression__RangeAssignment_1_014457);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7203:1: rule__NativeExpression__RefAssignment_1_1 : ( ruleReference ) ;
    public final void rule__NativeExpression__RefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7207:1: ( ( ruleReference ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7208:1: ( ruleReference )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7208:1: ( ruleReference )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7209:1: ruleReference
            {
             before(grammarAccess.getNativeExpressionAccess().getRefReferenceParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReference_in_rule__NativeExpression__RefAssignment_1_114488);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7218:1: rule__NativeExpression__NativeFunctionAssignment_3 : ( ruleNativeFunction ) ;
    public final void rule__NativeExpression__NativeFunctionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7222:1: ( ( ruleNativeFunction ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7223:1: ( ruleNativeFunction )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7223:1: ( ruleNativeFunction )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7224:1: ruleNativeFunction
            {
             before(grammarAccess.getNativeExpressionAccess().getNativeFunctionNativeFunctionEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNativeFunction_in_rule__NativeExpression__NativeFunctionAssignment_314519);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7233:1: rule__RangeLiteral__ValuesAssignment_2 : ( RULE_NUMBER ) ;
    public final void rule__RangeLiteral__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7237:1: ( ( RULE_NUMBER ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7238:1: ( RULE_NUMBER )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7238:1: ( RULE_NUMBER )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7239:1: RULE_NUMBER
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_2_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_214550); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7248:1: rule__RangeLiteral__ValuesAssignment_3_1 : ( RULE_NUMBER ) ;
    public final void rule__RangeLiteral__ValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7252:1: ( ( RULE_NUMBER ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7253:1: ( RULE_NUMBER )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7253:1: ( RULE_NUMBER )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7254:1: RULE_NUMBER
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_3_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_3_114581); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7263:1: rule__NodeRef__NodesAssignment_0 : ( rulePrimaryNodeRef ) ;
    public final void rule__NodeRef__NodesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7267:1: ( ( rulePrimaryNodeRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7268:1: ( rulePrimaryNodeRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7268:1: ( rulePrimaryNodeRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7269:1: rulePrimaryNodeRef
            {
             before(grammarAccess.getNodeRefAccess().getNodesPrimaryNodeRefParserRuleCall_0_0()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_rule__NodeRef__NodesAssignment_014612);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7278:1: rule__NodeRef__RefAssignment_1_1 : ( ruleLeafRef ) ;
    public final void rule__NodeRef__RefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7282:1: ( ( ruleLeafRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7283:1: ( ruleLeafRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7283:1: ( ruleLeafRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7284:1: ruleLeafRef
            {
             before(grammarAccess.getNodeRefAccess().getRefLeafRefParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleLeafRef_in_rule__NodeRef__RefAssignment_1_114643);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7293:1: rule__PrimaryNodeRef__NodeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__PrimaryNodeRef__NodeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7297:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7298:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7298:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7299:1: ( RULE_ID )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7300:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7301:1: RULE_ID
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryNodeRef__NodeAssignment_214678); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7312:1: rule__ResourceRef__ResourceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ResourceRef__ResourceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7316:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7317:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7317:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7318:1: ( RULE_ID )
            {
             before(grammarAccess.getResourceRefAccess().getResourceResourceCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7319:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7320:1: RULE_ID
            {
             before(grammarAccess.getResourceRefAccess().getResourceResourceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResourceRef__ResourceAssignment_214717); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7331:1: rule__LinkRef__LinkAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LinkRef__LinkAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7335:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7336:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7336:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7337:1: ( RULE_ID )
            {
             before(grammarAccess.getLinkRefAccess().getLinkLinkCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7338:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7339:1: RULE_ID
            {
             before(grammarAccess.getLinkRefAccess().getLinkLinkIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LinkRef__LinkAssignment_214756); 
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
        "\1\4\1\uffff\1\14\1\61\3\uffff\1\4\1\14\1\4\1\64\1\uffff\1\14\2"+
        "\4\2\14";
    static final String DFA5_maxS =
        "\1\67\1\uffff\1\57\1\61\3\uffff\1\4\1\63\1\24\1\65\1\uffff\1\63"+
        "\2\4\2\61";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\2\4\uffff\1\3\5\uffff";
    static final String DFA5_specialS =
        "\21\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\1\4\5\uffff\3\4\11\uffff\1\4\5\uffff\1\5\3\uffff"+
            "\1\1\14\uffff\1\4\2\uffff\1\3\3\uffff\2\4",
            "",
            "\2\4\12\uffff\1\4\4\uffff\1\4\5\uffff\1\6\14\4",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\2\4\17\uffff\1\4\5\uffff\1\13\13\4\2\uffff\1\11\1\uffff\1"+
            "\12",
            "\1\14\12\uffff\6\4",
            "\1\15\1\16",
            "",
            "\2\4\17\uffff\1\4\5\uffff\1\13\13\4\2\uffff\1\11\1\uffff\1"+
            "\12",
            "\1\17",
            "\1\20",
            "\2\4\17\uffff\1\4\5\uffff\1\13\13\4\2\uffff\1\4",
            "\2\4\17\uffff\1\4\5\uffff\1\13\13\4\2\uffff\1\4"
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
            return "1193:1: rule__Statement__Alternatives_0_0 : ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) );";
        }
    }
    static final String DFA14_eotS =
        "\30\uffff";
    static final String DFA14_eofS =
        "\4\uffff\1\11\6\uffff\1\16\1\22\6\uffff\1\22\2\uffff\2\22";
    static final String DFA14_minS =
        "\1\4\1\uffff\1\6\1\61\1\14\1\uffff\1\32\1\4\2\uffff\1\6\2\14\1\32"+
        "\2\uffff\1\4\1\64\1\uffff\1\14\2\4\2\14";
    static final String DFA14_maxS =
        "\1\67\1\uffff\1\6\1\61\1\60\1\uffff\1\60\1\4\2\uffff\1\6\1\61\1"+
        "\63\1\60\2\uffff\1\24\1\65\1\uffff\1\63\2\4\2\61";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\3\uffff\1\7\2\uffff\1\5\1\6\4\uffff\1\2\1\3\2\uffff"+
        "\1\4\5\uffff";
    static final String DFA14_specialS =
        "\30\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\4\1\uffff\1\1\7\uffff\1\1\11\uffff\1\5\26\uffff\1\2\2\uffff"+
            "\1\3\4\uffff\1\1",
            "",
            "\1\6",
            "\1\7",
            "\2\11\12\uffff\1\10\2\11\2\uffff\1\11\6\uffff\15\11",
            "",
            "\1\12\25\uffff\1\13",
            "\1\14",
            "",
            "",
            "\1\15",
            "\2\16\13\uffff\2\16\2\uffff\1\16\6\uffff\13\16\1\uffff\1\16"+
            "\1\17",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\uffff\1\22"+
            "\1\20\1\uffff\1\21",
            "\1\12\25\uffff\1\13",
            "",
            "",
            "\1\23\12\uffff\6\17",
            "\1\24\1\25",
            "",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\uffff\1\22"+
            "\1\20\1\uffff\1\21",
            "\1\26",
            "\1\27",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\uffff\1\22"+
            "\1\17",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\uffff\1\22"+
            "\1\17"
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
            return "1431:1: rule__PrimaryExpression__Alternatives : ( ( ruleLiteral ) | ( ruleRange ) | ( ruleNativeExpression ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleIndexedCall ) | ( ruleParenthesizedExpression ) );";
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
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral1386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Group__0_in_ruleNumberLiteral1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0_in_ruleParenthesizedExpression1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall1506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__0_in_ruleFunctionCall1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall1566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexedCall1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group__0_in_ruleIndexedCall1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall1626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarOrArgumentCall1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__0_in_ruleVarOrArgumentCall1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression1686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNativeExpression1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__0_in_ruleNativeExpression1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_ruleRange1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral1805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeLiteral1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__0_in_ruleRangeLiteral1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReference1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_entryRuleContextRef1924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextRef1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__0_in_ruleContextRef1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef1984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef2044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryNodeRef2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__0_in_rulePrimaryNodeRef2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeafRef_in_entryRuleLeafRef2104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLeafRef2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LeafRef__Alternatives_in_ruleLeafRef2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_entryRuleResourceRef2164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceRef2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__0_in_ruleResourceRef2197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_entryRuleLinkRef2224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkRef2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__0_in_ruleLinkRef2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeFunction__Alternatives_in_ruleNativeFunction2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22331 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22343 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22366 = new BitSet(new long[]{0x00C48006C9007052L});
    public static final BitSet FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22378 = new BitSet(new long[]{0x00C48006C9007052L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__0_in_rule__Statement__Alternatives2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_rule__Statement__Alternatives2433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_rule__Statement__Alternatives2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__Statement__Alternatives2467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_rule__Statement__Alternatives_0_02499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_rule__Statement__Alternatives_0_02516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_rule__Statement__Alternatives_0_02533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__ExpressionAssignment_0_0_3_in_rule__Statement__Alternatives_0_02550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_rule__Statement__Alternatives_0_02568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__0_in_rule__Logical__Alternatives_1_02600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__0_in_rule__Logical__Alternatives_1_02618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__0_in_rule__Equality__Alternatives_1_02651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__0_in_rule__Equality__Alternatives_1_02669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__0_in_rule__Comparison__Alternatives_1_02702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__0_in_rule__Comparison__Alternatives_1_02720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__0_in_rule__Comparison__Alternatives_1_02738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__0_in_rule__Comparison__Alternatives_1_02756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_02789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_02807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_02840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_02858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__0_in_rule__Multiplication__Alternatives_1_02876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Unary__Alternatives2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__0_in_rule__Unary__Alternatives2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__0_in_rule__Unary__Alternatives_1_02959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__0_in_rule__Unary__Alternatives_1_02977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__UnaryOperator__Alternatives3011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__UnaryOperator__Alternatives3031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__PrimaryExpression__Alternatives3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_rule__PrimaryExpression__Alternatives3082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_rule__PrimaryExpression__Alternatives3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__PrimaryExpression__Alternatives3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rule__PrimaryExpression__Alternatives3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_rule__PrimaryExpression__Alternatives3150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_rule__Literal__Alternatives3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__0_in_rule__Literal__Alternatives3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__ConditionAssignment_1_1_0_in_rule__Literal__Alternatives_1_13249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Literal__Alternatives_1_13268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__RangeAssignment_1_0_in_rule__NativeExpression__Alternatives_13302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__RefAssignment_1_1_in_rule__NativeExpression__Alternatives_13320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_rule__LeafRef__Alternatives3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_rule__LeafRef__Alternatives3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NativeFunction__Alternatives3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NativeFunction__Alternatives3424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NativeFunction__Alternatives3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__NativeFunction__Alternatives3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__NativeFunction__Alternatives3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__NativeFunction__Alternatives3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group__0__Impl_in_rule__Mod__Group__03541 = new BitSet(new long[]{0x00C48006C9C07050L});
    public static final BitSet FOLLOW_rule__Mod__Group__1_in_rule__Mod__Group__03544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__0_in_rule__Mod__Group__0__Impl3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group__1__Impl_in_rule__Mod__Group__13602 = new BitSet(new long[]{0x00C48006C9C07050L});
    public static final BitSet FOLLOW_rule__Mod__Group__2_in_rule__Mod__Group__13605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__ImportsAssignment_1_in_rule__Mod__Group__1__Impl3632 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__Mod__Group__2__Impl_in_rule__Mod__Group__23663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Alternatives_2_in_rule__Mod__Group__2__Impl3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__0__Impl_in_rule__Mod__Group_0__03726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__1_in_rule__Mod__Group_0__03729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Mod__Group_0__0__Impl3757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__1__Impl_in_rule__Mod__Group_0__13788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__NameAssignment_0_1_in_rule__Mod__Group_0__1__Impl3815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03850 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Import__Group__0__Impl3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__03973 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Function__Group__1_in_rule__Function__Group__03976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Function__Group__0__Impl4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__14035 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Function__Group__2_in_rule__Function__Group__14038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl4065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__24095 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Function__Group__3_in_rule__Function__Group__24098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Function__Group__2__Impl4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__34157 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Function__Group__4_in_rule__Function__Group__34160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__0_in_rule__Function__Group__3__Impl4187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__4__Impl_in_rule__Function__Group__44218 = new BitSet(new long[]{0x00C48006C9007050L});
    public static final BitSet FOLLOW_rule__Function__Group__5_in_rule__Function__Group__44221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Function__Group__4__Impl4249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__5__Impl_in_rule__Function__Group__54280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__BlockAssignment_5_in_rule__Function__Group__5__Impl4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__0__Impl_in_rule__Function__Group_3__04349 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Function__Group_3__1_in_rule__Function__Group_3__04352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__ArgsAssignment_3_0_in_rule__Function__Group_3__0__Impl4379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__1__Impl_in_rule__Function__Group_3__14409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__0_in_rule__Function__Group_3__1__Impl4436 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__0__Impl_in_rule__Function__Group_3_1__04471 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__1_in_rule__Function__Group_3_1__04474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Function__Group_3_1__0__Impl4502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__1__Impl_in_rule__Function__Group_3_1__14533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__ArgsAssignment_3_1_1_in_rule__Function__Group_3_1__1__Impl4560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__04594 = new BitSet(new long[]{0x00C48006C9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__1_in_rule__Block__Group__04597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__14655 = new BitSet(new long[]{0x00C48006D9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__2_in_rule__Block__Group__14658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Block__Group__1__Impl4686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__24717 = new BitSet(new long[]{0x00C48006D9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__3_in_rule__Block__Group__24720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__StatementsAssignment_2_in_rule__Block__Group__2__Impl4747 = new BitSet(new long[]{0x00C48006C9007052L});
    public static final BitSet FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__34778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Block__Group__3__Impl4806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__0__Impl_in_rule__Statement__Group_0__04845 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__1_in_rule__Statement__Group_0__04848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Alternatives_0_0_in_rule__Statement__Group_0__0__Impl4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__1__Impl_in_rule__Statement__Group_0__14905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Statement__Group_0__1__Impl4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__0__Impl_in_rule__ReturnStatement__Group__04968 = new BitSet(new long[]{0x00C4800441007050L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__1_in_rule__ReturnStatement__Group__04971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__1__Impl_in_rule__ReturnStatement__Group__15029 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__2_in_rule__ReturnStatement__Group__15032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ReturnStatement__Group__1__Impl5060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__2__Impl_in_rule__ReturnStatement__Group__25091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__ExpressionAssignment_2_in_rule__ReturnStatement__Group__2__Impl5118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__05155 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__05158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__15216 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__15219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__IfStatement__Group__1__Impl5247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__25278 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__25281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__IfStatement__Group__2__Impl5309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__35340 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__35343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__IfAssignment_3_in_rule__IfStatement__Group__3__Impl5370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__45400 = new BitSet(new long[]{0x00C48006C9007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__5_in_rule__IfStatement__Group__45403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__IfStatement__Group__4__Impl5431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__5__Impl_in_rule__IfStatement__Group__55462 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__6_in_rule__IfStatement__Group__55465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__ThenAssignment_5_in_rule__IfStatement__Group__5__Impl5492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__6__Impl_in_rule__IfStatement__Group__65522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__0_in_rule__IfStatement__Group__6__Impl5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__0__Impl_in_rule__IfStatement__Group_6__05594 = new BitSet(new long[]{0x00C48006C9007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__1_in_rule__IfStatement__Group_6__05597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__IfStatement__Group_6__0__Impl5625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__1__Impl_in_rule__IfStatement__Group_6__15656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__ElseAssignment_6_1_in_rule__IfStatement__Group_6__1__Impl5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__0__Impl_in_rule__WhileStatement__Group__05717 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__1_in_rule__WhileStatement__Group__05720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__1__Impl_in_rule__WhileStatement__Group__15778 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__2_in_rule__WhileStatement__Group__15781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__WhileStatement__Group__1__Impl5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__2__Impl_in_rule__WhileStatement__Group__25840 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__3_in_rule__WhileStatement__Group__25843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__WhileStatement__Group__2__Impl5871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__3__Impl_in_rule__WhileStatement__Group__35902 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__4_in_rule__WhileStatement__Group__35905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__PredicateAssignment_3_in_rule__WhileStatement__Group__3__Impl5932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__4__Impl_in_rule__WhileStatement__Group__45962 = new BitSet(new long[]{0x00C48006C9007050L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__5_in_rule__WhileStatement__Group__45965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__WhileStatement__Group__4__Impl5993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__5__Impl_in_rule__WhileStatement__Group__56024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__BodyAssignment_5_in_rule__WhileStatement__Group__5__Impl6051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__0__Impl_in_rule__VariableStatement__Group__06093 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__1_in_rule__VariableStatement__Group__06096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__1__Impl_in_rule__VariableStatement__Group__16154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__2_in_rule__VariableStatement__Group__16157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__VariableStatement__Group__1__Impl6185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__2__Impl_in_rule__VariableStatement__Group__26216 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__3_in_rule__VariableStatement__Group__26219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__NameAssignment_2_in_rule__VariableStatement__Group__2__Impl6246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__3__Impl_in_rule__VariableStatement__Group__36276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__0_in_rule__VariableStatement__Group__3__Impl6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__0__Impl_in_rule__VariableStatement__Group_3__06342 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__1_in_rule__VariableStatement__Group_3__06345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__VariableStatement__Group_3__0__Impl6373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__1__Impl_in_rule__VariableStatement__Group_3__16404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__ExpressionAssignment_3_1_in_rule__VariableStatement__Group_3__1__Impl6431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__0__Impl_in_rule__AssignmentStatement__Group__06465 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__1_in_rule__AssignmentStatement__Group__06468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__1__Impl_in_rule__AssignmentStatement__Group__16526 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__2_in_rule__AssignmentStatement__Group__16529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__VarAssignment_1_in_rule__AssignmentStatement__Group__1__Impl6556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__2__Impl_in_rule__AssignmentStatement__Group__26586 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__3_in_rule__AssignmentStatement__Group__26589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AssignmentStatement__Group__2__Impl6617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__3__Impl_in_rule__AssignmentStatement__Group__36648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__ExpressionAssignment_3_in_rule__AssignmentStatement__Group__3__Impl6675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__0__Impl_in_rule__ReferenceAssignmentStatement__Group__06713 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__1_in_rule__ReferenceAssignmentStatement__Group__06716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__1__Impl_in_rule__ReferenceAssignmentStatement__Group__16774 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__2_in_rule__ReferenceAssignmentStatement__Group__16777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__RefAssignment_1_in_rule__ReferenceAssignmentStatement__Group__1__Impl6804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__2__Impl_in_rule__ReferenceAssignmentStatement__Group__26834 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__3_in_rule__ReferenceAssignmentStatement__Group__26837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ReferenceAssignmentStatement__Group__2__Impl6865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__3__Impl_in_rule__ReferenceAssignmentStatement__Group__36896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__ExpressionAssignment_3_in_rule__ReferenceAssignmentStatement__Group__3__Impl6923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group__0__Impl_in_rule__Logical__Group__06961 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group__1_in_rule__Logical__Group__06964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_rule__Logical__Group__0__Impl6991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group__1__Impl_in_rule__Logical__Group__17020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__0_in_rule__Logical__Group__1__Impl7047 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__0__Impl_in_rule__Logical__Group_1__07082 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__1_in_rule__Logical__Group_1__07085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Alternatives_1_0_in_rule__Logical__Group_1__0__Impl7112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__1__Impl_in_rule__Logical__Group_1__17142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__RightAssignment_1_1_in_rule__Logical__Group_1__1__Impl7169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__0__Impl_in_rule__Logical__Group_1_0_0__07203 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__1_in_rule__Logical__Group_1_0_0__07206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__1__Impl_in_rule__Logical__Group_1_0_0__17264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Logical__Group_1_0_0__1__Impl7292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__0__Impl_in_rule__Logical__Group_1_0_1__07327 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__1_in_rule__Logical__Group_1_0_1__07330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__1__Impl_in_rule__Logical__Group_1_0_1__17388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Logical__Group_1_0_1__1__Impl7416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group__0__Impl_in_rule__Equality__Group__07451 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group__1_in_rule__Equality__Group__07454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Equality__Group__0__Impl7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group__1__Impl_in_rule__Equality__Group__17510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__0_in_rule__Equality__Group__1__Impl7537 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__0__Impl_in_rule__Equality__Group_1__07572 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__1_in_rule__Equality__Group_1__07575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Alternatives_1_0_in_rule__Equality__Group_1__0__Impl7602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__1__Impl_in_rule__Equality__Group_1__17632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__RightAssignment_1_1_in_rule__Equality__Group_1__1__Impl7659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__0__Impl_in_rule__Equality__Group_1_0_0__07693 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__1_in_rule__Equality__Group_1_0_0__07696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__1__Impl_in_rule__Equality__Group_1_0_0__17754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Equality__Group_1_0_0__1__Impl7782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__0__Impl_in_rule__Equality__Group_1_0_1__07817 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__1_in_rule__Equality__Group_1_0_1__07820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__1__Impl_in_rule__Equality__Group_1_0_1__17878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Equality__Group_1_0_1__1__Impl7906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__07941 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__07944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl7971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__18000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl8027 = new BitSet(new long[]{0x00000F0000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__08062 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__08065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Alternatives_1_0_in_rule__Comparison__Group_1__0__Impl8092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__18122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl8149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__0__Impl_in_rule__Comparison__Group_1_0_0__08183 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__1_in_rule__Comparison__Group_1_0_0__08186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__1__Impl_in_rule__Comparison__Group_1_0_0__18244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Comparison__Group_1_0_0__1__Impl8272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__0__Impl_in_rule__Comparison__Group_1_0_1__08307 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__1_in_rule__Comparison__Group_1_0_1__08310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__1__Impl_in_rule__Comparison__Group_1_0_1__18368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Comparison__Group_1_0_1__1__Impl8396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__0__Impl_in_rule__Comparison__Group_1_0_2__08431 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__1_in_rule__Comparison__Group_1_0_2__08434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__1__Impl_in_rule__Comparison__Group_1_0_2__18492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Comparison__Group_1_0_2__1__Impl8520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__0__Impl_in_rule__Comparison__Group_1_0_3__08555 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__1_in_rule__Comparison__Group_1_0_3__08558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__1__Impl_in_rule__Comparison__Group_1_0_3__18616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Comparison__Group_1_0_3__1__Impl8644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__08679 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__08682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl8709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__18738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl8765 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__08800 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__08803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl8830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__18860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl8887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__08921 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__08924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__18982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Addition__Group_1_0_0__1__Impl9010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__09045 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__09048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__19106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Addition__Group_1_0_1__1__Impl9134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__09169 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__09172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Multiplication__Group__0__Impl9199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__19228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl9255 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__09290 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__09293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__0__Impl9320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__19350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl9377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__0__Impl_in_rule__Multiplication__Group_1_0_0__09411 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__09414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__1__Impl_in_rule__Multiplication__Group_1_0_0__19472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Multiplication__Group_1_0_0__1__Impl9500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__0__Impl_in_rule__Multiplication__Group_1_0_1__09535 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__09538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__1__Impl_in_rule__Multiplication__Group_1_0_1__19596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Multiplication__Group_1_0_1__1__Impl9624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__0__Impl_in_rule__Multiplication__Group_1_0_2__09659 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__1_in_rule__Multiplication__Group_1_0_2__09662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__1__Impl_in_rule__Multiplication__Group_1_0_2__19720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Multiplication__Group_1_0_2__1__Impl9748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__0__Impl_in_rule__Unary__Group_1__09783 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__1_in_rule__Unary__Group_1__09786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Alternatives_1_0_in_rule__Unary__Group_1__0__Impl9813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__1__Impl_in_rule__Unary__Group_1__19843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__RightAssignment_1_1_in_rule__Unary__Group_1__1__Impl9870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__0__Impl_in_rule__Unary__Group_1_0_0__09904 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__1_in_rule__Unary__Group_1_0_0__09907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__1__Impl_in_rule__Unary__Group_1_0_0__19965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__OpAssignment_1_0_0_1_in_rule__Unary__Group_1_0_0__1__Impl9992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__0__Impl_in_rule__Unary__Group_1_0_1__010026 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__1_in_rule__Unary__Group_1_0_1__010029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__1__Impl_in_rule__Unary__Group_1_0_1__110087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__OpAssignment_1_0_1_1_in_rule__Unary__Group_1_0_1__1__Impl10114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__0__Impl_in_rule__Literal__Group_1__010148 = new BitSet(new long[]{0x0080000000004040L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__1_in_rule__Literal__Group_1__010151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__1__Impl_in_rule__Literal__Group_1__110209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_1_1_in_rule__Literal__Group_1__1__Impl10236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Group__0__Impl_in_rule__NumberLiteral__Group__010270 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Group__1_in_rule__NumberLiteral__Group__010273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__Group__1__Impl_in_rule__NumberLiteral__Group__110331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberLiteral__ValueAssignment_1_in_rule__NumberLiteral__Group__1__Impl10358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__010392 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__010395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ParenthesizedExpression__Group__0__Impl10423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__110454 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__110457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__Group__1__Impl10484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__210513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ParenthesizedExpression__Group__2__Impl10541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__0__Impl_in_rule__FunctionCall__Group__010578 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__1_in_rule__FunctionCall__Group__010581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__1__Impl_in_rule__FunctionCall__Group__110639 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__2_in_rule__FunctionCall__Group__110642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__FuncAssignment_1_in_rule__FunctionCall__Group__1__Impl10669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__2__Impl_in_rule__FunctionCall__Group__210699 = new BitSet(new long[]{0x00C4800003007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__3_in_rule__FunctionCall__Group__210702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__FunctionCall__Group__2__Impl10730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__3__Impl_in_rule__FunctionCall__Group__310761 = new BitSet(new long[]{0x00C4800003007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__4_in_rule__FunctionCall__Group__310764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__0_in_rule__FunctionCall__Group__3__Impl10791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__4__Impl_in_rule__FunctionCall__Group__410822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__FunctionCall__Group__4__Impl10850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__0__Impl_in_rule__FunctionCall__Group_3__010891 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__1_in_rule__FunctionCall__Group_3__010894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__ArgsAssignment_3_0_in_rule__FunctionCall__Group_3__0__Impl10921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__1__Impl_in_rule__FunctionCall__Group_3__110951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__0_in_rule__FunctionCall__Group_3__1__Impl10978 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__0__Impl_in_rule__FunctionCall__Group_3_1__011013 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__1_in_rule__FunctionCall__Group_3_1__011016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FunctionCall__Group_3_1__0__Impl11044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__1__Impl_in_rule__FunctionCall__Group_3_1__111075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__ArgsAssignment_3_1_1_in_rule__FunctionCall__Group_3_1__1__Impl11102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group__0__Impl_in_rule__IndexedCall__Group__011136 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group__1_in_rule__IndexedCall__Group__011139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_rule__IndexedCall__Group__0__Impl11166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group__1__Impl_in_rule__IndexedCall__Group__111195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group_1__0_in_rule__IndexedCall__Group__1__Impl11222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group_1__0__Impl_in_rule__IndexedCall__Group_1__011257 = new BitSet(new long[]{0x00C4800001007050L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group_1__1_in_rule__IndexedCall__Group_1__011260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__IndexedCall__Group_1__0__Impl11288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group_1__1__Impl_in_rule__IndexedCall__Group_1__111319 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group_1__2_in_rule__IndexedCall__Group_1__111322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__IndexAssignment_1_1_in_rule__IndexedCall__Group_1__1__Impl11349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IndexedCall__Group_1__2__Impl_in_rule__IndexedCall__Group_1__211379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__IndexedCall__Group_1__2__Impl11407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__0__Impl_in_rule__VarOrArgumentCall__Group__011444 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__1_in_rule__VarOrArgumentCall__Group__011447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__1__Impl_in_rule__VarOrArgumentCall__Group__111505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__CallAssignment_1_in_rule__VarOrArgumentCall__Group__1__Impl11532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__0__Impl_in_rule__NativeExpression__Group__011566 = new BitSet(new long[]{0x0004800000000000L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__1_in_rule__NativeExpression__Group__011569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__1__Impl_in_rule__NativeExpression__Group__111627 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__2_in_rule__NativeExpression__Group__111630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Alternatives_1_in_rule__NativeExpression__Group__1__Impl11657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__2__Impl_in_rule__NativeExpression__Group__211687 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__3_in_rule__NativeExpression__Group__211690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__NativeExpression__Group__2__Impl11718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__3__Impl_in_rule__NativeExpression__Group__311749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__NativeFunctionAssignment_3_in_rule__NativeExpression__Group__3__Impl11776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__0__Impl_in_rule__RangeLiteral__Group__011814 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__1_in_rule__RangeLiteral__Group__011817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__1__Impl_in_rule__RangeLiteral__Group__111875 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__2_in_rule__RangeLiteral__Group__111878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__RangeLiteral__Group__1__Impl11906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__2__Impl_in_rule__RangeLiteral__Group__211937 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__3_in_rule__RangeLiteral__Group__211940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__ValuesAssignment_2_in_rule__RangeLiteral__Group__2__Impl11967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__3__Impl_in_rule__RangeLiteral__Group__311997 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__4_in_rule__RangeLiteral__Group__312000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__0_in_rule__RangeLiteral__Group__3__Impl12027 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__4__Impl_in_rule__RangeLiteral__Group__412058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__RangeLiteral__Group__4__Impl12086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__0__Impl_in_rule__RangeLiteral__Group_3__012127 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__1_in_rule__RangeLiteral__Group_3__012130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__RangeLiteral__Group_3__0__Impl12158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__1__Impl_in_rule__RangeLiteral__Group_3__112189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__ValuesAssignment_3_1_in_rule__RangeLiteral__Group_3__1__Impl12216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__0__Impl_in_rule__ContextRef__Group__012250 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__1_in_rule__ContextRef__Group__012253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ContextRef__Group__0__Impl12281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__1__Impl_in_rule__ContextRef__Group__112312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rule__ContextRef__Group__1__Impl12339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__012372 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__012375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl12404 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl12416 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__112449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__0_in_rule__NodeRef__Group__1__Impl12476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__0__Impl_in_rule__NodeRef__Group_1__012511 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__1_in_rule__NodeRef__Group_1__012514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__NodeRef__Group_1__0__Impl12542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__1__Impl_in_rule__NodeRef__Group_1__112573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__RefAssignment_1_1_in_rule__NodeRef__Group_1__1__Impl12600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__0__Impl_in_rule__PrimaryNodeRef__Group__012634 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__1_in_rule__PrimaryNodeRef__Group__012637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__1__Impl_in_rule__PrimaryNodeRef__Group__112695 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__2_in_rule__PrimaryNodeRef__Group__112698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__PrimaryNodeRef__Group__1__Impl12726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__2__Impl_in_rule__PrimaryNodeRef__Group__212757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__NodeAssignment_2_in_rule__PrimaryNodeRef__Group__2__Impl12784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__0__Impl_in_rule__ResourceRef__Group__012820 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__1_in_rule__ResourceRef__Group__012823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__1__Impl_in_rule__ResourceRef__Group__112881 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__2_in_rule__ResourceRef__Group__112884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ResourceRef__Group__1__Impl12912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__2__Impl_in_rule__ResourceRef__Group__212943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__ResourceAssignment_2_in_rule__ResourceRef__Group__2__Impl12970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__0__Impl_in_rule__LinkRef__Group__013006 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__1_in_rule__LinkRef__Group__013009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__1__Impl_in_rule__LinkRef__Group__113067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__2_in_rule__LinkRef__Group__113070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__LinkRef__Group__1__Impl13098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__2__Impl_in_rule__LinkRef__Group__213129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__LinkAssignment_2_in_rule__LinkRef__Group__2__Impl13156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Mod__NameAssignment_0_113197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Mod__ImportsAssignment_113228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rule__Mod__FunctionsAssignment_2_013259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Mod__StatementsAssignment_2_113290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_113322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Function__NameAssignment_113353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_013384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_1_113415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__Function__BlockAssignment_513446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Argument__NameAssignment13477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Block__StatementsAssignment_213508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Statement__ExpressionAssignment_0_0_313539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ReturnStatement__ExpressionAssignment_213570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_rule__IfStatement__IfAssignment_313601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__IfStatement__ThenAssignment_513632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__IfStatement__ElseAssignment_6_113663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_rule__WhileStatement__PredicateAssignment_313694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__WhileStatement__BodyAssignment_513725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableStatement__NameAssignment_213756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__VariableStatement__ExpressionAssignment_3_113787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AssignmentStatement__VarAssignment_113822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__AssignmentStatement__ExpressionAssignment_313857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_rule__ReferenceAssignmentStatement__RefAssignment_113888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ReferenceAssignmentStatement__ExpressionAssignment_313919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_rule__Logical__RightAssignment_1_113950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Equality__RightAssignment_1_113981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_114012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_114043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Multiplication__RightAssignment_1_114074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__Unary__OpAssignment_1_0_0_114110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__Unary__OpAssignment_1_0_1_114149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Unary__RightAssignment_1_114180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__Literal__ConditionAssignment_1_1_014216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__NumberLiteral__ValueAssignment_114255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FunctionCall__FuncAssignment_114290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_014325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_1_114356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__IndexedCall__IndexAssignment_1_114387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VarOrArgumentCall__CallAssignment_114422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_rule__NativeExpression__RangeAssignment_1_014457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__NativeExpression__RefAssignment_1_114488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeFunction_in_rule__NativeExpression__NativeFunctionAssignment_314519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_214550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_3_114581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_rule__NodeRef__NodesAssignment_014612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeafRef_in_rule__NodeRef__RefAssignment_1_114643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryNodeRef__NodeAssignment_214678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResourceRef__ResourceAssignment_214717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LinkRef__LinkAssignment_214756 = new BitSet(new long[]{0x0000000000000002L});

}