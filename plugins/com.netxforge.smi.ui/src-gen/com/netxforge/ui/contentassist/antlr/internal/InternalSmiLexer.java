package com.netxforge.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSmiLexer extends Lexer {
    public static final int T__42=42;
    public static final int T__40=40;
    public static final int RULE_ID=6;
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
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=18;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=4;
    public static final int RULE_ALPHA=11;
    public static final int RULE_SL_COMMENT=17;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=16;
    public static final int RULE_MODULE_ID=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=15;
    public static final int T__33=33;
    public static final int RULE_NUMERIC=12;
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

    public InternalSmiLexer() {;} 
    public InternalSmiLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSmiLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g"; }

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:11:7: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:11:9: 'OBJECT IDENTIFIER'
            {
            match("OBJECT IDENTIFIER"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:12:7: ( 'IA5String' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:12:9: 'IA5String'
            {
            match("IA5String"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:13:7: ( 'DEFINITIONS' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:13:9: 'DEFINITIONS'
            {
            match("DEFINITIONS"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:14:7: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:14:9: '::='
            {
            match("::="); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:15:7: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:15:9: 'BEGIN'
            {
            match("BEGIN"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:16:7: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:16:9: 'END'
            {
            match("END"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:17:7: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:17:9: '{'
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:18:7: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:18:9: '}'
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:19:7: ( 'MACRO' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:19:9: 'MACRO'
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:20:7: ( 'TYPE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:20:9: 'TYPE NOTATION'
            {
            match("TYPE NOTATION"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:21:7: ( 'VALUE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:21:9: 'VALUE NOTATION'
            {
            match("VALUE NOTATION"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:22:7: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:22:9: '|'
            {
            match('|'); 

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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:23:7: ( 'value' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:23:9: 'value'
            {
            match("value"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:24:7: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:24:9: '('
            {
            match('('); 

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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:25:7: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:25:9: ')'
            {
            match(')'); 

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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:26:7: ( 'Update' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:26:9: 'Update'
            {
            match("Update"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:27:7: ( 'empty' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:27:9: 'empty'
            {
            match("empty"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:28:7: ( 'OCTET STRING' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:28:9: 'OCTET STRING'
            {
            match("OCTET STRING"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:29:7: ( 'INTEGER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:29:9: 'INTEGER'
            {
            match("INTEGER"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:30:7: ( 'SIZE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:30:9: 'SIZE'
            {
            match("SIZE"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:31:7: ( '..' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:31:9: '..'
            {
            match(".."); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:32:7: ( 'CHOICE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:32:9: 'CHOICE'
            {
            match("CHOICE"); 


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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:33:7: ( ',' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:33:9: ','
            {
            match(','); 

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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:34:7: ( 'VALUE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:34:9: 'VALUE'
            {
            match("VALUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "RULE_MODULE_ID"
    public final void mRULE_MODULE_ID() throws RecognitionException {
        try {
            int _type = RULE_MODULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4724:16: ( RULE_ALPHA_CAP ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4724:18: RULE_ALPHA_CAP ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* ( RULE_ALPHA_CAP | RULE_ALPHA | RULE_NUMERIC )
            {
            mRULE_ALPHA_CAP(); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4724:33: ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
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
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4726:14: ( RULE_ALPHA ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4726:16: RULE_ALPHA ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
            {
            mRULE_ALPHA(); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4726:27: ( RULE_ALPHA | RULE_ALPHA_CAP | '-' | RULE_NUMERIC )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4728:16: ( '\"' RULE_MODULE_ID '\"' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4728:18: '\"' RULE_MODULE_ID '\"'
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4730:16: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4730:18: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4730:22: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
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
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4730:23: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4730:68: ~ ( ( '\\\\' | '\"' ) )
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4732:23: ( '0' .. '9' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4732:25: '0' .. '9'
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4734:21: ( 'a' .. 'z' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4734:23: 'a' .. 'z'
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4736:25: ( 'A' .. 'Z' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4736:27: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_ALPHA_CAP"

    // $ANTLR start "RULE_SL_ASN1_COMMENT"
    public final void mRULE_SL_ASN1_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_ASN1_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:22: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:24: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:29: (~ ( ( '\\n' | '\\r' ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:29: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop4;
                }
            } while (true);

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:45: ( ( '\\r' )? '\\n' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\n'||LA6_0=='\r') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:46: ( '\\r' )? '\\n'
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:46: ( '\\r' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\r') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:46: '\\r'
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
    // $ANTLR end "RULE_SL_ASN1_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4740:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4740:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4740:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:
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

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4742:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4742:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4742:11: ( '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='^') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4742:11: '^'
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

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4742:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:
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
            	    break loop9;
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4744:10: ( ( '0' .. '9' )+ )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4744:12: ( '0' .. '9' )+
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4744:12: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4744:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\"') ) {
                alt13=1;
            }
            else if ( (LA13_0=='\'') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\\') ) {
                            alt11=1;
                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop11;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
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
                    	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop12;
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4748:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4748:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4748:24: ( options {greedy=false; } : . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='*') ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1=='/') ) {
                        alt14=2;
                    }
                    else if ( ((LA14_1>='\u0000' && LA14_1<='.')||(LA14_1>='0' && LA14_1<='\uFFFF')) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0>='\u0000' && LA14_0<=')')||(LA14_0>='+' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4748:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop15;
                }
            } while (true);

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:40: ( ( '\\r' )? '\\n' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\n'||LA17_0=='\r') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:41: ( '\\r' )? '\\n'
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:41: ( '\\r' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='\r') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4750:41: '\\r'
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

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4752:16: ( . )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4752:18: .
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
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | RULE_MODULE_ID | RULE_ASN1_ID | RULE_PARAMETER | RULE_IA5STRING | RULE_SL_ASN1_COMMENT | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER )
        int alt18=36;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:10: T__19
                {
                mT__19(); 

                }
                break;
            case 2 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:16: T__20
                {
                mT__20(); 

                }
                break;
            case 3 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:22: T__21
                {
                mT__21(); 

                }
                break;
            case 4 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:28: T__22
                {
                mT__22(); 

                }
                break;
            case 5 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:34: T__23
                {
                mT__23(); 

                }
                break;
            case 6 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:40: T__24
                {
                mT__24(); 

                }
                break;
            case 7 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:46: T__25
                {
                mT__25(); 

                }
                break;
            case 8 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:52: T__26
                {
                mT__26(); 

                }
                break;
            case 9 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:58: T__27
                {
                mT__27(); 

                }
                break;
            case 10 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:64: T__28
                {
                mT__28(); 

                }
                break;
            case 11 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:70: T__29
                {
                mT__29(); 

                }
                break;
            case 12 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:76: T__30
                {
                mT__30(); 

                }
                break;
            case 13 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:82: T__31
                {
                mT__31(); 

                }
                break;
            case 14 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:88: T__32
                {
                mT__32(); 

                }
                break;
            case 15 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:94: T__33
                {
                mT__33(); 

                }
                break;
            case 16 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:100: T__34
                {
                mT__34(); 

                }
                break;
            case 17 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:106: T__35
                {
                mT__35(); 

                }
                break;
            case 18 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:112: T__36
                {
                mT__36(); 

                }
                break;
            case 19 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:118: T__37
                {
                mT__37(); 

                }
                break;
            case 20 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:124: T__38
                {
                mT__38(); 

                }
                break;
            case 21 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:130: T__39
                {
                mT__39(); 

                }
                break;
            case 22 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:136: T__40
                {
                mT__40(); 

                }
                break;
            case 23 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:142: T__41
                {
                mT__41(); 

                }
                break;
            case 24 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:148: T__42
                {
                mT__42(); 

                }
                break;
            case 25 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:154: RULE_MODULE_ID
                {
                mRULE_MODULE_ID(); 

                }
                break;
            case 26 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:169: RULE_ASN1_ID
                {
                mRULE_ASN1_ID(); 

                }
                break;
            case 27 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:182: RULE_PARAMETER
                {
                mRULE_PARAMETER(); 

                }
                break;
            case 28 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:197: RULE_IA5STRING
                {
                mRULE_IA5STRING(); 

                }
                break;
            case 29 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:212: RULE_SL_ASN1_COMMENT
                {
                mRULE_SL_ASN1_COMMENT(); 

                }
                break;
            case 30 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:233: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 31 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:241: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 32 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:249: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 33 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:258: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 34 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:270: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 35 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:286: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 36 :
                // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1:302: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\3\43\1\40\2\43\2\uffff\3\43\1\uffff\1\63\2\uffff\1\43\1"+
        "\63\1\43\1\40\1\43\1\uffff\1\43\1\63\2\40\1\uffff\1\40\2\uffff\2"+
        "\40\1\uffff\2\45\1\uffff\1\45\1\uffff\3\45\1\uffff\2\45\2\uffff"+
        "\3\45\1\uffff\1\63\1\uffff\1\63\2\uffff\1\45\1\63\1\45\1\uffff\1"+
        "\45\13\uffff\6\45\1\140\3\45\1\63\1\45\1\63\2\45\4\uffff\6\45\1"+
        "\uffff\3\45\1\63\1\45\1\63\1\166\1\45\1\uffff\5\45\1\176\1\177\1"+
        "\uffff\1\u0081\1\u0082\1\45\1\u0084\1\uffff\1\45\1\uffff\1\45\1"+
        "\uffff\3\45\5\uffff\1\u008a\1\uffff\1\u008b\1\uffff\1\45\1\u008d"+
        "\1\45\2\uffff\1\45\1\uffff\1\45\1\u0091\1\45\1\uffff\1\45\1\u0094"+
        "\1\uffff";
    static final String DFA18_eofS =
        "\u0095\uffff";
    static final String DFA18_minS =
        "\1\0\3\55\1\72\2\55\2\uffff\3\55\1\uffff\1\60\2\uffff\1\55\1\60"+
        "\1\55\1\56\1\55\1\uffff\1\55\1\60\1\0\1\55\1\uffff\1\101\2\uffff"+
        "\1\0\1\52\1\uffff\2\60\1\uffff\1\60\1\uffff\3\60\1\uffff\2\60\2"+
        "\uffff\3\60\1\uffff\1\60\1\uffff\1\60\2\uffff\3\60\1\uffff\1\60"+
        "\1\uffff\1\0\1\42\1\0\7\uffff\6\60\1\55\10\60\3\0\1\uffff\6\60\1"+
        "\uffff\1\60\1\40\4\60\1\55\1\60\1\uffff\1\60\1\40\3\60\2\55\1\uffff"+
        "\1\40\1\55\1\60\1\55\1\uffff\1\60\1\uffff\1\40\1\uffff\3\60\5\uffff"+
        "\1\55\1\uffff\1\55\1\uffff\1\60\1\55\1\60\2\uffff\1\60\1\uffff\1"+
        "\60\1\55\1\60\1\uffff\1\60\1\55\1\uffff";
    static final String DFA18_maxS =
        "\1\uffff\3\172\1\72\2\172\2\uffff\3\172\1\uffff\1\172\2\uffff\3"+
        "\172\1\56\1\172\1\uffff\2\172\1\uffff\1\55\1\uffff\1\172\2\uffff"+
        "\1\uffff\1\57\1\uffff\2\172\1\uffff\1\172\1\uffff\3\172\1\uffff"+
        "\2\172\2\uffff\3\172\1\uffff\1\172\1\uffff\1\172\2\uffff\3\172\1"+
        "\uffff\1\172\1\uffff\1\uffff\1\165\1\uffff\7\uffff\17\172\3\uffff"+
        "\1\uffff\6\172\1\uffff\10\172\1\uffff\7\172\1\uffff\4\172\1\uffff"+
        "\1\172\1\uffff\1\172\1\uffff\3\172\5\uffff\1\172\1\uffff\1\172\1"+
        "\uffff\3\172\2\uffff\1\172\1\uffff\3\172\1\uffff\2\172\1\uffff";
    static final String DFA18_acceptS =
        "\7\uffff\1\7\1\10\3\uffff\1\14\1\uffff\1\16\1\17\5\uffff\1\27\4"+
        "\uffff\1\36\1\uffff\1\37\1\40\2\uffff\1\44\2\uffff\1\37\1\uffff"+
        "\1\31\3\uffff\1\4\2\uffff\1\7\1\10\3\uffff\1\14\1\uffff\1\32\1\uffff"+
        "\1\16\1\17\3\uffff\1\25\1\uffff\1\27\3\uffff\1\34\1\35\1\36\1\40"+
        "\1\41\1\42\1\43\22\uffff\1\34\6\uffff\1\6\10\uffff\1\33\7\uffff"+
        "\1\12\4\uffff\1\24\1\uffff\1\33\1\uffff\1\22\3\uffff\1\5\1\11\1"+
        "\13\1\30\1\15\1\uffff\1\21\1\uffff\1\1\3\uffff\1\20\1\26\1\uffff"+
        "\1\23\3\uffff\1\2\2\uffff\1\3";
    static final String DFA18_specialS =
        "\1\6\27\uffff\1\5\5\uffff\1\4\36\uffff\1\7\1\uffff\1\0\26\uffff"+
        "\1\2\1\3\1\1\74\uffff}>";
    static final String[] DFA18_transitionS = {
            "\11\40\2\32\2\40\1\32\22\40\1\32\1\40\1\30\4\40\1\36\1\16\1"+
            "\17\2\40\1\25\1\31\1\23\1\37\12\35\1\4\6\40\1\26\1\5\1\24\1"+
            "\3\1\6\3\26\1\2\3\26\1\11\1\26\1\1\3\26\1\22\1\12\1\20\1\13"+
            "\4\26\3\40\1\33\1\34\1\40\4\27\1\21\20\27\1\15\4\27\1\7\1\14"+
            "\1\10\uff82\40",
            "\1\45\2\uffff\12\44\7\uffff\1\44\1\41\1\42\27\44\6\uffff\32"+
            "\44",
            "\1\45\2\uffff\12\44\7\uffff\1\46\14\44\1\47\14\44\6\uffff\32"+
            "\44",
            "\1\45\2\uffff\12\44\7\uffff\4\44\1\50\25\44\6\uffff\32\44",
            "\1\51",
            "\1\45\2\uffff\12\44\7\uffff\4\44\1\52\25\44\6\uffff\32\44",
            "\1\45\2\uffff\12\44\7\uffff\15\44\1\53\14\44\6\uffff\32\44",
            "",
            "",
            "\1\45\2\uffff\12\44\7\uffff\1\56\31\44\6\uffff\32\44",
            "\1\45\2\uffff\12\44\7\uffff\30\44\1\57\1\44\6\uffff\32\44",
            "\1\45\2\uffff\12\44\7\uffff\1\60\31\44\6\uffff\32\44",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\1\62\31\64",
            "",
            "",
            "\1\45\2\uffff\12\44\7\uffff\32\44\6\uffff\17\44\1\67\12\44",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\14\64\1\70\15\64",
            "\1\45\2\uffff\12\44\7\uffff\10\44\1\71\21\44\6\uffff\32\44",
            "\1\72",
            "\1\45\2\uffff\12\44\7\uffff\7\44\1\73\22\44\6\uffff\32\44",
            "",
            "\1\45\2\uffff\12\44\7\uffff\32\44\6\uffff\32\44",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\32\64",
            "\42\77\1\100\36\77\32\75\1\77\1\76\uffa3\77",
            "\1\101",
            "",
            "\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "\0\104",
            "\1\105\4\uffff\1\106",
            "",
            "\12\44\7\uffff\11\44\1\107\20\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\23\44\1\110\6\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\5\44\1\111\4\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\23\44\1\112\6\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\5\44\1\113\24\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\12\44\7\uffff\6\44\1\114\23\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\3\44\1\115\26\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "",
            "\12\44\7\uffff\2\44\1\116\27\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\17\44\1\117\12\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\13\44\1\120\16\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\13\64\1\121\16\64",
            "",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\32\64",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\3\44\1\122\26\44",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\17\64\1\123\12\64",
            "\12\44\7\uffff\31\44\1\124\4\uffff\1\43\1\uffff\32\44",
            "",
            "\12\44\7\uffff\16\44\1\125\13\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\42\77\1\100\12\77\1\127\2\77\12\126\7\77\32\126\1\77\1\76"+
            "\4\77\32\126\uff85\77",
            "\1\130\4\uffff\1\130\64\uffff\1\130\5\uffff\1\130\3\uffff\1"+
            "\130\7\uffff\1\130\3\uffff\1\130\1\uffff\2\130",
            "\42\77\1\100\71\77\1\76\uffa3\77",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\44\7\uffff\4\44\1\132\25\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\4\44\1\133\25\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\22\44\1\134\7\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\4\44\1\135\25\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\10\44\1\136\21\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\10\44\1\137\21\44\4\uffff\1\43\1\uffff\32\44",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\21\44\1\141\10\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\4\44\1\142\25\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\24\44\1\143\5\44\4\uffff\1\43\1\uffff\32\44",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\24\64\1\144\5\64",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\1\145\31\44",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\23\64\1\146\6\64",
            "\12\44\7\uffff\4\44\1\147\25\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\10\44\1\150\21\44\4\uffff\1\43\1\uffff\32\44",
            "\42\77\1\151\12\77\1\127\2\77\12\126\7\77\32\126\1\77\1\76"+
            "\4\77\32\126\uff85\77",
            "\42\77\1\100\12\77\1\127\2\77\12\126\7\77\32\126\1\77\1\76"+
            "\4\77\32\126\uff85\77",
            "\42\77\1\100\71\77\1\76\uffa3\77",
            "",
            "\12\44\7\uffff\2\44\1\152\27\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\23\44\1\153\6\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\23\44\1\154\6\44",
            "\12\44\7\uffff\6\44\1\155\23\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\15\44\1\156\14\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\15\44\1\157\14\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\12\44\7\uffff\16\44\1\160\13\44\4\uffff\1\43\1\uffff\32\44",
            "\1\161\17\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32"+
            "\44",
            "\12\44\7\uffff\4\44\1\162\25\44\4\uffff\1\43\1\uffff\32\44",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\4\64\1\163\25\64",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\23\44\1\164\6\44",
            "\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\30\64\1\165\1\64",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\2\44\1\167\27\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\12\44\7\uffff\23\44\1\171\6\44\4\uffff\1\43\1\uffff\32\44",
            "\1\172\17\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32"+
            "\44",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\21\44\1\173\10\44",
            "\12\44\7\uffff\4\44\1\174\25\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\10\44\1\175\21\44\4\uffff\1\43\1\uffff\32\44",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\1\u0080\14\uffff\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff"+
            "\1\43\1\uffff\32\44",
            "\1\63\2\uffff\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\32\64",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\4\44\1\u0083\25\44",
            "\1\63\2\uffff\12\64\7\uffff\32\64\4\uffff\1\43\1\uffff\32\64",
            "",
            "\12\44\7\uffff\4\44\1\u0085\25\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\1\u0086\17\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff"+
            "\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\10\44\1\u0087\21"+
            "\44",
            "\12\44\7\uffff\21\44\1\u0088\10\44\4\uffff\1\43\1\uffff\32"+
            "\44",
            "\12\44\7\uffff\23\44\1\u0089\6\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "",
            "",
            "",
            "",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\15\44\1\u008c\14"+
            "\44",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\10\44\1\u008e\21\44\4\uffff\1\43\1\uffff\32"+
            "\44",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\6\44\1\u008f\23\44",
            "",
            "\12\44\7\uffff\16\44\1\u0090\13\44\4\uffff\1\43\1\uffff\32"+
            "\44",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            "\12\44\7\uffff\15\44\1\u0092\14\44\4\uffff\1\43\1\uffff\32"+
            "\44",
            "",
            "\12\44\7\uffff\22\44\1\u0093\7\44\4\uffff\1\43\1\uffff\32\44",
            "\1\45\2\uffff\12\44\7\uffff\32\44\4\uffff\1\43\1\uffff\32\44",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | RULE_MODULE_ID | RULE_ASN1_ID | RULE_PARAMETER | RULE_IA5STRING | RULE_SL_ASN1_COMMENT | RULE_WS | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_63 = input.LA(1);

                        s = -1;
                        if ( (LA18_63=='\"') ) {s = 64;}

                        else if ( (LA18_63=='\\') ) {s = 62;}

                        else if ( ((LA18_63>='\u0000' && LA18_63<='!')||(LA18_63>='#' && LA18_63<='[')||(LA18_63>=']' && LA18_63<='\uFFFF')) ) {s = 63;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_88 = input.LA(1);

                        s = -1;
                        if ( (LA18_88=='\"') ) {s = 64;}

                        else if ( (LA18_88=='\\') ) {s = 62;}

                        else if ( ((LA18_88>='\u0000' && LA18_88<='!')||(LA18_88>='#' && LA18_88<='[')||(LA18_88>=']' && LA18_88<='\uFFFF')) ) {s = 63;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_86 = input.LA(1);

                        s = -1;
                        if ( (LA18_86=='\"') ) {s = 105;}

                        else if ( (LA18_86=='\\') ) {s = 62;}

                        else if ( ((LA18_86>='0' && LA18_86<='9')||(LA18_86>='A' && LA18_86<='Z')||(LA18_86>='a' && LA18_86<='z')) ) {s = 86;}

                        else if ( (LA18_86=='-') ) {s = 87;}

                        else if ( ((LA18_86>='\u0000' && LA18_86<='!')||(LA18_86>='#' && LA18_86<=',')||(LA18_86>='.' && LA18_86<='/')||(LA18_86>=':' && LA18_86<='@')||LA18_86=='['||(LA18_86>=']' && LA18_86<='`')||(LA18_86>='{' && LA18_86<='\uFFFF')) ) {s = 63;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_87 = input.LA(1);

                        s = -1;
                        if ( (LA18_87=='\"') ) {s = 64;}

                        else if ( (LA18_87=='\\') ) {s = 62;}

                        else if ( ((LA18_87>='0' && LA18_87<='9')||(LA18_87>='A' && LA18_87<='Z')||(LA18_87>='a' && LA18_87<='z')) ) {s = 86;}

                        else if ( (LA18_87=='-') ) {s = 87;}

                        else if ( ((LA18_87>='\u0000' && LA18_87<='!')||(LA18_87>='#' && LA18_87<=',')||(LA18_87>='.' && LA18_87<='/')||(LA18_87>=':' && LA18_87<='@')||LA18_87=='['||(LA18_87>=']' && LA18_87<='`')||(LA18_87>='{' && LA18_87<='\uFFFF')) ) {s = 63;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_30 = input.LA(1);

                        s = -1;
                        if ( ((LA18_30>='\u0000' && LA18_30<='\uFFFF')) ) {s = 68;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_24 = input.LA(1);

                        s = -1;
                        if ( ((LA18_24>='A' && LA18_24<='Z')) ) {s = 61;}

                        else if ( (LA18_24=='\\') ) {s = 62;}

                        else if ( ((LA18_24>='\u0000' && LA18_24<='!')||(LA18_24>='#' && LA18_24<='@')||LA18_24=='['||(LA18_24>=']' && LA18_24<='\uFFFF')) ) {s = 63;}

                        else if ( (LA18_24=='\"') ) {s = 64;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_0 = input.LA(1);

                        s = -1;
                        if ( (LA18_0=='O') ) {s = 1;}

                        else if ( (LA18_0=='I') ) {s = 2;}

                        else if ( (LA18_0=='D') ) {s = 3;}

                        else if ( (LA18_0==':') ) {s = 4;}

                        else if ( (LA18_0=='B') ) {s = 5;}

                        else if ( (LA18_0=='E') ) {s = 6;}

                        else if ( (LA18_0=='{') ) {s = 7;}

                        else if ( (LA18_0=='}') ) {s = 8;}

                        else if ( (LA18_0=='M') ) {s = 9;}

                        else if ( (LA18_0=='T') ) {s = 10;}

                        else if ( (LA18_0=='V') ) {s = 11;}

                        else if ( (LA18_0=='|') ) {s = 12;}

                        else if ( (LA18_0=='v') ) {s = 13;}

                        else if ( (LA18_0=='(') ) {s = 14;}

                        else if ( (LA18_0==')') ) {s = 15;}

                        else if ( (LA18_0=='U') ) {s = 16;}

                        else if ( (LA18_0=='e') ) {s = 17;}

                        else if ( (LA18_0=='S') ) {s = 18;}

                        else if ( (LA18_0=='.') ) {s = 19;}

                        else if ( (LA18_0=='C') ) {s = 20;}

                        else if ( (LA18_0==',') ) {s = 21;}

                        else if ( (LA18_0=='A'||(LA18_0>='F' && LA18_0<='H')||(LA18_0>='J' && LA18_0<='L')||LA18_0=='N'||(LA18_0>='P' && LA18_0<='R')||(LA18_0>='W' && LA18_0<='Z')) ) {s = 22;}

                        else if ( ((LA18_0>='a' && LA18_0<='d')||(LA18_0>='f' && LA18_0<='u')||(LA18_0>='w' && LA18_0<='z')) ) {s = 23;}

                        else if ( (LA18_0=='\"') ) {s = 24;}

                        else if ( (LA18_0=='-') ) {s = 25;}

                        else if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {s = 26;}

                        else if ( (LA18_0=='^') ) {s = 27;}

                        else if ( (LA18_0=='_') ) {s = 28;}

                        else if ( ((LA18_0>='0' && LA18_0<='9')) ) {s = 29;}

                        else if ( (LA18_0=='\'') ) {s = 30;}

                        else if ( (LA18_0=='/') ) {s = 31;}

                        else if ( ((LA18_0>='\u0000' && LA18_0<='\b')||(LA18_0>='\u000B' && LA18_0<='\f')||(LA18_0>='\u000E' && LA18_0<='\u001F')||LA18_0=='!'||(LA18_0>='#' && LA18_0<='&')||(LA18_0>='*' && LA18_0<='+')||(LA18_0>=';' && LA18_0<='@')||(LA18_0>='[' && LA18_0<=']')||LA18_0=='`'||(LA18_0>='~' && LA18_0<='\uFFFF')) ) {s = 32;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_61 = input.LA(1);

                        s = -1;
                        if ( ((LA18_61>='0' && LA18_61<='9')||(LA18_61>='A' && LA18_61<='Z')||(LA18_61>='a' && LA18_61<='z')) ) {s = 86;}

                        else if ( (LA18_61=='-') ) {s = 87;}

                        else if ( (LA18_61=='\"') ) {s = 64;}

                        else if ( (LA18_61=='\\') ) {s = 62;}

                        else if ( ((LA18_61>='\u0000' && LA18_61<='!')||(LA18_61>='#' && LA18_61<=',')||(LA18_61>='.' && LA18_61<='/')||(LA18_61>=':' && LA18_61<='@')||LA18_61=='['||(LA18_61>=']' && LA18_61<='`')||(LA18_61>='{' && LA18_61<='\uFFFF')) ) {s = 63;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}