package com.netxforge.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSmiLexer extends Lexer {
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int RULE_ALPHA_CAP=10;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_IA5STRING=8;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__50=50;
    public static final int RULE_PARAMETER=9;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_NEWLINE=5;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_ASN1_ID=6;
    public static final int RULE_ALPHA=11;
    public static final int RULE_MODULE_ID=4;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_BIG_INTEGER=7;
    public static final int RULE_NUMERIC=12;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;
    public static final int RULE_SL_ASN1_COMMENT=13;

    // delegates
    // delegators

    public InternalSmiLexer() {;} 
    public InternalSmiLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSmiLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:11:7: ( 'DEFINITIONS' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:11:9: 'DEFINITIONS'
            {
            match("DEFINITIONS"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:12:7: ( '::=' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:12:9: '::='
            {
            match("::="); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:13:7: ( 'BEGIN' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:13:9: 'BEGIN'
            {
            match("BEGIN"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:14:7: ( 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:14:9: 'END'
            {
            match("END"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:15:7: ( 'IMPORTS' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:15:9: 'IMPORTS'
            {
            match("IMPORTS"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:16:7: ( ';' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:16:9: ';'
            {
            match(';'); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:17:7: ( 'FROM' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:17:9: 'FROM'
            {
            match("FROM"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:18:7: ( ',' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:18:9: ','
            {
            match(','); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:19:7: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:19:9: 'OBJECT IDENTIFIER'
            {
            match("OBJECT IDENTIFIER"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:20:7: ( '{' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:20:9: '{'
            {
            match('{'); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:21:7: ( '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:21:9: '}'
            {
            match('}'); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:22:7: ( 'MACRO' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:22:9: 'MACRO'
            {
            match("MACRO"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:23:7: ( 'TYPE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:23:9: 'TYPE'
            {
            match("TYPE"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:24:7: ( 'NOTATION' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:24:9: 'NOTATION'
            {
            match("NOTATION"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:25:7: ( 'VALUE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:25:9: 'VALUE'
            {
            match("VALUE"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:26:7: ( '\"{\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:26:9: '\"{\"'
            {
            match("\"{\""); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:27:7: ( '\"}\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:27:9: '\"}\"'
            {
            match("\"}\""); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:28:7: ( 'IMPLICIT' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:28:9: 'IMPLICIT'
            {
            match("IMPLICIT"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:29:7: ( '|' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:29:9: '|'
            {
            match('|'); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:30:7: ( '[APPLICATION' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:30:9: '[APPLICATION'
            {
            match("[APPLICATION"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:31:7: ( ']' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:31:9: ']'
            {
            match(']'); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:32:7: ( 'value' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:32:9: 'value'
            {
            match("value"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:33:7: ( '(' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:33:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:34:7: ( ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:34:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:35:7: ( 'Update' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:35:9: 'Update'
            {
            match("Update"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:36:7: ( 'IA5String' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:36:9: 'IA5String'
            {
            match("IA5String"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:37:7: ( 'empty' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:37:9: 'empty'
            {
            match("empty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:38:7: ( 'OCTET' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:38:9: 'OCTET'
            {
            match("OCTET"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:39:7: ( 'STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:39:9: 'STRING'
            {
            match("STRING"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:40:7: ( 'INTEGER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:40:9: 'INTEGER'
            {
            match("INTEGER"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:41:7: ( 'SIZE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:41:9: 'SIZE'
            {
            match("SIZE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:42:7: ( '..' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:42:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:43:7: ( 'CHOICE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:43:9: 'CHOICE'
            {
            match("CHOICE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:44:7: ( 'SEQUENCE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:44:9: 'SEQUENCE'
            {
            match("SEQUENCE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:45:7: ( 'OF' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:45:9: 'OF'
            {
            match("OF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "RULE_MODULE_ID"
    public final void mRULE_MODULE_ID() throws RecognitionException {
        try {
            int _type = RULE_MODULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3039:16: ( RULE_ALPHA_CAP ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3039:18: RULE_ALPHA_CAP ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC )
            {
            mRULE_ALPHA_CAP(); 
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3039:33: ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='-'||(LA1_1>='0' && LA1_1<='9')||(LA1_1>='A' && LA1_1<='Z')||(LA1_1>='a' && LA1_1<='z')) ) {
                        alt1=1;
                    }


                }
                else if ( (LA1_0=='-') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MODULE_ID"

    // $ANTLR start "RULE_ASN1_ID"
    public final void mRULE_ASN1_ID() throws RecognitionException {
        try {
            int _type = RULE_ASN1_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3041:14: ( RULE_ALPHA ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3041:16: RULE_ALPHA ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC )
            {
            mRULE_ALPHA(); 
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3041:27: ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='-'||(LA2_1>='0' && LA2_1<='9')||(LA2_1>='A' && LA2_1<='Z')||(LA2_1>='a' && LA2_1<='z')) ) {
                        alt2=1;
                    }


                }
                else if ( (LA2_0=='-') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ASN1_ID"

    // $ANTLR start "RULE_PARAMETER"
    public final void mRULE_PARAMETER() throws RecognitionException {
        try {
            int _type = RULE_PARAMETER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3043:16: ( '\"' RULE_MODULE_ID '\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3043:18: '\"' RULE_MODULE_ID '\"'
            {
            match('\"'); 
            mRULE_MODULE_ID(); 
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PARAMETER"

    // $ANTLR start "RULE_IA5STRING"
    public final void mRULE_IA5STRING() throws RecognitionException {
        try {
            int _type = RULE_IA5STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3045:16: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3045:18: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3045:22: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3045:23: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3045:68: ~ ( ( '\\\\' | '\"' ) )
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
            	    break loop3;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IA5STRING"

    // $ANTLR start "RULE_ALPHA"
    public final void mRULE_ALPHA() throws RecognitionException {
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3047:21: ( 'a' .. 'z' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3047:23: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ALPHA"

    // $ANTLR start "RULE_ALPHA_CAP"
    public final void mRULE_ALPHA_CAP() throws RecognitionException {
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3049:25: ( 'A' .. 'Z' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3049:27: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ALPHA_CAP"

    // $ANTLR start "RULE_NUMERIC"
    public final void mRULE_NUMERIC() throws RecognitionException {
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3051:23: ( '0' .. '9' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3051:25: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMERIC"

    // $ANTLR start "RULE_BIG_INTEGER"
    public final void mRULE_BIG_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_BIG_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3053:18: ( ( '-' )? ( '0' .. '9' )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3053:20: ( '-' )? ( '0' .. '9' )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3053:20: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3053:20: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3053:25: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3053:26: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIG_INTEGER"

    // $ANTLR start "RULE_SL_ASN1_COMMENT"
    public final void mRULE_SL_ASN1_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_ASN1_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3055:22: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3055:24: '--' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("--"); 

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3055:29: (~ ( ( '\\n' | '\\r' ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3055:29: ~ ( ( '\\n' | '\\r' ) )
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
    // $ANTLR end "RULE_SL_ASN1_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3057:9: ( ( ' ' | '\\t' )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3057:11: ( ' ' | '\\t' )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3057:11: ( ' ' | '\\t' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_NEWLINE"
    public final void mRULE_NEWLINE() throws RecognitionException {
        try {
            int _type = RULE_NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3059:14: ( ( ( '\\r' )? | '\\n' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3059:16: ( ( '\\r' )? | '\\n' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3059:16: ( ( '\\r' )? | '\\n' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n') ) {
                alt9=2;
            }
            else {
                alt9=1;}
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3059:17: ( '\\r' )?
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3059:17: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3059:17: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3059:23: '\\n'
                    {
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
    // $ANTLR end "RULE_NEWLINE"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3061:16: ( . )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3061:18: .
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
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | RULE_MODULE_ID | RULE_ASN1_ID | RULE_PARAMETER | RULE_IA5STRING | RULE_BIG_INTEGER | RULE_SL_ASN1_COMMENT | RULE_WS | RULE_NEWLINE | RULE_ANY_OTHER )
        int alt10=44;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:40: T__21
                {
                mT__21(); 

                }
                break;
            case 7 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:46: T__22
                {
                mT__22(); 

                }
                break;
            case 8 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:52: T__23
                {
                mT__23(); 

                }
                break;
            case 9 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:58: T__24
                {
                mT__24(); 

                }
                break;
            case 10 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:64: T__25
                {
                mT__25(); 

                }
                break;
            case 11 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:70: T__26
                {
                mT__26(); 

                }
                break;
            case 12 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:76: T__27
                {
                mT__27(); 

                }
                break;
            case 13 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:82: T__28
                {
                mT__28(); 

                }
                break;
            case 14 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:88: T__29
                {
                mT__29(); 

                }
                break;
            case 15 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:94: T__30
                {
                mT__30(); 

                }
                break;
            case 16 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:100: T__31
                {
                mT__31(); 

                }
                break;
            case 17 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:106: T__32
                {
                mT__32(); 

                }
                break;
            case 18 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:112: T__33
                {
                mT__33(); 

                }
                break;
            case 19 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:118: T__34
                {
                mT__34(); 

                }
                break;
            case 20 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:124: T__35
                {
                mT__35(); 

                }
                break;
            case 21 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:130: T__36
                {
                mT__36(); 

                }
                break;
            case 22 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:136: T__37
                {
                mT__37(); 

                }
                break;
            case 23 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:142: T__38
                {
                mT__38(); 

                }
                break;
            case 24 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:148: T__39
                {
                mT__39(); 

                }
                break;
            case 25 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:154: T__40
                {
                mT__40(); 

                }
                break;
            case 26 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:160: T__41
                {
                mT__41(); 

                }
                break;
            case 27 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:166: T__42
                {
                mT__42(); 

                }
                break;
            case 28 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:172: T__43
                {
                mT__43(); 

                }
                break;
            case 29 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:178: T__44
                {
                mT__44(); 

                }
                break;
            case 30 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:184: T__45
                {
                mT__45(); 

                }
                break;
            case 31 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:190: T__46
                {
                mT__46(); 

                }
                break;
            case 32 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:196: T__47
                {
                mT__47(); 

                }
                break;
            case 33 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:202: T__48
                {
                mT__48(); 

                }
                break;
            case 34 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:208: T__49
                {
                mT__49(); 

                }
                break;
            case 35 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:214: T__50
                {
                mT__50(); 

                }
                break;
            case 36 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:220: RULE_MODULE_ID
                {
                mRULE_MODULE_ID(); 

                }
                break;
            case 37 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:235: RULE_ASN1_ID
                {
                mRULE_ASN1_ID(); 

                }
                break;
            case 38 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:248: RULE_PARAMETER
                {
                mRULE_PARAMETER(); 

                }
                break;
            case 39 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:263: RULE_IA5STRING
                {
                mRULE_IA5STRING(); 

                }
                break;
            case 40 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:278: RULE_BIG_INTEGER
                {
                mRULE_BIG_INTEGER(); 

                }
                break;
            case 41 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:295: RULE_SL_ASN1_COMMENT
                {
                mRULE_SL_ASN1_COMMENT(); 

                }
                break;
            case 42 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:316: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 43 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:324: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 44 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:337: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\42\5\44\1\uffff\1\44\1\uffff\1\44\2\uffff\5\44\1\uffff\1\44\1"+
        "\uffff\1\44\2\uffff\10\44\6\uffff\1\46\2\uffff\5\46\1\uffff\1\46"+
        "\1\uffff\2\46\1\127\2\uffff\4\46\7\uffff\1\101\3\uffff\1\46\1\101"+
        "\3\46\1\uffff\1\46\3\uffff\2\46\1\151\6\46\1\uffff\4\46\4\uffff"+
        "\1\101\1\46\1\101\6\46\1\uffff\4\46\1\u0085\3\46\1\u0089\2\46\3"+
        "\uffff\1\101\1\46\1\101\1\46\1\u0091\3\46\1\u0095\4\46\1\uffff\1"+
        "\46\1\u009b\1\u009c\1\uffff\1\46\1\u009e\1\uffff\1\u009f\1\46\1"+
        "\u00a1\1\46\1\uffff\3\46\1\uffff\5\46\2\uffff\1\46\2\uffff\1\u00ac"+
        "\1\uffff\1\u00ad\1\46\1\u00af\1\46\1\u00b1\2\46\1\u00b4\1\uffff"+
        "\1\46\2\uffff\1\46\1\uffff\1\46\1\uffff\1\u00b8\1\46\1\uffff\1\u00ba"+
        "\1\u00bb\1\46\1\uffff\1\u00bd\2\uffff\1\46\1\uffff\1\u00bf\1\uffff";
    static final String DFA10_eofS =
        "\u00c0\uffff";
    static final String DFA10_minS =
        "\1\0\1\55\1\72\3\55\1\uffff\1\55\1\uffff\1\55\2\uffff\4\55\1\0\1"+
        "\uffff\1\101\1\uffff\1\55\2\uffff\3\55\1\56\4\55\6\uffff\1\106\2"+
        "\uffff\1\107\1\104\1\120\1\65\1\124\1\uffff\1\117\1\uffff\1\112"+
        "\1\124\1\55\2\uffff\1\103\1\120\1\124\1\114\2\0\1\uffff\1\0\3\uffff"+
        "\1\154\3\uffff\1\144\1\160\1\122\1\132\1\121\1\uffff\1\117\3\uffff"+
        "\2\111\1\55\1\114\1\123\1\105\1\115\2\105\1\uffff\1\122\1\105\1"+
        "\101\1\125\2\uffff\2\0\1\165\1\141\1\164\1\111\1\105\1\125\1\111"+
        "\2\116\1\uffff\1\122\1\111\1\164\1\107\1\55\1\103\1\124\1\117\1"+
        "\55\1\124\1\105\3\uffff\1\145\1\164\1\171\1\116\1\55\1\105\1\103"+
        "\1\111\1\55\1\124\1\103\1\162\1\105\1\uffff\1\124\2\55\1\uffff\1"+
        "\111\1\55\1\uffff\1\55\1\145\1\55\1\107\1\uffff\1\116\1\105\1\124"+
        "\1\uffff\1\123\1\111\1\151\1\122\1\40\2\uffff\1\117\2\uffff\1\55"+
        "\1\uffff\1\55\1\103\1\55\1\111\1\55\1\124\1\156\1\55\1\uffff\1\116"+
        "\2\uffff\1\105\1\uffff\1\117\1\uffff\1\55\1\147\1\uffff\2\55\1\116"+
        "\1\uffff\1\55\2\uffff\1\123\1\uffff\1\55\1\uffff";
    static final String DFA10_maxS =
        "\1\uffff\1\172\1\72\3\172\1\uffff\1\172\1\uffff\1\172\2\uffff\4"+
        "\172\1\uffff\1\uffff\1\101\1\uffff\1\172\2\uffff\3\172\1\56\3\172"+
        "\1\71\6\uffff\1\106\2\uffff\1\107\1\104\1\120\1\65\1\124\1\uffff"+
        "\1\117\1\uffff\1\112\1\124\1\172\2\uffff\1\103\1\120\1\124\1\114"+
        "\2\uffff\1\uffff\1\uffff\3\uffff\1\154\3\uffff\1\144\1\160\1\122"+
        "\1\132\1\121\1\uffff\1\117\3\uffff\2\111\1\172\1\117\1\123\1\105"+
        "\1\115\2\105\1\uffff\1\122\1\105\1\101\1\125\2\uffff\2\uffff\1\165"+
        "\1\141\1\164\1\111\1\105\1\125\1\111\2\116\1\uffff\1\122\1\111\1"+
        "\164\1\107\1\172\1\103\1\124\1\117\1\172\1\124\1\105\3\uffff\1\145"+
        "\1\164\1\171\1\116\1\172\1\105\1\103\1\111\1\172\1\124\1\103\1\162"+
        "\1\105\1\uffff\1\124\2\172\1\uffff\1\111\1\172\1\uffff\1\172\1\145"+
        "\1\172\1\107\1\uffff\1\116\1\105\1\124\1\uffff\1\123\1\111\1\151"+
        "\1\122\1\40\2\uffff\1\117\2\uffff\1\172\1\uffff\1\172\1\103\1\172"+
        "\1\111\1\172\1\124\1\156\1\172\1\uffff\1\116\2\uffff\1\105\1\uffff"+
        "\1\117\1\uffff\1\172\1\147\1\uffff\2\172\1\116\1\uffff\1\172\2\uffff"+
        "\1\123\1\uffff\1\172\1\uffff";
    static final String DFA10_acceptS =
        "\6\uffff\1\6\1\uffff\1\10\1\uffff\1\12\1\13\5\uffff\1\23\1\uffff"+
        "\1\25\1\uffff\1\27\1\30\10\uffff\1\50\1\52\3\53\1\54\1\uffff\1\44"+
        "\1\2\5\uffff\1\6\1\uffff\1\10\3\uffff\1\12\1\13\6\uffff\1\47\1\uffff"+
        "\1\23\1\24\1\25\1\uffff\1\45\1\27\1\30\5\uffff\1\40\1\uffff\1\51"+
        "\1\50\1\52\11\uffff\1\43\4\uffff\1\20\1\21\13\uffff\1\4\13\uffff"+
        "\1\20\1\21\1\46\15\uffff\1\7\3\uffff\1\15\2\uffff\1\46\4\uffff\1"+
        "\37\3\uffff\1\3\5\uffff\1\34\1\14\1\uffff\1\17\1\26\1\uffff\1\33"+
        "\10\uffff\1\11\1\uffff\1\31\1\35\1\uffff\1\41\1\uffff\1\5\2\uffff"+
        "\1\36\3\uffff\1\22\1\uffff\1\16\1\42\1\uffff\1\32\1\uffff\1\1";
    static final String DFA10_specialS =
        "\1\5\17\uffff\1\1\50\uffff\1\6\1\3\1\uffff\1\0\41\uffff\1\4\1\2"+
        "\140\uffff}>";
    static final String[] DFA10_transitionS = {
            "\11\44\1\40\1\43\2\44\1\41\22\44\1\40\1\44\1\20\5\44\1\25\1"+
            "\26\2\44\1\10\1\36\1\32\1\44\12\37\1\2\1\6\5\44\1\34\1\3\1\33"+
            "\1\1\1\4\1\7\2\34\1\5\3\34\1\14\1\16\1\11\3\34\1\31\1\15\1\27"+
            "\1\17\4\34\1\22\1\44\1\23\3\44\4\35\1\30\20\35\1\24\4\35\1\12"+
            "\1\21\1\13\uff82\44",
            "\1\46\2\uffff\12\46\7\uffff\4\46\1\45\25\46\6\uffff\32\46",
            "\1\47",
            "\1\46\2\uffff\12\46\7\uffff\4\46\1\50\25\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\15\46\1\51\14\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\1\53\13\46\1\52\1\54\14\46\6\uffff"+
            "\32\46",
            "",
            "\1\46\2\uffff\12\46\7\uffff\21\46\1\56\10\46\6\uffff\32\46",
            "",
            "\1\46\2\uffff\12\46\7\uffff\1\46\1\60\1\61\2\46\1\62\24\46"+
            "\6\uffff\32\46",
            "",
            "",
            "\1\46\2\uffff\12\46\7\uffff\1\65\31\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\30\46\1\66\1\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\16\46\1\67\13\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\1\70\31\46\6\uffff\32\46",
            "\101\73\32\74\40\73\1\71\1\73\1\72\uff82\73",
            "",
            "\1\76",
            "",
            "\1\101\2\uffff\12\101\7\uffff\32\101\6\uffff\1\100\31\101",
            "",
            "",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\17\46\1\104\12\46",
            "\1\101\2\uffff\12\101\7\uffff\32\101\6\uffff\14\101\1\105\15"+
            "\101",
            "\1\46\2\uffff\12\46\7\uffff\4\46\1\110\3\46\1\107\12\46\1\106"+
            "\6\46\6\uffff\32\46",
            "\1\111",
            "\1\46\2\uffff\12\46\7\uffff\7\46\1\112\22\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\101\2\uffff\12\101\7\uffff\32\101\6\uffff\32\101",
            "\1\113\2\uffff\12\114",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\116",
            "",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "",
            "\1\124",
            "",
            "\1\125",
            "\1\126",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\42\73\1\134\uffdd\73",
            "\42\73\1\135\uffdd\73",
            "",
            "\55\73\1\137\2\73\12\136\7\73\32\136\6\73\32\136\uff85\73",
            "",
            "",
            "",
            "\1\140",
            "",
            "",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "\1\146",
            "",
            "",
            "",
            "\1\147",
            "\1\150",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\153\2\uffff\1\152",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "",
            "",
            "\42\73\1\167\12\73\1\137\2\73\12\136\7\73\32\136\6\73\32\136"+
            "\uff85\73",
            "\55\73\1\137\2\73\12\136\7\73\32\136\6\73\32\136\uff85\73",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u008a",
            "\1\u008b",
            "",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\u009d",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\101\2\uffff\12\101\7\uffff\32\101\6\uffff\32\101",
            "\1\u00a0",
            "\1\101\2\uffff\12\101\7\uffff\32\101\6\uffff\32\101",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "",
            "\1\u00ab",
            "",
            "",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00ae",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00b0",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00b2",
            "\1\u00b3",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "\1\u00b5",
            "",
            "",
            "\1\u00b6",
            "",
            "\1\u00b7",
            "",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00b9",
            "",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "\1\u00bc",
            "",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            "",
            "",
            "\1\u00be",
            "",
            "\1\46\2\uffff\12\46\7\uffff\32\46\6\uffff\32\46",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | RULE_MODULE_ID | RULE_ASN1_ID | RULE_PARAMETER | RULE_IA5STRING | RULE_BIG_INTEGER | RULE_SL_ASN1_COMMENT | RULE_WS | RULE_NEWLINE | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_60 = input.LA(1);

                        s = -1;
                        if ( ((LA10_60>='0' && LA10_60<='9')||(LA10_60>='A' && LA10_60<='Z')||(LA10_60>='a' && LA10_60<='z')) ) {s = 94;}

                        else if ( (LA10_60=='-') ) {s = 95;}

                        else if ( ((LA10_60>='\u0000' && LA10_60<=',')||(LA10_60>='.' && LA10_60<='/')||(LA10_60>=':' && LA10_60<='@')||(LA10_60>='[' && LA10_60<='`')||(LA10_60>='{' && LA10_60<='\uFFFF')) ) {s = 59;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_16 = input.LA(1);

                        s = -1;
                        if ( (LA10_16=='{') ) {s = 57;}

                        else if ( (LA10_16=='}') ) {s = 58;}

                        else if ( ((LA10_16>='\u0000' && LA10_16<='@')||(LA10_16>='[' && LA10_16<='z')||LA10_16=='|'||(LA10_16>='~' && LA10_16<='\uFFFF')) ) {s = 59;}

                        else if ( ((LA10_16>='A' && LA10_16<='Z')) ) {s = 60;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_95 = input.LA(1);

                        s = -1;
                        if ( ((LA10_95>='0' && LA10_95<='9')||(LA10_95>='A' && LA10_95<='Z')||(LA10_95>='a' && LA10_95<='z')) ) {s = 94;}

                        else if ( (LA10_95=='-') ) {s = 95;}

                        else if ( ((LA10_95>='\u0000' && LA10_95<=',')||(LA10_95>='.' && LA10_95<='/')||(LA10_95>=':' && LA10_95<='@')||(LA10_95>='[' && LA10_95<='`')||(LA10_95>='{' && LA10_95<='\uFFFF')) ) {s = 59;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_58 = input.LA(1);

                        s = -1;
                        if ( (LA10_58=='\"') ) {s = 93;}

                        else if ( ((LA10_58>='\u0000' && LA10_58<='!')||(LA10_58>='#' && LA10_58<='\uFFFF')) ) {s = 59;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_94 = input.LA(1);

                        s = -1;
                        if ( ((LA10_94>='0' && LA10_94<='9')||(LA10_94>='A' && LA10_94<='Z')||(LA10_94>='a' && LA10_94<='z')) ) {s = 94;}

                        else if ( (LA10_94=='-') ) {s = 95;}

                        else if ( (LA10_94=='\"') ) {s = 119;}

                        else if ( ((LA10_94>='\u0000' && LA10_94<='!')||(LA10_94>='#' && LA10_94<=',')||(LA10_94>='.' && LA10_94<='/')||(LA10_94>=':' && LA10_94<='@')||(LA10_94>='[' && LA10_94<='`')||(LA10_94>='{' && LA10_94<='\uFFFF')) ) {s = 59;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_0 = input.LA(1);

                        s = -1;
                        if ( (LA10_0=='D') ) {s = 1;}

                        else if ( (LA10_0==':') ) {s = 2;}

                        else if ( (LA10_0=='B') ) {s = 3;}

                        else if ( (LA10_0=='E') ) {s = 4;}

                        else if ( (LA10_0=='I') ) {s = 5;}

                        else if ( (LA10_0==';') ) {s = 6;}

                        else if ( (LA10_0=='F') ) {s = 7;}

                        else if ( (LA10_0==',') ) {s = 8;}

                        else if ( (LA10_0=='O') ) {s = 9;}

                        else if ( (LA10_0=='{') ) {s = 10;}

                        else if ( (LA10_0=='}') ) {s = 11;}

                        else if ( (LA10_0=='M') ) {s = 12;}

                        else if ( (LA10_0=='T') ) {s = 13;}

                        else if ( (LA10_0=='N') ) {s = 14;}

                        else if ( (LA10_0=='V') ) {s = 15;}

                        else if ( (LA10_0=='\"') ) {s = 16;}

                        else if ( (LA10_0=='|') ) {s = 17;}

                        else if ( (LA10_0=='[') ) {s = 18;}

                        else if ( (LA10_0==']') ) {s = 19;}

                        else if ( (LA10_0=='v') ) {s = 20;}

                        else if ( (LA10_0=='(') ) {s = 21;}

                        else if ( (LA10_0==')') ) {s = 22;}

                        else if ( (LA10_0=='U') ) {s = 23;}

                        else if ( (LA10_0=='e') ) {s = 24;}

                        else if ( (LA10_0=='S') ) {s = 25;}

                        else if ( (LA10_0=='.') ) {s = 26;}

                        else if ( (LA10_0=='C') ) {s = 27;}

                        else if ( (LA10_0=='A'||(LA10_0>='G' && LA10_0<='H')||(LA10_0>='J' && LA10_0<='L')||(LA10_0>='P' && LA10_0<='R')||(LA10_0>='W' && LA10_0<='Z')) ) {s = 28;}

                        else if ( ((LA10_0>='a' && LA10_0<='d')||(LA10_0>='f' && LA10_0<='u')||(LA10_0>='w' && LA10_0<='z')) ) {s = 29;}

                        else if ( (LA10_0=='-') ) {s = 30;}

                        else if ( ((LA10_0>='0' && LA10_0<='9')) ) {s = 31;}

                        else if ( (LA10_0=='\t'||LA10_0==' ') ) {s = 32;}

                        else if ( (LA10_0=='\r') ) {s = 33;}

                        else if ( (LA10_0=='\n') ) {s = 35;}

                        else if ( ((LA10_0>='\u0000' && LA10_0<='\b')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\u001F')||LA10_0=='!'||(LA10_0>='#' && LA10_0<='\'')||(LA10_0>='*' && LA10_0<='+')||LA10_0=='/'||(LA10_0>='<' && LA10_0<='@')||LA10_0=='\\'||(LA10_0>='^' && LA10_0<='`')||(LA10_0>='~' && LA10_0<='\uFFFF')) ) {s = 36;}

                        else s = 34;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_57 = input.LA(1);

                        s = -1;
                        if ( (LA10_57=='\"') ) {s = 92;}

                        else if ( ((LA10_57>='\u0000' && LA10_57<='!')||(LA10_57>='#' && LA10_57<='\uFFFF')) ) {s = 59;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}