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
    public static final int RULE_NEWLINE=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ALPHA_CAP=10;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_IA5STRING=9;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=6;
    public static final int RULE_ALPHA=11;
    public static final int EOF=-1;
    public static final int RULE_MODULE_ID=4;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__33=33;
    public static final int RULE_NUMERIC=12;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__35=35;
    public static final int T__17=17;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_INT=7;
    public static final int RULE_WS=14;
    public static final int RULE_SL_ASN1_COMMENT=13;
    public static final int RULE_PARAMETER=8;

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:15:7: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:15:9: 'OBJECT IDENTIFIER'
            {
            match("OBJECT IDENTIFIER"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:16:7: ( '{' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:16:9: '{'
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:17:7: ( '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:17:9: '}'
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:18:7: ( 'MACRO' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:18:9: 'MACRO'
            {
            match("MACRO"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:19:7: ( 'TYPE NOTATION' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:19:9: 'TYPE NOTATION'
            {
            match("TYPE NOTATION"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:20:7: ( 'VALUE NOTATION' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:20:9: 'VALUE NOTATION'
            {
            match("VALUE NOTATION"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:21:7: ( '|' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:21:9: '|'
            {
            match('|'); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:22:7: ( 'value' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:22:9: 'value'
            {
            match("value"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:23:7: ( '(' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:23:9: '('
            {
            match('('); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:24:7: ( ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:24:9: ')'
            {
            match(')'); 

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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:25:7: ( 'Update' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:25:9: 'Update'
            {
            match("Update"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:26:7: ( 'VALUE OBJECT IDENTIFIER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:26:9: 'VALUE OBJECT IDENTIFIER'
            {
            match("VALUE OBJECT IDENTIFIER"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:27:7: ( 'IA5String' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:27:9: 'IA5String'
            {
            match("IA5String"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:28:7: ( 'empty' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:28:9: 'empty'
            {
            match("empty"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:29:7: ( 'OCTET STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:29:9: 'OCTET STRING'
            {
            match("OCTET STRING"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:30:7: ( 'INTEGER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:30:9: 'INTEGER'
            {
            match("INTEGER"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:31:7: ( 'SIZE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:31:9: 'SIZE'
            {
            match("SIZE"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:32:7: ( '..' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:32:9: '..'
            {
            match(".."); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:33:7: ( 'CHOICE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:33:9: 'CHOICE'
            {
            match("CHOICE"); 


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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:34:7: ( ',' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:34:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "RULE_MODULE_ID"
    public final void mRULE_MODULE_ID() throws RecognitionException {
        try {
            int _type = RULE_MODULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1788:16: ( RULE_ALPHA_CAP ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1788:18: RULE_ALPHA_CAP ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC )
            {
            mRULE_ALPHA_CAP(); 
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1788:33: ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1790:14: ( RULE_ALPHA ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1790:16: RULE_ALPHA ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
            {
            mRULE_ALPHA(); 
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1790:27: ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1792:16: ( '\"' RULE_MODULE_ID '\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1792:18: '\"' RULE_MODULE_ID '\"'
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1794:16: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1794:18: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1794:22: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1794:23: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1794:68: ~ ( ( '\\\\' | '\"' ) )
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

    // $ANTLR start "RULE_NUMERIC"
    public final void mRULE_NUMERIC() throws RecognitionException {
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1796:23: ( '0' .. '9' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1796:25: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMERIC"

    // $ANTLR start "RULE_ALPHA"
    public final void mRULE_ALPHA() throws RecognitionException {
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1798:21: ( 'a' .. 'z' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1798:23: 'a' .. 'z'
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1800:25: ( 'A' .. 'Z' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1800:27: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ALPHA_CAP"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1802:10: ( ( '0' .. '9' )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1802:12: ( '0' .. '9' )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1802:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1802:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_SL_ASN1_COMMENT"
    public final void mRULE_SL_ASN1_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_ASN1_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1804:22: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1804:24: '--' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("--"); 

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1804:29: (~ ( ( '\\n' | '\\r' ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='\f')||(LA5_0>='\u000E' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1804:29: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop5;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1806:9: ( ( ' ' | '\\t' )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1806:11: ( ' ' | '\\t' )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1806:11: ( ' ' | '\\t' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\t'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1808:14: ( ( ( '\\r' )? | '\\n' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1808:16: ( ( '\\r' )? | '\\n' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1808:16: ( ( '\\r' )? | '\\n' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\n') ) {
                alt8=2;
            }
            else {
                alt8=1;}
            switch (alt8) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1808:17: ( '\\r' )?
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1808:17: ( '\\r' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1808:17: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1808:23: '\\n'
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1810:16: ( . )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1810:18: .
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
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | RULE_MODULE_ID | RULE_ASN1_ID | RULE_PARAMETER | RULE_IA5STRING | RULE_INT | RULE_SL_ASN1_COMMENT | RULE_WS | RULE_NEWLINE | RULE_ANY_OTHER )
        int alt9=33;
        alt9 = dfa9.predict(input);
        switch (alt9) {
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
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:154: RULE_MODULE_ID
                {
                mRULE_MODULE_ID(); 

                }
                break;
            case 26 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:169: RULE_ASN1_ID
                {
                mRULE_ASN1_ID(); 

                }
                break;
            case 27 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:182: RULE_PARAMETER
                {
                mRULE_PARAMETER(); 

                }
                break;
            case 28 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:197: RULE_IA5STRING
                {
                mRULE_IA5STRING(); 

                }
                break;
            case 29 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:212: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 30 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:221: RULE_SL_ASN1_COMMENT
                {
                mRULE_SL_ASN1_COMMENT(); 

                }
                break;
            case 31 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:242: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 32 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:250: RULE_NEWLINE
                {
                mRULE_NEWLINE(); 

                }
                break;
            case 33 :
                // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1:263: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\35\5\37\2\uffff\3\37\1\uffff\1\56\2\uffff\2\37\1\56\3\37\1\uffff"+
        "\1\37\1\uffff\1\37\1\uffff\1\37\5\uffff\1\41\2\uffff\4\41\2\uffff"+
        "\3\41\1\uffff\1\56\3\uffff\3\41\1\56\1\41\1\uffff\1\41\6\uffff\2"+
        "\41\1\121\5\41\1\56\3\41\1\56\2\41\2\uffff\2\41\1\uffff\5\41\1\56"+
        "\3\41\1\56\1\153\1\41\1\uffff\1\41\1\157\2\41\1\162\1\uffff\1\41"+
        "\1\164\3\41\1\170\1\uffff\1\41\1\uffff\1\41\1\uffff\1\41\4\uffff"+
        "\1\176\2\41\1\uffff\1\u0081\1\41\4\uffff\1\41\1\u0084\1\uffff\2"+
        "\41\1\uffff\1\41\1\u0088\1\41\1\uffff\1\u008a\1\uffff";
    static final String DFA9_eofS =
        "\u008b\uffff";
    static final String DFA9_minS =
        "\1\0\1\55\1\72\3\55\2\uffff\3\55\1\uffff\1\141\2\uffff\2\55\1\155"+
        "\1\55\1\56\1\55\1\uffff\1\55\1\uffff\1\0\1\uffff\1\55\5\uffff\1"+
        "\106\2\uffff\1\107\1\104\1\112\1\124\2\uffff\1\103\1\120\1\114\1"+
        "\uffff\1\154\3\uffff\1\144\1\65\1\124\1\160\1\132\1\uffff\1\117"+
        "\2\uffff\1\0\3\uffff\2\111\1\55\2\105\1\122\1\105\1\125\1\165\1"+
        "\141\1\123\1\105\1\164\1\105\1\111\2\0\2\116\1\uffff\1\103\1\124"+
        "\1\117\1\40\1\105\1\145\2\164\1\107\1\171\1\55\1\103\1\uffff\1\111"+
        "\1\55\1\124\1\40\1\55\1\uffff\1\40\1\55\1\145\1\162\1\105\1\55\1"+
        "\uffff\1\105\1\uffff\1\124\1\uffff\1\40\2\uffff\1\116\1\uffff\1"+
        "\55\1\151\1\122\1\uffff\1\55\1\111\4\uffff\1\156\1\55\1\uffff\1"+
        "\117\1\147\1\uffff\1\116\1\55\1\123\1\uffff\1\55\1\uffff";
    static final String DFA9_maxS =
        "\1\uffff\1\172\1\72\3\172\2\uffff\3\172\1\uffff\1\141\2\uffff\2"+
        "\172\1\155\1\172\1\56\1\172\1\uffff\1\172\1\uffff\1\uffff\1\uffff"+
        "\1\55\5\uffff\1\106\2\uffff\1\107\1\104\1\112\1\124\2\uffff\1\103"+
        "\1\120\1\114\1\uffff\1\154\3\uffff\1\144\1\65\1\124\1\160\1\132"+
        "\1\uffff\1\117\2\uffff\1\uffff\3\uffff\2\111\1\172\2\105\1\122\1"+
        "\105\1\125\1\165\1\141\1\123\1\105\1\164\1\105\1\111\2\uffff\2\116"+
        "\1\uffff\1\103\1\124\1\117\1\40\1\105\1\145\2\164\1\107\1\171\1"+
        "\172\1\103\1\uffff\1\111\1\172\1\124\1\40\1\172\1\uffff\1\40\1\172"+
        "\1\145\1\162\1\105\1\172\1\uffff\1\105\1\uffff\1\124\1\uffff\1\40"+
        "\2\uffff\1\117\1\uffff\1\172\1\151\1\122\1\uffff\1\172\1\111\4\uffff"+
        "\1\156\1\172\1\uffff\1\117\1\147\1\uffff\1\116\1\172\1\123\1\uffff"+
        "\1\172\1\uffff";
    static final String DFA9_acceptS =
        "\6\uffff\1\6\1\7\3\uffff\1\13\1\uffff\1\15\1\16\6\uffff\1\30\1\uffff"+
        "\1\32\1\uffff\1\35\1\uffff\1\37\3\40\1\41\1\uffff\1\31\1\2\4\uffff"+
        "\1\6\1\7\3\uffff\1\13\1\uffff\1\32\1\15\1\16\5\uffff\1\26\1\uffff"+
        "\1\30\1\34\1\uffff\1\35\1\36\1\37\23\uffff\1\4\14\uffff\1\33\5\uffff"+
        "\1\11\6\uffff\1\25\1\uffff\1\33\1\uffff\1\3\1\uffff\1\23\1\10\1"+
        "\uffff\1\14\3\uffff\1\22\2\uffff\1\5\1\12\1\20\1\17\2\uffff\1\27"+
        "\2\uffff\1\24\3\uffff\1\21\1\uffff\1\1";
    static final String DFA9_specialS =
        "\1\4\27\uffff\1\2\41\uffff\1\1\22\uffff\1\0\1\3\74\uffff}>";
    static final String[] DFA9_transitionS = {
            "\11\37\1\33\1\36\2\37\1\34\22\37\1\33\1\37\1\30\5\37\1\15\1"+
            "\16\2\37\1\25\1\32\1\23\1\37\12\31\1\2\6\37\1\26\1\3\1\24\1"+
            "\1\1\4\3\26\1\20\3\26\1\10\1\26\1\5\3\26\1\22\1\11\1\17\1\12"+
            "\4\26\6\37\4\27\1\21\20\27\1\14\4\27\1\6\1\13\1\7\uff82\37",
            "\1\41\2\uffff\12\41\7\uffff\4\41\1\40\25\41\6\uffff\32\41",
            "\1\42",
            "\1\41\2\uffff\12\41\7\uffff\4\41\1\43\25\41\6\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\15\41\1\44\14\41\6\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\1\41\1\45\1\46\27\41\6\uffff\32"+
            "\41",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\1\51\31\41\6\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\30\41\1\52\1\41\6\uffff\32\41",
            "\1\41\2\uffff\12\41\7\uffff\1\53\31\41\6\uffff\32\41",
            "",
            "\1\55",
            "",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\17\41\1\61\12\41",
            "\1\41\2\uffff\12\41\7\uffff\1\62\14\41\1\63\14\41\6\uffff\32"+
            "\41",
            "\1\64",
            "\1\41\2\uffff\12\41\7\uffff\10\41\1\65\21\41\6\uffff\32\41",
            "\1\66",
            "\1\41\2\uffff\12\41\7\uffff\7\41\1\67\22\41\6\uffff\32\41",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "",
            "\101\71\32\72\uffa5\71",
            "",
            "\1\74",
            "",
            "",
            "",
            "",
            "",
            "\1\76",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "",
            "",
            "\1\103",
            "\1\104",
            "\1\105",
            "",
            "\1\106",
            "",
            "",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "\1\114",
            "",
            "",
            "\55\71\1\116\2\71\12\115\7\71\32\115\6\71\32\115\uff85\71",
            "",
            "",
            "",
            "\1\117",
            "\1\120",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\42\71\1\136\12\71\1\116\2\71\12\115\7\71\32\115\6\71\32\115"+
            "\uff85\71",
            "\55\71\1\116\2\71\12\115\7\71\32\115\6\71\32\115\uff85\71",
            "\1\137",
            "\1\140",
            "",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "\1\154",
            "",
            "\1\156",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "\1\160",
            "\1\161",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "",
            "\1\163",
            "\1\56\2\uffff\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\56\2\uffff\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\1\171",
            "",
            "\1\172",
            "",
            "\1\173",
            "",
            "",
            "\1\174\1\175",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "\1\177",
            "\1\u0080",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "\1\u0082",
            "",
            "",
            "",
            "",
            "\1\u0083",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            "\1\u0089",
            "",
            "\1\41\2\uffff\12\41\7\uffff\32\41\6\uffff\32\41",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | RULE_MODULE_ID | RULE_ASN1_ID | RULE_PARAMETER | RULE_IA5STRING | RULE_INT | RULE_SL_ASN1_COMMENT | RULE_WS | RULE_NEWLINE | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_77 = input.LA(1);

                        s = -1;
                        if ( ((LA9_77>='0' && LA9_77<='9')||(LA9_77>='A' && LA9_77<='Z')||(LA9_77>='a' && LA9_77<='z')) ) {s = 77;}

                        else if ( (LA9_77=='-') ) {s = 78;}

                        else if ( (LA9_77=='\"') ) {s = 94;}

                        else if ( ((LA9_77>='\u0000' && LA9_77<='!')||(LA9_77>='#' && LA9_77<=',')||(LA9_77>='.' && LA9_77<='/')||(LA9_77>=':' && LA9_77<='@')||(LA9_77>='[' && LA9_77<='`')||(LA9_77>='{' && LA9_77<='\uFFFF')) ) {s = 57;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_58 = input.LA(1);

                        s = -1;
                        if ( ((LA9_58>='\u0000' && LA9_58<=',')||(LA9_58>='.' && LA9_58<='/')||(LA9_58>=':' && LA9_58<='@')||(LA9_58>='[' && LA9_58<='`')||(LA9_58>='{' && LA9_58<='\uFFFF')) ) {s = 57;}

                        else if ( ((LA9_58>='0' && LA9_58<='9')||(LA9_58>='A' && LA9_58<='Z')||(LA9_58>='a' && LA9_58<='z')) ) {s = 77;}

                        else if ( (LA9_58=='-') ) {s = 78;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_24 = input.LA(1);

                        s = -1;
                        if ( ((LA9_24>='\u0000' && LA9_24<='@')||(LA9_24>='[' && LA9_24<='\uFFFF')) ) {s = 57;}

                        else if ( ((LA9_24>='A' && LA9_24<='Z')) ) {s = 58;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_78 = input.LA(1);

                        s = -1;
                        if ( ((LA9_78>='0' && LA9_78<='9')||(LA9_78>='A' && LA9_78<='Z')||(LA9_78>='a' && LA9_78<='z')) ) {s = 77;}

                        else if ( (LA9_78=='-') ) {s = 78;}

                        else if ( ((LA9_78>='\u0000' && LA9_78<=',')||(LA9_78>='.' && LA9_78<='/')||(LA9_78>=':' && LA9_78<='@')||(LA9_78>='[' && LA9_78<='`')||(LA9_78>='{' && LA9_78<='\uFFFF')) ) {s = 57;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_0 = input.LA(1);

                        s = -1;
                        if ( (LA9_0=='D') ) {s = 1;}

                        else if ( (LA9_0==':') ) {s = 2;}

                        else if ( (LA9_0=='B') ) {s = 3;}

                        else if ( (LA9_0=='E') ) {s = 4;}

                        else if ( (LA9_0=='O') ) {s = 5;}

                        else if ( (LA9_0=='{') ) {s = 6;}

                        else if ( (LA9_0=='}') ) {s = 7;}

                        else if ( (LA9_0=='M') ) {s = 8;}

                        else if ( (LA9_0=='T') ) {s = 9;}

                        else if ( (LA9_0=='V') ) {s = 10;}

                        else if ( (LA9_0=='|') ) {s = 11;}

                        else if ( (LA9_0=='v') ) {s = 12;}

                        else if ( (LA9_0=='(') ) {s = 13;}

                        else if ( (LA9_0==')') ) {s = 14;}

                        else if ( (LA9_0=='U') ) {s = 15;}

                        else if ( (LA9_0=='I') ) {s = 16;}

                        else if ( (LA9_0=='e') ) {s = 17;}

                        else if ( (LA9_0=='S') ) {s = 18;}

                        else if ( (LA9_0=='.') ) {s = 19;}

                        else if ( (LA9_0=='C') ) {s = 20;}

                        else if ( (LA9_0==',') ) {s = 21;}

                        else if ( (LA9_0=='A'||(LA9_0>='F' && LA9_0<='H')||(LA9_0>='J' && LA9_0<='L')||LA9_0=='N'||(LA9_0>='P' && LA9_0<='R')||(LA9_0>='W' && LA9_0<='Z')) ) {s = 22;}

                        else if ( ((LA9_0>='a' && LA9_0<='d')||(LA9_0>='f' && LA9_0<='u')||(LA9_0>='w' && LA9_0<='z')) ) {s = 23;}

                        else if ( (LA9_0=='\"') ) {s = 24;}

                        else if ( ((LA9_0>='0' && LA9_0<='9')) ) {s = 25;}

                        else if ( (LA9_0=='-') ) {s = 26;}

                        else if ( (LA9_0=='\t'||LA9_0==' ') ) {s = 27;}

                        else if ( (LA9_0=='\r') ) {s = 28;}

                        else if ( (LA9_0=='\n') ) {s = 30;}

                        else if ( ((LA9_0>='\u0000' && LA9_0<='\b')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\u001F')||LA9_0=='!'||(LA9_0>='#' && LA9_0<='\'')||(LA9_0>='*' && LA9_0<='+')||LA9_0=='/'||(LA9_0>=';' && LA9_0<='@')||(LA9_0>='[' && LA9_0<='`')||(LA9_0>='~' && LA9_0<='\uFFFF')) ) {s = 31;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}