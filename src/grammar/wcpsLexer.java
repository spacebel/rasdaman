// $ANTLR 3.1.2 src/grammar/wcps.g 2009-05-29 12:32:50
package grammar;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class wcpsLexer extends Lexer {
    public static final int IMAGECRS=28;
    public static final int LT=18;
    public static final int HEXACONSTANT=113;
    public static final int LN=66;
    public static final int LOG=65;
    public static final int CHAR=88;
    public static final int COMPLEX=93;
    public static final int SETINTERPOLATIONDEFAULT=54;
    public static final int COUNT=37;
    public static final int EQUALS=16;
    public static final int COSH=71;
    public static final int NOT=76;
    public static final int INTEGERCONSTANT=78;
    public static final int EOF=-1;
    public static final int SINH=70;
    public static final int LBRACKET=82;
    public static final int RPAREN=7;
    public static final int TANH=72;
    public static final int LINEAR=100;
    public static final int NAME=107;
    public static final int FULL=103;
    public static final int SIN=67;
    public static final int USING=44;
    public static final int EXP=64;
    public static final int COS=68;
    public static final int TAN=69;
    public static final int RETURN=10;
    public static final int DOUBLE=92;
    public static final int NULLDEFAULT=109;
    public static final int STORE=12;
    public static final int DIVIDE=25;
    public static final int BOOLEANCONSTANT=97;
    public static final int RBRACE=57;
    public static final int SETNULLSET=53;
    public static final int CONDENSE=42;
    public static final int WHITESPACE=114;
    public static final int SEMICOLON=49;
    public static final int VALUE=47;
    public static final int MULT=24;
    public static final int LIST=48;
    public static final int COMPLEX2=94;
    public static final int ABS=61;
    public static final int DECIMALCONSTANT=111;
    public static final int CRSSET=30;
    public static final int SCALE=81;
    public static final int VARIABLE_DOLLAR=108;
    public static final int FLOATCONSTANT=98;
    public static final int IMAGECRSDOMAIN=29;
    public static final int NONE=104;
    public static final int OR=13;
    public static final int TRIM=84;
    public static final int GT=19;
    public static final int ROUND=79;
    public static final int QUADRATIC=101;
    public static final int ENCODE=11;
    public static final int PHI=110;
    public static final int OVER=43;
    public static final int COVERAGE=46;
    public static final int WHERE=9;
    public static final int RE=62;
    public static final int OVERLAY=26;
    public static final int GTE=21;
    public static final int LBRACE=56;
    public static final int MAX=41;
    public static final int INTERPOLATIONDEFAULT=32;
    public static final int FOR=4;
    public static final int FLOAT=91;
    public static final int SLICE=85;
    public static final int AND=15;
    public static final int LTE=20;
    public static final int LPAREN=6;
    public static final int EXTEND=86;
    public static final int IM=63;
    public static final int BOOLEAN=87;
    public static final int IN=5;
    public static final int COMMA=8;
    public static final int AVG=39;
    public static final int IDENTIFIER=27;
    public static final int SOME=36;
    public static final int ALL=35;
    public static final int ARCSIN=73;
    public static final int PLUS=22;
    public static final int ARCCOS=74;
    public static final int RBRACKET=83;
    public static final int DOT=96;
    public static final int ADD=38;
    public static final int SETIDENTIFIER=51;
    public static final int XOR=14;
    public static final int SETINTERPOLATIONSET=55;
    public static final int OTHER=106;
    public static final int VALUES=50;
    public static final int ARCTAN=75;
    public static final int NOTEQUALS=17;
    public static final int SHORT=89;
    public static final int STRUCT=58;
    public static final int OCTALCONSTANT=112;
    public static final int MIN=40;
    public static final int SQRT=60;
    public static final int MINUS=23;
    public static final int CRSTRANSFORM=59;
    public static final int DOMAIN=34;
    public static final int COLON=45;
    public static final int CUBIC=102;
    public static final int UNSIGNED=95;
    public static final int NULLSET=31;
    public static final int BIT=77;
    public static final int LONG=90;
    public static final int INTERPOLATIONSET=33;
    public static final int SETCRSSET=52;
    public static final int HALF=105;
    public static final int STRING=80;
    public static final int NEAREST=99;

    // delegates
    // delegators

    public wcpsLexer() {;} 
    public wcpsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public wcpsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/grammar/wcps.g"; }

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:388:5: ( '+' )
            // src/grammar/wcps.g:388:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:389:6: ( '-' )
            // src/grammar/wcps.g:389:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:390:7: ( '/' )
            // src/grammar/wcps.g:390:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:391:5: ( '*' )
            // src/grammar/wcps.g:391:7: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:392:7: ( '=' )
            // src/grammar/wcps.g:392:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "NOTEQUALS"
    public final void mNOTEQUALS() throws RecognitionException {
        try {
            int _type = NOTEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:393:10: ( '!=' )
            // src/grammar/wcps.g:393:12: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTEQUALS"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:394:3: ( '<' )
            // src/grammar/wcps.g:394:5: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:395:3: ( '>' )
            // src/grammar/wcps.g:395:5: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LTE"
    public final void mLTE() throws RecognitionException {
        try {
            int _type = LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:396:4: ( '<=' )
            // src/grammar/wcps.g:396:6: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LTE"

    // $ANTLR start "GTE"
    public final void mGTE() throws RecognitionException {
        try {
            int _type = GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:397:4: ( '>=' )
            // src/grammar/wcps.g:397:6: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GTE"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:398:4: ( '.' )
            // src/grammar/wcps.g:398:6: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:399:7: ( '(' )
            // src/grammar/wcps.g:399:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:400:7: ( ')' )
            // src/grammar/wcps.g:400:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:401:9: ( '[' )
            // src/grammar/wcps.g:401:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:402:9: ( ']' )
            // src/grammar/wcps.g:402:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:403:7: ( '{' )
            // src/grammar/wcps.g:403:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:404:7: ( '}' )
            // src/grammar/wcps.g:404:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:405:6: ( ',' )
            // src/grammar/wcps.g:405:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:406:6: ( ':' )
            // src/grammar/wcps.g:406:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:407:10: ( ';' )
            // src/grammar/wcps.g:407:12: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:408:4: ( ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:408:6: ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "FOR"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:409:3: ( ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:409:5: ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "IN"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:410:6: ( ( 'w' | 'W' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:410:8: ( 'w' | 'W' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "WHERE"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:411:7: ( ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:411:9: ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "RETURN"

    // $ANTLR start "STORE"
    public final void mSTORE() throws RecognitionException {
        try {
            int _type = STORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:412:6: ( ( 's' | 'S' ) ( 't' | 'T' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:412:8: ( 's' | 'S' ) ( 't' | 'T' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "STORE"

    // $ANTLR start "ENCODE"
    public final void mENCODE() throws RecognitionException {
        try {
            int _type = ENCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:413:7: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'd' | 'D' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:413:9: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'd' | 'D' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "ENCODE"

    // $ANTLR start "SQRT"
    public final void mSQRT() throws RecognitionException {
        try {
            int _type = SQRT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:414:5: ( ( 's' | 'S' ) ( 'q' | 'Q' ) ( 'r' | 'R' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:414:7: ( 's' | 'S' ) ( 'q' | 'Q' ) ( 'r' | 'R' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "SQRT"

    // $ANTLR start "SIN"
    public final void mSIN() throws RecognitionException {
        try {
            int _type = SIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:415:4: ( ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:415:6: ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "SIN"

    // $ANTLR start "COS"
    public final void mCOS() throws RecognitionException {
        try {
            int _type = COS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:416:4: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' ) )
            // src/grammar/wcps.g:416:6: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "COS"

    // $ANTLR start "TAN"
    public final void mTAN() throws RecognitionException {
        try {
            int _type = TAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:417:4: ( ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:417:6: ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "TAN"

    // $ANTLR start "SINH"
    public final void mSINH() throws RecognitionException {
        try {
            int _type = SINH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:418:5: ( ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'h' | 'H' ) )
            // src/grammar/wcps.g:418:7: ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'h' | 'H' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "SINH"

    // $ANTLR start "COSH"
    public final void mCOSH() throws RecognitionException {
        try {
            int _type = COSH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:419:5: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' ) ( 'h' | 'H' ) )
            // src/grammar/wcps.g:419:7: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' ) ( 'h' | 'H' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "COSH"

    // $ANTLR start "TANH"
    public final void mTANH() throws RecognitionException {
        try {
            int _type = TANH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:420:5: ( ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'h' | 'H' ) )
            // src/grammar/wcps.g:420:7: ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'h' | 'H' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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
    // $ANTLR end "TANH"

    // $ANTLR start "ARCSIN"
    public final void mARCSIN() throws RecognitionException {
        try {
            int _type = ARCSIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:421:7: ( ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'c' | 'C' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:421:9: ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'c' | 'C' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "ARCSIN"

    // $ANTLR start "ARCCOS"
    public final void mARCCOS() throws RecognitionException {
        try {
            int _type = ARCCOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:422:7: ( ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'c' | 'C' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' ) )
            // src/grammar/wcps.g:422:9: ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'c' | 'C' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "ARCCOS"

    // $ANTLR start "ARCTAN"
    public final void mARCTAN() throws RecognitionException {
        try {
            int _type = ARCTAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:423:7: ( ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:423:9: ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "ARCTAN"

    // $ANTLR start "EXP"
    public final void mEXP() throws RecognitionException {
        try {
            int _type = EXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:424:4: ( ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'p' | 'P' ) )
            // src/grammar/wcps.g:424:6: ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'p' | 'P' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
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
    // $ANTLR end "EXP"

    // $ANTLR start "LN"
    public final void mLN() throws RecognitionException {
        try {
            int _type = LN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:425:3: ( ( 'l' | 'L' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:425:5: ( 'l' | 'L' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "LN"

    // $ANTLR start "LOG"
    public final void mLOG() throws RecognitionException {
        try {
            int _type = LOG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:426:4: ( ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'g' | 'G' ) )
            // src/grammar/wcps.g:426:6: ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
    // $ANTLR end "LOG"

    // $ANTLR start "ROUND"
    public final void mROUND() throws RecognitionException {
        try {
            int _type = ROUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:427:6: ( ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
            // src/grammar/wcps.g:427:8: ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "ROUND"

    // $ANTLR start "ABS"
    public final void mABS() throws RecognitionException {
        try {
            int _type = ABS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:428:4: ( ( 'a' | 'A' ) ( 'b' | 'B' ) ( 's' | 'S' ) )
            // src/grammar/wcps.g:428:6: ( 'a' | 'A' ) ( 'b' | 'B' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "ABS"

    // $ANTLR start "OVERLAY"
    public final void mOVERLAY() throws RecognitionException {
        try {
            int _type = OVERLAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:429:8: ( ( 'o' | 'O' ) ( 'v' | 'V' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 'y' | 'Y' ) )
            // src/grammar/wcps.g:429:10: ( 'o' | 'O' ) ( 'v' | 'V' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
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
    // $ANTLR end "OVERLAY"

    // $ANTLR start "STRUCT"
    public final void mSTRUCT() throws RecognitionException {
        try {
            int _type = STRUCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:430:7: ( ( 's' | 'S' ) ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'c' | 'C' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:430:9: ( 's' | 'S' ) ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'c' | 'C' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "STRUCT"

    // $ANTLR start "RE"
    public final void mRE() throws RecognitionException {
        try {
            int _type = RE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:431:3: ( ( 'r' | 'R' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:431:5: ( 'r' | 'R' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "RE"

    // $ANTLR start "IM"
    public final void mIM() throws RecognitionException {
        try {
            int _type = IM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:432:3: ( ( 'i' | 'I' ) ( 'm' | 'M' ) )
            // src/grammar/wcps.g:432:5: ( 'i' | 'I' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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
    // $ANTLR end "IM"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:433:4: ( ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
            // src/grammar/wcps.g:433:6: ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:434:3: ( ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:434:5: ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "OR"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:435:4: ( ( 'x' | 'X' ) ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:435:6: ( 'x' | 'X' ) ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "XOR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:436:4: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:436:6: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "NOT"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:437:11: ( ( 'i' | 'I' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'i' | 'I' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:437:13: ( 'i' | 'I' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'i' | 'I' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "IMAGECRS"
    public final void mIMAGECRS() throws RecognitionException {
        try {
            int _type = IMAGECRS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:438:9: ( ( 'i' | 'I' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) )
            // src/grammar/wcps.g:438:11: ( 'i' | 'I' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "IMAGECRS"

    // $ANTLR start "IMAGECRSDOMAIN"
    public final void mIMAGECRSDOMAIN() throws RecognitionException {
        try {
            int _type = IMAGECRSDOMAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:439:15: ( ( 'i' | 'I' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'd' | 'D' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:439:17: ( 'i' | 'I' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'd' | 'D' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "IMAGECRSDOMAIN"

    // $ANTLR start "CRSSET"
    public final void mCRSSET() throws RecognitionException {
        try {
            int _type = CRSSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:440:7: ( ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:440:9: ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "CRSSET"

    // $ANTLR start "DOMAIN"
    public final void mDOMAIN() throws RecognitionException {
        try {
            int _type = DOMAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:441:7: ( ( 'd' | 'D' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:441:9: ( 'd' | 'D' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "DOMAIN"

    // $ANTLR start "NULLSET"
    public final void mNULLSET() throws RecognitionException {
        try {
            int _type = NULLSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:442:8: ( ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:442:10: ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "NULLSET"

    // $ANTLR start "NULLDEFAULT"
    public final void mNULLDEFAULT() throws RecognitionException {
        try {
            int _type = NULLDEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:443:12: ( ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:443:14: ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "NULLDEFAULT"

    // $ANTLR start "INTERPOLATIONDEFAULT"
    public final void mINTERPOLATIONDEFAULT() throws RecognitionException {
        try {
            int _type = INTERPOLATIONDEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:444:21: ( ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:444:23: ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "INTERPOLATIONDEFAULT"

    // $ANTLR start "INTERPOLATIONSET"
    public final void mINTERPOLATIONSET() throws RecognitionException {
        try {
            int _type = INTERPOLATIONSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:445:17: ( ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:445:19: ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "INTERPOLATIONSET"

    // $ANTLR start "SETIDENTIFIER"
    public final void mSETIDENTIFIER() throws RecognitionException {
        try {
            int _type = SETIDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:446:14: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'i' | 'I' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:446:16: ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'f' | 'F' ) ( 'i' | 'I' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "SETIDENTIFIER"

    // $ANTLR start "SETNULLSET"
    public final void mSETNULLSET() throws RecognitionException {
        try {
            int _type = SETNULLSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:447:11: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:447:13: ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "SETNULLSET"

    // $ANTLR start "SETINTERPOLATIONDEFAULT"
    public final void mSETINTERPOLATIONDEFAULT() throws RecognitionException {
        try {
            int _type = SETINTERPOLATIONDEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:448:24: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:448:26: ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "SETINTERPOLATIONDEFAULT"

    // $ANTLR start "SETINTERPOLATIONSET"
    public final void mSETINTERPOLATIONSET() throws RecognitionException {
        try {
            int _type = SETINTERPOLATIONSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:449:20: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:449:21: ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'p' | 'P' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "SETINTERPOLATIONSET"

    // $ANTLR start "SETCRSSET"
    public final void mSETCRSSET() throws RecognitionException {
        try {
            int _type = SETCRSSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:450:10: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:450:12: ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "SETCRSSET"

    // $ANTLR start "TRIM"
    public final void mTRIM() throws RecognitionException {
        try {
            int _type = TRIM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:451:5: ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'm' | 'M' ) )
            // src/grammar/wcps.g:451:7: ( 't' | 'T' ) ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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
    // $ANTLR end "TRIM"

    // $ANTLR start "SLICE"
    public final void mSLICE() throws RecognitionException {
        try {
            int _type = SLICE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:452:6: ( ( 's' | 'S' ) ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'c' | 'C' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:452:8: ( 's' | 'S' ) ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'c' | 'C' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "SLICE"

    // $ANTLR start "EXTEND"
    public final void mEXTEND() throws RecognitionException {
        try {
            int _type = EXTEND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:453:7: ( ( 'e' | 'E' ) ( 'x' | 'X' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
            // src/grammar/wcps.g:453:9: ( 'e' | 'E' ) ( 'x' | 'X' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "EXTEND"

    // $ANTLR start "SCALE"
    public final void mSCALE() throws RecognitionException {
        try {
            int _type = SCALE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:454:6: ( ( 's' | 'S' ) ( 'c' | 'C' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:454:8: ( 's' | 'S' ) ( 'c' | 'C' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "SCALE"

    // $ANTLR start "CRSTRANSFORM"
    public final void mCRSTRANSFORM() throws RecognitionException {
        try {
            int _type = CRSTRANSFORM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:455:13: ( ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'm' | 'M' ) )
            // src/grammar/wcps.g:455:15: ( 'c' | 'C' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'm' | 'M' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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
    // $ANTLR end "CRSTRANSFORM"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:456:6: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:456:8: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "COUNT"

    // $ANTLR start "ADD"
    public final void mADD() throws RecognitionException {
        try {
            int _type = ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:457:4: ( ( 'a' | 'A' ) ( 'd' | 'D' ) ( 'd' | 'D' ) )
            // src/grammar/wcps.g:457:6: ( 'a' | 'A' ) ( 'd' | 'D' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "ADD"

    // $ANTLR start "AVG"
    public final void mAVG() throws RecognitionException {
        try {
            int _type = AVG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:458:4: ( ( 'a' | 'A' ) ( 'v' | 'V' ) ( 'g' | 'G' ) )
            // src/grammar/wcps.g:458:6: ( 'a' | 'A' ) ( 'v' | 'V' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
    // $ANTLR end "AVG"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:459:4: ( ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' ) )
            // src/grammar/wcps.g:459:6: ( 'm' | 'M' ) ( 'a' | 'A' ) ( 'x' | 'X' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
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
    // $ANTLR end "MAX"

    // $ANTLR start "MIN"
    public final void mMIN() throws RecognitionException {
        try {
            int _type = MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:460:4: ( ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:460:6: ( 'm' | 'M' ) ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "MIN"

    // $ANTLR start "SOME"
    public final void mSOME() throws RecognitionException {
        try {
            int _type = SOME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:461:5: ( ( 's' | 'S' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:461:7: ( 's' | 'S' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "SOME"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:462:4: ( ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
            // src/grammar/wcps.g:462:6: ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "ALL"

    // $ANTLR start "COVERAGE"
    public final void mCOVERAGE() throws RecognitionException {
        try {
            int _type = COVERAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:463:9: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'v' | 'V' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:463:11: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'v' | 'V' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "COVERAGE"

    // $ANTLR start "OVER"
    public final void mOVER() throws RecognitionException {
        try {
            int _type = OVER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:464:5: ( ( 'o' | 'O' ) ( 'v' | 'V' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:464:7: ( 'o' | 'O' ) ( 'v' | 'V' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "OVER"

    // $ANTLR start "VALUE"
    public final void mVALUE() throws RecognitionException {
        try {
            int _type = VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:465:6: ( ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'u' | 'U' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:465:8: ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'u' | 'U' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "VALUE"

    // $ANTLR start "VALUES"
    public final void mVALUES() throws RecognitionException {
        try {
            int _type = VALUES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:466:7: ( ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'u' | 'U' ) ( 'e' | 'E' ) ( 's' | 'S' ) )
            // src/grammar/wcps.g:466:9: ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'u' | 'U' ) ( 'e' | 'E' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "VALUES"

    // $ANTLR start "LIST"
    public final void mLIST() throws RecognitionException {
        try {
            int _type = LIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:467:5: ( ( 'l' | 'L' ) ( 'i' | 'I' ) ( 's' | 'S' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:467:7: ( 'l' | 'L' ) ( 'i' | 'I' ) ( 's' | 'S' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "LIST"

    // $ANTLR start "CONDENSE"
    public final void mCONDENSE() throws RecognitionException {
        try {
            int _type = CONDENSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:468:9: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:468:11: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "CONDENSE"

    // $ANTLR start "USING"
    public final void mUSING() throws RecognitionException {
        try {
            int _type = USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:469:6: ( ( 'u' | 'U' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' ) )
            // src/grammar/wcps.g:469:8: ( 'u' | 'U' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
    // $ANTLR end "USING"

    // $ANTLR start "NEAREST"
    public final void mNEAREST() throws RecognitionException {
        try {
            int _type = NEAREST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:470:8: ( ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'e' | 'E' ) ( 's' | 'S' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:470:10: ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'r' | 'R' ) ( 'e' | 'E' ) ( 's' | 'S' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "NEAREST"

    // $ANTLR start "LINEAR"
    public final void mLINEAR() throws RecognitionException {
        try {
            int _type = LINEAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:471:7: ( ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:471:9: ( 'l' | 'L' ) ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "LINEAR"

    // $ANTLR start "QUADRATIC"
    public final void mQUADRATIC() throws RecognitionException {
        try {
            int _type = QUADRATIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:472:10: ( ( 'q' | 'Q' ) ( 'u' | 'U' ) ( 'a' | 'A' ) ( 'd' | 'D' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'c' | 'C' ) )
            // src/grammar/wcps.g:472:12: ( 'q' | 'Q' ) ( 'u' | 'U' ) ( 'a' | 'A' ) ( 'd' | 'D' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'c' | 'C' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
    // $ANTLR end "QUADRATIC"

    // $ANTLR start "CUBIC"
    public final void mCUBIC() throws RecognitionException {
        try {
            int _type = CUBIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:473:6: ( ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 'i' | 'I' ) ( 'c' | 'C' ) )
            // src/grammar/wcps.g:473:8: ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 'i' | 'I' ) ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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
    // $ANTLR end "CUBIC"

    // $ANTLR start "FULL"
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:474:5: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
            // src/grammar/wcps.g:474:7: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "FULL"

    // $ANTLR start "NONE"
    public final void mNONE() throws RecognitionException {
        try {
            int _type = NONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:475:5: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:475:7: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "NONE"

    // $ANTLR start "HALF"
    public final void mHALF() throws RecognitionException {
        try {
            int _type = HALF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:476:5: ( ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'f' | 'F' ) )
            // src/grammar/wcps.g:476:7: ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'f' | 'F' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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
    // $ANTLR end "HALF"

    // $ANTLR start "OTHER"
    public final void mOTHER() throws RecognitionException {
        try {
            int _type = OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:477:6: ( ( 'o' | 'O' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:477:8: ( 'o' | 'O' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "OTHER"

    // $ANTLR start "PHI"
    public final void mPHI() throws RecognitionException {
        try {
            int _type = PHI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:478:4: ( ( 'p' | 'P' ) ( 'h' | 'H' ) ( 'i' | 'I' ) )
            // src/grammar/wcps.g:478:6: ( 'p' | 'P' ) ( 'h' | 'H' ) ( 'i' | 'I' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
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
    // $ANTLR end "PHI"

    // $ANTLR start "BIT"
    public final void mBIT() throws RecognitionException {
        try {
            int _type = BIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:479:4: ( ( 'b' | 'B' ) ( 'i' | 'I' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:479:6: ( 'b' | 'B' ) ( 'i' | 'I' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "BIT"

    // $ANTLR start "UNSIGNED"
    public final void mUNSIGNED() throws RecognitionException {
        try {
            int _type = UNSIGNED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:480:9: ( ( 'u' | 'U' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'd' | 'D' ) )
            // src/grammar/wcps.g:480:11: ( 'u' | 'U' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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
    // $ANTLR end "UNSIGNED"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:481:8: ( ( 'b' | 'B' ) ( 'o' | 'O' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'n' | 'N' ) )
            // src/grammar/wcps.g:481:10: ( 'b' | 'B' ) ( 'o' | 'O' ) ( 'o' | 'O' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:482:5: ( ( 'c' | 'C' ) ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'r' | 'R' ) )
            // src/grammar/wcps.g:482:7: ( 'c' | 'C' ) ( 'h' | 'H' ) ( 'a' | 'A' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "CHAR"

    // $ANTLR start "SHORT"
    public final void mSHORT() throws RecognitionException {
        try {
            int _type = SHORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:483:6: ( ( 's' | 'S' ) ( 'h' | 'H' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:483:8: ( 's' | 'S' ) ( 'h' | 'H' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "SHORT"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:484:5: ( ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'g' | 'G' ) )
            // src/grammar/wcps.g:484:7: ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 'g' | 'G' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
    // $ANTLR end "LONG"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:485:6: ( ( 'f' | 'F' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'a' | 'A' ) ( 't' | 'T' ) )
            // src/grammar/wcps.g:485:8: ( 'f' | 'F' ) ( 'l' | 'L' ) ( 'o' | 'O' ) ( 'a' | 'A' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "FLOAT"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:486:7: ( ( 'd' | 'D' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'e' | 'E' ) )
            // src/grammar/wcps.g:486:9: ( 'd' | 'D' ) ( 'o' | 'O' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "DOUBLE"

    // $ANTLR start "COMPLEX"
    public final void mCOMPLEX() throws RecognitionException {
        try {
            int _type = COMPLEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:487:8: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'p' | 'P' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'x' | 'X' ) )
            // src/grammar/wcps.g:487:10: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'p' | 'P' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'x' | 'X' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
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
    // $ANTLR end "COMPLEX"

    // $ANTLR start "COMPLEX2"
    public final void mCOMPLEX2() throws RecognitionException {
        try {
            int _type = COMPLEX2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:488:9: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'p' | 'P' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'x' | 'X' ) '2' )
            // src/grammar/wcps.g:488:11: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'm' | 'M' ) ( 'p' | 'P' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'x' | 'X' ) '2'
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('2'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMPLEX2"

    // $ANTLR start "BOOLEANCONSTANT"
    public final void mBOOLEANCONSTANT() throws RecognitionException {
        try {
            int _type = BOOLEANCONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:489:16: ( ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' ) ) | ( ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='T'||LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='F'||LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // src/grammar/wcps.g:489:18: ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' ) )
                    {
                    // src/grammar/wcps.g:489:18: ( ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' ) )
                    // src/grammar/wcps.g:489:19: ( 't' | 'T' ) ( 'r' | 'R' ) ( 'u' | 'U' ) ( 'e' | 'E' )
                    {
                    if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }


                    }
                    break;
                case 2 :
                    // src/grammar/wcps.g:489:57: ( ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' ) )
                    {
                    // src/grammar/wcps.g:489:57: ( ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' ) )
                    // src/grammar/wcps.g:489:58: ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 's' | 'S' ) ( 'e' | 'E' )
                    {
                    if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEANCONSTANT"

    // $ANTLR start "DECIMALCONSTANT"
    public final void mDECIMALCONSTANT() throws RecognitionException {
        try {
            // src/grammar/wcps.g:490:25: ( ( '1' .. '9' ) ( ( '0' .. '9' )* ) | '0' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>='1' && LA3_0<='9')) ) {
                alt3=1;
            }
            else if ( (LA3_0=='0') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // src/grammar/wcps.g:491:2: ( '1' .. '9' ) ( ( '0' .. '9' )* )
                    {
                    // src/grammar/wcps.g:491:2: ( '1' .. '9' )
                    // src/grammar/wcps.g:491:3: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // src/grammar/wcps.g:491:12: ( ( '0' .. '9' )* )
                    // src/grammar/wcps.g:491:13: ( '0' .. '9' )*
                    {
                    // src/grammar/wcps.g:491:13: ( '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // src/grammar/wcps.g:491:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // src/grammar/wcps.g:492:4: '0'
                    {
                    match('0'); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "DECIMALCONSTANT"

    // $ANTLR start "OCTALCONSTANT"
    public final void mOCTALCONSTANT() throws RecognitionException {
        try {
            // src/grammar/wcps.g:493:23: ( '0' ( '1' .. '7' ) ( ( '0' .. '7' )* ) )
            // src/grammar/wcps.g:494:2: '0' ( '1' .. '7' ) ( ( '0' .. '7' )* )
            {
            match('0'); 
            // src/grammar/wcps.g:494:6: ( '1' .. '7' )
            // src/grammar/wcps.g:494:7: '1' .. '7'
            {
            matchRange('1','7'); 

            }

            // src/grammar/wcps.g:494:17: ( ( '0' .. '7' )* )
            // src/grammar/wcps.g:494:18: ( '0' .. '7' )*
            {
            // src/grammar/wcps.g:494:18: ( '0' .. '7' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='7')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/grammar/wcps.g:494:19: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "OCTALCONSTANT"

    // $ANTLR start "HEXACONSTANT"
    public final void mHEXACONSTANT() throws RecognitionException {
        try {
            // src/grammar/wcps.g:495:22: ( ( '0x' | '0X' ) ( '1' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )* ) )
            // src/grammar/wcps.g:496:2: ( '0x' | '0X' ) ( '1' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )* )
            {
            // src/grammar/wcps.g:496:2: ( '0x' | '0X' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='x') ) {
                    alt5=1;
                }
                else if ( (LA5_1=='X') ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // src/grammar/wcps.g:496:3: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // src/grammar/wcps.g:496:8: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            if ( (input.LA(1)>='1' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // src/grammar/wcps.g:496:43: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )* )
            // src/grammar/wcps.g:496:44: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )*
            {
            // src/grammar/wcps.g:496:44: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='F')||(LA6_0>='a' && LA6_0<='f')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/grammar/wcps.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
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


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEXACONSTANT"

    // $ANTLR start "INTEGERCONSTANT"
    public final void mINTEGERCONSTANT() throws RecognitionException {
        try {
            int _type = INTEGERCONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:497:16: ( DECIMALCONSTANT | OCTALCONSTANT | HEXACONSTANT )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='1' && LA7_0<='9')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'X':
                case 'x':
                    {
                    alt7=3;
                    }
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt7=2;
                    }
                    break;
                default:
                    alt7=1;}

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // src/grammar/wcps.g:497:18: DECIMALCONSTANT
                    {
                    mDECIMALCONSTANT(); 

                    }
                    break;
                case 2 :
                    // src/grammar/wcps.g:497:36: OCTALCONSTANT
                    {
                    mOCTALCONSTANT(); 

                    }
                    break;
                case 3 :
                    // src/grammar/wcps.g:497:52: HEXACONSTANT
                    {
                    mHEXACONSTANT(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGERCONSTANT"

    // $ANTLR start "FLOATCONSTANT"
    public final void mFLOATCONSTANT() throws RecognitionException {
        try {
            int _type = FLOATCONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:498:14: ( DECIMALCONSTANT ( '.' ) ( ( '0' .. '9' )+ ) ( ( 'e' | 'E' ) ( ( '-' | '+' )? ) ( ( '0' .. '9' )+ ) )? )
            // src/grammar/wcps.g:498:16: DECIMALCONSTANT ( '.' ) ( ( '0' .. '9' )+ ) ( ( 'e' | 'E' ) ( ( '-' | '+' )? ) ( ( '0' .. '9' )+ ) )?
            {
            mDECIMALCONSTANT(); 
            // src/grammar/wcps.g:498:32: ( '.' )
            // src/grammar/wcps.g:498:33: '.'
            {
            match('.'); 

            }

            // src/grammar/wcps.g:498:37: ( ( '0' .. '9' )+ )
            // src/grammar/wcps.g:498:38: ( '0' .. '9' )+
            {
            // src/grammar/wcps.g:498:38: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/grammar/wcps.g:498:38: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            // src/grammar/wcps.g:498:48: ( ( 'e' | 'E' ) ( ( '-' | '+' )? ) ( ( '0' .. '9' )+ ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // src/grammar/wcps.g:498:49: ( 'e' | 'E' ) ( ( '-' | '+' )? ) ( ( '0' .. '9' )+ )
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // src/grammar/wcps.g:498:58: ( ( '-' | '+' )? )
                    // src/grammar/wcps.g:498:59: ( '-' | '+' )?
                    {
                    // src/grammar/wcps.g:498:59: ( '-' | '+' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='+'||LA9_0=='-') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // src/grammar/wcps.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }

                    // src/grammar/wcps.g:498:70: ( ( '0' .. '9' )+ )
                    // src/grammar/wcps.g:498:71: ( '0' .. '9' )+
                    {
                    // src/grammar/wcps.g:498:71: ( '0' .. '9' )+
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
                    	    // src/grammar/wcps.g:498:71: '0' .. '9'
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
    // $ANTLR end "FLOATCONSTANT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:500:7: ( '\"' ( options {greedy=false; } : . )* '\"' )
            // src/grammar/wcps.g:500:9: '\"' ( options {greedy=false; } : . )* '\"'
            {
            match('\"'); 
            // src/grammar/wcps.g:500:13: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\"') ) {
                    alt12=2;
                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='!')||(LA12_0>='#' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // src/grammar/wcps.g:500:41: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match('\"'); 
            setText(getText().substring(1, getText().length()-1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:501:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* ) )
            // src/grammar/wcps.g:501:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // src/grammar/wcps.g:501:30: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // src/grammar/wcps.g:501:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // src/grammar/wcps.g:501:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/grammar/wcps.g:
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
            	    break loop13;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "VARIABLE_DOLLAR"
    public final void mVARIABLE_DOLLAR() throws RecognitionException {
        try {
            int _type = VARIABLE_DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:502:16: ( '$' ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* ) )
            // src/grammar/wcps.g:502:18: '$' ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            {
            match('$'); 
            // src/grammar/wcps.g:502:21: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // src/grammar/wcps.g:502:22: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            // src/grammar/wcps.g:502:22: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // src/grammar/wcps.g:
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
            	    break loop14;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLE_DOLLAR"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/grammar/wcps.g:503:11: ( ( ' ' | '\\t' | '\\r' | '\\n' | '\\u000C' )+ )
            // src/grammar/wcps.g:503:13: ( ' ' | '\\t' | '\\r' | '\\n' | '\\u000C' )+
            {
            // src/grammar/wcps.g:503:13: ( ' ' | '\\t' | '\\r' | '\\n' | '\\u000C' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\t' && LA15_0<='\n')||(LA15_0>='\f' && LA15_0<='\r')||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // src/grammar/wcps.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // src/grammar/wcps.g:1:8: ( PLUS | MINUS | DIVIDE | MULT | EQUALS | NOTEQUALS | LT | GT | LTE | GTE | DOT | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | COMMA | COLON | SEMICOLON | FOR | IN | WHERE | RETURN | STORE | ENCODE | SQRT | SIN | COS | TAN | SINH | COSH | TANH | ARCSIN | ARCCOS | ARCTAN | EXP | LN | LOG | ROUND | ABS | OVERLAY | STRUCT | RE | IM | AND | OR | XOR | NOT | IDENTIFIER | IMAGECRS | IMAGECRSDOMAIN | CRSSET | DOMAIN | NULLSET | NULLDEFAULT | INTERPOLATIONDEFAULT | INTERPOLATIONSET | SETIDENTIFIER | SETNULLSET | SETINTERPOLATIONDEFAULT | SETINTERPOLATIONSET | SETCRSSET | TRIM | SLICE | EXTEND | SCALE | CRSTRANSFORM | COUNT | ADD | AVG | MAX | MIN | SOME | ALL | COVERAGE | OVER | VALUE | VALUES | LIST | CONDENSE | USING | NEAREST | LINEAR | QUADRATIC | CUBIC | FULL | NONE | HALF | OTHER | PHI | BIT | UNSIGNED | BOOLEAN | CHAR | SHORT | LONG | FLOAT | DOUBLE | COMPLEX | COMPLEX2 | BOOLEANCONSTANT | INTEGERCONSTANT | FLOATCONSTANT | STRING | NAME | VARIABLE_DOLLAR | WHITESPACE )
        int alt16=108;
        alt16 = dfa16.predict(input);
        switch (alt16) {
            case 1 :
                // src/grammar/wcps.g:1:10: PLUS
                {
                mPLUS(); 

                }
                break;
            case 2 :
                // src/grammar/wcps.g:1:15: MINUS
                {
                mMINUS(); 

                }
                break;
            case 3 :
                // src/grammar/wcps.g:1:21: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 4 :
                // src/grammar/wcps.g:1:28: MULT
                {
                mMULT(); 

                }
                break;
            case 5 :
                // src/grammar/wcps.g:1:33: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 6 :
                // src/grammar/wcps.g:1:40: NOTEQUALS
                {
                mNOTEQUALS(); 

                }
                break;
            case 7 :
                // src/grammar/wcps.g:1:50: LT
                {
                mLT(); 

                }
                break;
            case 8 :
                // src/grammar/wcps.g:1:53: GT
                {
                mGT(); 

                }
                break;
            case 9 :
                // src/grammar/wcps.g:1:56: LTE
                {
                mLTE(); 

                }
                break;
            case 10 :
                // src/grammar/wcps.g:1:60: GTE
                {
                mGTE(); 

                }
                break;
            case 11 :
                // src/grammar/wcps.g:1:64: DOT
                {
                mDOT(); 

                }
                break;
            case 12 :
                // src/grammar/wcps.g:1:68: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 13 :
                // src/grammar/wcps.g:1:75: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 14 :
                // src/grammar/wcps.g:1:82: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 15 :
                // src/grammar/wcps.g:1:91: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 16 :
                // src/grammar/wcps.g:1:100: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 17 :
                // src/grammar/wcps.g:1:107: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 18 :
                // src/grammar/wcps.g:1:114: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 19 :
                // src/grammar/wcps.g:1:120: COLON
                {
                mCOLON(); 

                }
                break;
            case 20 :
                // src/grammar/wcps.g:1:126: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 21 :
                // src/grammar/wcps.g:1:136: FOR
                {
                mFOR(); 

                }
                break;
            case 22 :
                // src/grammar/wcps.g:1:140: IN
                {
                mIN(); 

                }
                break;
            case 23 :
                // src/grammar/wcps.g:1:143: WHERE
                {
                mWHERE(); 

                }
                break;
            case 24 :
                // src/grammar/wcps.g:1:149: RETURN
                {
                mRETURN(); 

                }
                break;
            case 25 :
                // src/grammar/wcps.g:1:156: STORE
                {
                mSTORE(); 

                }
                break;
            case 26 :
                // src/grammar/wcps.g:1:162: ENCODE
                {
                mENCODE(); 

                }
                break;
            case 27 :
                // src/grammar/wcps.g:1:169: SQRT
                {
                mSQRT(); 

                }
                break;
            case 28 :
                // src/grammar/wcps.g:1:174: SIN
                {
                mSIN(); 

                }
                break;
            case 29 :
                // src/grammar/wcps.g:1:178: COS
                {
                mCOS(); 

                }
                break;
            case 30 :
                // src/grammar/wcps.g:1:182: TAN
                {
                mTAN(); 

                }
                break;
            case 31 :
                // src/grammar/wcps.g:1:186: SINH
                {
                mSINH(); 

                }
                break;
            case 32 :
                // src/grammar/wcps.g:1:191: COSH
                {
                mCOSH(); 

                }
                break;
            case 33 :
                // src/grammar/wcps.g:1:196: TANH
                {
                mTANH(); 

                }
                break;
            case 34 :
                // src/grammar/wcps.g:1:201: ARCSIN
                {
                mARCSIN(); 

                }
                break;
            case 35 :
                // src/grammar/wcps.g:1:208: ARCCOS
                {
                mARCCOS(); 

                }
                break;
            case 36 :
                // src/grammar/wcps.g:1:215: ARCTAN
                {
                mARCTAN(); 

                }
                break;
            case 37 :
                // src/grammar/wcps.g:1:222: EXP
                {
                mEXP(); 

                }
                break;
            case 38 :
                // src/grammar/wcps.g:1:226: LN
                {
                mLN(); 

                }
                break;
            case 39 :
                // src/grammar/wcps.g:1:229: LOG
                {
                mLOG(); 

                }
                break;
            case 40 :
                // src/grammar/wcps.g:1:233: ROUND
                {
                mROUND(); 

                }
                break;
            case 41 :
                // src/grammar/wcps.g:1:239: ABS
                {
                mABS(); 

                }
                break;
            case 42 :
                // src/grammar/wcps.g:1:243: OVERLAY
                {
                mOVERLAY(); 

                }
                break;
            case 43 :
                // src/grammar/wcps.g:1:251: STRUCT
                {
                mSTRUCT(); 

                }
                break;
            case 44 :
                // src/grammar/wcps.g:1:258: RE
                {
                mRE(); 

                }
                break;
            case 45 :
                // src/grammar/wcps.g:1:261: IM
                {
                mIM(); 

                }
                break;
            case 46 :
                // src/grammar/wcps.g:1:264: AND
                {
                mAND(); 

                }
                break;
            case 47 :
                // src/grammar/wcps.g:1:268: OR
                {
                mOR(); 

                }
                break;
            case 48 :
                // src/grammar/wcps.g:1:271: XOR
                {
                mXOR(); 

                }
                break;
            case 49 :
                // src/grammar/wcps.g:1:275: NOT
                {
                mNOT(); 

                }
                break;
            case 50 :
                // src/grammar/wcps.g:1:279: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 51 :
                // src/grammar/wcps.g:1:290: IMAGECRS
                {
                mIMAGECRS(); 

                }
                break;
            case 52 :
                // src/grammar/wcps.g:1:299: IMAGECRSDOMAIN
                {
                mIMAGECRSDOMAIN(); 

                }
                break;
            case 53 :
                // src/grammar/wcps.g:1:314: CRSSET
                {
                mCRSSET(); 

                }
                break;
            case 54 :
                // src/grammar/wcps.g:1:321: DOMAIN
                {
                mDOMAIN(); 

                }
                break;
            case 55 :
                // src/grammar/wcps.g:1:328: NULLSET
                {
                mNULLSET(); 

                }
                break;
            case 56 :
                // src/grammar/wcps.g:1:336: NULLDEFAULT
                {
                mNULLDEFAULT(); 

                }
                break;
            case 57 :
                // src/grammar/wcps.g:1:348: INTERPOLATIONDEFAULT
                {
                mINTERPOLATIONDEFAULT(); 

                }
                break;
            case 58 :
                // src/grammar/wcps.g:1:369: INTERPOLATIONSET
                {
                mINTERPOLATIONSET(); 

                }
                break;
            case 59 :
                // src/grammar/wcps.g:1:386: SETIDENTIFIER
                {
                mSETIDENTIFIER(); 

                }
                break;
            case 60 :
                // src/grammar/wcps.g:1:400: SETNULLSET
                {
                mSETNULLSET(); 

                }
                break;
            case 61 :
                // src/grammar/wcps.g:1:411: SETINTERPOLATIONDEFAULT
                {
                mSETINTERPOLATIONDEFAULT(); 

                }
                break;
            case 62 :
                // src/grammar/wcps.g:1:435: SETINTERPOLATIONSET
                {
                mSETINTERPOLATIONSET(); 

                }
                break;
            case 63 :
                // src/grammar/wcps.g:1:455: SETCRSSET
                {
                mSETCRSSET(); 

                }
                break;
            case 64 :
                // src/grammar/wcps.g:1:465: TRIM
                {
                mTRIM(); 

                }
                break;
            case 65 :
                // src/grammar/wcps.g:1:470: SLICE
                {
                mSLICE(); 

                }
                break;
            case 66 :
                // src/grammar/wcps.g:1:476: EXTEND
                {
                mEXTEND(); 

                }
                break;
            case 67 :
                // src/grammar/wcps.g:1:483: SCALE
                {
                mSCALE(); 

                }
                break;
            case 68 :
                // src/grammar/wcps.g:1:489: CRSTRANSFORM
                {
                mCRSTRANSFORM(); 

                }
                break;
            case 69 :
                // src/grammar/wcps.g:1:502: COUNT
                {
                mCOUNT(); 

                }
                break;
            case 70 :
                // src/grammar/wcps.g:1:508: ADD
                {
                mADD(); 

                }
                break;
            case 71 :
                // src/grammar/wcps.g:1:512: AVG
                {
                mAVG(); 

                }
                break;
            case 72 :
                // src/grammar/wcps.g:1:516: MAX
                {
                mMAX(); 

                }
                break;
            case 73 :
                // src/grammar/wcps.g:1:520: MIN
                {
                mMIN(); 

                }
                break;
            case 74 :
                // src/grammar/wcps.g:1:524: SOME
                {
                mSOME(); 

                }
                break;
            case 75 :
                // src/grammar/wcps.g:1:529: ALL
                {
                mALL(); 

                }
                break;
            case 76 :
                // src/grammar/wcps.g:1:533: COVERAGE
                {
                mCOVERAGE(); 

                }
                break;
            case 77 :
                // src/grammar/wcps.g:1:542: OVER
                {
                mOVER(); 

                }
                break;
            case 78 :
                // src/grammar/wcps.g:1:547: VALUE
                {
                mVALUE(); 

                }
                break;
            case 79 :
                // src/grammar/wcps.g:1:553: VALUES
                {
                mVALUES(); 

                }
                break;
            case 80 :
                // src/grammar/wcps.g:1:560: LIST
                {
                mLIST(); 

                }
                break;
            case 81 :
                // src/grammar/wcps.g:1:565: CONDENSE
                {
                mCONDENSE(); 

                }
                break;
            case 82 :
                // src/grammar/wcps.g:1:574: USING
                {
                mUSING(); 

                }
                break;
            case 83 :
                // src/grammar/wcps.g:1:580: NEAREST
                {
                mNEAREST(); 

                }
                break;
            case 84 :
                // src/grammar/wcps.g:1:588: LINEAR
                {
                mLINEAR(); 

                }
                break;
            case 85 :
                // src/grammar/wcps.g:1:595: QUADRATIC
                {
                mQUADRATIC(); 

                }
                break;
            case 86 :
                // src/grammar/wcps.g:1:605: CUBIC
                {
                mCUBIC(); 

                }
                break;
            case 87 :
                // src/grammar/wcps.g:1:611: FULL
                {
                mFULL(); 

                }
                break;
            case 88 :
                // src/grammar/wcps.g:1:616: NONE
                {
                mNONE(); 

                }
                break;
            case 89 :
                // src/grammar/wcps.g:1:621: HALF
                {
                mHALF(); 

                }
                break;
            case 90 :
                // src/grammar/wcps.g:1:626: OTHER
                {
                mOTHER(); 

                }
                break;
            case 91 :
                // src/grammar/wcps.g:1:632: PHI
                {
                mPHI(); 

                }
                break;
            case 92 :
                // src/grammar/wcps.g:1:636: BIT
                {
                mBIT(); 

                }
                break;
            case 93 :
                // src/grammar/wcps.g:1:640: UNSIGNED
                {
                mUNSIGNED(); 

                }
                break;
            case 94 :
                // src/grammar/wcps.g:1:649: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 95 :
                // src/grammar/wcps.g:1:657: CHAR
                {
                mCHAR(); 

                }
                break;
            case 96 :
                // src/grammar/wcps.g:1:662: SHORT
                {
                mSHORT(); 

                }
                break;
            case 97 :
                // src/grammar/wcps.g:1:668: LONG
                {
                mLONG(); 

                }
                break;
            case 98 :
                // src/grammar/wcps.g:1:673: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 99 :
                // src/grammar/wcps.g:1:679: DOUBLE
                {
                mDOUBLE(); 

                }
                break;
            case 100 :
                // src/grammar/wcps.g:1:686: COMPLEX
                {
                mCOMPLEX(); 

                }
                break;
            case 101 :
                // src/grammar/wcps.g:1:694: COMPLEX2
                {
                mCOMPLEX2(); 

                }
                break;
            case 102 :
                // src/grammar/wcps.g:1:703: BOOLEANCONSTANT
                {
                mBOOLEANCONSTANT(); 

                }
                break;
            case 103 :
                // src/grammar/wcps.g:1:719: INTEGERCONSTANT
                {
                mINTEGERCONSTANT(); 

                }
                break;
            case 104 :
                // src/grammar/wcps.g:1:735: FLOATCONSTANT
                {
                mFLOATCONSTANT(); 

                }
                break;
            case 105 :
                // src/grammar/wcps.g:1:749: STRING
                {
                mSTRING(); 

                }
                break;
            case 106 :
                // src/grammar/wcps.g:1:756: NAME
                {
                mNAME(); 

                }
                break;
            case 107 :
                // src/grammar/wcps.g:1:761: VARIABLE_DOLLAR
                {
                mVARIABLE_DOLLAR(); 

                }
                break;
            case 108 :
                // src/grammar/wcps.g:1:777: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\7\uffff\1\57\1\61\12\uffff\25\53\2\150\10\uffff\4\53\1\157\1\161"+
        "\2\53\1\165\27\53\1\u0094\3\53\1\u009a\20\53\1\150\2\uffff\1\u00ad"+
        "\4\53\1\uffff\1\53\1\uffff\3\53\1\uffff\4\53\1\u00bb\6\53\1\u00c4"+
        "\1\53\1\u00c7\7\53\1\u00d1\3\53\1\u00d7\1\u00d8\1\u00d9\1\u00da"+
        "\1\u00db\1\uffff\1\u00dc\4\53\1\uffff\1\53\1\u00e2\1\u00e3\5\53"+
        "\1\u00e9\1\u00ea\5\53\1\u00f0\1\u00f1\1\53\1\uffff\1\u00f3\12\53"+
        "\1\u00fe\1\u00ff\1\uffff\5\53\1\u0106\2\53\1\uffff\1\53\1\u010a"+
        "\1\uffff\7\53\1\u0112\1\u0113\1\uffff\1\u0114\1\u0115\3\53\6\uffff"+
        "\1\u0119\1\u011a\1\53\1\u011d\1\53\2\uffff\1\u011f\4\53\2\uffff"+
        "\4\53\1\u0129\2\uffff\1\53\1\uffff\1\u012b\1\u0115\3\53\1\u012f"+
        "\1\53\1\u0131\1\u0132\1\53\2\uffff\4\53\1\u0138\1\u0139\1\uffff"+
        "\1\u013a\2\53\1\uffff\1\u013d\5\53\1\u0143\4\uffff\3\53\2\uffff"+
        "\2\53\1\uffff\1\u0149\1\uffff\5\53\1\u0150\1\u0151\2\53\1\uffff"+
        "\1\53\1\uffff\3\53\1\uffff\1\u0158\2\uffff\1\u0159\4\53\3\uffff"+
        "\1\u015e\1\u015f\1\uffff\3\53\1\u0163\1\53\1\uffff\1\u0165\1\u0166"+
        "\1\u0167\1\u0168\1\53\1\uffff\3\53\1\u016d\1\u016e\1\u016f\2\uffff"+
        "\6\53\2\uffff\4\53\2\uffff\2\53\1\u017d\1\uffff\1\53\4\uffff\1\u017f"+
        "\1\u0180\1\53\1\u0182\3\uffff\2\53\1\u0185\1\53\1\u0188\5\53\1\u018e"+
        "\1\u018f\1\u0190\1\uffff\1\53\2\uffff\1\53\1\uffff\1\u0193\1\53"+
        "\1\uffff\2\53\1\uffff\4\53\1\u019b\3\uffff\2\53\1\uffff\1\u019e"+
        "\2\53\1\u01a1\2\53\1\u01a4\1\uffff\2\53\1\uffff\2\53\1\uffff\2\53"+
        "\1\uffff\1\53\1\u01ac\4\53\1\u01b1\1\uffff\2\53\1\u01b5\1\53\1\uffff"+
        "\2\53\1\u01b9\1\uffff\3\53\1\uffff\2\53\1\u01bf\2\53\1\uffff\7\53"+
        "\1\u01ca\1\u01cb\1\53\2\uffff\2\53\1\u01cf\1\uffff";
    static final String DFA16_eofS =
        "\u01d0\uffff";
    static final String DFA16_minS =
        "\1\11\6\uffff\2\75\12\uffff\1\101\1\104\1\110\1\105\1\103\1\116"+
        "\1\110\1\101\1\102\1\111\1\122\1\117\1\105\1\117\2\101\1\116\1\125"+
        "\1\101\1\110\1\111\2\56\10\uffff\1\122\1\114\1\117\1\114\2\60\2"+
        "\105\1\60\1\125\1\117\1\122\1\116\1\124\1\111\1\101\1\115\1\117"+
        "\1\103\1\120\1\115\1\123\1\102\1\101\1\116\1\111\1\103\1\123\2\104"+
        "\1\107\1\114\1\60\1\107\1\116\1\105\1\60\1\110\1\122\1\116\1\114"+
        "\1\101\1\115\1\130\1\116\1\114\1\111\1\123\1\101\1\114\1\111\1\124"+
        "\1\117\1\56\2\uffff\1\60\1\114\1\101\1\123\1\105\1\uffff\1\107\1"+
        "\uffff\1\116\1\122\1\125\1\uffff\1\116\1\122\1\125\1\124\1\60\2"+
        "\103\1\114\1\105\1\122\1\117\1\60\1\105\1\60\1\116\1\105\1\104\1"+
        "\120\1\123\1\111\1\122\1\60\1\115\1\105\1\103\5\60\1\uffff\1\60"+
        "\1\107\1\124\1\105\1\122\1\uffff\1\105\2\60\1\105\1\114\1\122\1"+
        "\101\1\102\2\60\1\125\1\116\1\111\1\104\1\106\2\60\1\114\1\uffff"+
        "\1\60\1\124\1\105\1\122\1\105\1\124\1\105\1\122\1\104\1\105\1\103"+
        "\2\60\1\uffff\1\104\1\125\1\122\2\105\1\60\1\124\1\104\1\uffff\1"+
        "\116\1\60\1\uffff\1\124\1\122\1\105\1\114\1\105\1\122\1\103\2\60"+
        "\1\uffff\2\60\1\111\1\117\1\101\6\uffff\2\60\1\101\1\60\1\122\2"+
        "\uffff\1\60\1\104\1\105\1\111\1\114\2\uffff\1\105\2\107\1\122\1"+
        "\60\2\uffff\1\105\1\uffff\2\60\1\120\1\103\1\111\1\60\1\116\2\60"+
        "\1\124\2\uffff\1\105\1\124\1\114\1\123\2\60\1\uffff\1\60\1\105\1"+
        "\104\1\uffff\1\60\1\101\1\116\1\105\1\124\1\101\1\60\4\uffff\1\116"+
        "\1\123\1\116\2\uffff\1\122\1\101\1\uffff\1\60\1\uffff\2\105\1\123"+
        "\1\116\1\105\2\60\1\116\1\101\1\uffff\1\101\1\uffff\1\117\1\122"+
        "\1\106\1\uffff\1\60\2\uffff\1\60\1\116\1\105\1\114\1\123\3\uffff"+
        "\2\60\1\uffff\1\107\1\123\1\130\1\60\1\116\1\uffff\4\60\1\131\1"+
        "\uffff\1\124\1\106\1\124\3\60\2\uffff\1\105\1\124\1\116\1\114\1"+
        "\123\1\111\2\uffff\1\124\1\122\1\123\1\105\2\uffff\2\105\1\60\1"+
        "\uffff\1\123\4\uffff\2\60\1\101\1\60\3\uffff\1\104\1\111\1\60\1"+
        "\101\1\60\1\105\1\111\1\120\1\105\1\124\3\60\1\uffff\1\106\2\uffff"+
        "\1\125\1\uffff\1\60\1\103\1\uffff\1\124\1\117\1\uffff\1\122\1\106"+
        "\1\117\1\124\1\60\3\uffff\1\117\1\114\1\uffff\1\60\1\111\1\115\1"+
        "\60\1\111\1\114\1\60\1\uffff\1\122\1\124\1\uffff\1\117\1\101\1\uffff"+
        "\1\105\1\101\1\uffff\1\115\1\60\1\116\1\111\1\122\1\124\1\60\1\uffff"+
        "\1\104\1\116\1\60\1\111\1\uffff\2\105\1\60\1\uffff\1\117\1\106\1"+
        "\124\1\uffff\1\116\1\101\1\60\1\104\1\125\1\uffff\2\105\1\114\1"+
        "\106\2\124\1\101\2\60\1\125\2\uffff\1\114\1\124\1\60\1\uffff";
    static final String DFA16_maxS =
        "\1\175\6\uffff\2\75\12\uffff\1\165\1\156\1\150\1\157\1\164\1\170"+
        "\1\165\1\162\1\166\1\157\1\166\1\157\1\165\1\157\1\151\1\141\1\163"+
        "\1\165\1\141\1\150\1\157\1\71\1\56\10\uffff\1\162\1\154\1\157\1"+
        "\154\2\172\2\145\1\172\1\165\2\162\1\156\1\164\1\151\1\141\1\155"+
        "\1\157\1\143\1\164\1\166\1\163\1\142\1\141\1\156\1\165\1\143\1\163"+
        "\2\144\1\147\1\154\1\172\1\156\1\163\1\145\1\172\1\150\1\162\1\164"+
        "\1\154\1\141\1\165\1\170\1\156\1\154\1\151\1\163\1\141\1\154\1\151"+
        "\1\164\1\157\1\71\2\uffff\1\172\1\154\1\141\1\163\1\145\1\uffff"+
        "\1\147\1\uffff\1\156\1\162\1\165\1\uffff\1\156\1\162\1\165\1\164"+
        "\1\172\1\156\1\143\1\154\1\145\1\162\1\157\1\172\1\145\1\172\1\156"+
        "\1\145\1\144\1\160\1\164\1\151\1\162\1\172\1\155\1\145\1\164\5\172"+
        "\1\uffff\1\172\1\147\1\164\1\145\1\162\1\uffff\1\145\2\172\1\145"+
        "\1\154\1\162\1\141\1\142\2\172\1\165\1\156\1\151\1\144\1\146\2\172"+
        "\1\154\1\uffff\1\172\1\164\1\145\1\162\1\145\1\164\1\145\1\162\1"+
        "\144\1\145\1\143\2\172\1\uffff\1\156\1\165\1\162\2\145\1\172\1\164"+
        "\1\144\1\uffff\1\156\1\172\1\uffff\1\164\1\162\1\145\1\154\1\145"+
        "\1\162\1\143\2\172\1\uffff\2\172\1\151\1\157\1\141\6\uffff\2\172"+
        "\1\141\1\172\1\162\2\uffff\1\172\1\163\1\145\1\151\1\154\2\uffff"+
        "\1\145\2\147\1\162\1\172\2\uffff\1\145\1\uffff\2\172\1\160\1\143"+
        "\1\151\1\172\1\156\2\172\1\164\2\uffff\1\145\1\164\1\154\1\163\2"+
        "\172\1\uffff\1\172\1\145\1\144\1\uffff\1\172\1\141\1\156\1\145\1"+
        "\164\1\141\1\172\4\uffff\1\156\1\163\1\156\2\uffff\1\162\1\141\1"+
        "\uffff\1\172\1\uffff\2\145\1\163\1\156\1\145\2\172\1\156\1\141\1"+
        "\uffff\1\141\1\uffff\1\157\1\162\1\146\1\uffff\1\172\2\uffff\1\172"+
        "\1\156\1\145\1\154\1\163\3\uffff\2\172\1\uffff\1\147\1\163\1\170"+
        "\1\172\1\156\1\uffff\4\172\1\171\1\uffff\1\164\1\146\1\164\3\172"+
        "\2\uffff\1\145\1\164\1\156\1\154\1\163\1\151\2\uffff\1\164\1\162"+
        "\1\163\1\145\2\uffff\2\145\1\172\1\uffff\1\163\4\uffff\2\172\1\141"+
        "\1\172\3\uffff\1\144\1\151\1\172\1\141\1\172\1\145\1\151\1\160\1"+
        "\145\1\164\3\172\1\uffff\1\146\2\uffff\1\165\1\uffff\1\172\1\143"+
        "\1\uffff\1\164\1\157\1\uffff\1\162\1\146\1\157\1\164\1\172\3\uffff"+
        "\1\157\1\154\1\uffff\1\172\1\151\1\155\1\172\1\151\1\154\1\172\1"+
        "\uffff\1\162\1\164\1\uffff\1\157\1\141\1\uffff\1\145\1\141\1\uffff"+
        "\1\155\1\172\1\156\1\151\1\162\1\164\1\172\1\uffff\1\163\1\156\1"+
        "\172\1\151\1\uffff\2\145\1\172\1\uffff\1\157\1\146\1\164\1\uffff"+
        "\1\156\1\141\1\172\1\163\1\165\1\uffff\2\145\1\154\1\146\2\164\1"+
        "\141\2\172\1\165\2\uffff\1\154\1\164\1\172\1\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\13\1\14\1\15\1\16\1\17"+
        "\1\20\1\21\1\22\1\23\1\24\27\uffff\1\151\1\152\1\153\1\154\1\11"+
        "\1\7\1\12\1\10\66\uffff\1\147\1\150\5\uffff\1\26\1\uffff\1\55\3"+
        "\uffff\1\54\36\uffff\1\46\5\uffff\1\57\22\uffff\1\25\15\uffff\1"+
        "\34\10\uffff\1\45\2\uffff\1\35\11\uffff\1\36\5\uffff\1\51\1\56\1"+
        "\106\1\107\1\113\1\47\5\uffff\1\60\1\61\5\uffff\1\110\1\111\5\uffff"+
        "\1\133\1\134\1\uffff\1\127\12\uffff\1\33\1\37\6\uffff\1\112\3\uffff"+
        "\1\40\7\uffff\1\137\1\41\1\100\1\146\3\uffff\1\141\1\120\2\uffff"+
        "\1\115\1\uffff\1\130\11\uffff\1\131\1\uffff\1\142\3\uffff\1\27\1"+
        "\uffff\1\50\1\31\5\uffff\1\101\1\103\1\140\2\uffff\1\105\5\uffff"+
        "\1\126\5\uffff\1\132\6\uffff\1\116\1\122\6\uffff\1\30\1\53\4\uffff"+
        "\1\32\1\102\3\uffff\1\65\1\uffff\1\42\1\43\1\44\1\124\4\uffff\1"+
        "\66\1\143\1\117\15\uffff\1\144\1\uffff\1\52\1\67\1\uffff\1\123\2"+
        "\uffff\1\136\2\uffff\1\63\5\uffff\1\114\1\121\1\145\2\uffff\1\135"+
        "\7\uffff\1\77\2\uffff\1\125\2\uffff\1\62\2\uffff\1\74\7\uffff\1"+
        "\70\4\uffff\1\104\3\uffff\1\73\3\uffff\1\64\5\uffff\1\72\12\uffff"+
        "\1\76\1\71\3\uffff\1\75";
    static final String DFA16_specialS =
        "\u01d0\uffff}>";
    static final String[] DFA16_transitionS = {
            "\2\55\1\uffff\2\55\22\uffff\1\55\1\6\1\52\1\uffff\1\54\3\uffff"+
            "\1\12\1\13\1\4\1\1\1\20\1\2\1\11\1\3\1\51\11\50\1\21\1\22\1"+
            "\7\1\5\1\10\2\uffff\1\33\1\47\1\31\1\40\1\30\1\23\1\53\1\45"+
            "\1\24\2\53\1\34\1\41\1\37\1\35\1\46\1\44\1\26\1\27\1\32\1\43"+
            "\1\42\1\25\1\36\2\53\1\14\1\uffff\1\15\1\uffff\1\53\1\uffff"+
            "\1\33\1\47\1\31\1\40\1\30\1\23\1\53\1\45\1\24\2\53\1\34\1\41"+
            "\1\37\1\35\1\46\1\44\1\26\1\27\1\32\1\43\1\42\1\25\1\36\2\53"+
            "\1\16\1\uffff\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\60",
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
            "\1\65\12\uffff\1\64\2\uffff\1\62\5\uffff\1\63\13\uffff\1\65"+
            "\12\uffff\1\64\2\uffff\1\62\5\uffff\1\63",
            "\1\70\10\uffff\1\67\1\66\25\uffff\1\70\10\uffff\1\67\1\66",
            "\1\71\37\uffff\1\71",
            "\1\72\11\uffff\1\73\25\uffff\1\72\11\uffff\1\73",
            "\1\101\1\uffff\1\77\2\uffff\1\103\1\76\2\uffff\1\100\2\uffff"+
            "\1\102\1\uffff\1\75\2\uffff\1\74\16\uffff\1\101\1\uffff\1\77"+
            "\2\uffff\1\103\1\76\2\uffff\1\100\2\uffff\1\102\1\uffff\1\75"+
            "\2\uffff\1\74",
            "\1\104\11\uffff\1\105\25\uffff\1\104\11\uffff\1\105",
            "\1\111\6\uffff\1\106\2\uffff\1\107\2\uffff\1\110\22\uffff\1"+
            "\111\6\uffff\1\106\2\uffff\1\107\2\uffff\1\110",
            "\1\112\20\uffff\1\113\16\uffff\1\112\20\uffff\1\113",
            "\1\115\1\uffff\1\117\7\uffff\1\121\1\uffff\1\116\3\uffff\1"+
            "\114\3\uffff\1\120\13\uffff\1\115\1\uffff\1\117\7\uffff\1\121"+
            "\1\uffff\1\116\3\uffff\1\114\3\uffff\1\120",
            "\1\124\4\uffff\1\122\1\123\31\uffff\1\124\4\uffff\1\122\1\123",
            "\1\126\1\uffff\1\127\1\uffff\1\125\33\uffff\1\126\1\uffff\1"+
            "\127\1\uffff\1\125",
            "\1\130\37\uffff\1\130",
            "\1\133\11\uffff\1\131\5\uffff\1\132\17\uffff\1\133\11\uffff"+
            "\1\131\5\uffff\1\132",
            "\1\134\37\uffff\1\134",
            "\1\135\7\uffff\1\136\27\uffff\1\135\7\uffff\1\136",
            "\1\137\37\uffff\1\137",
            "\1\141\4\uffff\1\140\32\uffff\1\141\4\uffff\1\140",
            "\1\142\37\uffff\1\142",
            "\1\143\37\uffff\1\143",
            "\1\144\37\uffff\1\144",
            "\1\145\5\uffff\1\146\31\uffff\1\145\5\uffff\1\146",
            "\1\151\1\uffff\12\147",
            "\1\151",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "\1\154\37\uffff\1\154",
            "\1\155\37\uffff\1\155",
            "\12\53\7\uffff\23\53\1\156\6\53\4\uffff\1\53\1\uffff\23\53"+
            "\1\156\6\53",
            "\12\53\7\uffff\1\160\31\53\4\uffff\1\53\1\uffff\1\160\31\53",
            "\1\162\37\uffff\1\162",
            "\1\163\37\uffff\1\163",
            "\12\53\7\uffff\23\53\1\164\6\53\4\uffff\1\53\1\uffff\23\53"+
            "\1\164\6\53",
            "\1\166\37\uffff\1\166",
            "\1\167\2\uffff\1\170\34\uffff\1\167\2\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "\1\173\37\uffff\1\173",
            "\1\174\37\uffff\1\174",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "\1\u0080\37\uffff\1\u0080",
            "\1\u0081\3\uffff\1\u0082\33\uffff\1\u0081\3\uffff\1\u0082",
            "\1\u0087\1\u0086\4\uffff\1\u0083\1\uffff\1\u0084\1\u0085\26"+
            "\uffff\1\u0087\1\u0086\4\uffff\1\u0083\1\uffff\1\u0084\1\u0085",
            "\1\u0088\37\uffff\1\u0088",
            "\1\u0089\37\uffff\1\u0089",
            "\1\u008a\37\uffff\1\u008a",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\13\uffff\1\u008d\23\uffff\1\u008c\13\uffff\1\u008d",
            "\1\u008e\37\uffff\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0095\6\uffff\1\u0096\30\uffff\1\u0095\6\uffff\1\u0096",
            "\1\u0098\4\uffff\1\u0097\32\uffff\1\u0098\4\uffff\1\u0097",
            "\1\u0099\37\uffff\1\u0099",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c\37\uffff\1\u009c",
            "\1\u009e\5\uffff\1\u009d\31\uffff\1\u009e\5\uffff\1\u009d",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\7\uffff\1\u00a2\27\uffff\1\u00a1\7\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ab\37\uffff\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\151\1\uffff\12\147",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "\1\u00b1\37\uffff\1\u00b1",
            "",
            "\1\u00b2\37\uffff\1\u00b2",
            "",
            "\1\u00b3\37\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\u00b7\37\uffff\1\u00b7",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\u00b9\37\uffff\1\u00b9",
            "\12\53\7\uffff\7\53\1\u00ba\22\53\4\uffff\1\53\1\uffff\7\53"+
            "\1\u00ba\22\53",
            "\1\u00be\5\uffff\1\u00bc\4\uffff\1\u00bd\24\uffff\1\u00be\5"+
            "\uffff\1\u00bc\4\uffff\1\u00bd",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\u00c3\37\uffff\1\u00c3",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00c5\37\uffff\1\u00c5",
            "\12\53\7\uffff\7\53\1\u00c6\22\53\4\uffff\1\53\1\uffff\7\53"+
            "\1\u00c6\22\53",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cc\1\u00cd\36\uffff\1\u00cc\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf\37\uffff\1\u00cf",
            "\12\53\7\uffff\7\53\1\u00d0\22\53\4\uffff\1\53\1\uffff\7\53"+
            "\1\u00d0\22\53",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\u00d5\17\uffff\1\u00d4\1\u00d6\16\uffff\1\u00d5\17\uffff"+
            "\1\u00d4\1\u00d6",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\1\u00df\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00e0",
            "",
            "\1\u00e1\37\uffff\1\u00e1",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\u00e8\37\uffff\1\u00e8",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\u00ed\37\uffff\1\u00ed",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\u00ef\37\uffff\1\u00ef",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00f2\37\uffff\1\u00f2",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "\1\u00fa\37\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "\1\u00fd\37\uffff\1\u00fd",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u0100\11\uffff\1\u0101\25\uffff\1\u0100\11\uffff\1\u0101",
            "\1\u0102\37\uffff\1\u0102",
            "\1\u0103\37\uffff\1\u0103",
            "\1\u0104\37\uffff\1\u0104",
            "\1\u0105\37\uffff\1\u0105",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "",
            "\1\u0109\37\uffff\1\u0109",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u010b\37\uffff\1\u010b",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\37\uffff\1\u010d",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f\37\uffff\1\u010f",
            "\1\u0110\37\uffff\1\u0110",
            "\1\u0111\37\uffff\1\u0111",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0116\37\uffff\1\u0116",
            "\1\u0117\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0118",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u011b\37\uffff\1\u011b",
            "\12\53\7\uffff\13\53\1\u011c\16\53\4\uffff\1\53\1\uffff\13"+
            "\53\1\u011c\16\53",
            "\1\u011e\37\uffff\1\u011e",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0121\16\uffff\1\u0120\20\uffff\1\u0121\16\uffff\1\u0120",
            "\1\u0122\37\uffff\1\u0122",
            "\1\u0123\37\uffff\1\u0123",
            "\1\u0124\37\uffff\1\u0124",
            "",
            "",
            "\1\u0125\37\uffff\1\u0125",
            "\1\u0126\37\uffff\1\u0126",
            "\1\u0127\37\uffff\1\u0127",
            "\1\u0128\37\uffff\1\u0128",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\1\u012a\37\uffff\1\u012a",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u012c\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012e",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0130\37\uffff\1\u0130",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0133\37\uffff\1\u0133",
            "",
            "",
            "\1\u0134\37\uffff\1\u0134",
            "\1\u0135\37\uffff\1\u0135",
            "\1\u0136\37\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u013b\37\uffff\1\u013b",
            "\1\u013c\37\uffff\1\u013c",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u013e\37\uffff\1\u013e",
            "\1\u013f\37\uffff\1\u013f",
            "\1\u0140\37\uffff\1\u0140",
            "\1\u0141\37\uffff\1\u0141",
            "\1\u0142\37\uffff\1\u0142",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "",
            "\1\u0144\37\uffff\1\u0144",
            "\1\u0145\37\uffff\1\u0145",
            "\1\u0146\37\uffff\1\u0146",
            "",
            "",
            "\1\u0147\37\uffff\1\u0147",
            "\1\u0148\37\uffff\1\u0148",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u014a\37\uffff\1\u014a",
            "\1\u014b\37\uffff\1\u014b",
            "\1\u014c\37\uffff\1\u014c",
            "\1\u014d\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014e",
            "\12\53\7\uffff\22\53\1\u014f\7\53\4\uffff\1\53\1\uffff\22\53"+
            "\1\u014f\7\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0152\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0153",
            "",
            "\1\u0154\37\uffff\1\u0154",
            "",
            "\1\u0155\37\uffff\1\u0155",
            "\1\u0156\37\uffff\1\u0156",
            "\1\u0157\37\uffff\1\u0157",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u015a\37\uffff\1\u015a",
            "\1\u015b\37\uffff\1\u015b",
            "\1\u015c\37\uffff\1\u015c",
            "\1\u015d\37\uffff\1\u015d",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u0160\37\uffff\1\u0160",
            "\1\u0161\37\uffff\1\u0161",
            "\1\u0162\37\uffff\1\u0162",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0164\37\uffff\1\u0164",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0169\37\uffff\1\u0169",
            "",
            "\1\u016a\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016b",
            "\1\u016c\37\uffff\1\u016c",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\1\u0170\37\uffff\1\u0170",
            "\1\u0171\37\uffff\1\u0171",
            "\1\u0172\37\uffff\1\u0172",
            "\1\u0173\37\uffff\1\u0173",
            "\1\u0174\37\uffff\1\u0174",
            "\1\u0175\37\uffff\1\u0175",
            "",
            "",
            "\1\u0176\37\uffff\1\u0176",
            "\1\u0177\37\uffff\1\u0177",
            "\1\u0178\37\uffff\1\u0178",
            "\1\u0179\37\uffff\1\u0179",
            "",
            "",
            "\1\u017a\37\uffff\1\u017a",
            "\1\u017b\37\uffff\1\u017b",
            "\2\53\1\u017c\7\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u017e\37\uffff\1\u017e",
            "",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0181\37\uffff\1\u0181",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "\1\u0183\37\uffff\1\u0183",
            "\1\u0184\37\uffff\1\u0184",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0186\37\uffff\1\u0186",
            "\12\53\7\uffff\3\53\1\u0187\26\53\4\uffff\1\53\1\uffff\3\53"+
            "\1\u0187\26\53",
            "\1\u0189\37\uffff\1\u0189",
            "\1\u018a\37\uffff\1\u018a",
            "\1\u018b\37\uffff\1\u018b",
            "\1\u018c\37\uffff\1\u018c",
            "\1\u018d\37\uffff\1\u018d",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u0191\37\uffff\1\u0191",
            "",
            "",
            "\1\u0192\37\uffff\1\u0192",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0194\37\uffff\1\u0194",
            "",
            "\1\u0195\37\uffff\1\u0195",
            "\1\u0196\37\uffff\1\u0196",
            "",
            "\1\u0197\37\uffff\1\u0197",
            "\1\u0198\37\uffff\1\u0198",
            "\1\u0199\37\uffff\1\u0199",
            "\1\u019a\37\uffff\1\u019a",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "\1\u019c\37\uffff\1\u019c",
            "\1\u019d\37\uffff\1\u019d",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u019f\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a0",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01a2\37\uffff\1\u01a2",
            "\1\u01a3\37\uffff\1\u01a3",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01a5\37\uffff\1\u01a5",
            "\1\u01a6\37\uffff\1\u01a6",
            "",
            "\1\u01a7\37\uffff\1\u01a7",
            "\1\u01a8\37\uffff\1\u01a8",
            "",
            "\1\u01a9\37\uffff\1\u01a9",
            "\1\u01aa\37\uffff\1\u01aa",
            "",
            "\1\u01ab\37\uffff\1\u01ab",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01ad\37\uffff\1\u01ad",
            "\1\u01ae\37\uffff\1\u01ae",
            "\1\u01af\37\uffff\1\u01af",
            "\1\u01b0\37\uffff\1\u01b0",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01b2\16\uffff\1\u01b3\20\uffff\1\u01b2\16\uffff\1\u01b3",
            "\1\u01b4\37\uffff\1\u01b4",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01b6\37\uffff\1\u01b6",
            "",
            "\1\u01b7\37\uffff\1\u01b7",
            "\1\u01b8\37\uffff\1\u01b8",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u01ba\37\uffff\1\u01ba",
            "\1\u01bb\37\uffff\1\u01bb",
            "\1\u01bc\37\uffff\1\u01bc",
            "",
            "\1\u01bd\37\uffff\1\u01bd",
            "\1\u01be\37\uffff\1\u01be",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01c0\16\uffff\1\u01c1\20\uffff\1\u01c0\16\uffff\1\u01c1",
            "\1\u01c2\37\uffff\1\u01c2",
            "",
            "\1\u01c3\37\uffff\1\u01c3",
            "\1\u01c4\37\uffff\1\u01c4",
            "\1\u01c5\37\uffff\1\u01c5",
            "\1\u01c6\37\uffff\1\u01c6",
            "\1\u01c7\37\uffff\1\u01c7",
            "\1\u01c8\37\uffff\1\u01c8",
            "\1\u01c9\37\uffff\1\u01c9",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u01cc\37\uffff\1\u01cc",
            "",
            "",
            "\1\u01cd\37\uffff\1\u01cd",
            "\1\u01ce\37\uffff\1\u01ce",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( PLUS | MINUS | DIVIDE | MULT | EQUALS | NOTEQUALS | LT | GT | LTE | GTE | DOT | LPAREN | RPAREN | LBRACKET | RBRACKET | LBRACE | RBRACE | COMMA | COLON | SEMICOLON | FOR | IN | WHERE | RETURN | STORE | ENCODE | SQRT | SIN | COS | TAN | SINH | COSH | TANH | ARCSIN | ARCCOS | ARCTAN | EXP | LN | LOG | ROUND | ABS | OVERLAY | STRUCT | RE | IM | AND | OR | XOR | NOT | IDENTIFIER | IMAGECRS | IMAGECRSDOMAIN | CRSSET | DOMAIN | NULLSET | NULLDEFAULT | INTERPOLATIONDEFAULT | INTERPOLATIONSET | SETIDENTIFIER | SETNULLSET | SETINTERPOLATIONDEFAULT | SETINTERPOLATIONSET | SETCRSSET | TRIM | SLICE | EXTEND | SCALE | CRSTRANSFORM | COUNT | ADD | AVG | MAX | MIN | SOME | ALL | COVERAGE | OVER | VALUE | VALUES | LIST | CONDENSE | USING | NEAREST | LINEAR | QUADRATIC | CUBIC | FULL | NONE | HALF | OTHER | PHI | BIT | UNSIGNED | BOOLEAN | CHAR | SHORT | LONG | FLOAT | DOUBLE | COMPLEX | COMPLEX2 | BOOLEANCONSTANT | INTEGERCONSTANT | FLOATCONSTANT | STRING | NAME | VARIABLE_DOLLAR | WHITESPACE );";
        }
    }
 

}