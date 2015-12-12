/* The following code was generated by JFlex 1.4.3 on 18:42 12/12/15 */

/***************************/
/* FILE NAME: LEX_FILE.lex */
/***************************/

/***************************/
/* AUTHOR: OREN ISH SHALOM */
/***************************/

/*************/
/* USER CODE */
/*************/
   
import java_cup.runtime.*;

/******************************/
/* DOLAR DOLAR - DON'T TOUCH! */
/******************************/
      

class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\54\1\61"+
    "\2\0\1\52\1\57\1\0\1\37\1\40\1\5\1\50\1\46\1\51"+
    "\1\47\1\4\1\11\11\7\1\0\1\45\1\56\1\53\1\55\2\0"+
    "\32\10\1\43\1\12\1\44\1\0\1\6\1\0\1\15\1\27\1\13"+
    "\1\23\1\17\1\33\1\31\1\35\1\24\1\6\1\36\1\14\1\6"+
    "\1\22\1\26\2\6\1\30\1\16\1\21\1\32\1\25\1\34\1\20"+
    "\2\6\1\41\1\60\1\42\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\6\14\5\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\2\1\1\30\1\31\2\32\1\1\1\33"+
    "\1\2\1\0\13\5\1\34\6\5\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\2\0\11\5\1\50\1\5\1\51\6\5\1\0\1\2"+
    "\5\5\1\52\1\5\1\53\1\54\1\55\1\56\5\5"+
    "\1\57\6\5\1\60\1\5\1\61\1\62\1\5\1\63"+
    "\1\64\1\65\2\5\1\66\1\5\1\67\1\70\1\71";

  private static int [] zzUnpackAction() {
    int [] result = new int[138];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\144\0\310\0\144\0\372"+
    "\0\u012c\0\u015e\0\144\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258"+
    "\0\u028a\0\u02bc\0\u02ee\0\u0320\0\u0352\0\u0384\0\u03b6\0\144"+
    "\0\144\0\144\0\144\0\144\0\144\0\144\0\144\0\144"+
    "\0\144\0\144\0\144\0\u03e8\0\u041a\0\u044c\0\u047e\0\u04b0"+
    "\0\u04e2\0\144\0\u0514\0\u0546\0\144\0\u0578\0\144\0\u05aa"+
    "\0\u05dc\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\u0708\0\u073a"+
    "\0\u076c\0\u079e\0\u07d0\0\u0802\0\372\0\u0834\0\u0866\0\u0898"+
    "\0\u08ca\0\u08fc\0\u092e\0\144\0\144\0\144\0\144\0\144"+
    "\0\144\0\144\0\144\0\144\0\144\0\144\0\u0960\0\u0992"+
    "\0\u09c4\0\u09f6\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u0b22"+
    "\0\u0b54\0\372\0\u0b86\0\372\0\u0bb8\0\u0bea\0\u0c1c\0\u0c4e"+
    "\0\u0c80\0\u0cb2\0\u0ce4\0\u0960\0\u0d16\0\u0d48\0\u0d7a\0\u0dac"+
    "\0\u0dde\0\372\0\u0e10\0\372\0\372\0\372\0\372\0\u0e42"+
    "\0\u0e74\0\u0ea6\0\u0ed8\0\u0f0a\0\372\0\u0f3c\0\u0f6e\0\u0fa0"+
    "\0\u0fd2\0\u1004\0\u1036\0\372\0\u1068\0\372\0\372\0\u109a"+
    "\0\372\0\372\0\372\0\u10cc\0\u10fe\0\372\0\u1130\0\372"+
    "\0\372\0\372";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[138];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\3\1\14\1\15\1\10\1\16\1\17\1\10"+
    "\1\20\1\21\1\10\1\22\1\23\1\10\1\24\1\25"+
    "\2\10\1\26\1\27\2\10\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\7\53\1\56\46\53\1\57\64\0\1\5"+
    "\63\0\1\60\1\61\62\0\4\10\1\0\24\10\32\0"+
    "\1\11\1\0\1\11\56\0\4\12\1\0\24\12\31\0"+
    "\4\10\1\0\1\10\1\62\11\10\1\63\10\10\31\0"+
    "\4\10\1\0\4\10\1\64\17\10\31\0\4\10\1\0"+
    "\6\10\1\65\15\10\31\0\4\10\1\0\1\10\1\66"+
    "\3\10\1\67\16\10\31\0\4\10\1\0\15\10\1\70"+
    "\4\10\1\71\1\10\31\0\4\10\1\0\4\10\1\72"+
    "\12\10\1\73\4\10\31\0\4\10\1\0\7\10\1\74"+
    "\10\10\1\75\3\10\31\0\4\10\1\0\13\10\1\76"+
    "\10\10\31\0\4\10\1\0\13\10\1\77\1\10\1\100"+
    "\6\10\31\0\4\10\1\0\4\10\1\101\17\10\31\0"+
    "\4\10\1\0\2\10\1\102\21\10\31\0\4\10\1\0"+
    "\22\10\1\103\1\10\76\0\1\104\61\0\1\105\61\0"+
    "\1\106\61\0\1\107\65\0\1\110\62\0\1\111\1\0"+
    "\1\53\2\0\7\53\1\0\46\53\3\0\1\55\57\0"+
    "\2\112\1\0\7\112\1\113\6\112\1\114\1\115\36\112"+
    "\1\116\1\60\1\4\1\5\57\60\5\117\1\120\54\117"+
    "\6\0\4\10\1\0\2\10\1\121\21\10\31\0\4\10"+
    "\1\0\7\10\1\122\14\10\31\0\4\10\1\0\7\10"+
    "\1\123\14\10\31\0\4\10\1\0\2\10\1\124\12\10"+
    "\1\125\6\10\31\0\4\10\1\0\3\10\1\126\20\10"+
    "\31\0\4\10\1\0\6\10\1\127\15\10\31\0\4\10"+
    "\1\0\17\10\1\130\4\10\31\0\4\10\1\0\11\10"+
    "\1\131\12\10\31\0\4\10\1\0\21\10\1\132\2\10"+
    "\31\0\4\10\1\0\1\10\1\133\22\10\31\0\4\10"+
    "\1\0\6\10\1\134\15\10\31\0\4\10\1\0\11\10"+
    "\1\135\12\10\31\0\4\10\1\0\13\10\1\136\10\10"+
    "\31\0\4\10\1\0\4\10\1\137\17\10\31\0\4\10"+
    "\1\0\6\10\1\140\15\10\31\0\4\10\1\0\1\10"+
    "\1\141\22\10\31\0\4\10\1\0\11\10\1\142\12\10"+
    "\23\0\5\117\1\143\60\117\1\144\1\143\54\117\6\0"+
    "\4\10\1\0\3\10\1\145\20\10\31\0\4\10\1\0"+
    "\6\10\1\146\15\10\31\0\4\10\1\0\16\10\1\147"+
    "\5\10\31\0\4\10\1\0\6\10\1\150\15\10\31\0"+
    "\4\10\1\0\11\10\1\151\12\10\31\0\4\10\1\0"+
    "\4\10\1\152\17\10\31\0\4\10\1\0\4\10\1\153"+
    "\17\10\31\0\4\10\1\0\4\10\1\154\17\10\31\0"+
    "\4\10\1\0\3\10\1\155\20\10\31\0\4\10\1\0"+
    "\1\10\1\156\22\10\31\0\4\10\1\0\10\10\1\157"+
    "\13\10\31\0\4\10\1\0\1\10\1\160\22\10\31\0"+
    "\4\10\1\0\2\10\1\161\21\10\31\0\4\10\1\0"+
    "\17\10\1\162\4\10\31\0\4\10\1\0\3\10\1\163"+
    "\20\10\31\0\4\10\1\0\1\10\1\164\22\10\23\0"+
    "\4\117\1\5\1\143\54\117\6\0\4\10\1\0\3\10"+
    "\1\165\20\10\31\0\4\10\1\0\11\10\1\166\12\10"+
    "\31\0\4\10\1\0\6\10\1\167\15\10\31\0\4\10"+
    "\1\0\11\10\1\170\12\10\31\0\4\10\1\0\7\10"+
    "\1\171\14\10\31\0\4\10\1\0\7\10\1\172\14\10"+
    "\31\0\4\10\1\0\4\10\1\173\17\10\31\0\4\10"+
    "\1\0\23\10\1\174\31\0\4\10\1\0\15\10\1\175"+
    "\6\10\31\0\4\10\1\0\4\10\1\176\17\10\31\0"+
    "\4\10\1\0\4\10\1\177\17\10\31\0\4\10\1\0"+
    "\7\10\1\200\14\10\31\0\4\10\1\0\22\10\1\201"+
    "\1\10\31\0\4\10\1\0\1\202\23\10\31\0\4\10"+
    "\1\0\16\10\1\203\5\10\31\0\4\10\1\0\10\10"+
    "\1\204\13\10\31\0\4\10\1\0\2\10\1\205\21\10"+
    "\31\0\4\10\1\0\7\10\1\206\14\10\31\0\4\10"+
    "\1\0\17\10\1\207\4\10\31\0\4\10\1\0\3\10"+
    "\1\210\20\10\31\0\4\10\1\0\7\10\1\211\14\10"+
    "\31\0\4\10\1\0\4\10\1\212\17\10\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4450];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\1\11\1\1\1\11\3\1\1\11"+
    "\14\1\14\11\6\1\1\11\2\1\1\11\1\1\1\11"+
    "\1\1\1\0\22\1\13\11\2\0\22\1\1\0\47\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[138];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    /*********************************************************************************/
    /* Create a new java_cup.runtime.Symbol with information about the current token */
    /*********************************************************************************/
    StringBuilder string = new StringBuilder();
	StringBuilder unescapedString = new StringBuilder();    
	
    private Symbol symbol(int type)               { return new Symbol(type, yyline, yycolumn); }
    private Symbol symbol(int type, Object value) { return new Symbol(type, yyline, yycolumn, value); }
    
    /**
     * Prints token in the following format: 
     *		#line-number: token
     */
    private void printlnWithLineNumber(String token) { System.out.println((yyline+1) + ": " + token); }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 130) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 7: 
          { printlnWithLineNumber("CLASS_ID(" + yytext() + ")");
						return symbol(sym.CLASS_ID, new String(yytext()));
          }
        case 58: break;
        case 52: 
          { printlnWithLineNumber("STATIC");    	return symbol(sym.STATIC);
          }
        case 59: break;
        case 50: 
          { printlnWithLineNumber("WHILE");    	return symbol(sym.WHILE);
          }
        case 60: break;
        case 53: 
          { printlnWithLineNumber("STRING");    	return symbol(sym.STRING);
          }
        case 61: break;
        case 55: 
          { printlnWithLineNumber("EXTENDS");    	return symbol(sym.EXTENDS);
          }
        case 62: break;
        case 41: 
          { printlnWithLineNumber("INT");    		return symbol(sym.INT);
          }
        case 63: break;
        case 36: 
          { string.append('\\'); unescapedString.append(yytext());
          }
        case 64: break;
        case 4: 
          { printlnWithLineNumber("MULTIPLY");    return symbol(sym.MULTIPLY);
          }
        case 65: break;
        case 28: 
          { printlnWithLineNumber("IF");    		return symbol(sym.IF);
          }
        case 66: break;
        case 13: 
          { printlnWithLineNumber("RB");    		return symbol(sym.RB);
          }
        case 67: break;
        case 6: 
          { printlnWithLineNumber("INTEGER(" + yytext() +")");
						return symbol(sym.INTEGER, new Integer(yytext()));
          }
        case 68: break;
        case 23: 
          { printlnWithLineNumber("LT");    		return symbol(sym.LT);
          }
        case 69: break;
        case 21: 
          { printlnWithLineNumber("LNEG");    	return symbol(sym.LNEG);
          }
        case 70: break;
        case 34: 
          { printlnWithLineNumber("LOR");    		return symbol(sym.LOR);
          }
        case 71: break;
        case 30: 
          { printlnWithLineNumber("NEQUAL");    	return symbol(sym.NEQUAL);
          }
        case 72: break;
        case 17: 
          { printlnWithLineNumber("PLUS");      	return symbol(sym.PLUS);
          }
        case 73: break;
        case 16: 
          { printlnWithLineNumber("DOT");    		return symbol(sym.DOT);
          }
        case 74: break;
        case 32: 
          { printlnWithLineNumber("LTE");    		return symbol(sym.LTE);
          }
        case 75: break;
        case 38: 
          { string.append('\n'); unescapedString.append(yytext());
          }
        case 76: break;
        case 2: 
          { /* just skip what was found, do nothing */
          }
        case 77: break;
        case 5: 
          { printlnWithLineNumber("ID(" + yytext() + ")");
						return symbol(sym.ID, new String(yytext()));
          }
        case 78: break;
        case 9: 
          { printlnWithLineNumber("RP");    		return symbol(sym.RP);
          }
        case 79: break;
        case 37: 
          { string.append('\t'); unescapedString.append(yytext());
          }
        case 80: break;
        case 56: 
          { printlnWithLineNumber("BOOLEAN");    	return symbol(sym.BOOLEAN);
          }
        case 81: break;
        case 51: 
          { printlnWithLineNumber("LENGTH");    	return symbol(sym.LENGTH);
          }
        case 82: break;
        case 19: 
          { printlnWithLineNumber("MOD");    		return symbol(sym.MOD);
          }
        case 83: break;
        case 12: 
          { printlnWithLineNumber("LB");    		return symbol(sym.LB);
          }
        case 84: break;
        case 18: 
          { printlnWithLineNumber("MINUS");    	return symbol(sym.MINUS);
          }
        case 85: break;
        case 48: 
          { printlnWithLineNumber("BREAK");    	return symbol(sym.BREAK);
          }
        case 86: break;
        case 44: 
          { printlnWithLineNumber("THIS");    	return symbol(sym.THIS);
          }
        case 87: break;
        case 29: 
          { printlnWithLineNumber("EQUAL");    	return symbol(sym.EQUAL);
          }
        case 88: break;
        case 27: 
          { yybegin(YYINITIAL);
						printlnWithLineNumber("QUOTE(\"" + unescapedString.toString() + "\")"); 
						return symbol(sym.QUOTE, string.toString());
          }
        case 89: break;
        case 31: 
          { printlnWithLineNumber("GTE");    		return symbol(sym.GTE);
          }
        case 90: break;
        case 8: 
          { printlnWithLineNumber("LP");    		return symbol(sym.LP);
          }
        case 91: break;
        case 54: 
          { printlnWithLineNumber("RETURN");    	return symbol(sym.RETURN);
          }
        case 92: break;
        case 45: 
          { printlnWithLineNumber("NULL");    	return symbol(sym.NULL);
          }
        case 93: break;
        case 39: 
          { string.append('\"'); unescapedString.append(yytext());
          }
        case 94: break;
        case 1: 
          { printlnWithLineNumber("Lexical error: illegal character '" + yytext() + "'"); System.exit(1);
          }
        case 95: break;
        case 25: 
          { string.append(yytext()); unescapedString.append(yytext());
          }
        case 96: break;
        case 22: 
          { printlnWithLineNumber("GT");    		return symbol(sym.GT);
          }
        case 97: break;
        case 43: 
          { printlnWithLineNumber("TRUE");    	return symbol(sym.TRUE);
          }
        case 98: break;
        case 3: 
          { printlnWithLineNumber("DIVIDE");    	return symbol(sym.DIVIDE);
          }
        case 99: break;
        case 24: 
          { string.setLength(0); unescapedString.setLength(0) ; yybegin(STRING);
          }
        case 100: break;
        case 35: 
          { printlnWithLineNumber("Lexical error: illegal escape sequence \"" + yytext() + "\""); System.exit(1);
          }
        case 101: break;
        case 15: 
          { printlnWithLineNumber("COMMA");    	return symbol(sym.COMMA);
          }
        case 102: break;
        case 46: 
          { printlnWithLineNumber("VOID");    	return symbol(sym.VOID);
          }
        case 103: break;
        case 42: 
          { printlnWithLineNumber("ELSE");    	return symbol(sym.ELSE);
          }
        case 104: break;
        case 40: 
          { printlnWithLineNumber("NEW");    		return symbol(sym.NEW);
          }
        case 105: break;
        case 10: 
          { printlnWithLineNumber("LCBR");    	return symbol(sym.LCBR);
          }
        case 106: break;
        case 14: 
          { printlnWithLineNumber("SEMI"); 		return symbol(sym.SEMI);
          }
        case 107: break;
        case 33: 
          { printlnWithLineNumber("LAND");    	return symbol(sym.LAND);
          }
        case 108: break;
        case 20: 
          { printlnWithLineNumber("ASSIGN");    	return symbol(sym.ASSIGN);
          }
        case 109: break;
        case 11: 
          { printlnWithLineNumber("RCBR");    	return symbol(sym.RCBR);
          }
        case 110: break;
        case 47: 
          { printlnWithLineNumber("CLASS");    	return symbol(sym.CLASS);
          }
        case 111: break;
        case 57: 
          { printlnWithLineNumber("CONTINUE");    return symbol(sym.CONTINUE);
          }
        case 112: break;
        case 26: 
          { printlnWithLineNumber("Lexical error: Unterminated string at end of line"); System.exit(1);
          }
        case 113: break;
        case 49: 
          { printlnWithLineNumber("FALSE");    	return symbol(sym.FALSE);
          }
        case 114: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                System.out.println((yyline+2) + ": EOF"); return symbol(sym.EOF);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
