package com.netxforge.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNetxscriptLexer extends Lexer {
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
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__33=33;
    public static final int T__15=15;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__35=35;
    public static final int T__17=17;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int RULE_NUMBER=6;
    public static final int T__38=38;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=8;
    public static final int RULE_WS=11;

    // delegates
    // delegators

    public InternalNetxscriptLexer() {;} 
    public InternalNetxscriptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalNetxscriptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:11:7: ( '-' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:11:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:12:7: ( '+' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:12:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:13:7: ( 'mod' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:13:9: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:14:7: ( 'import' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:14:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:15:7: ( 'def' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:15:9: 'def'
            {
            match("def"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:16:7: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:16:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:17:7: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:17:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:18:7: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:18:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:19:7: ( '{' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:19:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:20:7: ( '}' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:20:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:21:7: ( ';' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:21:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:22:7: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:22:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:23:7: ( '&&' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:23:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:24:7: ( '||' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:24:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:25:7: ( '==' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:25:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:26:7: ( '!=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:26:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:27:7: ( '<' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:27:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:28:7: ( '<=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:28:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:29:7: ( '>' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:29:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:30:7: ( '>=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:30:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:31:7: ( '*' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:31:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:32:7: ( '/' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:32:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:33:7: ( '%' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:33:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:34:7: ( 'NODE.' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:34:9: 'NODE.'
            {
            match("NODE."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:35:7: ( '.' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:35:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:36:7: ( '!' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:36:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:13: ( ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:15: ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )?
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:15: ( '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:16: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:27: ( '.' ( '0' .. '9' )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:28: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:32: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4802:33: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4804:14: ( ( 'true' | 'false' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4804:16: ( 'true' | 'false' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4804:16: ( 'true' | 'false' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='t') ) {
                alt4=1;
            }
            else if ( (LA4_0=='f') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4804:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4804:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4806:10: ( 'this one has been deactivated' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4806:12: 'this one has been deactivated'
            {
            match("this one has been deactivated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4808:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4808:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4808:11: ( '^' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='^') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4808:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4808:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\'') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop8:
                    do {
                        int alt8=3;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\\') ) {
                            alt8=1;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                            alt8=2;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4810:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4812:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4812:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4812:24: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4812:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:40: ( ( '\\r' )? '\\n' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:41: ( '\\r' )? '\\n'
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:41: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4814:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4816:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4816:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4816:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4818:16: ( . )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4818:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | RULE_NUMBER | RULE_BOOLEAN | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt15=35;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:166: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;
            case 28 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:178: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 29 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:191: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 30 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:200: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 31 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:208: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 32 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:220: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 33 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:236: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 34 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:252: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 35 :
                // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1:260: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\30\2\uffff\3\44\6\uffff\1\56\2\40\1\62\1\64\1\66\1\uffff\1\72"+
        "\1\uffff\1\44\1\75\2\uffff\2\44\1\40\1\uffff\2\40\4\uffff\1\44\1"+
        "\uffff\2\44\25\uffff\1\44\1\uffff\3\44\2\uffff\1\112\1\44\1\114"+
        "\4\44\1\uffff\1\44\1\uffff\1\44\1\123\3\44\3\uffff\1\123\1\127\1"+
        "\uffff";
    static final String DFA15_eofS =
        "\130\uffff";
    static final String DFA15_minS =
        "\1\0\2\uffff\1\157\1\155\1\145\6\uffff\1\75\1\46\1\174\3\75\1\uffff"+
        "\1\52\1\uffff\1\117\1\60\2\uffff\1\150\1\141\1\101\1\uffff\2\0\4"+
        "\uffff\1\144\1\uffff\1\160\1\146\25\uffff\1\104\1\uffff\1\165\1"+
        "\151\1\154\2\uffff\1\60\1\157\1\60\1\105\1\145\2\163\1\uffff\1\162"+
        "\1\uffff\1\56\1\60\1\40\1\145\1\164\3\uffff\2\60\1\uffff";
    static final String DFA15_maxS =
        "\1\uffff\2\uffff\1\157\1\155\1\145\6\uffff\1\75\1\46\1\174\3\75"+
        "\1\uffff\1\57\1\uffff\1\117\1\71\2\uffff\1\162\1\141\1\172\1\uffff"+
        "\2\uffff\4\uffff\1\144\1\uffff\1\160\1\146\25\uffff\1\104\1\uffff"+
        "\1\165\1\151\1\154\2\uffff\1\172\1\157\1\172\1\105\1\145\2\163\1"+
        "\uffff\1\162\1\uffff\1\56\1\172\1\40\1\145\1\164\3\uffff\2\172\1"+
        "\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\6\1\7\1\10\1\11\1\12\1\13\6\uffff\1\25"+
        "\1\uffff\1\27\2\uffff\2\33\3\uffff\1\36\2\uffff\1\42\1\43\1\1\1"+
        "\2\1\uffff\1\36\2\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\17\1\14\1"+
        "\15\1\16\1\20\1\32\1\22\1\21\1\24\1\23\1\25\1\40\1\41\1\26\1\27"+
        "\1\uffff\1\31\3\uffff\1\37\1\42\7\uffff\1\3\1\uffff\1\5\5\uffff"+
        "\1\30\1\34\1\35\2\uffff\1\4";
    static final String DFA15_specialS =
        "\1\2\34\uffff\1\1\1\0\71\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\40\2\37\2\40\1\37\22\40\1\37\1\17\1\35\2\40\1\24\1\15\1"+
            "\36\1\6\1\7\1\22\1\2\1\10\1\1\1\26\1\23\12\27\1\40\1\13\1\20"+
            "\1\14\1\21\2\40\15\34\1\25\14\34\3\40\1\33\1\34\1\40\3\34\1"+
            "\5\1\34\1\32\2\34\1\4\3\34\1\3\6\34\1\31\6\34\1\11\1\16\1\12"+
            "\uff82\40",
            "",
            "",
            "\1\43",
            "\1\45",
            "\1\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\63",
            "\1\65",
            "",
            "\1\70\4\uffff\1\71",
            "",
            "\1\74",
            "\12\30",
            "",
            "",
            "\1\77\11\uffff\1\76",
            "\1\100",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\0\101",
            "\0\101",
            "",
            "",
            "",
            "",
            "\1\103",
            "",
            "\1\104",
            "\1\105",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\106",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\113",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "",
            "\1\121",
            "",
            "\1\122",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\124",
            "\1\125",
            "\1\126",
            "",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | RULE_NUMBER | RULE_BOOLEAN | RULE_INT | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_30 = input.LA(1);

                        s = -1;
                        if ( ((LA15_30>='\u0000' && LA15_30<='\uFFFF')) ) {s = 65;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_29 = input.LA(1);

                        s = -1;
                        if ( ((LA15_29>='\u0000' && LA15_29<='\uFFFF')) ) {s = 65;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='-') ) {s = 1;}

                        else if ( (LA15_0=='+') ) {s = 2;}

                        else if ( (LA15_0=='m') ) {s = 3;}

                        else if ( (LA15_0=='i') ) {s = 4;}

                        else if ( (LA15_0=='d') ) {s = 5;}

                        else if ( (LA15_0=='(') ) {s = 6;}

                        else if ( (LA15_0==')') ) {s = 7;}

                        else if ( (LA15_0==',') ) {s = 8;}

                        else if ( (LA15_0=='{') ) {s = 9;}

                        else if ( (LA15_0=='}') ) {s = 10;}

                        else if ( (LA15_0==';') ) {s = 11;}

                        else if ( (LA15_0=='=') ) {s = 12;}

                        else if ( (LA15_0=='&') ) {s = 13;}

                        else if ( (LA15_0=='|') ) {s = 14;}

                        else if ( (LA15_0=='!') ) {s = 15;}

                        else if ( (LA15_0=='<') ) {s = 16;}

                        else if ( (LA15_0=='>') ) {s = 17;}

                        else if ( (LA15_0=='*') ) {s = 18;}

                        else if ( (LA15_0=='/') ) {s = 19;}

                        else if ( (LA15_0=='%') ) {s = 20;}

                        else if ( (LA15_0=='N') ) {s = 21;}

                        else if ( (LA15_0=='.') ) {s = 22;}

                        else if ( ((LA15_0>='0' && LA15_0<='9')) ) {s = 23;}

                        else if ( (LA15_0=='t') ) {s = 25;}

                        else if ( (LA15_0=='f') ) {s = 26;}

                        else if ( (LA15_0=='^') ) {s = 27;}

                        else if ( ((LA15_0>='A' && LA15_0<='M')||(LA15_0>='O' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='c')||LA15_0=='e'||(LA15_0>='g' && LA15_0<='h')||(LA15_0>='j' && LA15_0<='l')||(LA15_0>='n' && LA15_0<='s')||(LA15_0>='u' && LA15_0<='z')) ) {s = 28;}

                        else if ( (LA15_0=='\"') ) {s = 29;}

                        else if ( (LA15_0=='\'') ) {s = 30;}

                        else if ( ((LA15_0>='\t' && LA15_0<='\n')||LA15_0=='\r'||LA15_0==' ') ) {s = 31;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||(LA15_0>='#' && LA15_0<='$')||LA15_0==':'||(LA15_0>='?' && LA15_0<='@')||(LA15_0>='[' && LA15_0<=']')||LA15_0=='`'||(LA15_0>='~' && LA15_0<='\uFFFF')) ) {s = 32;}

                        else s = 24;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}