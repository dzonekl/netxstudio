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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-'", "'+'", "'false'", "'COUNT'", "'SUM'", "'MIN'", "'MAX'", "'MEAN'", "'DEVIATION'", "'mod'", "'import'", "'def'", "'('", "')'", "','", "'{'", "'}'", "';'", "'return'", "'if'", "'else'", "'while'", "'var'", "'='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'*'", "'/'", "'%'", "'.'", "'this'", "'->'", "'RES'", "'LINK'", "'!'", "'true'"
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


    // $ANTLR start "entryRuleReference"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:767:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:768:1: ( ruleReference EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:769:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1566);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1573); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:776:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:780:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:781:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:781:1: ( ( rule__Reference__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:782:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:783:1: ( rule__Reference__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:783:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference1599);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:795:1: entryRuleContextRef : ruleContextRef EOF ;
    public final void entryRuleContextRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:796:1: ( ruleContextRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:797:1: ruleContextRef EOF
            {
             before(grammarAccess.getContextRefRule()); 
            pushFollow(FOLLOW_ruleContextRef_in_entryRuleContextRef1626);
            ruleContextRef();

            state._fsp--;

             after(grammarAccess.getContextRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextRef1633); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:804:1: ruleContextRef : ( ( rule__ContextRef__Group__0 ) ) ;
    public final void ruleContextRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:808:2: ( ( ( rule__ContextRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:809:1: ( ( rule__ContextRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:809:1: ( ( rule__ContextRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:810:1: ( rule__ContextRef__Group__0 )
            {
             before(grammarAccess.getContextRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:811:1: ( rule__ContextRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:811:2: rule__ContextRef__Group__0
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__0_in_ruleContextRef1659);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:823:1: entryRuleNodeRef : ruleNodeRef EOF ;
    public final void entryRuleNodeRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:824:1: ( ruleNodeRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:825:1: ruleNodeRef EOF
            {
             before(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef1686);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef1693); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:832:1: ruleNodeRef : ( ( rule__NodeRef__Group__0 ) ) ;
    public final void ruleNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:836:2: ( ( ( rule__NodeRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:837:1: ( ( rule__NodeRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:837:1: ( ( rule__NodeRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:838:1: ( rule__NodeRef__Group__0 )
            {
             before(grammarAccess.getNodeRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:839:1: ( rule__NodeRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:839:2: rule__NodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef1719);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:851:1: entryRulePrimaryNodeRef : rulePrimaryNodeRef EOF ;
    public final void entryRulePrimaryNodeRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:852:1: ( rulePrimaryNodeRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:853:1: rulePrimaryNodeRef EOF
            {
             before(grammarAccess.getPrimaryNodeRefRule()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef1746);
            rulePrimaryNodeRef();

            state._fsp--;

             after(grammarAccess.getPrimaryNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryNodeRef1753); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:860:1: rulePrimaryNodeRef : ( ( rule__PrimaryNodeRef__Group__0 ) ) ;
    public final void rulePrimaryNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:864:2: ( ( ( rule__PrimaryNodeRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:865:1: ( ( rule__PrimaryNodeRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:865:1: ( ( rule__PrimaryNodeRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:866:1: ( rule__PrimaryNodeRef__Group__0 )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:867:1: ( rule__PrimaryNodeRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:867:2: rule__PrimaryNodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__0_in_rulePrimaryNodeRef1779);
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


    // $ANTLR start "entryRuleResourceRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:879:1: entryRuleResourceRef : ruleResourceRef EOF ;
    public final void entryRuleResourceRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:880:1: ( ruleResourceRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:881:1: ruleResourceRef EOF
            {
             before(grammarAccess.getResourceRefRule()); 
            pushFollow(FOLLOW_ruleResourceRef_in_entryRuleResourceRef1806);
            ruleResourceRef();

            state._fsp--;

             after(grammarAccess.getResourceRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceRef1813); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:888:1: ruleResourceRef : ( ( rule__ResourceRef__Group__0 ) ) ;
    public final void ruleResourceRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:892:2: ( ( ( rule__ResourceRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:893:1: ( ( rule__ResourceRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:893:1: ( ( rule__ResourceRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:894:1: ( rule__ResourceRef__Group__0 )
            {
             before(grammarAccess.getResourceRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:895:1: ( rule__ResourceRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:895:2: rule__ResourceRef__Group__0
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__0_in_ruleResourceRef1839);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:907:1: entryRuleLinkRef : ruleLinkRef EOF ;
    public final void entryRuleLinkRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:908:1: ( ruleLinkRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:909:1: ruleLinkRef EOF
            {
             before(grammarAccess.getLinkRefRule()); 
            pushFollow(FOLLOW_ruleLinkRef_in_entryRuleLinkRef1866);
            ruleLinkRef();

            state._fsp--;

             after(grammarAccess.getLinkRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkRef1873); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:916:1: ruleLinkRef : ( ( rule__LinkRef__Group__0 ) ) ;
    public final void ruleLinkRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:920:2: ( ( ( rule__LinkRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:921:1: ( ( rule__LinkRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:921:1: ( ( rule__LinkRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:922:1: ( rule__LinkRef__Group__0 )
            {
             before(grammarAccess.getLinkRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:923:1: ( rule__LinkRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:923:2: rule__LinkRef__Group__0
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__0_in_ruleLinkRef1899);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:936:1: ruleNativeFunction : ( ( rule__NativeFunction__Alternatives ) ) ;
    public final void ruleNativeFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:940:1: ( ( ( rule__NativeFunction__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:941:1: ( ( rule__NativeFunction__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:941:1: ( ( rule__NativeFunction__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:942:1: ( rule__NativeFunction__Alternatives )
            {
             before(grammarAccess.getNativeFunctionAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:943:1: ( rule__NativeFunction__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:943:2: rule__NativeFunction__Alternatives
            {
            pushFollow(FOLLOW_rule__NativeFunction__Alternatives_in_ruleNativeFunction1936);
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


    // $ANTLR start "rule__Statement__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:955:1: rule__Statement__Alternatives : ( ( ( rule__Statement__Group_0__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleBlock ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:959:1: ( ( ( rule__Statement__Group_0__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleBlock ) )
            int alt1=4;
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
            case 52:
            case 53:
                {
                alt1=1;
                }
                break;
            case 31:
                {
                alt1=2;
                }
                break;
            case 33:
                {
                alt1=3;
                }
                break;
            case 27:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:960:1: ( ( rule__Statement__Group_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:960:1: ( ( rule__Statement__Group_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:961:1: ( rule__Statement__Group_0__0 )
                    {
                     before(grammarAccess.getStatementAccess().getGroup_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:962:1: ( rule__Statement__Group_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:962:2: rule__Statement__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Statement__Group_0__0_in_rule__Statement__Alternatives1972);
                    rule__Statement__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatementAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:966:6: ( ruleIfStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:966:6: ( ruleIfStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:967:1: ruleIfStatement
                    {
                     before(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIfStatement_in_rule__Statement__Alternatives1990);
                    ruleIfStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:972:6: ( ruleWhileStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:972:6: ( ruleWhileStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:973:1: ruleWhileStatement
                    {
                     before(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleWhileStatement_in_rule__Statement__Alternatives2007);
                    ruleWhileStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:978:6: ( ruleBlock )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:978:6: ( ruleBlock )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:979:1: ruleBlock
                    {
                     before(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleBlock_in_rule__Statement__Alternatives2024);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:989:1: rule__Statement__Alternatives_0_0 : ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) );
    public final void rule__Statement__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:993:1: ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) )
            int alt2=5;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:994:1: ( ruleVariableStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:994:1: ( ruleVariableStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:995:1: ruleVariableStatement
                    {
                     before(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 
                    pushFollow(FOLLOW_ruleVariableStatement_in_rule__Statement__Alternatives_0_02056);
                    ruleVariableStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1000:6: ( ruleAssignmentStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1000:6: ( ruleAssignmentStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1001:1: ruleAssignmentStatement
                    {
                     before(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 
                    pushFollow(FOLLOW_ruleAssignmentStatement_in_rule__Statement__Alternatives_0_02073);
                    ruleAssignmentStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1006:6: ( ruleReferenceAssignmentStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1006:6: ( ruleReferenceAssignmentStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1007:1: ruleReferenceAssignmentStatement
                    {
                     before(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 
                    pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_rule__Statement__Alternatives_0_02090);
                    ruleReferenceAssignmentStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1012:6: ( ( rule__Statement__ExpressionAssignment_0_0_3 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1012:6: ( ( rule__Statement__ExpressionAssignment_0_0_3 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1013:1: ( rule__Statement__ExpressionAssignment_0_0_3 )
                    {
                     before(grammarAccess.getStatementAccess().getExpressionAssignment_0_0_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1014:1: ( rule__Statement__ExpressionAssignment_0_0_3 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1014:2: rule__Statement__ExpressionAssignment_0_0_3
                    {
                    pushFollow(FOLLOW_rule__Statement__ExpressionAssignment_0_0_3_in_rule__Statement__Alternatives_0_02107);
                    rule__Statement__ExpressionAssignment_0_0_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatementAccess().getExpressionAssignment_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1018:6: ( ruleReturnStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1018:6: ( ruleReturnStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1019:1: ruleReturnStatement
                    {
                     before(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_4()); 
                    pushFollow(FOLLOW_ruleReturnStatement_in_rule__Statement__Alternatives_0_02125);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1029:1: rule__Logical__Alternatives_1_0 : ( ( ( rule__Logical__Group_1_0_0__0 ) ) | ( ( rule__Logical__Group_1_0_1__0 ) ) );
    public final void rule__Logical__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1033:1: ( ( ( rule__Logical__Group_1_0_0__0 ) ) | ( ( rule__Logical__Group_1_0_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==36) ) {
                alt3=1;
            }
            else if ( (LA3_0==37) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1034:1: ( ( rule__Logical__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1034:1: ( ( rule__Logical__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1035:1: ( rule__Logical__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getLogicalAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1036:1: ( rule__Logical__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1036:2: rule__Logical__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Logical__Group_1_0_0__0_in_rule__Logical__Alternatives_1_02157);
                    rule__Logical__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLogicalAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1040:6: ( ( rule__Logical__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1040:6: ( ( rule__Logical__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1041:1: ( rule__Logical__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getLogicalAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1042:1: ( rule__Logical__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1042:2: rule__Logical__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Logical__Group_1_0_1__0_in_rule__Logical__Alternatives_1_02175);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1051:1: rule__Equality__Alternatives_1_0 : ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) );
    public final void rule__Equality__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1055:1: ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==38) ) {
                alt4=1;
            }
            else if ( (LA4_0==39) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1056:1: ( ( rule__Equality__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1056:1: ( ( rule__Equality__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1057:1: ( rule__Equality__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1058:1: ( rule__Equality__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1058:2: rule__Equality__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Equality__Group_1_0_0__0_in_rule__Equality__Alternatives_1_02208);
                    rule__Equality__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1062:6: ( ( rule__Equality__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1062:6: ( ( rule__Equality__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1063:1: ( rule__Equality__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getEqualityAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1064:1: ( rule__Equality__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1064:2: rule__Equality__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Equality__Group_1_0_1__0_in_rule__Equality__Alternatives_1_02226);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1073:1: rule__Comparison__Alternatives_1_0 : ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) );
    public final void rule__Comparison__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1077:1: ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt5=1;
                }
                break;
            case 41:
                {
                alt5=2;
                }
                break;
            case 42:
                {
                alt5=3;
                }
                break;
            case 43:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1078:1: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1078:1: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1079:1: ( rule__Comparison__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1080:1: ( rule__Comparison__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1080:2: rule__Comparison__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__0_in_rule__Comparison__Alternatives_1_02259);
                    rule__Comparison__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1084:6: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1084:6: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1085:1: ( rule__Comparison__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1086:1: ( rule__Comparison__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1086:2: rule__Comparison__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__0_in_rule__Comparison__Alternatives_1_02277);
                    rule__Comparison__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1090:6: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1090:6: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1091:1: ( rule__Comparison__Group_1_0_2__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1092:1: ( rule__Comparison__Group_1_0_2__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1092:2: rule__Comparison__Group_1_0_2__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__0_in_rule__Comparison__Alternatives_1_02295);
                    rule__Comparison__Group_1_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1096:6: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1096:6: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1097:1: ( rule__Comparison__Group_1_0_3__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1098:1: ( rule__Comparison__Group_1_0_3__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1098:2: rule__Comparison__Group_1_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__0_in_rule__Comparison__Alternatives_1_02313);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1107:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1111:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==12) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1112:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1112:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1113:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1114:1: ( rule__Addition__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1114:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_02346);
                    rule__Addition__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1118:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1118:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1119:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1120:1: ( rule__Addition__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1120:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_02364);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1129:1: rule__Multiplication__Alternatives_1_0 : ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) | ( ( rule__Multiplication__Group_1_0_2__0 ) ) );
    public final void rule__Multiplication__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1133:1: ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) | ( ( rule__Multiplication__Group_1_0_2__0 ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt7=1;
                }
                break;
            case 45:
                {
                alt7=2;
                }
                break;
            case 46:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1134:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1134:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1135:1: ( rule__Multiplication__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1136:1: ( rule__Multiplication__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1136:2: rule__Multiplication__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_02397);
                    rule__Multiplication__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1140:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1140:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1141:1: ( rule__Multiplication__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1142:1: ( rule__Multiplication__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1142:2: rule__Multiplication__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_02415);
                    rule__Multiplication__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1146:6: ( ( rule__Multiplication__Group_1_0_2__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1146:6: ( ( rule__Multiplication__Group_1_0_2__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1147:1: ( rule__Multiplication__Group_1_0_2__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1148:1: ( rule__Multiplication__Group_1_0_2__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1148:2: rule__Multiplication__Group_1_0_2__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__0_in_rule__Multiplication__Alternatives_1_02433);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1157:1: rule__Unary__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__Unary__Group_1__0 ) ) );
    public final void rule__Unary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1161:1: ( ( rulePrimaryExpression ) | ( ( rule__Unary__Group_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==RULE_NUMBER||LA8_0==14||LA8_0==24||LA8_0==48||LA8_0==53) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=12 && LA8_0<=13)||LA8_0==52) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1162:1: ( rulePrimaryExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1162:1: ( rulePrimaryExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1163:1: rulePrimaryExpression
                    {
                     before(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Unary__Alternatives2466);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1168:6: ( ( rule__Unary__Group_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1168:6: ( ( rule__Unary__Group_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1169:1: ( rule__Unary__Group_1__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1170:1: ( rule__Unary__Group_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1170:2: rule__Unary__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1__0_in_rule__Unary__Alternatives2483);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1179:1: rule__Unary__Alternatives_1_0 : ( ( ( rule__Unary__Group_1_0_0__0 ) ) | ( ( rule__Unary__Group_1_0_1__0 ) ) );
    public final void rule__Unary__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1183:1: ( ( ( rule__Unary__Group_1_0_0__0 ) ) | ( ( rule__Unary__Group_1_0_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==52) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=12 && LA9_0<=13)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1184:1: ( ( rule__Unary__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1184:1: ( ( rule__Unary__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1185:1: ( rule__Unary__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1186:1: ( rule__Unary__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1186:2: rule__Unary__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1_0_0__0_in_rule__Unary__Alternatives_1_02516);
                    rule__Unary__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1190:6: ( ( rule__Unary__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1190:6: ( ( rule__Unary__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1191:1: ( rule__Unary__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1192:1: ( rule__Unary__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1192:2: rule__Unary__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1_0_1__0_in_rule__Unary__Alternatives_1_02534);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1201:1: rule__UnaryOperator__Alternatives : ( ( '-' ) | ( '+' ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1205:1: ( ( '-' ) | ( '+' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            else if ( (LA10_0==13) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1206:1: ( '-' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1206:1: ( '-' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1207:1: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__UnaryOperator__Alternatives2568); 
                     after(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1214:6: ( '+' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1214:6: ( '+' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1215:1: '+'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__UnaryOperator__Alternatives2588); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1227:1: rule__PrimaryExpression__Alternatives : ( ( ruleLiteral ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleVarOrArgumentCall ) | ( ruleParenthesizedExpression ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1231:1: ( ( ruleLiteral ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleVarOrArgumentCall ) | ( ruleParenthesizedExpression ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
            case 14:
            case 53:
                {
                alt11=1;
                }
                break;
            case 48:
                {
                alt11=2;
                }
                break;
            case RULE_ID:
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3==24) ) {
                    alt11=3;
                }
                else if ( (LA11_3==EOF||(LA11_3>=12 && LA11_3<=13)||(LA11_3>=25 && LA11_3<=26)||LA11_3==29||(LA11_3>=36 && LA11_3<=46)) ) {
                    alt11=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            case 24:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1232:1: ( ruleLiteral )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1232:1: ( ruleLiteral )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1233:1: ruleLiteral
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__PrimaryExpression__Alternatives2622);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1238:6: ( ruleReference )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1238:6: ( ruleReference )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1239:1: ruleReference
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__PrimaryExpression__Alternatives2639);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1244:6: ( ruleFunctionCall )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1244:6: ( ruleFunctionCall )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1245:1: ruleFunctionCall
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleFunctionCall_in_rule__PrimaryExpression__Alternatives2656);
                    ruleFunctionCall();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1250:6: ( ruleVarOrArgumentCall )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1250:6: ( ruleVarOrArgumentCall )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1251:1: ruleVarOrArgumentCall
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getVarOrArgumentCallParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVarOrArgumentCall_in_rule__PrimaryExpression__Alternatives2673);
                    ruleVarOrArgumentCall();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getVarOrArgumentCallParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1256:6: ( ruleParenthesizedExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1256:6: ( ruleParenthesizedExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1257:1: ruleParenthesizedExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives2690);
                    ruleParenthesizedExpression();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_4()); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1267:1: rule__Literal__Alternatives : ( ( ( rule__Literal__Group_0__0 ) ) | ( ( rule__Literal__Group_1__0 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1271:1: ( ( ( rule__Literal__Group_0__0 ) ) | ( ( rule__Literal__Group_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_NUMBER) ) {
                alt12=1;
            }
            else if ( (LA12_0==14||LA12_0==53) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1272:1: ( ( rule__Literal__Group_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1272:1: ( ( rule__Literal__Group_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1273:1: ( rule__Literal__Group_0__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1274:1: ( rule__Literal__Group_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1274:2: rule__Literal__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Literal__Group_0__0_in_rule__Literal__Alternatives2722);
                    rule__Literal__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1278:6: ( ( rule__Literal__Group_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1278:6: ( ( rule__Literal__Group_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1279:1: ( rule__Literal__Group_1__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1280:1: ( rule__Literal__Group_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1280:2: rule__Literal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Literal__Group_1__0_in_rule__Literal__Alternatives2740);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1289:1: rule__Literal__Alternatives_1_1 : ( ( ( rule__Literal__ConditionAssignment_1_1_0 ) ) | ( 'false' ) );
    public final void rule__Literal__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1293:1: ( ( ( rule__Literal__ConditionAssignment_1_1_0 ) ) | ( 'false' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==53) ) {
                alt13=1;
            }
            else if ( (LA13_0==14) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1294:1: ( ( rule__Literal__ConditionAssignment_1_1_0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1294:1: ( ( rule__Literal__ConditionAssignment_1_1_0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1295:1: ( rule__Literal__ConditionAssignment_1_1_0 )
                    {
                     before(grammarAccess.getLiteralAccess().getConditionAssignment_1_1_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1296:1: ( rule__Literal__ConditionAssignment_1_1_0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1296:2: rule__Literal__ConditionAssignment_1_1_0
                    {
                    pushFollow(FOLLOW_rule__Literal__ConditionAssignment_1_1_0_in_rule__Literal__Alternatives_1_12773);
                    rule__Literal__ConditionAssignment_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getConditionAssignment_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1300:6: ( 'false' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1300:6: ( 'false' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1301:1: 'false'
                    {
                     before(grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Literal__Alternatives_1_12792); 
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


    // $ANTLR start "rule__NodeRef__RefAlternatives_1_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1313:1: rule__NodeRef__RefAlternatives_1_1_0 : ( ( ruleResourceRef ) | ( ruleLinkRef ) );
    public final void rule__NodeRef__RefAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1317:1: ( ( ruleResourceRef ) | ( ruleLinkRef ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            else if ( (LA14_0==51) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1318:1: ( ruleResourceRef )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1318:1: ( ruleResourceRef )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1319:1: ruleResourceRef
                    {
                     before(grammarAccess.getNodeRefAccess().getRefResourceRefParserRuleCall_1_1_0_0()); 
                    pushFollow(FOLLOW_ruleResourceRef_in_rule__NodeRef__RefAlternatives_1_1_02826);
                    ruleResourceRef();

                    state._fsp--;

                     after(grammarAccess.getNodeRefAccess().getRefResourceRefParserRuleCall_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1324:6: ( ruleLinkRef )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1324:6: ( ruleLinkRef )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1325:1: ruleLinkRef
                    {
                     before(grammarAccess.getNodeRefAccess().getRefLinkRefParserRuleCall_1_1_0_1()); 
                    pushFollow(FOLLOW_ruleLinkRef_in_rule__NodeRef__RefAlternatives_1_1_02843);
                    ruleLinkRef();

                    state._fsp--;

                     after(grammarAccess.getNodeRefAccess().getRefLinkRefParserRuleCall_1_1_0_1()); 

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
    // $ANTLR end "rule__NodeRef__RefAlternatives_1_1_0"


    // $ANTLR start "rule__NativeFunction__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1335:1: rule__NativeFunction__Alternatives : ( ( ( 'COUNT' ) ) | ( ( 'SUM' ) ) | ( ( 'MIN' ) ) | ( ( 'MAX' ) ) | ( ( 'MEAN' ) ) | ( ( 'DEVIATION' ) ) );
    public final void rule__NativeFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1339:1: ( ( ( 'COUNT' ) ) | ( ( 'SUM' ) ) | ( ( 'MIN' ) ) | ( ( 'MAX' ) ) | ( ( 'MEAN' ) ) | ( ( 'DEVIATION' ) ) )
            int alt15=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt15=1;
                }
                break;
            case 16:
                {
                alt15=2;
                }
                break;
            case 17:
                {
                alt15=3;
                }
                break;
            case 18:
                {
                alt15=4;
                }
                break;
            case 19:
                {
                alt15=5;
                }
                break;
            case 20:
                {
                alt15=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1340:1: ( ( 'COUNT' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1340:1: ( ( 'COUNT' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1341:1: ( 'COUNT' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1342:1: ( 'COUNT' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1342:3: 'COUNT'
                    {
                    match(input,15,FOLLOW_15_in_rule__NativeFunction__Alternatives2876); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1347:6: ( ( 'SUM' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1347:6: ( ( 'SUM' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1348:1: ( 'SUM' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1349:1: ( 'SUM' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1349:3: 'SUM'
                    {
                    match(input,16,FOLLOW_16_in_rule__NativeFunction__Alternatives2897); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1354:6: ( ( 'MIN' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1354:6: ( ( 'MIN' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1355:1: ( 'MIN' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1356:1: ( 'MIN' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1356:3: 'MIN'
                    {
                    match(input,17,FOLLOW_17_in_rule__NativeFunction__Alternatives2918); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1361:6: ( ( 'MAX' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1361:6: ( ( 'MAX' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1362:1: ( 'MAX' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1363:1: ( 'MAX' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1363:3: 'MAX'
                    {
                    match(input,18,FOLLOW_18_in_rule__NativeFunction__Alternatives2939); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1368:6: ( ( 'MEAN' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1368:6: ( ( 'MEAN' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1369:1: ( 'MEAN' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1370:1: ( 'MEAN' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1370:3: 'MEAN'
                    {
                    match(input,19,FOLLOW_19_in_rule__NativeFunction__Alternatives2960); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1375:6: ( ( 'DEVIATION' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1375:6: ( ( 'DEVIATION' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1376:1: ( 'DEVIATION' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1377:1: ( 'DEVIATION' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1377:3: 'DEVIATION'
                    {
                    match(input,20,FOLLOW_20_in_rule__NativeFunction__Alternatives2981); 

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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1389:1: rule__Mod__Group__0 : rule__Mod__Group__0__Impl rule__Mod__Group__1 ;
    public final void rule__Mod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1393:1: ( rule__Mod__Group__0__Impl rule__Mod__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1394:2: rule__Mod__Group__0__Impl rule__Mod__Group__1
            {
            pushFollow(FOLLOW_rule__Mod__Group__0__Impl_in_rule__Mod__Group__03014);
            rule__Mod__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group__1_in_rule__Mod__Group__03017);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1401:1: rule__Mod__Group__0__Impl : ( ( rule__Mod__Group_0__0 )? ) ;
    public final void rule__Mod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1405:1: ( ( ( rule__Mod__Group_0__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1406:1: ( ( rule__Mod__Group_0__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1406:1: ( ( rule__Mod__Group_0__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1407:1: ( rule__Mod__Group_0__0 )?
            {
             before(grammarAccess.getModAccess().getGroup_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1408:1: ( rule__Mod__Group_0__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1408:2: rule__Mod__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Mod__Group_0__0_in_rule__Mod__Group__0__Impl3044);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1418:1: rule__Mod__Group__1 : rule__Mod__Group__1__Impl rule__Mod__Group__2 ;
    public final void rule__Mod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1422:1: ( rule__Mod__Group__1__Impl rule__Mod__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1423:2: rule__Mod__Group__1__Impl rule__Mod__Group__2
            {
            pushFollow(FOLLOW_rule__Mod__Group__1__Impl_in_rule__Mod__Group__13075);
            rule__Mod__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group__2_in_rule__Mod__Group__13078);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1430:1: rule__Mod__Group__1__Impl : ( ( rule__Mod__ImportsAssignment_1 )* ) ;
    public final void rule__Mod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1434:1: ( ( ( rule__Mod__ImportsAssignment_1 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1435:1: ( ( rule__Mod__ImportsAssignment_1 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1435:1: ( ( rule__Mod__ImportsAssignment_1 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1436:1: ( rule__Mod__ImportsAssignment_1 )*
            {
             before(grammarAccess.getModAccess().getImportsAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1437:1: ( rule__Mod__ImportsAssignment_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==22) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1437:2: rule__Mod__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Mod__ImportsAssignment_1_in_rule__Mod__Group__1__Impl3105);
            	    rule__Mod__ImportsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1447:1: rule__Mod__Group__2 : rule__Mod__Group__2__Impl rule__Mod__Group__3 ;
    public final void rule__Mod__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1451:1: ( rule__Mod__Group__2__Impl rule__Mod__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1452:2: rule__Mod__Group__2__Impl rule__Mod__Group__3
            {
            pushFollow(FOLLOW_rule__Mod__Group__2__Impl_in_rule__Mod__Group__23136);
            rule__Mod__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group__3_in_rule__Mod__Group__23139);
            rule__Mod__Group__3();

            state._fsp--;


            }

        }
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1459:1: rule__Mod__Group__2__Impl : ( ( rule__Mod__FunctionsAssignment_2 )* ) ;
    public final void rule__Mod__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1463:1: ( ( ( rule__Mod__FunctionsAssignment_2 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1464:1: ( ( rule__Mod__FunctionsAssignment_2 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1464:1: ( ( rule__Mod__FunctionsAssignment_2 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1465:1: ( rule__Mod__FunctionsAssignment_2 )*
            {
             before(grammarAccess.getModAccess().getFunctionsAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1466:1: ( rule__Mod__FunctionsAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1466:2: rule__Mod__FunctionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Mod__FunctionsAssignment_2_in_rule__Mod__Group__2__Impl3166);
            	    rule__Mod__FunctionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getModAccess().getFunctionsAssignment_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Mod__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1476:1: rule__Mod__Group__3 : rule__Mod__Group__3__Impl ;
    public final void rule__Mod__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1480:1: ( rule__Mod__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1481:2: rule__Mod__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Mod__Group__3__Impl_in_rule__Mod__Group__33197);
            rule__Mod__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__3"


    // $ANTLR start "rule__Mod__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1487:1: rule__Mod__Group__3__Impl : ( ( rule__Mod__StatementsAssignment_3 )* ) ;
    public final void rule__Mod__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1491:1: ( ( ( rule__Mod__StatementsAssignment_3 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1492:1: ( ( rule__Mod__StatementsAssignment_3 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1492:1: ( ( rule__Mod__StatementsAssignment_3 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1493:1: ( rule__Mod__StatementsAssignment_3 )*
            {
             before(grammarAccess.getModAccess().getStatementsAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1494:1: ( rule__Mod__StatementsAssignment_3 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID||LA19_0==RULE_NUMBER||(LA19_0>=12 && LA19_0<=14)||LA19_0==24||LA19_0==27||(LA19_0>=30 && LA19_0<=31)||(LA19_0>=33 && LA19_0<=34)||LA19_0==48||(LA19_0>=52 && LA19_0<=53)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1494:2: rule__Mod__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Mod__StatementsAssignment_3_in_rule__Mod__Group__3__Impl3224);
            	    rule__Mod__StatementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getModAccess().getStatementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__3__Impl"


    // $ANTLR start "rule__Mod__Group_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1512:1: rule__Mod__Group_0__0 : rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1 ;
    public final void rule__Mod__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1516:1: ( rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1517:2: rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1
            {
            pushFollow(FOLLOW_rule__Mod__Group_0__0__Impl_in_rule__Mod__Group_0__03263);
            rule__Mod__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group_0__1_in_rule__Mod__Group_0__03266);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1524:1: rule__Mod__Group_0__0__Impl : ( 'mod' ) ;
    public final void rule__Mod__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1528:1: ( ( 'mod' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1529:1: ( 'mod' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1529:1: ( 'mod' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1530:1: 'mod'
            {
             before(grammarAccess.getModAccess().getModKeyword_0_0()); 
            match(input,21,FOLLOW_21_in_rule__Mod__Group_0__0__Impl3294); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1543:1: rule__Mod__Group_0__1 : rule__Mod__Group_0__1__Impl ;
    public final void rule__Mod__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1547:1: ( rule__Mod__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1548:2: rule__Mod__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Mod__Group_0__1__Impl_in_rule__Mod__Group_0__13325);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1554:1: rule__Mod__Group_0__1__Impl : ( ( rule__Mod__NameAssignment_0_1 ) ) ;
    public final void rule__Mod__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1558:1: ( ( ( rule__Mod__NameAssignment_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1559:1: ( ( rule__Mod__NameAssignment_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1559:1: ( ( rule__Mod__NameAssignment_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1560:1: ( rule__Mod__NameAssignment_0_1 )
            {
             before(grammarAccess.getModAccess().getNameAssignment_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1561:1: ( rule__Mod__NameAssignment_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1561:2: rule__Mod__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Mod__NameAssignment_0_1_in_rule__Mod__Group_0__1__Impl3352);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1576:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1580:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1581:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03387);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03390);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1588:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1592:1: ( ( 'import' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1593:1: ( 'import' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1593:1: ( 'import' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1594:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Import__Group__0__Impl3418); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1607:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1611:1: ( rule__Import__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1612:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13449);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1618:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1622:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1623:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1623:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1624:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1625:1: ( rule__Import__ImportURIAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1625:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl3476);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1639:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1643:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1644:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__03510);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__1_in_rule__Function__Group__03513);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1651:1: rule__Function__Group__0__Impl : ( 'def' ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1655:1: ( ( 'def' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1656:1: ( 'def' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1656:1: ( 'def' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1657:1: 'def'
            {
             before(grammarAccess.getFunctionAccess().getDefKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__Function__Group__0__Impl3541); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1670:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1674:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1675:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__13572);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__2_in_rule__Function__Group__13575);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1682:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1686:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1687:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1687:1: ( ( rule__Function__NameAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1688:1: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1689:1: ( rule__Function__NameAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1689:2: rule__Function__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl3602);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1699:1: rule__Function__Group__2 : rule__Function__Group__2__Impl rule__Function__Group__3 ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1703:1: ( rule__Function__Group__2__Impl rule__Function__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1704:2: rule__Function__Group__2__Impl rule__Function__Group__3
            {
            pushFollow(FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__23632);
            rule__Function__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__3_in_rule__Function__Group__23635);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1711:1: rule__Function__Group__2__Impl : ( '(' ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1715:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1716:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1716:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1717:1: '('
            {
             before(grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__Function__Group__2__Impl3663); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1730:1: rule__Function__Group__3 : rule__Function__Group__3__Impl rule__Function__Group__4 ;
    public final void rule__Function__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1734:1: ( rule__Function__Group__3__Impl rule__Function__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1735:2: rule__Function__Group__3__Impl rule__Function__Group__4
            {
            pushFollow(FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__33694);
            rule__Function__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__4_in_rule__Function__Group__33697);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1742:1: rule__Function__Group__3__Impl : ( ( rule__Function__Group_3__0 )? ) ;
    public final void rule__Function__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1746:1: ( ( ( rule__Function__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1747:1: ( ( rule__Function__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1747:1: ( ( rule__Function__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1748:1: ( rule__Function__Group_3__0 )?
            {
             before(grammarAccess.getFunctionAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1749:1: ( rule__Function__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1749:2: rule__Function__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Function__Group_3__0_in_rule__Function__Group__3__Impl3724);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1759:1: rule__Function__Group__4 : rule__Function__Group__4__Impl rule__Function__Group__5 ;
    public final void rule__Function__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1763:1: ( rule__Function__Group__4__Impl rule__Function__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1764:2: rule__Function__Group__4__Impl rule__Function__Group__5
            {
            pushFollow(FOLLOW_rule__Function__Group__4__Impl_in_rule__Function__Group__43755);
            rule__Function__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__5_in_rule__Function__Group__43758);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1771:1: rule__Function__Group__4__Impl : ( ')' ) ;
    public final void rule__Function__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1775:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1776:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1776:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1777:1: ')'
            {
             before(grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__Function__Group__4__Impl3786); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1790:1: rule__Function__Group__5 : rule__Function__Group__5__Impl ;
    public final void rule__Function__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1794:1: ( rule__Function__Group__5__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1795:2: rule__Function__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group__5__Impl_in_rule__Function__Group__53817);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1801:1: rule__Function__Group__5__Impl : ( ( rule__Function__BlockAssignment_5 ) ) ;
    public final void rule__Function__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1805:1: ( ( ( rule__Function__BlockAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1806:1: ( ( rule__Function__BlockAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1806:1: ( ( rule__Function__BlockAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1807:1: ( rule__Function__BlockAssignment_5 )
            {
             before(grammarAccess.getFunctionAccess().getBlockAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1808:1: ( rule__Function__BlockAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1808:2: rule__Function__BlockAssignment_5
            {
            pushFollow(FOLLOW_rule__Function__BlockAssignment_5_in_rule__Function__Group__5__Impl3844);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1830:1: rule__Function__Group_3__0 : rule__Function__Group_3__0__Impl rule__Function__Group_3__1 ;
    public final void rule__Function__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1834:1: ( rule__Function__Group_3__0__Impl rule__Function__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1835:2: rule__Function__Group_3__0__Impl rule__Function__Group_3__1
            {
            pushFollow(FOLLOW_rule__Function__Group_3__0__Impl_in_rule__Function__Group_3__03886);
            rule__Function__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group_3__1_in_rule__Function__Group_3__03889);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1842:1: rule__Function__Group_3__0__Impl : ( ( rule__Function__ArgsAssignment_3_0 ) ) ;
    public final void rule__Function__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1846:1: ( ( ( rule__Function__ArgsAssignment_3_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1847:1: ( ( rule__Function__ArgsAssignment_3_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1847:1: ( ( rule__Function__ArgsAssignment_3_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1848:1: ( rule__Function__ArgsAssignment_3_0 )
            {
             before(grammarAccess.getFunctionAccess().getArgsAssignment_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1849:1: ( rule__Function__ArgsAssignment_3_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1849:2: rule__Function__ArgsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__Function__ArgsAssignment_3_0_in_rule__Function__Group_3__0__Impl3916);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1859:1: rule__Function__Group_3__1 : rule__Function__Group_3__1__Impl ;
    public final void rule__Function__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1863:1: ( rule__Function__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1864:2: rule__Function__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group_3__1__Impl_in_rule__Function__Group_3__13946);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1870:1: rule__Function__Group_3__1__Impl : ( ( rule__Function__Group_3_1__0 )* ) ;
    public final void rule__Function__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1874:1: ( ( ( rule__Function__Group_3_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1875:1: ( ( rule__Function__Group_3_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1875:1: ( ( rule__Function__Group_3_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1876:1: ( rule__Function__Group_3_1__0 )*
            {
             before(grammarAccess.getFunctionAccess().getGroup_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1877:1: ( rule__Function__Group_3_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==26) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1877:2: rule__Function__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Function__Group_3_1__0_in_rule__Function__Group_3__1__Impl3973);
            	    rule__Function__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1891:1: rule__Function__Group_3_1__0 : rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1 ;
    public final void rule__Function__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1895:1: ( rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1896:2: rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Function__Group_3_1__0__Impl_in_rule__Function__Group_3_1__04008);
            rule__Function__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group_3_1__1_in_rule__Function__Group_3_1__04011);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1903:1: rule__Function__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__Function__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1907:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1908:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1908:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1909:1: ','
            {
             before(grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0()); 
            match(input,26,FOLLOW_26_in_rule__Function__Group_3_1__0__Impl4039); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1922:1: rule__Function__Group_3_1__1 : rule__Function__Group_3_1__1__Impl ;
    public final void rule__Function__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1926:1: ( rule__Function__Group_3_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1927:2: rule__Function__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group_3_1__1__Impl_in_rule__Function__Group_3_1__14070);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1933:1: rule__Function__Group_3_1__1__Impl : ( ( rule__Function__ArgsAssignment_3_1_1 ) ) ;
    public final void rule__Function__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1937:1: ( ( ( rule__Function__ArgsAssignment_3_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1938:1: ( ( rule__Function__ArgsAssignment_3_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1938:1: ( ( rule__Function__ArgsAssignment_3_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1939:1: ( rule__Function__ArgsAssignment_3_1_1 )
            {
             before(grammarAccess.getFunctionAccess().getArgsAssignment_3_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1940:1: ( rule__Function__ArgsAssignment_3_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1940:2: rule__Function__ArgsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Function__ArgsAssignment_3_1_1_in_rule__Function__Group_3_1__1__Impl4097);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1954:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1958:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1959:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__04131);
            rule__Block__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__1_in_rule__Block__Group__04134);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1966:1: rule__Block__Group__0__Impl : ( () ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1970:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1971:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1971:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1972:1: ()
            {
             before(grammarAccess.getBlockAccess().getBlockAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1973:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1975:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1985:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1989:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1990:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__14192);
            rule__Block__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__2_in_rule__Block__Group__14195);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1997:1: rule__Block__Group__1__Impl : ( '{' ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2001:1: ( ( '{' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2002:1: ( '{' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2002:1: ( '{' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2003:1: '{'
            {
             before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,27,FOLLOW_27_in_rule__Block__Group__1__Impl4223); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2016:1: rule__Block__Group__2 : rule__Block__Group__2__Impl rule__Block__Group__3 ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2020:1: ( rule__Block__Group__2__Impl rule__Block__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2021:2: rule__Block__Group__2__Impl rule__Block__Group__3
            {
            pushFollow(FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__24254);
            rule__Block__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__3_in_rule__Block__Group__24257);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2028:1: rule__Block__Group__2__Impl : ( ( rule__Block__StatementsAssignment_2 )* ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2032:1: ( ( ( rule__Block__StatementsAssignment_2 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2033:1: ( ( rule__Block__StatementsAssignment_2 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2033:1: ( ( rule__Block__StatementsAssignment_2 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2034:1: ( rule__Block__StatementsAssignment_2 )*
            {
             before(grammarAccess.getBlockAccess().getStatementsAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2035:1: ( rule__Block__StatementsAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID||LA22_0==RULE_NUMBER||(LA22_0>=12 && LA22_0<=14)||LA22_0==24||LA22_0==27||(LA22_0>=30 && LA22_0<=31)||(LA22_0>=33 && LA22_0<=34)||LA22_0==48||(LA22_0>=52 && LA22_0<=53)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2035:2: rule__Block__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Block__StatementsAssignment_2_in_rule__Block__Group__2__Impl4284);
            	    rule__Block__StatementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2045:1: rule__Block__Group__3 : rule__Block__Group__3__Impl ;
    public final void rule__Block__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2049:1: ( rule__Block__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2050:2: rule__Block__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__34315);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2056:1: rule__Block__Group__3__Impl : ( '}' ) ;
    public final void rule__Block__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2060:1: ( ( '}' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2061:1: ( '}' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2061:1: ( '}' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2062:1: '}'
            {
             before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__Block__Group__3__Impl4343); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2083:1: rule__Statement__Group_0__0 : rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 ;
    public final void rule__Statement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2087:1: ( rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2088:2: rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1
            {
            pushFollow(FOLLOW_rule__Statement__Group_0__0__Impl_in_rule__Statement__Group_0__04382);
            rule__Statement__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statement__Group_0__1_in_rule__Statement__Group_0__04385);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2095:1: rule__Statement__Group_0__0__Impl : ( ( rule__Statement__Alternatives_0_0 ) ) ;
    public final void rule__Statement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2099:1: ( ( ( rule__Statement__Alternatives_0_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2100:1: ( ( rule__Statement__Alternatives_0_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2100:1: ( ( rule__Statement__Alternatives_0_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2101:1: ( rule__Statement__Alternatives_0_0 )
            {
             before(grammarAccess.getStatementAccess().getAlternatives_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2102:1: ( rule__Statement__Alternatives_0_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2102:2: rule__Statement__Alternatives_0_0
            {
            pushFollow(FOLLOW_rule__Statement__Alternatives_0_0_in_rule__Statement__Group_0__0__Impl4412);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2112:1: rule__Statement__Group_0__1 : rule__Statement__Group_0__1__Impl ;
    public final void rule__Statement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2116:1: ( rule__Statement__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2117:2: rule__Statement__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Statement__Group_0__1__Impl_in_rule__Statement__Group_0__14442);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2123:1: rule__Statement__Group_0__1__Impl : ( ';' ) ;
    public final void rule__Statement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2127:1: ( ( ';' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2128:1: ( ';' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2128:1: ( ';' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2129:1: ';'
            {
             before(grammarAccess.getStatementAccess().getSemicolonKeyword_0_1()); 
            match(input,29,FOLLOW_29_in_rule__Statement__Group_0__1__Impl4470); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2146:1: rule__ReturnStatement__Group__0 : rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 ;
    public final void rule__ReturnStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2150:1: ( rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2151:2: rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__0__Impl_in_rule__ReturnStatement__Group__04505);
            rule__ReturnStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReturnStatement__Group__1_in_rule__ReturnStatement__Group__04508);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2158:1: rule__ReturnStatement__Group__0__Impl : ( () ) ;
    public final void rule__ReturnStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2162:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2163:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2163:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2164:1: ()
            {
             before(grammarAccess.getReturnStatementAccess().getReturnAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2165:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2167:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2177:1: rule__ReturnStatement__Group__1 : rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 ;
    public final void rule__ReturnStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2181:1: ( rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2182:2: rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__1__Impl_in_rule__ReturnStatement__Group__14566);
            rule__ReturnStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReturnStatement__Group__2_in_rule__ReturnStatement__Group__14569);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2189:1: rule__ReturnStatement__Group__1__Impl : ( 'return' ) ;
    public final void rule__ReturnStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2193:1: ( ( 'return' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2194:1: ( 'return' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2194:1: ( 'return' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2195:1: 'return'
            {
             before(grammarAccess.getReturnStatementAccess().getReturnKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__ReturnStatement__Group__1__Impl4597); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2208:1: rule__ReturnStatement__Group__2 : rule__ReturnStatement__Group__2__Impl ;
    public final void rule__ReturnStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2212:1: ( rule__ReturnStatement__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2213:2: rule__ReturnStatement__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__2__Impl_in_rule__ReturnStatement__Group__24628);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2219:1: rule__ReturnStatement__Group__2__Impl : ( ( rule__ReturnStatement__ExpressionAssignment_2 )? ) ;
    public final void rule__ReturnStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2223:1: ( ( ( rule__ReturnStatement__ExpressionAssignment_2 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2224:1: ( ( rule__ReturnStatement__ExpressionAssignment_2 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2224:1: ( ( rule__ReturnStatement__ExpressionAssignment_2 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2225:1: ( rule__ReturnStatement__ExpressionAssignment_2 )?
            {
             before(grammarAccess.getReturnStatementAccess().getExpressionAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2226:1: ( rule__ReturnStatement__ExpressionAssignment_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID||LA23_0==RULE_NUMBER||(LA23_0>=12 && LA23_0<=14)||LA23_0==24||LA23_0==48||(LA23_0>=52 && LA23_0<=53)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2226:2: rule__ReturnStatement__ExpressionAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ReturnStatement__ExpressionAssignment_2_in_rule__ReturnStatement__Group__2__Impl4655);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2242:1: rule__IfStatement__Group__0 : rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 ;
    public final void rule__IfStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2246:1: ( rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2247:2: rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__04692);
            rule__IfStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__04695);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2254:1: rule__IfStatement__Group__0__Impl : ( () ) ;
    public final void rule__IfStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2258:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2259:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2259:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2260:1: ()
            {
             before(grammarAccess.getIfStatementAccess().getIfAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2261:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2263:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2273:1: rule__IfStatement__Group__1 : rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 ;
    public final void rule__IfStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2277:1: ( rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2278:2: rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__14753);
            rule__IfStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__14756);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2285:1: rule__IfStatement__Group__1__Impl : ( 'if' ) ;
    public final void rule__IfStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2289:1: ( ( 'if' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2290:1: ( 'if' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2290:1: ( 'if' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2291:1: 'if'
            {
             before(grammarAccess.getIfStatementAccess().getIfKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__IfStatement__Group__1__Impl4784); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2304:1: rule__IfStatement__Group__2 : rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 ;
    public final void rule__IfStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2308:1: ( rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2309:2: rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__24815);
            rule__IfStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__24818);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2316:1: rule__IfStatement__Group__2__Impl : ( '(' ) ;
    public final void rule__IfStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2320:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2321:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2321:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2322:1: '('
            {
             before(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__IfStatement__Group__2__Impl4846); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2335:1: rule__IfStatement__Group__3 : rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 ;
    public final void rule__IfStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2339:1: ( rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2340:2: rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__34877);
            rule__IfStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__34880);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2347:1: rule__IfStatement__Group__3__Impl : ( ( rule__IfStatement__IfAssignment_3 ) ) ;
    public final void rule__IfStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2351:1: ( ( ( rule__IfStatement__IfAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2352:1: ( ( rule__IfStatement__IfAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2352:1: ( ( rule__IfStatement__IfAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2353:1: ( rule__IfStatement__IfAssignment_3 )
            {
             before(grammarAccess.getIfStatementAccess().getIfAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2354:1: ( rule__IfStatement__IfAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2354:2: rule__IfStatement__IfAssignment_3
            {
            pushFollow(FOLLOW_rule__IfStatement__IfAssignment_3_in_rule__IfStatement__Group__3__Impl4907);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2364:1: rule__IfStatement__Group__4 : rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 ;
    public final void rule__IfStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2368:1: ( rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2369:2: rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__44937);
            rule__IfStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__5_in_rule__IfStatement__Group__44940);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2376:1: rule__IfStatement__Group__4__Impl : ( ')' ) ;
    public final void rule__IfStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2380:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2381:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2381:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2382:1: ')'
            {
             before(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__IfStatement__Group__4__Impl4968); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2395:1: rule__IfStatement__Group__5 : rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6 ;
    public final void rule__IfStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2399:1: ( rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2400:2: rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__5__Impl_in_rule__IfStatement__Group__54999);
            rule__IfStatement__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__6_in_rule__IfStatement__Group__55002);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2407:1: rule__IfStatement__Group__5__Impl : ( ( rule__IfStatement__ThenAssignment_5 ) ) ;
    public final void rule__IfStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2411:1: ( ( ( rule__IfStatement__ThenAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2412:1: ( ( rule__IfStatement__ThenAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2412:1: ( ( rule__IfStatement__ThenAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2413:1: ( rule__IfStatement__ThenAssignment_5 )
            {
             before(grammarAccess.getIfStatementAccess().getThenAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2414:1: ( rule__IfStatement__ThenAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2414:2: rule__IfStatement__ThenAssignment_5
            {
            pushFollow(FOLLOW_rule__IfStatement__ThenAssignment_5_in_rule__IfStatement__Group__5__Impl5029);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2424:1: rule__IfStatement__Group__6 : rule__IfStatement__Group__6__Impl ;
    public final void rule__IfStatement__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2428:1: ( rule__IfStatement__Group__6__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2429:2: rule__IfStatement__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__6__Impl_in_rule__IfStatement__Group__65059);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2435:1: rule__IfStatement__Group__6__Impl : ( ( rule__IfStatement__Group_6__0 )? ) ;
    public final void rule__IfStatement__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2439:1: ( ( ( rule__IfStatement__Group_6__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2440:1: ( ( rule__IfStatement__Group_6__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2440:1: ( ( rule__IfStatement__Group_6__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2441:1: ( rule__IfStatement__Group_6__0 )?
            {
             before(grammarAccess.getIfStatementAccess().getGroup_6()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2442:1: ( rule__IfStatement__Group_6__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2442:2: rule__IfStatement__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__IfStatement__Group_6__0_in_rule__IfStatement__Group__6__Impl5086);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2466:1: rule__IfStatement__Group_6__0 : rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1 ;
    public final void rule__IfStatement__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2470:1: ( rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2471:2: rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1
            {
            pushFollow(FOLLOW_rule__IfStatement__Group_6__0__Impl_in_rule__IfStatement__Group_6__05131);
            rule__IfStatement__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group_6__1_in_rule__IfStatement__Group_6__05134);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2478:1: rule__IfStatement__Group_6__0__Impl : ( 'else' ) ;
    public final void rule__IfStatement__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2482:1: ( ( 'else' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2483:1: ( 'else' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2483:1: ( 'else' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2484:1: 'else'
            {
             before(grammarAccess.getIfStatementAccess().getElseKeyword_6_0()); 
            match(input,32,FOLLOW_32_in_rule__IfStatement__Group_6__0__Impl5162); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2497:1: rule__IfStatement__Group_6__1 : rule__IfStatement__Group_6__1__Impl ;
    public final void rule__IfStatement__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2501:1: ( rule__IfStatement__Group_6__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2502:2: rule__IfStatement__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__IfStatement__Group_6__1__Impl_in_rule__IfStatement__Group_6__15193);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2508:1: rule__IfStatement__Group_6__1__Impl : ( ( rule__IfStatement__ElseAssignment_6_1 ) ) ;
    public final void rule__IfStatement__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2512:1: ( ( ( rule__IfStatement__ElseAssignment_6_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2513:1: ( ( rule__IfStatement__ElseAssignment_6_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2513:1: ( ( rule__IfStatement__ElseAssignment_6_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2514:1: ( rule__IfStatement__ElseAssignment_6_1 )
            {
             before(grammarAccess.getIfStatementAccess().getElseAssignment_6_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2515:1: ( rule__IfStatement__ElseAssignment_6_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2515:2: rule__IfStatement__ElseAssignment_6_1
            {
            pushFollow(FOLLOW_rule__IfStatement__ElseAssignment_6_1_in_rule__IfStatement__Group_6__1__Impl5220);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2529:1: rule__WhileStatement__Group__0 : rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 ;
    public final void rule__WhileStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2533:1: ( rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2534:2: rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__0__Impl_in_rule__WhileStatement__Group__05254);
            rule__WhileStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__1_in_rule__WhileStatement__Group__05257);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2541:1: rule__WhileStatement__Group__0__Impl : ( () ) ;
    public final void rule__WhileStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2545:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2546:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2546:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2547:1: ()
            {
             before(grammarAccess.getWhileStatementAccess().getWhileAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2548:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2550:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2560:1: rule__WhileStatement__Group__1 : rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 ;
    public final void rule__WhileStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2564:1: ( rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2565:2: rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__1__Impl_in_rule__WhileStatement__Group__15315);
            rule__WhileStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__2_in_rule__WhileStatement__Group__15318);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2572:1: rule__WhileStatement__Group__1__Impl : ( 'while' ) ;
    public final void rule__WhileStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2576:1: ( ( 'while' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2577:1: ( 'while' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2577:1: ( 'while' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2578:1: 'while'
            {
             before(grammarAccess.getWhileStatementAccess().getWhileKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__WhileStatement__Group__1__Impl5346); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2591:1: rule__WhileStatement__Group__2 : rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 ;
    public final void rule__WhileStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2595:1: ( rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2596:2: rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__2__Impl_in_rule__WhileStatement__Group__25377);
            rule__WhileStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__3_in_rule__WhileStatement__Group__25380);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2603:1: rule__WhileStatement__Group__2__Impl : ( '(' ) ;
    public final void rule__WhileStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2607:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2608:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2608:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2609:1: '('
            {
             before(grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__WhileStatement__Group__2__Impl5408); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2622:1: rule__WhileStatement__Group__3 : rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 ;
    public final void rule__WhileStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2626:1: ( rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2627:2: rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__3__Impl_in_rule__WhileStatement__Group__35439);
            rule__WhileStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__4_in_rule__WhileStatement__Group__35442);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2634:1: rule__WhileStatement__Group__3__Impl : ( ( rule__WhileStatement__PredicateAssignment_3 ) ) ;
    public final void rule__WhileStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2638:1: ( ( ( rule__WhileStatement__PredicateAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2639:1: ( ( rule__WhileStatement__PredicateAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2639:1: ( ( rule__WhileStatement__PredicateAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2640:1: ( rule__WhileStatement__PredicateAssignment_3 )
            {
             before(grammarAccess.getWhileStatementAccess().getPredicateAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2641:1: ( rule__WhileStatement__PredicateAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2641:2: rule__WhileStatement__PredicateAssignment_3
            {
            pushFollow(FOLLOW_rule__WhileStatement__PredicateAssignment_3_in_rule__WhileStatement__Group__3__Impl5469);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2651:1: rule__WhileStatement__Group__4 : rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5 ;
    public final void rule__WhileStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2655:1: ( rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2656:2: rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__4__Impl_in_rule__WhileStatement__Group__45499);
            rule__WhileStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__5_in_rule__WhileStatement__Group__45502);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2663:1: rule__WhileStatement__Group__4__Impl : ( ')' ) ;
    public final void rule__WhileStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2667:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2668:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2668:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2669:1: ')'
            {
             before(grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__WhileStatement__Group__4__Impl5530); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2682:1: rule__WhileStatement__Group__5 : rule__WhileStatement__Group__5__Impl ;
    public final void rule__WhileStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2686:1: ( rule__WhileStatement__Group__5__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2687:2: rule__WhileStatement__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__5__Impl_in_rule__WhileStatement__Group__55561);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2693:1: rule__WhileStatement__Group__5__Impl : ( ( rule__WhileStatement__BodyAssignment_5 ) ) ;
    public final void rule__WhileStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2697:1: ( ( ( rule__WhileStatement__BodyAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2698:1: ( ( rule__WhileStatement__BodyAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2698:1: ( ( rule__WhileStatement__BodyAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2699:1: ( rule__WhileStatement__BodyAssignment_5 )
            {
             before(grammarAccess.getWhileStatementAccess().getBodyAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2700:1: ( rule__WhileStatement__BodyAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2700:2: rule__WhileStatement__BodyAssignment_5
            {
            pushFollow(FOLLOW_rule__WhileStatement__BodyAssignment_5_in_rule__WhileStatement__Group__5__Impl5588);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2722:1: rule__VariableStatement__Group__0 : rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1 ;
    public final void rule__VariableStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2726:1: ( rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2727:2: rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__0__Impl_in_rule__VariableStatement__Group__05630);
            rule__VariableStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__1_in_rule__VariableStatement__Group__05633);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2734:1: rule__VariableStatement__Group__0__Impl : ( () ) ;
    public final void rule__VariableStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2738:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2739:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2739:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2740:1: ()
            {
             before(grammarAccess.getVariableStatementAccess().getVariableAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2741:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2743:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2753:1: rule__VariableStatement__Group__1 : rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2 ;
    public final void rule__VariableStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2757:1: ( rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2758:2: rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__1__Impl_in_rule__VariableStatement__Group__15691);
            rule__VariableStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__2_in_rule__VariableStatement__Group__15694);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2765:1: rule__VariableStatement__Group__1__Impl : ( 'var' ) ;
    public final void rule__VariableStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2769:1: ( ( 'var' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2770:1: ( 'var' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2770:1: ( 'var' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2771:1: 'var'
            {
             before(grammarAccess.getVariableStatementAccess().getVarKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__VariableStatement__Group__1__Impl5722); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2784:1: rule__VariableStatement__Group__2 : rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3 ;
    public final void rule__VariableStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2788:1: ( rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2789:2: rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__2__Impl_in_rule__VariableStatement__Group__25753);
            rule__VariableStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__3_in_rule__VariableStatement__Group__25756);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2796:1: rule__VariableStatement__Group__2__Impl : ( ( rule__VariableStatement__NameAssignment_2 ) ) ;
    public final void rule__VariableStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2800:1: ( ( ( rule__VariableStatement__NameAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2801:1: ( ( rule__VariableStatement__NameAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2801:1: ( ( rule__VariableStatement__NameAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2802:1: ( rule__VariableStatement__NameAssignment_2 )
            {
             before(grammarAccess.getVariableStatementAccess().getNameAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2803:1: ( rule__VariableStatement__NameAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2803:2: rule__VariableStatement__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableStatement__NameAssignment_2_in_rule__VariableStatement__Group__2__Impl5783);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2813:1: rule__VariableStatement__Group__3 : rule__VariableStatement__Group__3__Impl ;
    public final void rule__VariableStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2817:1: ( rule__VariableStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2818:2: rule__VariableStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__3__Impl_in_rule__VariableStatement__Group__35813);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2824:1: rule__VariableStatement__Group__3__Impl : ( ( rule__VariableStatement__Group_3__0 )? ) ;
    public final void rule__VariableStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2828:1: ( ( ( rule__VariableStatement__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2829:1: ( ( rule__VariableStatement__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2829:1: ( ( rule__VariableStatement__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2830:1: ( rule__VariableStatement__Group_3__0 )?
            {
             before(grammarAccess.getVariableStatementAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2831:1: ( rule__VariableStatement__Group_3__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2831:2: rule__VariableStatement__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__VariableStatement__Group_3__0_in_rule__VariableStatement__Group__3__Impl5840);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2849:1: rule__VariableStatement__Group_3__0 : rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1 ;
    public final void rule__VariableStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2853:1: ( rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2854:2: rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group_3__0__Impl_in_rule__VariableStatement__Group_3__05879);
            rule__VariableStatement__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group_3__1_in_rule__VariableStatement__Group_3__05882);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2861:1: rule__VariableStatement__Group_3__0__Impl : ( '=' ) ;
    public final void rule__VariableStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2865:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2866:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2866:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2867:1: '='
            {
             before(grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0()); 
            match(input,35,FOLLOW_35_in_rule__VariableStatement__Group_3__0__Impl5910); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2880:1: rule__VariableStatement__Group_3__1 : rule__VariableStatement__Group_3__1__Impl ;
    public final void rule__VariableStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2884:1: ( rule__VariableStatement__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2885:2: rule__VariableStatement__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group_3__1__Impl_in_rule__VariableStatement__Group_3__15941);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2891:1: rule__VariableStatement__Group_3__1__Impl : ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) ) ;
    public final void rule__VariableStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2895:1: ( ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2896:1: ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2896:1: ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2897:1: ( rule__VariableStatement__ExpressionAssignment_3_1 )
            {
             before(grammarAccess.getVariableStatementAccess().getExpressionAssignment_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2898:1: ( rule__VariableStatement__ExpressionAssignment_3_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2898:2: rule__VariableStatement__ExpressionAssignment_3_1
            {
            pushFollow(FOLLOW_rule__VariableStatement__ExpressionAssignment_3_1_in_rule__VariableStatement__Group_3__1__Impl5968);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2912:1: rule__AssignmentStatement__Group__0 : rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1 ;
    public final void rule__AssignmentStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2916:1: ( rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2917:2: rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__0__Impl_in_rule__AssignmentStatement__Group__06002);
            rule__AssignmentStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__1_in_rule__AssignmentStatement__Group__06005);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2924:1: rule__AssignmentStatement__Group__0__Impl : ( () ) ;
    public final void rule__AssignmentStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2928:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2929:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2929:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2930:1: ()
            {
             before(grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2931:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2933:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2943:1: rule__AssignmentStatement__Group__1 : rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2 ;
    public final void rule__AssignmentStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2947:1: ( rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2948:2: rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__1__Impl_in_rule__AssignmentStatement__Group__16063);
            rule__AssignmentStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__2_in_rule__AssignmentStatement__Group__16066);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2955:1: rule__AssignmentStatement__Group__1__Impl : ( ( rule__AssignmentStatement__VarAssignment_1 ) ) ;
    public final void rule__AssignmentStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2959:1: ( ( ( rule__AssignmentStatement__VarAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2960:1: ( ( rule__AssignmentStatement__VarAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2960:1: ( ( rule__AssignmentStatement__VarAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2961:1: ( rule__AssignmentStatement__VarAssignment_1 )
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2962:1: ( rule__AssignmentStatement__VarAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2962:2: rule__AssignmentStatement__VarAssignment_1
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__VarAssignment_1_in_rule__AssignmentStatement__Group__1__Impl6093);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2972:1: rule__AssignmentStatement__Group__2 : rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3 ;
    public final void rule__AssignmentStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2976:1: ( rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2977:2: rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__2__Impl_in_rule__AssignmentStatement__Group__26123);
            rule__AssignmentStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__3_in_rule__AssignmentStatement__Group__26126);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2984:1: rule__AssignmentStatement__Group__2__Impl : ( '=' ) ;
    public final void rule__AssignmentStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2988:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2989:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2989:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2990:1: '='
            {
             before(grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__AssignmentStatement__Group__2__Impl6154); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3003:1: rule__AssignmentStatement__Group__3 : rule__AssignmentStatement__Group__3__Impl ;
    public final void rule__AssignmentStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3007:1: ( rule__AssignmentStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3008:2: rule__AssignmentStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__3__Impl_in_rule__AssignmentStatement__Group__36185);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3014:1: rule__AssignmentStatement__Group__3__Impl : ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) ) ;
    public final void rule__AssignmentStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3018:1: ( ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3019:1: ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3019:1: ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3020:1: ( rule__AssignmentStatement__ExpressionAssignment_3 )
            {
             before(grammarAccess.getAssignmentStatementAccess().getExpressionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3021:1: ( rule__AssignmentStatement__ExpressionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3021:2: rule__AssignmentStatement__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__ExpressionAssignment_3_in_rule__AssignmentStatement__Group__3__Impl6212);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3039:1: rule__ReferenceAssignmentStatement__Group__0 : rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1 ;
    public final void rule__ReferenceAssignmentStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3043:1: ( rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3044:2: rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__0__Impl_in_rule__ReferenceAssignmentStatement__Group__06250);
            rule__ReferenceAssignmentStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__1_in_rule__ReferenceAssignmentStatement__Group__06253);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3051:1: rule__ReferenceAssignmentStatement__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceAssignmentStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3055:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3056:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3056:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3057:1: ()
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignementAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3058:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3060:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3070:1: rule__ReferenceAssignmentStatement__Group__1 : rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2 ;
    public final void rule__ReferenceAssignmentStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3074:1: ( rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3075:2: rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__1__Impl_in_rule__ReferenceAssignmentStatement__Group__16311);
            rule__ReferenceAssignmentStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__2_in_rule__ReferenceAssignmentStatement__Group__16314);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3082:1: rule__ReferenceAssignmentStatement__Group__1__Impl : ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) ) ;
    public final void rule__ReferenceAssignmentStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3086:1: ( ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3087:1: ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3087:1: ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3088:1: ( rule__ReferenceAssignmentStatement__RefAssignment_1 )
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3089:1: ( rule__ReferenceAssignmentStatement__RefAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3089:2: rule__ReferenceAssignmentStatement__RefAssignment_1
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__RefAssignment_1_in_rule__ReferenceAssignmentStatement__Group__1__Impl6341);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3099:1: rule__ReferenceAssignmentStatement__Group__2 : rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3 ;
    public final void rule__ReferenceAssignmentStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3103:1: ( rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3104:2: rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__2__Impl_in_rule__ReferenceAssignmentStatement__Group__26371);
            rule__ReferenceAssignmentStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__3_in_rule__ReferenceAssignmentStatement__Group__26374);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3111:1: rule__ReferenceAssignmentStatement__Group__2__Impl : ( '=' ) ;
    public final void rule__ReferenceAssignmentStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3115:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3116:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3116:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3117:1: '='
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__ReferenceAssignmentStatement__Group__2__Impl6402); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3130:1: rule__ReferenceAssignmentStatement__Group__3 : rule__ReferenceAssignmentStatement__Group__3__Impl ;
    public final void rule__ReferenceAssignmentStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3134:1: ( rule__ReferenceAssignmentStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3135:2: rule__ReferenceAssignmentStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__3__Impl_in_rule__ReferenceAssignmentStatement__Group__36433);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3141:1: rule__ReferenceAssignmentStatement__Group__3__Impl : ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) ) ;
    public final void rule__ReferenceAssignmentStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3145:1: ( ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3146:1: ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3146:1: ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3147:1: ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 )
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3148:1: ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3148:2: rule__ReferenceAssignmentStatement__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__ExpressionAssignment_3_in_rule__ReferenceAssignmentStatement__Group__3__Impl6460);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3166:1: rule__Logical__Group__0 : rule__Logical__Group__0__Impl rule__Logical__Group__1 ;
    public final void rule__Logical__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3170:1: ( rule__Logical__Group__0__Impl rule__Logical__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3171:2: rule__Logical__Group__0__Impl rule__Logical__Group__1
            {
            pushFollow(FOLLOW_rule__Logical__Group__0__Impl_in_rule__Logical__Group__06498);
            rule__Logical__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group__1_in_rule__Logical__Group__06501);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3178:1: rule__Logical__Group__0__Impl : ( ruleEquality ) ;
    public final void rule__Logical__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3182:1: ( ( ruleEquality ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3183:1: ( ruleEquality )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3183:1: ( ruleEquality )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3184:1: ruleEquality
            {
             before(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleEquality_in_rule__Logical__Group__0__Impl6528);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3195:1: rule__Logical__Group__1 : rule__Logical__Group__1__Impl ;
    public final void rule__Logical__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3199:1: ( rule__Logical__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3200:2: rule__Logical__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group__1__Impl_in_rule__Logical__Group__16557);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3206:1: rule__Logical__Group__1__Impl : ( ( rule__Logical__Group_1__0 )* ) ;
    public final void rule__Logical__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3210:1: ( ( ( rule__Logical__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3211:1: ( ( rule__Logical__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3211:1: ( ( rule__Logical__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3212:1: ( rule__Logical__Group_1__0 )*
            {
             before(grammarAccess.getLogicalAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3213:1: ( rule__Logical__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=36 && LA26_0<=37)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3213:2: rule__Logical__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Logical__Group_1__0_in_rule__Logical__Group__1__Impl6584);
            	    rule__Logical__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3227:1: rule__Logical__Group_1__0 : rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1 ;
    public final void rule__Logical__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3231:1: ( rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3232:2: rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1__0__Impl_in_rule__Logical__Group_1__06619);
            rule__Logical__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1__1_in_rule__Logical__Group_1__06622);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3239:1: rule__Logical__Group_1__0__Impl : ( ( rule__Logical__Alternatives_1_0 ) ) ;
    public final void rule__Logical__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3243:1: ( ( ( rule__Logical__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3244:1: ( ( rule__Logical__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3244:1: ( ( rule__Logical__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3245:1: ( rule__Logical__Alternatives_1_0 )
            {
             before(grammarAccess.getLogicalAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3246:1: ( rule__Logical__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3246:2: rule__Logical__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Logical__Alternatives_1_0_in_rule__Logical__Group_1__0__Impl6649);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3256:1: rule__Logical__Group_1__1 : rule__Logical__Group_1__1__Impl ;
    public final void rule__Logical__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3260:1: ( rule__Logical__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3261:2: rule__Logical__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1__1__Impl_in_rule__Logical__Group_1__16679);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3267:1: rule__Logical__Group_1__1__Impl : ( ( rule__Logical__RightAssignment_1_1 ) ) ;
    public final void rule__Logical__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3271:1: ( ( ( rule__Logical__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3272:1: ( ( rule__Logical__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3272:1: ( ( rule__Logical__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3273:1: ( rule__Logical__RightAssignment_1_1 )
            {
             before(grammarAccess.getLogicalAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3274:1: ( rule__Logical__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3274:2: rule__Logical__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Logical__RightAssignment_1_1_in_rule__Logical__Group_1__1__Impl6706);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3288:1: rule__Logical__Group_1_0_0__0 : rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1 ;
    public final void rule__Logical__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3292:1: ( rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3293:2: rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__0__Impl_in_rule__Logical__Group_1_0_0__06740);
            rule__Logical__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__1_in_rule__Logical__Group_1_0_0__06743);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3300:1: rule__Logical__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Logical__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3304:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3305:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3305:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3306:1: ()
            {
             before(grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3307:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3309:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3319:1: rule__Logical__Group_1_0_0__1 : rule__Logical__Group_1_0_0__1__Impl ;
    public final void rule__Logical__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3323:1: ( rule__Logical__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3324:2: rule__Logical__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__1__Impl_in_rule__Logical__Group_1_0_0__16801);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3330:1: rule__Logical__Group_1_0_0__1__Impl : ( '&&' ) ;
    public final void rule__Logical__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3334:1: ( ( '&&' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3335:1: ( '&&' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3335:1: ( '&&' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3336:1: '&&'
            {
             before(grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1()); 
            match(input,36,FOLLOW_36_in_rule__Logical__Group_1_0_0__1__Impl6829); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3353:1: rule__Logical__Group_1_0_1__0 : rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1 ;
    public final void rule__Logical__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3357:1: ( rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3358:2: rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__0__Impl_in_rule__Logical__Group_1_0_1__06864);
            rule__Logical__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__1_in_rule__Logical__Group_1_0_1__06867);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3365:1: rule__Logical__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Logical__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3369:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3370:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3370:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3371:1: ()
            {
             before(grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3372:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3374:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3384:1: rule__Logical__Group_1_0_1__1 : rule__Logical__Group_1_0_1__1__Impl ;
    public final void rule__Logical__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3388:1: ( rule__Logical__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3389:2: rule__Logical__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__1__Impl_in_rule__Logical__Group_1_0_1__16925);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3395:1: rule__Logical__Group_1_0_1__1__Impl : ( '||' ) ;
    public final void rule__Logical__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3399:1: ( ( '||' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3400:1: ( '||' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3400:1: ( '||' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3401:1: '||'
            {
             before(grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1()); 
            match(input,37,FOLLOW_37_in_rule__Logical__Group_1_0_1__1__Impl6953); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3418:1: rule__Equality__Group__0 : rule__Equality__Group__0__Impl rule__Equality__Group__1 ;
    public final void rule__Equality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3422:1: ( rule__Equality__Group__0__Impl rule__Equality__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3423:2: rule__Equality__Group__0__Impl rule__Equality__Group__1
            {
            pushFollow(FOLLOW_rule__Equality__Group__0__Impl_in_rule__Equality__Group__06988);
            rule__Equality__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group__1_in_rule__Equality__Group__06991);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3430:1: rule__Equality__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__Equality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3434:1: ( ( ruleComparison ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3435:1: ( ruleComparison )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3435:1: ( ruleComparison )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3436:1: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleComparison_in_rule__Equality__Group__0__Impl7018);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3447:1: rule__Equality__Group__1 : rule__Equality__Group__1__Impl ;
    public final void rule__Equality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3451:1: ( rule__Equality__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3452:2: rule__Equality__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group__1__Impl_in_rule__Equality__Group__17047);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3458:1: rule__Equality__Group__1__Impl : ( ( rule__Equality__Group_1__0 )* ) ;
    public final void rule__Equality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3462:1: ( ( ( rule__Equality__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3463:1: ( ( rule__Equality__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3463:1: ( ( rule__Equality__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3464:1: ( rule__Equality__Group_1__0 )*
            {
             before(grammarAccess.getEqualityAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3465:1: ( rule__Equality__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=38 && LA27_0<=39)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3465:2: rule__Equality__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Equality__Group_1__0_in_rule__Equality__Group__1__Impl7074);
            	    rule__Equality__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3479:1: rule__Equality__Group_1__0 : rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 ;
    public final void rule__Equality__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3483:1: ( rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3484:2: rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1__0__Impl_in_rule__Equality__Group_1__07109);
            rule__Equality__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1__1_in_rule__Equality__Group_1__07112);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3491:1: rule__Equality__Group_1__0__Impl : ( ( rule__Equality__Alternatives_1_0 ) ) ;
    public final void rule__Equality__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3495:1: ( ( ( rule__Equality__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3496:1: ( ( rule__Equality__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3496:1: ( ( rule__Equality__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3497:1: ( rule__Equality__Alternatives_1_0 )
            {
             before(grammarAccess.getEqualityAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3498:1: ( rule__Equality__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3498:2: rule__Equality__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Equality__Alternatives_1_0_in_rule__Equality__Group_1__0__Impl7139);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3508:1: rule__Equality__Group_1__1 : rule__Equality__Group_1__1__Impl ;
    public final void rule__Equality__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3512:1: ( rule__Equality__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3513:2: rule__Equality__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1__1__Impl_in_rule__Equality__Group_1__17169);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3519:1: rule__Equality__Group_1__1__Impl : ( ( rule__Equality__RightAssignment_1_1 ) ) ;
    public final void rule__Equality__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3523:1: ( ( ( rule__Equality__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3524:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3524:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3525:1: ( rule__Equality__RightAssignment_1_1 )
            {
             before(grammarAccess.getEqualityAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3526:1: ( rule__Equality__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3526:2: rule__Equality__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Equality__RightAssignment_1_1_in_rule__Equality__Group_1__1__Impl7196);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3540:1: rule__Equality__Group_1_0_0__0 : rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 ;
    public final void rule__Equality__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3544:1: ( rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3545:2: rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__0__Impl_in_rule__Equality__Group_1_0_0__07230);
            rule__Equality__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__1_in_rule__Equality__Group_1_0_0__07233);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3552:1: rule__Equality__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3556:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3557:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3557:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3558:1: ()
            {
             before(grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3559:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3561:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3571:1: rule__Equality__Group_1_0_0__1 : rule__Equality__Group_1_0_0__1__Impl ;
    public final void rule__Equality__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3575:1: ( rule__Equality__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3576:2: rule__Equality__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__1__Impl_in_rule__Equality__Group_1_0_0__17291);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3582:1: rule__Equality__Group_1_0_0__1__Impl : ( '==' ) ;
    public final void rule__Equality__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3586:1: ( ( '==' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3587:1: ( '==' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3587:1: ( '==' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3588:1: '=='
            {
             before(grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1()); 
            match(input,38,FOLLOW_38_in_rule__Equality__Group_1_0_0__1__Impl7319); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3605:1: rule__Equality__Group_1_0_1__0 : rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 ;
    public final void rule__Equality__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3609:1: ( rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3610:2: rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__0__Impl_in_rule__Equality__Group_1_0_1__07354);
            rule__Equality__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__1_in_rule__Equality__Group_1_0_1__07357);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3617:1: rule__Equality__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3621:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3622:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3622:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3623:1: ()
            {
             before(grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3624:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3626:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3636:1: rule__Equality__Group_1_0_1__1 : rule__Equality__Group_1_0_1__1__Impl ;
    public final void rule__Equality__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3640:1: ( rule__Equality__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3641:2: rule__Equality__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__1__Impl_in_rule__Equality__Group_1_0_1__17415);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3647:1: rule__Equality__Group_1_0_1__1__Impl : ( '!=' ) ;
    public final void rule__Equality__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3651:1: ( ( '!=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3652:1: ( '!=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3652:1: ( '!=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3653:1: '!='
            {
             before(grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1()); 
            match(input,39,FOLLOW_39_in_rule__Equality__Group_1_0_1__1__Impl7443); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3670:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3674:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3675:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__07478);
            rule__Comparison__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__07481);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3682:1: rule__Comparison__Group__0__Impl : ( ruleAddition ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3686:1: ( ( ruleAddition ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3687:1: ( ruleAddition )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3687:1: ( ruleAddition )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3688:1: ruleAddition
            {
             before(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl7508);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3699:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3703:1: ( rule__Comparison__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3704:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__17537);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3710:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3714:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3715:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3715:1: ( ( rule__Comparison__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3716:1: ( rule__Comparison__Group_1__0 )*
            {
             before(grammarAccess.getComparisonAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3717:1: ( rule__Comparison__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=40 && LA28_0<=43)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3717:2: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl7564);
            	    rule__Comparison__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3731:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3735:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3736:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__07599);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__07602);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3743:1: rule__Comparison__Group_1__0__Impl : ( ( rule__Comparison__Alternatives_1_0 ) ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3747:1: ( ( ( rule__Comparison__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3748:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3748:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3749:1: ( rule__Comparison__Alternatives_1_0 )
            {
             before(grammarAccess.getComparisonAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3750:1: ( rule__Comparison__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3750:2: rule__Comparison__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Comparison__Alternatives_1_0_in_rule__Comparison__Group_1__0__Impl7629);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3760:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3764:1: ( rule__Comparison__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3765:2: rule__Comparison__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__17659);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3771:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__RightAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3775:1: ( ( ( rule__Comparison__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3776:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3776:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3777:1: ( rule__Comparison__RightAssignment_1_1 )
            {
             before(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3778:1: ( rule__Comparison__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3778:2: rule__Comparison__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl7686);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3792:1: rule__Comparison__Group_1_0_0__0 : rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 ;
    public final void rule__Comparison__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3796:1: ( rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3797:2: rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__0__Impl_in_rule__Comparison__Group_1_0_0__07720);
            rule__Comparison__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__1_in_rule__Comparison__Group_1_0_0__07723);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3804:1: rule__Comparison__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3808:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3809:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3809:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3810:1: ()
            {
             before(grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3811:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3813:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3823:1: rule__Comparison__Group_1_0_0__1 : rule__Comparison__Group_1_0_0__1__Impl ;
    public final void rule__Comparison__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3827:1: ( rule__Comparison__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3828:2: rule__Comparison__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__1__Impl_in_rule__Comparison__Group_1_0_0__17781);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3834:1: rule__Comparison__Group_1_0_0__1__Impl : ( '<' ) ;
    public final void rule__Comparison__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3838:1: ( ( '<' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3839:1: ( '<' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3839:1: ( '<' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3840:1: '<'
            {
             before(grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1()); 
            match(input,40,FOLLOW_40_in_rule__Comparison__Group_1_0_0__1__Impl7809); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3857:1: rule__Comparison__Group_1_0_1__0 : rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 ;
    public final void rule__Comparison__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3861:1: ( rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3862:2: rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__0__Impl_in_rule__Comparison__Group_1_0_1__07844);
            rule__Comparison__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__1_in_rule__Comparison__Group_1_0_1__07847);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3869:1: rule__Comparison__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3873:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3874:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3874:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3875:1: ()
            {
             before(grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3876:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3878:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3888:1: rule__Comparison__Group_1_0_1__1 : rule__Comparison__Group_1_0_1__1__Impl ;
    public final void rule__Comparison__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3892:1: ( rule__Comparison__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3893:2: rule__Comparison__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__1__Impl_in_rule__Comparison__Group_1_0_1__17905);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3899:1: rule__Comparison__Group_1_0_1__1__Impl : ( '<=' ) ;
    public final void rule__Comparison__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3903:1: ( ( '<=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3904:1: ( '<=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3904:1: ( '<=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3905:1: '<='
            {
             before(grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1()); 
            match(input,41,FOLLOW_41_in_rule__Comparison__Group_1_0_1__1__Impl7933); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3922:1: rule__Comparison__Group_1_0_2__0 : rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 ;
    public final void rule__Comparison__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3926:1: ( rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3927:2: rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__0__Impl_in_rule__Comparison__Group_1_0_2__07968);
            rule__Comparison__Group_1_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__1_in_rule__Comparison__Group_1_0_2__07971);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3934:1: rule__Comparison__Group_1_0_2__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3938:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3939:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3939:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3940:1: ()
            {
             before(grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3941:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3943:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3953:1: rule__Comparison__Group_1_0_2__1 : rule__Comparison__Group_1_0_2__1__Impl ;
    public final void rule__Comparison__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3957:1: ( rule__Comparison__Group_1_0_2__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3958:2: rule__Comparison__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__1__Impl_in_rule__Comparison__Group_1_0_2__18029);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3964:1: rule__Comparison__Group_1_0_2__1__Impl : ( '>' ) ;
    public final void rule__Comparison__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3968:1: ( ( '>' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3969:1: ( '>' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3969:1: ( '>' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3970:1: '>'
            {
             before(grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1()); 
            match(input,42,FOLLOW_42_in_rule__Comparison__Group_1_0_2__1__Impl8057); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3987:1: rule__Comparison__Group_1_0_3__0 : rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 ;
    public final void rule__Comparison__Group_1_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3991:1: ( rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3992:2: rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__0__Impl_in_rule__Comparison__Group_1_0_3__08092);
            rule__Comparison__Group_1_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__1_in_rule__Comparison__Group_1_0_3__08095);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3999:1: rule__Comparison__Group_1_0_3__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4003:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4004:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4004:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4005:1: ()
            {
             before(grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4006:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4008:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4018:1: rule__Comparison__Group_1_0_3__1 : rule__Comparison__Group_1_0_3__1__Impl ;
    public final void rule__Comparison__Group_1_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4022:1: ( rule__Comparison__Group_1_0_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4023:2: rule__Comparison__Group_1_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__1__Impl_in_rule__Comparison__Group_1_0_3__18153);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4029:1: rule__Comparison__Group_1_0_3__1__Impl : ( '>=' ) ;
    public final void rule__Comparison__Group_1_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4033:1: ( ( '>=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4034:1: ( '>=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4034:1: ( '>=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4035:1: '>='
            {
             before(grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1()); 
            match(input,43,FOLLOW_43_in_rule__Comparison__Group_1_0_3__1__Impl8181); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4052:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4056:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4057:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__08216);
            rule__Addition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__08219);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4064:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4068:1: ( ( ruleMultiplication ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4069:1: ( ruleMultiplication )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4069:1: ( ruleMultiplication )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4070:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl8246);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4081:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4085:1: ( rule__Addition__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4086:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__18275);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4092:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4096:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4097:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4097:1: ( ( rule__Addition__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4098:1: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4099:1: ( rule__Addition__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=12 && LA29_0<=13)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4099:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl8302);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4113:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4117:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4118:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__08337);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__08340);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4125:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4129:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4130:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4130:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4131:1: ( rule__Addition__Alternatives_1_0 )
            {
             before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4132:1: ( rule__Addition__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4132:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl8367);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4142:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4146:1: ( rule__Addition__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4147:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__18397);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4153:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4157:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4158:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4158:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4159:1: ( rule__Addition__RightAssignment_1_1 )
            {
             before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4160:1: ( rule__Addition__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4160:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl8424);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4174:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4178:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4179:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__08458);
            rule__Addition__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__08461);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4186:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4190:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4191:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4191:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4192:1: ()
            {
             before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4193:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4195:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4205:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4209:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4210:2: rule__Addition__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__18519);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4216:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4220:1: ( ( '+' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4221:1: ( '+' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4221:1: ( '+' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4222:1: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            match(input,13,FOLLOW_13_in_rule__Addition__Group_1_0_0__1__Impl8547); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4239:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4243:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4244:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__08582);
            rule__Addition__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__08585);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4251:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4255:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4256:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4256:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4257:1: ()
            {
             before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4258:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4260:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4270:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4274:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4275:2: rule__Addition__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__18643);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4281:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4285:1: ( ( '-' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4286:1: ( '-' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4286:1: ( '-' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4287:1: '-'
            {
             before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            match(input,12,FOLLOW_12_in_rule__Addition__Group_1_0_1__1__Impl8671); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4304:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4308:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4309:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__08706);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__08709);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4316:1: rule__Multiplication__Group__0__Impl : ( ruleUnary ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4320:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4321:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4321:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4322:1: ruleUnary
            {
             before(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Multiplication__Group__0__Impl8736);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4333:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4337:1: ( rule__Multiplication__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4338:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__18765);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4344:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4348:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4349:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4349:1: ( ( rule__Multiplication__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4350:1: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4351:1: ( rule__Multiplication__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=44 && LA30_0<=46)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4351:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl8792);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4365:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4369:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4370:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__08827);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__08830);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4377:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Alternatives_1_0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4381:1: ( ( ( rule__Multiplication__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4382:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4382:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4383:1: ( rule__Multiplication__Alternatives_1_0 )
            {
             before(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4384:1: ( rule__Multiplication__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4384:2: rule__Multiplication__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__0__Impl8857);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4394:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4398:1: ( rule__Multiplication__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4399:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__18887);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4405:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4409:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4410:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4410:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4411:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4412:1: ( rule__Multiplication__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4412:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl8914);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4426:1: rule__Multiplication__Group_1_0_0__0 : rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 ;
    public final void rule__Multiplication__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4430:1: ( rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4431:2: rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__0__Impl_in_rule__Multiplication__Group_1_0_0__08948);
            rule__Multiplication__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__08951);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4438:1: rule__Multiplication__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4442:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4443:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4443:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4444:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4445:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4447:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4457:1: rule__Multiplication__Group_1_0_0__1 : rule__Multiplication__Group_1_0_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4461:1: ( rule__Multiplication__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4462:2: rule__Multiplication__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__1__Impl_in_rule__Multiplication__Group_1_0_0__19009);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4468:1: rule__Multiplication__Group_1_0_0__1__Impl : ( '*' ) ;
    public final void rule__Multiplication__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4472:1: ( ( '*' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4473:1: ( '*' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4473:1: ( '*' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4474:1: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 
            match(input,44,FOLLOW_44_in_rule__Multiplication__Group_1_0_0__1__Impl9037); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4491:1: rule__Multiplication__Group_1_0_1__0 : rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 ;
    public final void rule__Multiplication__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4495:1: ( rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4496:2: rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__0__Impl_in_rule__Multiplication__Group_1_0_1__09072);
            rule__Multiplication__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__09075);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4503:1: rule__Multiplication__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4507:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4508:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4508:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4509:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4510:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4512:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4522:1: rule__Multiplication__Group_1_0_1__1 : rule__Multiplication__Group_1_0_1__1__Impl ;
    public final void rule__Multiplication__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4526:1: ( rule__Multiplication__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4527:2: rule__Multiplication__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__1__Impl_in_rule__Multiplication__Group_1_0_1__19133);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4533:1: rule__Multiplication__Group_1_0_1__1__Impl : ( '/' ) ;
    public final void rule__Multiplication__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4537:1: ( ( '/' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4538:1: ( '/' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4538:1: ( '/' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4539:1: '/'
            {
             before(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 
            match(input,45,FOLLOW_45_in_rule__Multiplication__Group_1_0_1__1__Impl9161); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4556:1: rule__Multiplication__Group_1_0_2__0 : rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1 ;
    public final void rule__Multiplication__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4560:1: ( rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4561:2: rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__0__Impl_in_rule__Multiplication__Group_1_0_2__09196);
            rule__Multiplication__Group_1_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__1_in_rule__Multiplication__Group_1_0_2__09199);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4568:1: rule__Multiplication__Group_1_0_2__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4572:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4573:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4573:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4574:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4575:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4577:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4587:1: rule__Multiplication__Group_1_0_2__1 : rule__Multiplication__Group_1_0_2__1__Impl ;
    public final void rule__Multiplication__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4591:1: ( rule__Multiplication__Group_1_0_2__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4592:2: rule__Multiplication__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__1__Impl_in_rule__Multiplication__Group_1_0_2__19257);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4598:1: rule__Multiplication__Group_1_0_2__1__Impl : ( '%' ) ;
    public final void rule__Multiplication__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4602:1: ( ( '%' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4603:1: ( '%' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4603:1: ( '%' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4604:1: '%'
            {
             before(grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1()); 
            match(input,46,FOLLOW_46_in_rule__Multiplication__Group_1_0_2__1__Impl9285); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4621:1: rule__Unary__Group_1__0 : rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1 ;
    public final void rule__Unary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4625:1: ( rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4626:2: rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1__0__Impl_in_rule__Unary__Group_1__09320);
            rule__Unary__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1__1_in_rule__Unary__Group_1__09323);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4633:1: rule__Unary__Group_1__0__Impl : ( ( rule__Unary__Alternatives_1_0 ) ) ;
    public final void rule__Unary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4637:1: ( ( ( rule__Unary__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4638:1: ( ( rule__Unary__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4638:1: ( ( rule__Unary__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4639:1: ( rule__Unary__Alternatives_1_0 )
            {
             before(grammarAccess.getUnaryAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4640:1: ( rule__Unary__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4640:2: rule__Unary__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Unary__Alternatives_1_0_in_rule__Unary__Group_1__0__Impl9350);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4650:1: rule__Unary__Group_1__1 : rule__Unary__Group_1__1__Impl ;
    public final void rule__Unary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4654:1: ( rule__Unary__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4655:2: rule__Unary__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1__1__Impl_in_rule__Unary__Group_1__19380);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4661:1: rule__Unary__Group_1__1__Impl : ( ( rule__Unary__RightAssignment_1_1 ) ) ;
    public final void rule__Unary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4665:1: ( ( ( rule__Unary__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4666:1: ( ( rule__Unary__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4666:1: ( ( rule__Unary__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4667:1: ( rule__Unary__RightAssignment_1_1 )
            {
             before(grammarAccess.getUnaryAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4668:1: ( rule__Unary__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4668:2: rule__Unary__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Unary__RightAssignment_1_1_in_rule__Unary__Group_1__1__Impl9407);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4682:1: rule__Unary__Group_1_0_0__0 : rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1 ;
    public final void rule__Unary__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4686:1: ( rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4687:2: rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__0__Impl_in_rule__Unary__Group_1_0_0__09441);
            rule__Unary__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__1_in_rule__Unary__Group_1_0_0__09444);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4694:1: rule__Unary__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Unary__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4698:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4699:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4699:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4700:1: ()
            {
             before(grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4701:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4703:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4713:1: rule__Unary__Group_1_0_0__1 : rule__Unary__Group_1_0_0__1__Impl ;
    public final void rule__Unary__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4717:1: ( rule__Unary__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4718:2: rule__Unary__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__1__Impl_in_rule__Unary__Group_1_0_0__19502);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4724:1: rule__Unary__Group_1_0_0__1__Impl : ( ( rule__Unary__OpAssignment_1_0_0_1 ) ) ;
    public final void rule__Unary__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4728:1: ( ( ( rule__Unary__OpAssignment_1_0_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4729:1: ( ( rule__Unary__OpAssignment_1_0_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4729:1: ( ( rule__Unary__OpAssignment_1_0_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4730:1: ( rule__Unary__OpAssignment_1_0_0_1 )
            {
             before(grammarAccess.getUnaryAccess().getOpAssignment_1_0_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4731:1: ( rule__Unary__OpAssignment_1_0_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4731:2: rule__Unary__OpAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__Unary__OpAssignment_1_0_0_1_in_rule__Unary__Group_1_0_0__1__Impl9529);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4745:1: rule__Unary__Group_1_0_1__0 : rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1 ;
    public final void rule__Unary__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4749:1: ( rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4750:2: rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__0__Impl_in_rule__Unary__Group_1_0_1__09563);
            rule__Unary__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__1_in_rule__Unary__Group_1_0_1__09566);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4757:1: rule__Unary__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Unary__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4761:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4762:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4762:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4763:1: ()
            {
             before(grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4764:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4766:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4776:1: rule__Unary__Group_1_0_1__1 : rule__Unary__Group_1_0_1__1__Impl ;
    public final void rule__Unary__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4780:1: ( rule__Unary__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4781:2: rule__Unary__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__1__Impl_in_rule__Unary__Group_1_0_1__19624);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4787:1: rule__Unary__Group_1_0_1__1__Impl : ( ( rule__Unary__OpAssignment_1_0_1_1 ) ) ;
    public final void rule__Unary__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4791:1: ( ( ( rule__Unary__OpAssignment_1_0_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4792:1: ( ( rule__Unary__OpAssignment_1_0_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4792:1: ( ( rule__Unary__OpAssignment_1_0_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4793:1: ( rule__Unary__OpAssignment_1_0_1_1 )
            {
             before(grammarAccess.getUnaryAccess().getOpAssignment_1_0_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4794:1: ( rule__Unary__OpAssignment_1_0_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4794:2: rule__Unary__OpAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_rule__Unary__OpAssignment_1_0_1_1_in_rule__Unary__Group_1_0_1__1__Impl9651);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4808:1: rule__Literal__Group_0__0 : rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1 ;
    public final void rule__Literal__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4812:1: ( rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4813:2: rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1
            {
            pushFollow(FOLLOW_rule__Literal__Group_0__0__Impl_in_rule__Literal__Group_0__09685);
            rule__Literal__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Literal__Group_0__1_in_rule__Literal__Group_0__09688);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4820:1: rule__Literal__Group_0__0__Impl : ( () ) ;
    public final void rule__Literal__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4824:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4825:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4825:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4826:1: ()
            {
             before(grammarAccess.getLiteralAccess().getNumberLiteralAction_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4827:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4829:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4839:1: rule__Literal__Group_0__1 : rule__Literal__Group_0__1__Impl ;
    public final void rule__Literal__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4843:1: ( rule__Literal__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4844:2: rule__Literal__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Literal__Group_0__1__Impl_in_rule__Literal__Group_0__19746);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4850:1: rule__Literal__Group_0__1__Impl : ( ( rule__Literal__ValueAssignment_0_1 ) ) ;
    public final void rule__Literal__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4854:1: ( ( ( rule__Literal__ValueAssignment_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4855:1: ( ( rule__Literal__ValueAssignment_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4855:1: ( ( rule__Literal__ValueAssignment_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4856:1: ( rule__Literal__ValueAssignment_0_1 )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4857:1: ( rule__Literal__ValueAssignment_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4857:2: rule__Literal__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Literal__ValueAssignment_0_1_in_rule__Literal__Group_0__1__Impl9773);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4871:1: rule__Literal__Group_1__0 : rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 ;
    public final void rule__Literal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4875:1: ( rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4876:2: rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1
            {
            pushFollow(FOLLOW_rule__Literal__Group_1__0__Impl_in_rule__Literal__Group_1__09807);
            rule__Literal__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Literal__Group_1__1_in_rule__Literal__Group_1__09810);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4883:1: rule__Literal__Group_1__0__Impl : ( () ) ;
    public final void rule__Literal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4887:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4888:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4888:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4889:1: ()
            {
             before(grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4890:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4892:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4902:1: rule__Literal__Group_1__1 : rule__Literal__Group_1__1__Impl ;
    public final void rule__Literal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4906:1: ( rule__Literal__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4907:2: rule__Literal__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Literal__Group_1__1__Impl_in_rule__Literal__Group_1__19868);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4913:1: rule__Literal__Group_1__1__Impl : ( ( rule__Literal__Alternatives_1_1 ) ) ;
    public final void rule__Literal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4917:1: ( ( ( rule__Literal__Alternatives_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4918:1: ( ( rule__Literal__Alternatives_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4918:1: ( ( rule__Literal__Alternatives_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4919:1: ( rule__Literal__Alternatives_1_1 )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4920:1: ( rule__Literal__Alternatives_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4920:2: rule__Literal__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_1_1_in_rule__Literal__Group_1__1__Impl9895);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4934:1: rule__ParenthesizedExpression__Group__0 : rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 ;
    public final void rule__ParenthesizedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4938:1: ( rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4939:2: rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__09929);
            rule__ParenthesizedExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__09932);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4946:1: rule__ParenthesizedExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4950:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4951:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4951:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4952:1: '('
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__ParenthesizedExpression__Group__0__Impl9960); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4965:1: rule__ParenthesizedExpression__Group__1 : rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 ;
    public final void rule__ParenthesizedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4969:1: ( rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4970:2: rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__19991);
            rule__ParenthesizedExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__19994);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4977:1: rule__ParenthesizedExpression__Group__1__Impl : ( ruleExpression ) ;
    public final void rule__ParenthesizedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4981:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4982:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4982:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4983:1: ruleExpression
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__Group__1__Impl10021);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4994:1: rule__ParenthesizedExpression__Group__2 : rule__ParenthesizedExpression__Group__2__Impl ;
    public final void rule__ParenthesizedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4998:1: ( rule__ParenthesizedExpression__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4999:2: rule__ParenthesizedExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__210050);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5005:1: rule__ParenthesizedExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5009:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5010:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5010:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5011:1: ')'
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_25_in_rule__ParenthesizedExpression__Group__2__Impl10078); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5030:1: rule__FunctionCall__Group__0 : rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 ;
    public final void rule__FunctionCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5034:1: ( rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5035:2: rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__0__Impl_in_rule__FunctionCall__Group__010115);
            rule__FunctionCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__1_in_rule__FunctionCall__Group__010118);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5042:1: rule__FunctionCall__Group__0__Impl : ( () ) ;
    public final void rule__FunctionCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5046:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5047:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5047:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5048:1: ()
            {
             before(grammarAccess.getFunctionCallAccess().getFunctionCallAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5049:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5051:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5061:1: rule__FunctionCall__Group__1 : rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 ;
    public final void rule__FunctionCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5065:1: ( rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5066:2: rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__1__Impl_in_rule__FunctionCall__Group__110176);
            rule__FunctionCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__2_in_rule__FunctionCall__Group__110179);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5073:1: rule__FunctionCall__Group__1__Impl : ( ( rule__FunctionCall__FuncAssignment_1 ) ) ;
    public final void rule__FunctionCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5077:1: ( ( ( rule__FunctionCall__FuncAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5078:1: ( ( rule__FunctionCall__FuncAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5078:1: ( ( rule__FunctionCall__FuncAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5079:1: ( rule__FunctionCall__FuncAssignment_1 )
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5080:1: ( rule__FunctionCall__FuncAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5080:2: rule__FunctionCall__FuncAssignment_1
            {
            pushFollow(FOLLOW_rule__FunctionCall__FuncAssignment_1_in_rule__FunctionCall__Group__1__Impl10206);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5090:1: rule__FunctionCall__Group__2 : rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 ;
    public final void rule__FunctionCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5094:1: ( rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5095:2: rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__2__Impl_in_rule__FunctionCall__Group__210236);
            rule__FunctionCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__3_in_rule__FunctionCall__Group__210239);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5102:1: rule__FunctionCall__Group__2__Impl : ( '(' ) ;
    public final void rule__FunctionCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5106:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5107:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5107:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5108:1: '('
            {
             before(grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__FunctionCall__Group__2__Impl10267); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5121:1: rule__FunctionCall__Group__3 : rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 ;
    public final void rule__FunctionCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5125:1: ( rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5126:2: rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__3__Impl_in_rule__FunctionCall__Group__310298);
            rule__FunctionCall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__4_in_rule__FunctionCall__Group__310301);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5133:1: rule__FunctionCall__Group__3__Impl : ( ( rule__FunctionCall__Group_3__0 )? ) ;
    public final void rule__FunctionCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5137:1: ( ( ( rule__FunctionCall__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5138:1: ( ( rule__FunctionCall__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5138:1: ( ( rule__FunctionCall__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5139:1: ( rule__FunctionCall__Group_3__0 )?
            {
             before(grammarAccess.getFunctionCallAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5140:1: ( rule__FunctionCall__Group_3__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID||LA31_0==RULE_NUMBER||(LA31_0>=12 && LA31_0<=14)||LA31_0==24||LA31_0==48||(LA31_0>=52 && LA31_0<=53)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5140:2: rule__FunctionCall__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FunctionCall__Group_3__0_in_rule__FunctionCall__Group__3__Impl10328);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5150:1: rule__FunctionCall__Group__4 : rule__FunctionCall__Group__4__Impl ;
    public final void rule__FunctionCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5154:1: ( rule__FunctionCall__Group__4__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5155:2: rule__FunctionCall__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__4__Impl_in_rule__FunctionCall__Group__410359);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5161:1: rule__FunctionCall__Group__4__Impl : ( ')' ) ;
    public final void rule__FunctionCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5165:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5166:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5166:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5167:1: ')'
            {
             before(grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__FunctionCall__Group__4__Impl10387); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5190:1: rule__FunctionCall__Group_3__0 : rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 ;
    public final void rule__FunctionCall__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5194:1: ( rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5195:2: rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3__0__Impl_in_rule__FunctionCall__Group_3__010428);
            rule__FunctionCall__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group_3__1_in_rule__FunctionCall__Group_3__010431);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5202:1: rule__FunctionCall__Group_3__0__Impl : ( ( rule__FunctionCall__ArgsAssignment_3_0 ) ) ;
    public final void rule__FunctionCall__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5206:1: ( ( ( rule__FunctionCall__ArgsAssignment_3_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5207:1: ( ( rule__FunctionCall__ArgsAssignment_3_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5207:1: ( ( rule__FunctionCall__ArgsAssignment_3_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5208:1: ( rule__FunctionCall__ArgsAssignment_3_0 )
            {
             before(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5209:1: ( rule__FunctionCall__ArgsAssignment_3_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5209:2: rule__FunctionCall__ArgsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__FunctionCall__ArgsAssignment_3_0_in_rule__FunctionCall__Group_3__0__Impl10458);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5219:1: rule__FunctionCall__Group_3__1 : rule__FunctionCall__Group_3__1__Impl ;
    public final void rule__FunctionCall__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5223:1: ( rule__FunctionCall__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5224:2: rule__FunctionCall__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3__1__Impl_in_rule__FunctionCall__Group_3__110488);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5230:1: rule__FunctionCall__Group_3__1__Impl : ( ( rule__FunctionCall__Group_3_1__0 )* ) ;
    public final void rule__FunctionCall__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5234:1: ( ( ( rule__FunctionCall__Group_3_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5235:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5235:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5236:1: ( rule__FunctionCall__Group_3_1__0 )*
            {
             before(grammarAccess.getFunctionCallAccess().getGroup_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5237:1: ( rule__FunctionCall__Group_3_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==26) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5237:2: rule__FunctionCall__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__0_in_rule__FunctionCall__Group_3__1__Impl10515);
            	    rule__FunctionCall__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5251:1: rule__FunctionCall__Group_3_1__0 : rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 ;
    public final void rule__FunctionCall__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5255:1: ( rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5256:2: rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__0__Impl_in_rule__FunctionCall__Group_3_1__010550);
            rule__FunctionCall__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__1_in_rule__FunctionCall__Group_3_1__010553);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5263:1: rule__FunctionCall__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__FunctionCall__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5267:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5268:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5268:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5269:1: ','
            {
             before(grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0()); 
            match(input,26,FOLLOW_26_in_rule__FunctionCall__Group_3_1__0__Impl10581); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5282:1: rule__FunctionCall__Group_3_1__1 : rule__FunctionCall__Group_3_1__1__Impl ;
    public final void rule__FunctionCall__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5286:1: ( rule__FunctionCall__Group_3_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5287:2: rule__FunctionCall__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__1__Impl_in_rule__FunctionCall__Group_3_1__110612);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5293:1: rule__FunctionCall__Group_3_1__1__Impl : ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) ) ;
    public final void rule__FunctionCall__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5297:1: ( ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5298:1: ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5298:1: ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5299:1: ( rule__FunctionCall__ArgsAssignment_3_1_1 )
            {
             before(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5300:1: ( rule__FunctionCall__ArgsAssignment_3_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5300:2: rule__FunctionCall__ArgsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__FunctionCall__ArgsAssignment_3_1_1_in_rule__FunctionCall__Group_3_1__1__Impl10639);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5314:1: rule__VarOrArgumentCall__Group__0 : rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1 ;
    public final void rule__VarOrArgumentCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5318:1: ( rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5319:2: rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__0__Impl_in_rule__VarOrArgumentCall__Group__010673);
            rule__VarOrArgumentCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__1_in_rule__VarOrArgumentCall__Group__010676);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5326:1: rule__VarOrArgumentCall__Group__0__Impl : ( () ) ;
    public final void rule__VarOrArgumentCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5330:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5331:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5331:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5332:1: ()
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5333:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5335:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5345:1: rule__VarOrArgumentCall__Group__1 : rule__VarOrArgumentCall__Group__1__Impl ;
    public final void rule__VarOrArgumentCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5349:1: ( rule__VarOrArgumentCall__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5350:2: rule__VarOrArgumentCall__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__1__Impl_in_rule__VarOrArgumentCall__Group__110734);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5356:1: rule__VarOrArgumentCall__Group__1__Impl : ( ( rule__VarOrArgumentCall__CallAssignment_1 ) ) ;
    public final void rule__VarOrArgumentCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5360:1: ( ( ( rule__VarOrArgumentCall__CallAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5361:1: ( ( rule__VarOrArgumentCall__CallAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5361:1: ( ( rule__VarOrArgumentCall__CallAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5362:1: ( rule__VarOrArgumentCall__CallAssignment_1 )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5363:1: ( rule__VarOrArgumentCall__CallAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5363:2: rule__VarOrArgumentCall__CallAssignment_1
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__CallAssignment_1_in_rule__VarOrArgumentCall__Group__1__Impl10761);
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


    // $ANTLR start "rule__Reference__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5377:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5381:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5382:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__010795);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__010798);
            rule__Reference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5389:1: rule__Reference__Group__0__Impl : ( ruleContextRef ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5393:1: ( ( ruleContextRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5394:1: ( ruleContextRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5394:1: ( ruleContextRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5395:1: ruleContextRef
            {
             before(grammarAccess.getReferenceAccess().getContextRefParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleContextRef_in_rule__Reference__Group__0__Impl10825);
            ruleContextRef();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getContextRefParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5406:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5410:1: ( rule__Reference__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5411:2: rule__Reference__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__110854);
            rule__Reference__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5417:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__Group_1__0 )? ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5421:1: ( ( ( rule__Reference__Group_1__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5422:1: ( ( rule__Reference__Group_1__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5422:1: ( ( rule__Reference__Group_1__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5423:1: ( rule__Reference__Group_1__0 )?
            {
             before(grammarAccess.getReferenceAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5424:1: ( rule__Reference__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5424:2: rule__Reference__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_1__0_in_rule__Reference__Group__1__Impl10881);
                    rule__Reference__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5438:1: rule__Reference__Group_1__0 : rule__Reference__Group_1__0__Impl rule__Reference__Group_1__1 ;
    public final void rule__Reference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5442:1: ( rule__Reference__Group_1__0__Impl rule__Reference__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5443:2: rule__Reference__Group_1__0__Impl rule__Reference__Group_1__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_1__0__Impl_in_rule__Reference__Group_1__010916);
            rule__Reference__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_1__1_in_rule__Reference__Group_1__010919);
            rule__Reference__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__0"


    // $ANTLR start "rule__Reference__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5450:1: rule__Reference__Group_1__0__Impl : ( '.' ) ;
    public final void rule__Reference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5454:1: ( ( '.' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5455:1: ( '.' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5455:1: ( '.' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5456:1: '.'
            {
             before(grammarAccess.getReferenceAccess().getFullStopKeyword_1_0()); 
            match(input,47,FOLLOW_47_in_rule__Reference__Group_1__0__Impl10947); 
             after(grammarAccess.getReferenceAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__0__Impl"


    // $ANTLR start "rule__Reference__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5469:1: rule__Reference__Group_1__1 : rule__Reference__Group_1__1__Impl ;
    public final void rule__Reference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5473:1: ( rule__Reference__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5474:2: rule__Reference__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_1__1__Impl_in_rule__Reference__Group_1__110978);
            rule__Reference__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__1"


    // $ANTLR start "rule__Reference__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5480:1: rule__Reference__Group_1__1__Impl : ( ( rule__Reference__NativeFunctionAssignment_1_1 ) ) ;
    public final void rule__Reference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5484:1: ( ( ( rule__Reference__NativeFunctionAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5485:1: ( ( rule__Reference__NativeFunctionAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5485:1: ( ( rule__Reference__NativeFunctionAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5486:1: ( rule__Reference__NativeFunctionAssignment_1_1 )
            {
             before(grammarAccess.getReferenceAccess().getNativeFunctionAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5487:1: ( rule__Reference__NativeFunctionAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5487:2: rule__Reference__NativeFunctionAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Reference__NativeFunctionAssignment_1_1_in_rule__Reference__Group_1__1__Impl11005);
            rule__Reference__NativeFunctionAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNativeFunctionAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_1__1__Impl"


    // $ANTLR start "rule__ContextRef__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5501:1: rule__ContextRef__Group__0 : rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1 ;
    public final void rule__ContextRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5505:1: ( rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5506:2: rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__0__Impl_in_rule__ContextRef__Group__011039);
            rule__ContextRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextRef__Group__1_in_rule__ContextRef__Group__011042);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5513:1: rule__ContextRef__Group__0__Impl : ( 'this' ) ;
    public final void rule__ContextRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5517:1: ( ( 'this' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5518:1: ( 'this' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5518:1: ( 'this' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5519:1: 'this'
            {
             before(grammarAccess.getContextRefAccess().getThisKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__ContextRef__Group__0__Impl11070); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5532:1: rule__ContextRef__Group__1 : rule__ContextRef__Group__1__Impl ;
    public final void rule__ContextRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5536:1: ( rule__ContextRef__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5537:2: rule__ContextRef__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__1__Impl_in_rule__ContextRef__Group__111101);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5543:1: rule__ContextRef__Group__1__Impl : ( ruleNodeRef ) ;
    public final void rule__ContextRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5547:1: ( ( ruleNodeRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5548:1: ( ruleNodeRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5548:1: ( ruleNodeRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5549:1: ruleNodeRef
            {
             before(grammarAccess.getContextRefAccess().getNodeRefParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleNodeRef_in_rule__ContextRef__Group__1__Impl11128);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5564:1: rule__NodeRef__Group__0 : rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 ;
    public final void rule__NodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5568:1: ( rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5569:2: rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__011161);
            rule__NodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__011164);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5576:1: rule__NodeRef__Group__0__Impl : ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) ) ;
    public final void rule__NodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5580:1: ( ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5581:1: ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5581:1: ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5582:1: ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5582:1: ( ( rule__NodeRef__NodesAssignment_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5583:1: ( rule__NodeRef__NodesAssignment_0 )
            {
             before(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5584:1: ( rule__NodeRef__NodesAssignment_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5584:2: rule__NodeRef__NodesAssignment_0
            {
            pushFollow(FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11193);
            rule__NodeRef__NodesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 

            }

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5587:1: ( ( rule__NodeRef__NodesAssignment_0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5588:1: ( rule__NodeRef__NodesAssignment_0 )*
            {
             before(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5589:1: ( rule__NodeRef__NodesAssignment_0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==49) ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==RULE_ID) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5589:2: rule__NodeRef__NodesAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11205);
            	    rule__NodeRef__NodesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5600:1: rule__NodeRef__Group__1 : rule__NodeRef__Group__1__Impl ;
    public final void rule__NodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5604:1: ( rule__NodeRef__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5605:2: rule__NodeRef__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__111238);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5611:1: rule__NodeRef__Group__1__Impl : ( ( rule__NodeRef__Group_1__0 )? ) ;
    public final void rule__NodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5615:1: ( ( ( rule__NodeRef__Group_1__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5616:1: ( ( rule__NodeRef__Group_1__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5616:1: ( ( rule__NodeRef__Group_1__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5617:1: ( rule__NodeRef__Group_1__0 )?
            {
             before(grammarAccess.getNodeRefAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5618:1: ( rule__NodeRef__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==49) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5618:2: rule__NodeRef__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__NodeRef__Group_1__0_in_rule__NodeRef__Group__1__Impl11265);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5632:1: rule__NodeRef__Group_1__0 : rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1 ;
    public final void rule__NodeRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5636:1: ( rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5637:2: rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group_1__0__Impl_in_rule__NodeRef__Group_1__011300);
            rule__NodeRef__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group_1__1_in_rule__NodeRef__Group_1__011303);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5644:1: rule__NodeRef__Group_1__0__Impl : ( '->' ) ;
    public final void rule__NodeRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5648:1: ( ( '->' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5649:1: ( '->' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5649:1: ( '->' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5650:1: '->'
            {
             before(grammarAccess.getNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0()); 
            match(input,49,FOLLOW_49_in_rule__NodeRef__Group_1__0__Impl11331); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5663:1: rule__NodeRef__Group_1__1 : rule__NodeRef__Group_1__1__Impl ;
    public final void rule__NodeRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5667:1: ( rule__NodeRef__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5668:2: rule__NodeRef__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group_1__1__Impl_in_rule__NodeRef__Group_1__111362);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5674:1: rule__NodeRef__Group_1__1__Impl : ( ( rule__NodeRef__RefAssignment_1_1 ) ) ;
    public final void rule__NodeRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5678:1: ( ( ( rule__NodeRef__RefAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5679:1: ( ( rule__NodeRef__RefAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5679:1: ( ( rule__NodeRef__RefAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5680:1: ( rule__NodeRef__RefAssignment_1_1 )
            {
             before(grammarAccess.getNodeRefAccess().getRefAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5681:1: ( rule__NodeRef__RefAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5681:2: rule__NodeRef__RefAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NodeRef__RefAssignment_1_1_in_rule__NodeRef__Group_1__1__Impl11389);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5695:1: rule__PrimaryNodeRef__Group__0 : rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1 ;
    public final void rule__PrimaryNodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5699:1: ( rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5700:2: rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__0__Impl_in_rule__PrimaryNodeRef__Group__011423);
            rule__PrimaryNodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__1_in_rule__PrimaryNodeRef__Group__011426);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5707:1: rule__PrimaryNodeRef__Group__0__Impl : ( () ) ;
    public final void rule__PrimaryNodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5711:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5712:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5712:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5713:1: ()
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5714:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5716:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5726:1: rule__PrimaryNodeRef__Group__1 : rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2 ;
    public final void rule__PrimaryNodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5730:1: ( rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5731:2: rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__1__Impl_in_rule__PrimaryNodeRef__Group__111484);
            rule__PrimaryNodeRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__2_in_rule__PrimaryNodeRef__Group__111487);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5738:1: rule__PrimaryNodeRef__Group__1__Impl : ( '->' ) ;
    public final void rule__PrimaryNodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5742:1: ( ( '->' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5743:1: ( '->' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5743:1: ( '->' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5744:1: '->'
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,49,FOLLOW_49_in_rule__PrimaryNodeRef__Group__1__Impl11515); 
             after(grammarAccess.getPrimaryNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

            }


            }

        }
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5757:1: rule__PrimaryNodeRef__Group__2 : rule__PrimaryNodeRef__Group__2__Impl ;
    public final void rule__PrimaryNodeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5761:1: ( rule__PrimaryNodeRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5762:2: rule__PrimaryNodeRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__2__Impl_in_rule__PrimaryNodeRef__Group__211546);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5768:1: rule__PrimaryNodeRef__Group__2__Impl : ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) ) ;
    public final void rule__PrimaryNodeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5772:1: ( ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5773:1: ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5773:1: ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5774:1: ( rule__PrimaryNodeRef__NodeAssignment_2 )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5775:1: ( rule__PrimaryNodeRef__NodeAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5775:2: rule__PrimaryNodeRef__NodeAssignment_2
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__NodeAssignment_2_in_rule__PrimaryNodeRef__Group__2__Impl11573);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5791:1: rule__ResourceRef__Group__0 : rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1 ;
    public final void rule__ResourceRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5795:1: ( rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5796:2: rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__0__Impl_in_rule__ResourceRef__Group__011609);
            rule__ResourceRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResourceRef__Group__1_in_rule__ResourceRef__Group__011612);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5803:1: rule__ResourceRef__Group__0__Impl : ( () ) ;
    public final void rule__ResourceRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5807:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5808:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5808:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5809:1: ()
            {
             before(grammarAccess.getResourceRefAccess().getResourceRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5810:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5812:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5822:1: rule__ResourceRef__Group__1 : rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2 ;
    public final void rule__ResourceRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5826:1: ( rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5827:2: rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__1__Impl_in_rule__ResourceRef__Group__111670);
            rule__ResourceRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResourceRef__Group__2_in_rule__ResourceRef__Group__111673);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5834:1: rule__ResourceRef__Group__1__Impl : ( 'RES' ) ;
    public final void rule__ResourceRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5838:1: ( ( 'RES' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5839:1: ( 'RES' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5839:1: ( 'RES' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5840:1: 'RES'
            {
             before(grammarAccess.getResourceRefAccess().getRESKeyword_1()); 
            match(input,50,FOLLOW_50_in_rule__ResourceRef__Group__1__Impl11701); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5853:1: rule__ResourceRef__Group__2 : rule__ResourceRef__Group__2__Impl ;
    public final void rule__ResourceRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5857:1: ( rule__ResourceRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5858:2: rule__ResourceRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__2__Impl_in_rule__ResourceRef__Group__211732);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5864:1: rule__ResourceRef__Group__2__Impl : ( ( rule__ResourceRef__ResourceAssignment_2 ) ) ;
    public final void rule__ResourceRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5868:1: ( ( ( rule__ResourceRef__ResourceAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5869:1: ( ( rule__ResourceRef__ResourceAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5869:1: ( ( rule__ResourceRef__ResourceAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5870:1: ( rule__ResourceRef__ResourceAssignment_2 )
            {
             before(grammarAccess.getResourceRefAccess().getResourceAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5871:1: ( rule__ResourceRef__ResourceAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5871:2: rule__ResourceRef__ResourceAssignment_2
            {
            pushFollow(FOLLOW_rule__ResourceRef__ResourceAssignment_2_in_rule__ResourceRef__Group__2__Impl11759);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5887:1: rule__LinkRef__Group__0 : rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1 ;
    public final void rule__LinkRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5891:1: ( rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5892:2: rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__0__Impl_in_rule__LinkRef__Group__011795);
            rule__LinkRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LinkRef__Group__1_in_rule__LinkRef__Group__011798);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5899:1: rule__LinkRef__Group__0__Impl : ( () ) ;
    public final void rule__LinkRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5903:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5904:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5904:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5905:1: ()
            {
             before(grammarAccess.getLinkRefAccess().getLinkRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5906:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5908:1: 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5918:1: rule__LinkRef__Group__1 : rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2 ;
    public final void rule__LinkRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5922:1: ( rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5923:2: rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__1__Impl_in_rule__LinkRef__Group__111856);
            rule__LinkRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LinkRef__Group__2_in_rule__LinkRef__Group__111859);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5930:1: rule__LinkRef__Group__1__Impl : ( 'LINK' ) ;
    public final void rule__LinkRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5934:1: ( ( 'LINK' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5935:1: ( 'LINK' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5935:1: ( 'LINK' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5936:1: 'LINK'
            {
             before(grammarAccess.getLinkRefAccess().getLINKKeyword_1()); 
            match(input,51,FOLLOW_51_in_rule__LinkRef__Group__1__Impl11887); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5949:1: rule__LinkRef__Group__2 : rule__LinkRef__Group__2__Impl ;
    public final void rule__LinkRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5953:1: ( rule__LinkRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5954:2: rule__LinkRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__2__Impl_in_rule__LinkRef__Group__211918);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5960:1: rule__LinkRef__Group__2__Impl : ( ( rule__LinkRef__LinkAssignment_2 ) ) ;
    public final void rule__LinkRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5964:1: ( ( ( rule__LinkRef__LinkAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5965:1: ( ( rule__LinkRef__LinkAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5965:1: ( ( rule__LinkRef__LinkAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5966:1: ( rule__LinkRef__LinkAssignment_2 )
            {
             before(grammarAccess.getLinkRefAccess().getLinkAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5967:1: ( rule__LinkRef__LinkAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5967:2: rule__LinkRef__LinkAssignment_2
            {
            pushFollow(FOLLOW_rule__LinkRef__LinkAssignment_2_in_rule__LinkRef__Group__2__Impl11945);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5984:1: rule__Mod__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Mod__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5988:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5989:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5989:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5990:1: RULE_ID
            {
             before(grammarAccess.getModAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Mod__NameAssignment_0_111986); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5999:1: rule__Mod__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Mod__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6003:1: ( ( ruleImport ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6004:1: ( ruleImport )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6004:1: ( ruleImport )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6005:1: ruleImport
            {
             before(grammarAccess.getModAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Mod__ImportsAssignment_112017);
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


    // $ANTLR start "rule__Mod__FunctionsAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6014:1: rule__Mod__FunctionsAssignment_2 : ( ruleFunction ) ;
    public final void rule__Mod__FunctionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6018:1: ( ( ruleFunction ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6019:1: ( ruleFunction )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6019:1: ( ruleFunction )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6020:1: ruleFunction
            {
             before(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleFunction_in_rule__Mod__FunctionsAssignment_212048);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__FunctionsAssignment_2"


    // $ANTLR start "rule__Mod__StatementsAssignment_3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6029:1: rule__Mod__StatementsAssignment_3 : ( ruleStatement ) ;
    public final void rule__Mod__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6033:1: ( ( ruleStatement ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6034:1: ( ruleStatement )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6034:1: ( ruleStatement )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6035:1: ruleStatement
            {
             before(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Mod__StatementsAssignment_312079);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__StatementsAssignment_3"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6045:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6049:1: ( ( RULE_STRING ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6050:1: ( RULE_STRING )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6050:1: ( RULE_STRING )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6051:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_112111); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6060:1: rule__Function__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6064:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6065:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6065:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6066:1: RULE_ID
            {
             before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Function__NameAssignment_112142); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6075:1: rule__Function__ArgsAssignment_3_0 : ( ruleArgument ) ;
    public final void rule__Function__ArgsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6079:1: ( ( ruleArgument ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6080:1: ( ruleArgument )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6080:1: ( ruleArgument )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6081:1: ruleArgument
            {
             before(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_012173);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6090:1: rule__Function__ArgsAssignment_3_1_1 : ( ruleArgument ) ;
    public final void rule__Function__ArgsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6094:1: ( ( ruleArgument ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6095:1: ( ruleArgument )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6095:1: ( ruleArgument )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6096:1: ruleArgument
            {
             before(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_1_112204);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6105:1: rule__Function__BlockAssignment_5 : ( ruleBlock ) ;
    public final void rule__Function__BlockAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6109:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6110:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6110:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6111:1: ruleBlock
            {
             before(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__Function__BlockAssignment_512235);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6120:1: rule__Argument__NameAssignment : ( RULE_ID ) ;
    public final void rule__Argument__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6124:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6125:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6125:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6126:1: RULE_ID
            {
             before(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Argument__NameAssignment12266); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6135:1: rule__Block__StatementsAssignment_2 : ( ruleStatement ) ;
    public final void rule__Block__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6139:1: ( ( ruleStatement ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6140:1: ( ruleStatement )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6140:1: ( ruleStatement )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6141:1: ruleStatement
            {
             before(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Block__StatementsAssignment_212297);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6150:1: rule__Statement__ExpressionAssignment_0_0_3 : ( ruleExpression ) ;
    public final void rule__Statement__ExpressionAssignment_0_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6154:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6155:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6155:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6156:1: ruleExpression
            {
             before(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_0_0_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Statement__ExpressionAssignment_0_0_312328);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6165:1: rule__ReturnStatement__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__ReturnStatement__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6169:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6170:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6170:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6171:1: ruleExpression
            {
             before(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ReturnStatement__ExpressionAssignment_212359);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6180:1: rule__IfStatement__IfAssignment_3 : ( ruleLogical ) ;
    public final void rule__IfStatement__IfAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6184:1: ( ( ruleLogical ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6185:1: ( ruleLogical )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6185:1: ( ruleLogical )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6186:1: ruleLogical
            {
             before(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLogical_in_rule__IfStatement__IfAssignment_312390);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6195:1: rule__IfStatement__ThenAssignment_5 : ( ruleBlock ) ;
    public final void rule__IfStatement__ThenAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6199:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6200:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6200:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6201:1: ruleBlock
            {
             before(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__IfStatement__ThenAssignment_512421);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6210:1: rule__IfStatement__ElseAssignment_6_1 : ( ruleBlock ) ;
    public final void rule__IfStatement__ElseAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6214:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6215:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6215:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6216:1: ruleBlock
            {
             before(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__IfStatement__ElseAssignment_6_112452);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6225:1: rule__WhileStatement__PredicateAssignment_3 : ( ruleLogical ) ;
    public final void rule__WhileStatement__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6229:1: ( ( ruleLogical ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6230:1: ( ruleLogical )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6230:1: ( ruleLogical )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6231:1: ruleLogical
            {
             before(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLogical_in_rule__WhileStatement__PredicateAssignment_312483);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6240:1: rule__WhileStatement__BodyAssignment_5 : ( ruleBlock ) ;
    public final void rule__WhileStatement__BodyAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6244:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6245:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6245:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6246:1: ruleBlock
            {
             before(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__WhileStatement__BodyAssignment_512514);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6255:1: rule__VariableStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VariableStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6259:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6260:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6260:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6261:1: RULE_ID
            {
             before(grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableStatement__NameAssignment_212545); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6270:1: rule__VariableStatement__ExpressionAssignment_3_1 : ( ruleExpression ) ;
    public final void rule__VariableStatement__ExpressionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6274:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6275:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6275:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6276:1: ruleExpression
            {
             before(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableStatement__ExpressionAssignment_3_112576);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6285:1: rule__AssignmentStatement__VarAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AssignmentStatement__VarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6289:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6290:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6290:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6291:1: ( RULE_ID )
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6292:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6293:1: RULE_ID
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AssignmentStatement__VarAssignment_112611); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6304:1: rule__AssignmentStatement__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__AssignmentStatement__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6308:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6309:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6309:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6310:1: ruleExpression
            {
             before(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__AssignmentStatement__ExpressionAssignment_312646);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6319:1: rule__ReferenceAssignmentStatement__RefAssignment_1 : ( ruleContextRef ) ;
    public final void rule__ReferenceAssignmentStatement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6323:1: ( ( ruleContextRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6324:1: ( ruleContextRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6324:1: ( ruleContextRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6325:1: ruleContextRef
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefContextRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleContextRef_in_rule__ReferenceAssignmentStatement__RefAssignment_112677);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6334:1: rule__ReferenceAssignmentStatement__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__ReferenceAssignmentStatement__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6338:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6339:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6339:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6340:1: ruleExpression
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ReferenceAssignmentStatement__ExpressionAssignment_312708);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6349:1: rule__Logical__RightAssignment_1_1 : ( ruleEquality ) ;
    public final void rule__Logical__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6353:1: ( ( ruleEquality ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6354:1: ( ruleEquality )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6354:1: ( ruleEquality )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6355:1: ruleEquality
            {
             before(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEquality_in_rule__Logical__RightAssignment_1_112739);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6364:1: rule__Equality__RightAssignment_1_1 : ( ruleComparison ) ;
    public final void rule__Equality__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6368:1: ( ( ruleComparison ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6369:1: ( ruleComparison )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6369:1: ( ruleComparison )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6370:1: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleComparison_in_rule__Equality__RightAssignment_1_112770);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6379:1: rule__Comparison__RightAssignment_1_1 : ( ruleAddition ) ;
    public final void rule__Comparison__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6383:1: ( ( ruleAddition ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6384:1: ( ruleAddition )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6384:1: ( ruleAddition )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6385:1: ruleAddition
            {
             before(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_112801);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6394:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6398:1: ( ( ruleMultiplication ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6399:1: ( ruleMultiplication )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6399:1: ( ruleMultiplication )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6400:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_112832);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6409:1: rule__Multiplication__RightAssignment_1_1 : ( ruleUnary ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6413:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6414:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6414:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6415:1: ruleUnary
            {
             before(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Multiplication__RightAssignment_1_112863);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6424:1: rule__Unary__OpAssignment_1_0_0_1 : ( ( '!' ) ) ;
    public final void rule__Unary__OpAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6428:1: ( ( ( '!' ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6429:1: ( ( '!' ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6429:1: ( ( '!' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6430:1: ( '!' )
            {
             before(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6431:1: ( '!' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6432:1: '!'
            {
             before(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 
            match(input,52,FOLLOW_52_in_rule__Unary__OpAssignment_1_0_0_112899); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6447:1: rule__Unary__OpAssignment_1_0_1_1 : ( ruleUnaryOperator ) ;
    public final void rule__Unary__OpAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6451:1: ( ( ruleUnaryOperator ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6452:1: ( ruleUnaryOperator )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6452:1: ( ruleUnaryOperator )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6453:1: ruleUnaryOperator
            {
             before(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__Unary__OpAssignment_1_0_1_112938);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6462:1: rule__Unary__RightAssignment_1_1 : ( ruleUnary ) ;
    public final void rule__Unary__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6466:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6467:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6467:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6468:1: ruleUnary
            {
             before(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Unary__RightAssignment_1_112969);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6477:1: rule__Literal__ValueAssignment_0_1 : ( RULE_NUMBER ) ;
    public final void rule__Literal__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6481:1: ( ( RULE_NUMBER ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6482:1: ( RULE_NUMBER )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6482:1: ( RULE_NUMBER )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6483:1: RULE_NUMBER
            {
             before(grammarAccess.getLiteralAccess().getValueNUMBERTerminalRuleCall_0_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__Literal__ValueAssignment_0_113000); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6492:1: rule__Literal__ConditionAssignment_1_1_0 : ( ( 'true' ) ) ;
    public final void rule__Literal__ConditionAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6496:1: ( ( ( 'true' ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6497:1: ( ( 'true' ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6497:1: ( ( 'true' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6498:1: ( 'true' )
            {
             before(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6499:1: ( 'true' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6500:1: 'true'
            {
             before(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 
            match(input,53,FOLLOW_53_in_rule__Literal__ConditionAssignment_1_1_013036); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6515:1: rule__FunctionCall__FuncAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__FunctionCall__FuncAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6519:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6520:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6520:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6521:1: ( RULE_ID )
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6522:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6523:1: RULE_ID
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FunctionCall__FuncAssignment_113079); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6534:1: rule__FunctionCall__ArgsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6538:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6539:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6539:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6540:1: ruleExpression
            {
             before(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_013114);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6549:1: rule__FunctionCall__ArgsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6553:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6554:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6554:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6555:1: ruleExpression
            {
             before(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_1_113145);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6564:1: rule__VarOrArgumentCall__CallAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VarOrArgumentCall__CallAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6568:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6569:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6569:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6570:1: ( RULE_ID )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6571:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6572:1: RULE_ID
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VarOrArgumentCall__CallAssignment_113180); 
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


    // $ANTLR start "rule__Reference__NativeFunctionAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6583:1: rule__Reference__NativeFunctionAssignment_1_1 : ( ruleNativeFunction ) ;
    public final void rule__Reference__NativeFunctionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6587:1: ( ( ruleNativeFunction ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6588:1: ( ruleNativeFunction )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6588:1: ( ruleNativeFunction )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6589:1: ruleNativeFunction
            {
             before(grammarAccess.getReferenceAccess().getNativeFunctionNativeFunctionEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleNativeFunction_in_rule__Reference__NativeFunctionAssignment_1_113215);
            ruleNativeFunction();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getNativeFunctionNativeFunctionEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__NativeFunctionAssignment_1_1"


    // $ANTLR start "rule__NodeRef__NodesAssignment_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6598:1: rule__NodeRef__NodesAssignment_0 : ( rulePrimaryNodeRef ) ;
    public final void rule__NodeRef__NodesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6602:1: ( ( rulePrimaryNodeRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6603:1: ( rulePrimaryNodeRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6603:1: ( rulePrimaryNodeRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6604:1: rulePrimaryNodeRef
            {
             before(grammarAccess.getNodeRefAccess().getNodesPrimaryNodeRefParserRuleCall_0_0()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_rule__NodeRef__NodesAssignment_013246);
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6613:1: rule__NodeRef__RefAssignment_1_1 : ( ( rule__NodeRef__RefAlternatives_1_1_0 ) ) ;
    public final void rule__NodeRef__RefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6617:1: ( ( ( rule__NodeRef__RefAlternatives_1_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6618:1: ( ( rule__NodeRef__RefAlternatives_1_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6618:1: ( ( rule__NodeRef__RefAlternatives_1_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6619:1: ( rule__NodeRef__RefAlternatives_1_1_0 )
            {
             before(grammarAccess.getNodeRefAccess().getRefAlternatives_1_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6620:1: ( rule__NodeRef__RefAlternatives_1_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6620:2: rule__NodeRef__RefAlternatives_1_1_0
            {
            pushFollow(FOLLOW_rule__NodeRef__RefAlternatives_1_1_0_in_rule__NodeRef__RefAssignment_1_113277);
            rule__NodeRef__RefAlternatives_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getRefAlternatives_1_1_0()); 

            }


            }

        }
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6629:1: rule__PrimaryNodeRef__NodeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__PrimaryNodeRef__NodeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6633:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6634:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6634:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6635:1: ( RULE_ID )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6636:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6637:1: RULE_ID
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryNodeRef__NodeAssignment_213314); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6648:1: rule__ResourceRef__ResourceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ResourceRef__ResourceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6652:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6653:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6653:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6654:1: ( RULE_ID )
            {
             before(grammarAccess.getResourceRefAccess().getResourceResourceCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6655:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6656:1: RULE_ID
            {
             before(grammarAccess.getResourceRefAccess().getResourceResourceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResourceRef__ResourceAssignment_213353); 
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
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6667:1: rule__LinkRef__LinkAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LinkRef__LinkAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6671:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6672:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6672:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6673:1: ( RULE_ID )
            {
             before(grammarAccess.getLinkRefAccess().getLinkLinkCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6674:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6675:1: RULE_ID
            {
             before(grammarAccess.getLinkRefAccess().getLinkLinkIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LinkRef__LinkAssignment_213392); 
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


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\20\uffff";
    static final String DFA2_eofS =
        "\20\uffff";
    static final String DFA2_minS =
        "\1\4\1\uffff\1\14\1\61\3\uffff\1\4\1\14\1\4\1\uffff\1\14\2\4\2\14";
    static final String DFA2_maxS =
        "\1\65\1\uffff\1\56\1\61\3\uffff\1\4\1\61\1\63\1\uffff\1\61\2\4\2"+
        "\57";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\2\3\uffff\1\3\5\uffff";
    static final String DFA2_specialS =
        "\20\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\2\1\uffff\1\4\5\uffff\3\4\11\uffff\1\4\5\uffff\1\5\3\uffff"+
            "\1\1\15\uffff\1\3\3\uffff\2\4",
            "",
            "\2\4\12\uffff\1\4\4\uffff\1\4\5\uffff\1\6\13\4",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\2\4\17\uffff\1\4\5\uffff\1\12\14\4\1\uffff\1\11",
            "\1\13\55\uffff\1\14\1\15",
            "",
            "\2\4\17\uffff\1\4\5\uffff\1\12\14\4\1\uffff\1\11",
            "\1\16",
            "\1\17",
            "\2\4\17\uffff\1\4\5\uffff\1\12\14\4",
            "\2\4\17\uffff\1\4\5\uffff\1\12\14\4"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "989:1: rule__Statement__Alternatives_0_0 : ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) );";
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
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_entryRuleContextRef1626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextRef1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__0_in_ruleContextRef1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef1686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryNodeRef1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__0_in_rulePrimaryNodeRef1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_entryRuleResourceRef1806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceRef1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__0_in_ruleResourceRef1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_entryRuleLinkRef1866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkRef1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__0_in_ruleLinkRef1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeFunction__Alternatives_in_ruleNativeFunction1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__0_in_rule__Statement__Alternatives1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_rule__Statement__Alternatives1990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_rule__Statement__Alternatives2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__Statement__Alternatives2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_rule__Statement__Alternatives_0_02056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_rule__Statement__Alternatives_0_02073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_rule__Statement__Alternatives_0_02090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__ExpressionAssignment_0_0_3_in_rule__Statement__Alternatives_0_02107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_rule__Statement__Alternatives_0_02125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__0_in_rule__Logical__Alternatives_1_02157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__0_in_rule__Logical__Alternatives_1_02175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__0_in_rule__Equality__Alternatives_1_02208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__0_in_rule__Equality__Alternatives_1_02226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__0_in_rule__Comparison__Alternatives_1_02259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__0_in_rule__Comparison__Alternatives_1_02277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__0_in_rule__Comparison__Alternatives_1_02295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__0_in_rule__Comparison__Alternatives_1_02313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_02346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_02364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_02397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_02415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__0_in_rule__Multiplication__Alternatives_1_02433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Unary__Alternatives2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__0_in_rule__Unary__Alternatives2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__0_in_rule__Unary__Alternatives_1_02516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__0_in_rule__Unary__Alternatives_1_02534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__UnaryOperator__Alternatives2568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__UnaryOperator__Alternatives2588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__PrimaryExpression__Alternatives2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__PrimaryExpression__Alternatives2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rule__PrimaryExpression__Alternatives2656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_rule__PrimaryExpression__Alternatives2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__0_in_rule__Literal__Alternatives2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__0_in_rule__Literal__Alternatives2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__ConditionAssignment_1_1_0_in_rule__Literal__Alternatives_1_12773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Literal__Alternatives_1_12792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_rule__NodeRef__RefAlternatives_1_1_02826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_rule__NodeRef__RefAlternatives_1_1_02843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NativeFunction__Alternatives2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NativeFunction__Alternatives2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NativeFunction__Alternatives2918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__NativeFunction__Alternatives2939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__NativeFunction__Alternatives2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__NativeFunction__Alternatives2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group__0__Impl_in_rule__Mod__Group__03014 = new BitSet(new long[]{0x00310006C9C07050L});
    public static final BitSet FOLLOW_rule__Mod__Group__1_in_rule__Mod__Group__03017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__0_in_rule__Mod__Group__0__Impl3044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group__1__Impl_in_rule__Mod__Group__13075 = new BitSet(new long[]{0x00310006C9C07050L});
    public static final BitSet FOLLOW_rule__Mod__Group__2_in_rule__Mod__Group__13078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__ImportsAssignment_1_in_rule__Mod__Group__1__Impl3105 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__Mod__Group__2__Impl_in_rule__Mod__Group__23136 = new BitSet(new long[]{0x00310006C9C07050L});
    public static final BitSet FOLLOW_rule__Mod__Group__3_in_rule__Mod__Group__23139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__FunctionsAssignment_2_in_rule__Mod__Group__2__Impl3166 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Mod__Group__3__Impl_in_rule__Mod__Group__33197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__StatementsAssignment_3_in_rule__Mod__Group__3__Impl3224 = new BitSet(new long[]{0x00310006C9007052L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__0__Impl_in_rule__Mod__Group_0__03263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__1_in_rule__Mod__Group_0__03266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Mod__Group_0__0__Impl3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__1__Impl_in_rule__Mod__Group_0__13325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__NameAssignment_0_1_in_rule__Mod__Group_0__1__Impl3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03387 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Import__Group__0__Impl3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl3476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__03510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Function__Group__1_in_rule__Function__Group__03513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Function__Group__0__Impl3541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__13572 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Function__Group__2_in_rule__Function__Group__13575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__23632 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Function__Group__3_in_rule__Function__Group__23635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Function__Group__2__Impl3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__33694 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Function__Group__4_in_rule__Function__Group__33697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__0_in_rule__Function__Group__3__Impl3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__4__Impl_in_rule__Function__Group__43755 = new BitSet(new long[]{0x00310006C9007050L});
    public static final BitSet FOLLOW_rule__Function__Group__5_in_rule__Function__Group__43758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Function__Group__4__Impl3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__5__Impl_in_rule__Function__Group__53817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__BlockAssignment_5_in_rule__Function__Group__5__Impl3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__0__Impl_in_rule__Function__Group_3__03886 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Function__Group_3__1_in_rule__Function__Group_3__03889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__ArgsAssignment_3_0_in_rule__Function__Group_3__0__Impl3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__1__Impl_in_rule__Function__Group_3__13946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__0_in_rule__Function__Group_3__1__Impl3973 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__0__Impl_in_rule__Function__Group_3_1__04008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__1_in_rule__Function__Group_3_1__04011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Function__Group_3_1__0__Impl4039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__1__Impl_in_rule__Function__Group_3_1__14070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__ArgsAssignment_3_1_1_in_rule__Function__Group_3_1__1__Impl4097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__04131 = new BitSet(new long[]{0x00310006C9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__1_in_rule__Block__Group__04134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__14192 = new BitSet(new long[]{0x00310006D9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__2_in_rule__Block__Group__14195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Block__Group__1__Impl4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__24254 = new BitSet(new long[]{0x00310006D9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__3_in_rule__Block__Group__24257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__StatementsAssignment_2_in_rule__Block__Group__2__Impl4284 = new BitSet(new long[]{0x00310006C9007052L});
    public static final BitSet FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__34315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Block__Group__3__Impl4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__0__Impl_in_rule__Statement__Group_0__04382 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__1_in_rule__Statement__Group_0__04385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Alternatives_0_0_in_rule__Statement__Group_0__0__Impl4412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__1__Impl_in_rule__Statement__Group_0__14442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Statement__Group_0__1__Impl4470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__0__Impl_in_rule__ReturnStatement__Group__04505 = new BitSet(new long[]{0x0031000441007050L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__1_in_rule__ReturnStatement__Group__04508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__1__Impl_in_rule__ReturnStatement__Group__14566 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__2_in_rule__ReturnStatement__Group__14569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ReturnStatement__Group__1__Impl4597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__2__Impl_in_rule__ReturnStatement__Group__24628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__ExpressionAssignment_2_in_rule__ReturnStatement__Group__2__Impl4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__04692 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__04695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__14753 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__14756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__IfStatement__Group__1__Impl4784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__24815 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__24818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__IfStatement__Group__2__Impl4846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__34877 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__34880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__IfAssignment_3_in_rule__IfStatement__Group__3__Impl4907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__44937 = new BitSet(new long[]{0x00310006C9007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__5_in_rule__IfStatement__Group__44940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__IfStatement__Group__4__Impl4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__5__Impl_in_rule__IfStatement__Group__54999 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__6_in_rule__IfStatement__Group__55002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__ThenAssignment_5_in_rule__IfStatement__Group__5__Impl5029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__6__Impl_in_rule__IfStatement__Group__65059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__0_in_rule__IfStatement__Group__6__Impl5086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__0__Impl_in_rule__IfStatement__Group_6__05131 = new BitSet(new long[]{0x00310006C9007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__1_in_rule__IfStatement__Group_6__05134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__IfStatement__Group_6__0__Impl5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__1__Impl_in_rule__IfStatement__Group_6__15193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__ElseAssignment_6_1_in_rule__IfStatement__Group_6__1__Impl5220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__0__Impl_in_rule__WhileStatement__Group__05254 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__1_in_rule__WhileStatement__Group__05257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__1__Impl_in_rule__WhileStatement__Group__15315 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__2_in_rule__WhileStatement__Group__15318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__WhileStatement__Group__1__Impl5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__2__Impl_in_rule__WhileStatement__Group__25377 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__3_in_rule__WhileStatement__Group__25380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__WhileStatement__Group__2__Impl5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__3__Impl_in_rule__WhileStatement__Group__35439 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__4_in_rule__WhileStatement__Group__35442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__PredicateAssignment_3_in_rule__WhileStatement__Group__3__Impl5469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__4__Impl_in_rule__WhileStatement__Group__45499 = new BitSet(new long[]{0x00310006C9007050L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__5_in_rule__WhileStatement__Group__45502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__WhileStatement__Group__4__Impl5530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__5__Impl_in_rule__WhileStatement__Group__55561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__BodyAssignment_5_in_rule__WhileStatement__Group__5__Impl5588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__0__Impl_in_rule__VariableStatement__Group__05630 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__1_in_rule__VariableStatement__Group__05633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__1__Impl_in_rule__VariableStatement__Group__15691 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__2_in_rule__VariableStatement__Group__15694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__VariableStatement__Group__1__Impl5722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__2__Impl_in_rule__VariableStatement__Group__25753 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__3_in_rule__VariableStatement__Group__25756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__NameAssignment_2_in_rule__VariableStatement__Group__2__Impl5783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__3__Impl_in_rule__VariableStatement__Group__35813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__0_in_rule__VariableStatement__Group__3__Impl5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__0__Impl_in_rule__VariableStatement__Group_3__05879 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__1_in_rule__VariableStatement__Group_3__05882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__VariableStatement__Group_3__0__Impl5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__1__Impl_in_rule__VariableStatement__Group_3__15941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__ExpressionAssignment_3_1_in_rule__VariableStatement__Group_3__1__Impl5968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__0__Impl_in_rule__AssignmentStatement__Group__06002 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__1_in_rule__AssignmentStatement__Group__06005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__1__Impl_in_rule__AssignmentStatement__Group__16063 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__2_in_rule__AssignmentStatement__Group__16066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__VarAssignment_1_in_rule__AssignmentStatement__Group__1__Impl6093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__2__Impl_in_rule__AssignmentStatement__Group__26123 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__3_in_rule__AssignmentStatement__Group__26126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AssignmentStatement__Group__2__Impl6154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__3__Impl_in_rule__AssignmentStatement__Group__36185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__ExpressionAssignment_3_in_rule__AssignmentStatement__Group__3__Impl6212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__0__Impl_in_rule__ReferenceAssignmentStatement__Group__06250 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__1_in_rule__ReferenceAssignmentStatement__Group__06253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__1__Impl_in_rule__ReferenceAssignmentStatement__Group__16311 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__2_in_rule__ReferenceAssignmentStatement__Group__16314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__RefAssignment_1_in_rule__ReferenceAssignmentStatement__Group__1__Impl6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__2__Impl_in_rule__ReferenceAssignmentStatement__Group__26371 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__3_in_rule__ReferenceAssignmentStatement__Group__26374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ReferenceAssignmentStatement__Group__2__Impl6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__3__Impl_in_rule__ReferenceAssignmentStatement__Group__36433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__ExpressionAssignment_3_in_rule__ReferenceAssignmentStatement__Group__3__Impl6460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group__0__Impl_in_rule__Logical__Group__06498 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group__1_in_rule__Logical__Group__06501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_rule__Logical__Group__0__Impl6528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group__1__Impl_in_rule__Logical__Group__16557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__0_in_rule__Logical__Group__1__Impl6584 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__0__Impl_in_rule__Logical__Group_1__06619 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__1_in_rule__Logical__Group_1__06622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Alternatives_1_0_in_rule__Logical__Group_1__0__Impl6649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__1__Impl_in_rule__Logical__Group_1__16679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__RightAssignment_1_1_in_rule__Logical__Group_1__1__Impl6706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__0__Impl_in_rule__Logical__Group_1_0_0__06740 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__1_in_rule__Logical__Group_1_0_0__06743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__1__Impl_in_rule__Logical__Group_1_0_0__16801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Logical__Group_1_0_0__1__Impl6829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__0__Impl_in_rule__Logical__Group_1_0_1__06864 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__1_in_rule__Logical__Group_1_0_1__06867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__1__Impl_in_rule__Logical__Group_1_0_1__16925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Logical__Group_1_0_1__1__Impl6953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group__0__Impl_in_rule__Equality__Group__06988 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group__1_in_rule__Equality__Group__06991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Equality__Group__0__Impl7018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group__1__Impl_in_rule__Equality__Group__17047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__0_in_rule__Equality__Group__1__Impl7074 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__0__Impl_in_rule__Equality__Group_1__07109 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__1_in_rule__Equality__Group_1__07112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Alternatives_1_0_in_rule__Equality__Group_1__0__Impl7139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__1__Impl_in_rule__Equality__Group_1__17169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__RightAssignment_1_1_in_rule__Equality__Group_1__1__Impl7196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__0__Impl_in_rule__Equality__Group_1_0_0__07230 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__1_in_rule__Equality__Group_1_0_0__07233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__1__Impl_in_rule__Equality__Group_1_0_0__17291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Equality__Group_1_0_0__1__Impl7319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__0__Impl_in_rule__Equality__Group_1_0_1__07354 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__1_in_rule__Equality__Group_1_0_1__07357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__1__Impl_in_rule__Equality__Group_1_0_1__17415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Equality__Group_1_0_1__1__Impl7443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__07478 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__07481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl7508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__17537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl7564 = new BitSet(new long[]{0x00000F0000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__07599 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__07602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Alternatives_1_0_in_rule__Comparison__Group_1__0__Impl7629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__17659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl7686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__0__Impl_in_rule__Comparison__Group_1_0_0__07720 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__1_in_rule__Comparison__Group_1_0_0__07723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__1__Impl_in_rule__Comparison__Group_1_0_0__17781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Comparison__Group_1_0_0__1__Impl7809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__0__Impl_in_rule__Comparison__Group_1_0_1__07844 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__1_in_rule__Comparison__Group_1_0_1__07847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__1__Impl_in_rule__Comparison__Group_1_0_1__17905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Comparison__Group_1_0_1__1__Impl7933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__0__Impl_in_rule__Comparison__Group_1_0_2__07968 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__1_in_rule__Comparison__Group_1_0_2__07971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__1__Impl_in_rule__Comparison__Group_1_0_2__18029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Comparison__Group_1_0_2__1__Impl8057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__0__Impl_in_rule__Comparison__Group_1_0_3__08092 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__1_in_rule__Comparison__Group_1_0_3__08095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__1__Impl_in_rule__Comparison__Group_1_0_3__18153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Comparison__Group_1_0_3__1__Impl8181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__08216 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__08219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl8246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__18275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl8302 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__08337 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__08340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl8367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__18397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl8424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__08458 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__08461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__18519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Addition__Group_1_0_0__1__Impl8547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__08582 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__08585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__18643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Addition__Group_1_0_1__1__Impl8671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__08706 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__08709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Multiplication__Group__0__Impl8736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__18765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl8792 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__08827 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__08830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__0__Impl8857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__18887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl8914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__0__Impl_in_rule__Multiplication__Group_1_0_0__08948 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__08951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__1__Impl_in_rule__Multiplication__Group_1_0_0__19009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Multiplication__Group_1_0_0__1__Impl9037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__0__Impl_in_rule__Multiplication__Group_1_0_1__09072 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__09075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__1__Impl_in_rule__Multiplication__Group_1_0_1__19133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Multiplication__Group_1_0_1__1__Impl9161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__0__Impl_in_rule__Multiplication__Group_1_0_2__09196 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__1_in_rule__Multiplication__Group_1_0_2__09199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__1__Impl_in_rule__Multiplication__Group_1_0_2__19257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Multiplication__Group_1_0_2__1__Impl9285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__0__Impl_in_rule__Unary__Group_1__09320 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__1_in_rule__Unary__Group_1__09323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Alternatives_1_0_in_rule__Unary__Group_1__0__Impl9350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__1__Impl_in_rule__Unary__Group_1__19380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__RightAssignment_1_1_in_rule__Unary__Group_1__1__Impl9407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__0__Impl_in_rule__Unary__Group_1_0_0__09441 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__1_in_rule__Unary__Group_1_0_0__09444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__1__Impl_in_rule__Unary__Group_1_0_0__19502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__OpAssignment_1_0_0_1_in_rule__Unary__Group_1_0_0__1__Impl9529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__0__Impl_in_rule__Unary__Group_1_0_1__09563 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__1_in_rule__Unary__Group_1_0_1__09566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__1__Impl_in_rule__Unary__Group_1_0_1__19624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__OpAssignment_1_0_1_1_in_rule__Unary__Group_1_0_1__1__Impl9651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__0__Impl_in_rule__Literal__Group_0__09685 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__1_in_rule__Literal__Group_0__09688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__1__Impl_in_rule__Literal__Group_0__19746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__ValueAssignment_0_1_in_rule__Literal__Group_0__1__Impl9773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__0__Impl_in_rule__Literal__Group_1__09807 = new BitSet(new long[]{0x0020000000004040L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__1_in_rule__Literal__Group_1__09810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__1__Impl_in_rule__Literal__Group_1__19868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_1_1_in_rule__Literal__Group_1__1__Impl9895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__09929 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__09932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ParenthesizedExpression__Group__0__Impl9960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__19991 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__19994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__Group__1__Impl10021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__210050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ParenthesizedExpression__Group__2__Impl10078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__0__Impl_in_rule__FunctionCall__Group__010115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__1_in_rule__FunctionCall__Group__010118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__1__Impl_in_rule__FunctionCall__Group__110176 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__2_in_rule__FunctionCall__Group__110179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__FuncAssignment_1_in_rule__FunctionCall__Group__1__Impl10206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__2__Impl_in_rule__FunctionCall__Group__210236 = new BitSet(new long[]{0x0031000003007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__3_in_rule__FunctionCall__Group__210239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__FunctionCall__Group__2__Impl10267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__3__Impl_in_rule__FunctionCall__Group__310298 = new BitSet(new long[]{0x0031000003007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__4_in_rule__FunctionCall__Group__310301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__0_in_rule__FunctionCall__Group__3__Impl10328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__4__Impl_in_rule__FunctionCall__Group__410359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__FunctionCall__Group__4__Impl10387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__0__Impl_in_rule__FunctionCall__Group_3__010428 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__1_in_rule__FunctionCall__Group_3__010431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__ArgsAssignment_3_0_in_rule__FunctionCall__Group_3__0__Impl10458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__1__Impl_in_rule__FunctionCall__Group_3__110488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__0_in_rule__FunctionCall__Group_3__1__Impl10515 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__0__Impl_in_rule__FunctionCall__Group_3_1__010550 = new BitSet(new long[]{0x0031000001007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__1_in_rule__FunctionCall__Group_3_1__010553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FunctionCall__Group_3_1__0__Impl10581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__1__Impl_in_rule__FunctionCall__Group_3_1__110612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__ArgsAssignment_3_1_1_in_rule__FunctionCall__Group_3_1__1__Impl10639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__0__Impl_in_rule__VarOrArgumentCall__Group__010673 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__1_in_rule__VarOrArgumentCall__Group__010676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__1__Impl_in_rule__VarOrArgumentCall__Group__110734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__CallAssignment_1_in_rule__VarOrArgumentCall__Group__1__Impl10761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__010795 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__010798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_rule__Reference__Group__0__Impl10825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__110854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_1__0_in_rule__Reference__Group__1__Impl10881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_1__0__Impl_in_rule__Reference__Group_1__010916 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_rule__Reference__Group_1__1_in_rule__Reference__Group_1__010919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__Reference__Group_1__0__Impl10947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_1__1__Impl_in_rule__Reference__Group_1__110978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__NativeFunctionAssignment_1_1_in_rule__Reference__Group_1__1__Impl11005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__0__Impl_in_rule__ContextRef__Group__011039 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__1_in_rule__ContextRef__Group__011042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__ContextRef__Group__0__Impl11070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__1__Impl_in_rule__ContextRef__Group__111101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rule__ContextRef__Group__1__Impl11128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__011161 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__011164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11193 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11205 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__111238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__0_in_rule__NodeRef__Group__1__Impl11265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__0__Impl_in_rule__NodeRef__Group_1__011300 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__1_in_rule__NodeRef__Group_1__011303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__NodeRef__Group_1__0__Impl11331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__1__Impl_in_rule__NodeRef__Group_1__111362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__RefAssignment_1_1_in_rule__NodeRef__Group_1__1__Impl11389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__0__Impl_in_rule__PrimaryNodeRef__Group__011423 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__1_in_rule__PrimaryNodeRef__Group__011426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__1__Impl_in_rule__PrimaryNodeRef__Group__111484 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__2_in_rule__PrimaryNodeRef__Group__111487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__PrimaryNodeRef__Group__1__Impl11515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__2__Impl_in_rule__PrimaryNodeRef__Group__211546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__NodeAssignment_2_in_rule__PrimaryNodeRef__Group__2__Impl11573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__0__Impl_in_rule__ResourceRef__Group__011609 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__1_in_rule__ResourceRef__Group__011612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__1__Impl_in_rule__ResourceRef__Group__111670 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__2_in_rule__ResourceRef__Group__111673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ResourceRef__Group__1__Impl11701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__2__Impl_in_rule__ResourceRef__Group__211732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__ResourceAssignment_2_in_rule__ResourceRef__Group__2__Impl11759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__0__Impl_in_rule__LinkRef__Group__011795 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__1_in_rule__LinkRef__Group__011798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__1__Impl_in_rule__LinkRef__Group__111856 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__2_in_rule__LinkRef__Group__111859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__LinkRef__Group__1__Impl11887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__2__Impl_in_rule__LinkRef__Group__211918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__LinkAssignment_2_in_rule__LinkRef__Group__2__Impl11945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Mod__NameAssignment_0_111986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Mod__ImportsAssignment_112017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rule__Mod__FunctionsAssignment_212048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Mod__StatementsAssignment_312079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_112111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Function__NameAssignment_112142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_012173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_1_112204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__Function__BlockAssignment_512235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Argument__NameAssignment12266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Block__StatementsAssignment_212297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Statement__ExpressionAssignment_0_0_312328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ReturnStatement__ExpressionAssignment_212359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_rule__IfStatement__IfAssignment_312390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__IfStatement__ThenAssignment_512421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__IfStatement__ElseAssignment_6_112452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_rule__WhileStatement__PredicateAssignment_312483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__WhileStatement__BodyAssignment_512514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableStatement__NameAssignment_212545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__VariableStatement__ExpressionAssignment_3_112576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AssignmentStatement__VarAssignment_112611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__AssignmentStatement__ExpressionAssignment_312646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_rule__ReferenceAssignmentStatement__RefAssignment_112677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ReferenceAssignmentStatement__ExpressionAssignment_312708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_rule__Logical__RightAssignment_1_112739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Equality__RightAssignment_1_112770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_112801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_112832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Multiplication__RightAssignment_1_112863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Unary__OpAssignment_1_0_0_112899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__Unary__OpAssignment_1_0_1_112938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Unary__RightAssignment_1_112969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__Literal__ValueAssignment_0_113000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__Literal__ConditionAssignment_1_1_013036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FunctionCall__FuncAssignment_113079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_013114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_1_113145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VarOrArgumentCall__CallAssignment_113180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeFunction_in_rule__Reference__NativeFunctionAssignment_1_113215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_rule__NodeRef__NodesAssignment_013246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__RefAlternatives_1_1_0_in_rule__NodeRef__RefAssignment_1_113277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryNodeRef__NodeAssignment_213314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResourceRef__ResourceAssignment_213353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LinkRef__LinkAssignment_213392 = new BitSet(new long[]{0x0000000000000002L});

}