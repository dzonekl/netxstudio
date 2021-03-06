
/*
 * SMI, SPPI and ASN.1 lexer/parser 
 * 
 * Portions copyright (C) 2005 Nigel Sheridan-Smith
 *
 * Modified 11 January 2005 through to 13 January 2005 and beyond 
 *
 * Derived from ASN.1 lexer/parser by Vivek Gupta (11 November 2003)
 *
 */


header {
package parsesmi;
import parsesmi.*;
import antlr.*;
import java.lang.* ;
import java.math.*;
import java.util.*;
}

//	Creation of ASN.1 grammar for ANTLR	V2.7.1
// ===================================================
//		  TOKENS FOR ASN.1 LEXER DEFINITIONS
// ===================================================

class SMILexer extends Lexer;
options	{
	k = 3;
	exportVocab=SMI;
	charVocabulary = '\3'..'\377';
	caseSensitive=true;
	testLiterals = true;
	codeGenMakeSwitchThreshold = 2;  // Some optimizations
	codeGenBitsetTestThreshold = 3;
}

//	ASN1 Tokens 

tokens {
	
ABSENT_KW = "ABSENT" ;
ABSTRACT_SYNTAX_KW = "ABSTRACT-SYNTAX" ;
ALL_KW= "ALL" ;
ANY_KW = "ANY" ;
ARGUMENT_KW = "ARGUMENT" ;
APPLICATION_KW = "APPLICATION" ;
AUTOMATIC_KW = "AUTOMATIC" ;
BASED_NUM_KW = "BASEDNUM" ;
BEGIN_KW = "BEGIN" ;
BIT_KW = "BIT" ;
BMP_STRING_KW = "BMPString" ;
BOOLEAN_KW = "BOOLEAN" ;
BY_KW = "BY" ;
CHARACTER_KW = "CHARACTER" ;
CHOICE_KW = "CHOICE" ;
CLASS_KW = "CLASS" ;
COMPONENTS_KW = "COMPONENTS" ;
COMPONENT_KW = "COMPONENT" ;
CONSTRAINED_KW = "CONSTRAINED" ;
DEFAULT_KW = "DEFAULT" ;
DEFINED_KW = "DEFINED" ;
DEFINITIONS_KW = "DEFINITIONS" ;
EMBEDDED_KW = "EMBEDDED" ;
END_KW = "END" ;
ENUMERATED_KW = "ENUMERATED" ;
ERROR_KW = "ERROR" ;
ERRORS_KW = "ERRORS" ;
EXCEPT_KW = "EXCEPT" ;
EXPLICIT_KW = "EXPLICIT" ;
EXPORTS_KW = "EXPORTS" ;
EXTENSIBILITY_KW = "EXTENSIBILITY" ;
EXTERNAL_KW = "EXTERNAL" ;
FALSE_KW = "FALSE" ;
FROM_KW = "FROM" ;
GENERALIZED_TIME_KW = "GeneralizedTime" ;
GENERAL_STR_KW = "GeneralString" ;
GRAPHIC_STR_KW = "GraphicString" ;
IA5_STRING_KW = "IA5String" ;
IDENTIFIER_KW = "IDENTIFIER" ;
IMPLICIT_KW = "IMPLICIT" ;
IMPLIED_KW = "IMPLIED" ;
IMPORTS_KW = "IMPORTS" ;
INCLUDES_KW = "INCLUDES" ;
INSTANCE_KW = "INSTANCE" ;
INTEGER_KW = "INTEGER" ;
INTERSECTION_KW = "INTERSECTION" ;
ISO646STRING_KW = "ISO646String" ;
LINKED_KW = "LINKED" ;
MAX_KW = "MAX" ;
MINUS_INFINITY_KW = "MINUSINFINITY" ;
MIN_KW = "MIN" ;
NULL_KW = "NULL" ;
NUMERIC_STR_KW = "NumericString" ;
OBJECT_DESCRIPTOR_KW = "ObjectDescriptor" ;
OBJECT_KW = "OBJECT" ;
OCTET_KW = "OCTET" ;
OPERATION_KW = "OPERATION" ;
OF_KW = "OF" ;
OID_KW = "OID" ;
OPTIONAL_KW = "OPTIONAL" ;
PARAMETER_KW = "PARAMETER" ;
PDV_KW = "PDV" ;
PLUS_INFINITY_KW = "PLUSINFINITY" ;
PRESENT_KW = "PRESENT" ;
PRINTABLE_STR_KW = "PrintableString" ;
PRIVATE_KW = "PRIVATE" ;
REAL_KW = "REAL" ;
RELATIVE_KW = "RELATIVE" ;
RESULT_KW = "RESULT" ;
SEQUENCE_KW = "SEQUENCE" ;
SET_KW = "SET" ;
SIZE_KW = "SIZE" ;
STRING_KW = "STRING" ;
TAGS_KW = "TAGS" ;
TELETEX_STR_KW = "TeletexString" ;
TRUE_KW = "TRUE" ;
TYPE_IDENTIFIER_KW = "TYPE-IDENTIFIER" ;
UNION_KW = "UNION" ;
UNIQUE_KW = "UNIQUE" ;
UNIVERSAL_KW = "UNIVERSAL" ;
UNIVERSAL_STR_KW = "UniversalString" ;
UTC_TIME_KW = "UTCTime" ;
UTF8STRING_KW = "UTF8String" ;
VIDEOTEX_STR_KW = "VideotexString" ;
VISIBLE_STR_KW = "VisibleString" ;
WITH_KW = "WITH" ;
}

// Operators

ASSIGN_OP:	"::=";
BAR:		'|';
COLON:		':';
COMMA:		',';
COMMENT:	"--";
DOT:		'.';
DOTDOT:		"..";
ELLIPSIS:	"...";
EXCLAMATION:	'!';
INTERSECTION:	'^';
LESS:		'<';
L_BRACE:	'{';
L_BRACKET:	'[';
L_PAREN:	'(';
MINUS:		'-';
PLUS:		'+';
R_BRACE:	'}';
R_BRACKET:	']';
R_PAREN:	')';
SEMI:		';';
SINGLE_QUOTE:	"'";
CHARB:		"'B";
CHARH:		"'H";

// Whitespace -- ignored

WS			
    	:	(	' ' | '\t' | '\f'	|	(	options {generateAmbigWarnings=false;}
	:	"\r\n"		{ newline(); }// DOS
	|	'\r'   		{ newline(); }// Macintosh
	|	'\n'		{ newline(); }// Unix 
	))+
	{$setType(Token.SKIP); }
	;

// Single-line comments
SL_COMMENT
	: (options {warnWhenFollowAmbig=false;} 
	: COMMENT (  { LA(2)!='-' }? '-' 	|	~('-'|'\n'|'\r'))*	( (('\r')? '\n') { newline(); }| COMMENT) )
		{$setType(Token.SKIP);  }
	;

NUMBER	:	('0'..'9')+ ;

/* NSS 13/1/05: Added '_' as acceptable character - required for some PIBs */

UPPER	
options {testLiterals = false;}
	:   ('A'..'Z') 
		(options {warnWhenFollowAmbig = false;}
	:	( 'a'..'z' | 'A'..'Z' |'-' | '0'..'9' ))* 	;   // '_' | 

LOWER
options {testLiterals = false;}
	:	('a'..'z') 
		(options {warnWhenFollowAmbig = false;}
	:	( 'a'..'z' | 'A'..'Z' |'-' | '0'..'9' ))* 	;   // '_' | 


protected
BDIG		: ('0'|'1') ;
protected
HDIG		:	(options {warnWhenFollowAmbig = false;} :('0'..'9') )
			|	('A'..'F')
			|	('a'..'f')
			;

// Unable to resolve a string like 010101 followed by 'H
//B_STRING 	: 	SINGLE_QUOTE ({LA(3)!='B'}? BDIG)+  BDIG SINGLE_QUOTE 'B';
//H_STRING 	: 	SINGLE_QUOTE ({LA(3)!='H'}? HDIG)+  HDIG SINGLE_QUOTE 'H';

B_OR_H_STRING
	:	(options {warnWhenFollowAmbig = false;} 
		:(B_STRING)=>B_STRING {$setType(B_STRING);}
		| H_STRING {$setType(H_STRING);})
	;

/* Changed by NSS 13/1/05 - upper case *or* lower case 'B' and 'H'; zero or more digits */
protected
B_STRING 	: 	SINGLE_QUOTE (BDIG)* SINGLE_QUOTE ('B' | 'b') ;
protected
H_STRING 	: 	SINGLE_QUOTE (HDIG)* SINGLE_QUOTE ('H' | 'h') ;

			
C_STRING 	: 	'"' (options {greedy=false;}
                             : "\r\n"		{ newline(); }// DOS
                             | '\r'   		{ newline(); }// Macintosh
                             | '\n'		{ newline(); }// Unix 
                             | ~('\r' | '\n')
                            )* 
                        '"' ;


//*************************************************************************
//**********		PARSER DEFINITIONS
//*************************************************************************


class SMIParser	extends	Parser;
options	{
	exportVocab=SMI;
	k=3;
}

// Grammar Definitions

/* NSS 13/1/05: Added 'PIB-DEFINITIONS' for SPPI */
module_definition [ASNModule m]
                                        {}
    : module_identifier [m]
        ("PIB-DEFINITIONS"              {if (m.getType()!=ASNModule.SPPI) 
                                         {throw new SemanticException ("'PIB-DEFINITION' only allowed in SPPI file");}}
         | DEFINITIONS_KW               {if (m.getType()==ASNModule.SPPI) 
                                         {throw new SemanticException ("'DEFINITIONS' not allowed in SPPI file");}}
        ) 
	( (  e:EXPLICIT_KW              {m.setExplicitTags(true);}
           | i:IMPLICIT_KW              {m.setImplicitTags(true);} 
           | a:AUTOMATIC_KW             {m.setAutomaticTags(true);}
          ) TAGS_KW )? 
	(EXTENSIBILITY_KW IMPLIED_KW    {m.setExtensibilityImplied(true);}
        )?
        ASSIGN_OP BEGIN_KW module_body[m] END_KW;

module_identifier [ASNModule m]
                                        {ASNOidComponentList o=null;}
    : u:UPPER                           {m.setModuleName (u.getText());}
      (o=obj_id_comp_lst                {m.setDefinitiveIdentifier (o);}
      )? ;

module_body [ASNModule m]
                                        {List i=null;
                                         ASNExports e=null;
                                         ASNAssignment a=null;}
    : (e=exports                        {m.setExports (e);}
      )? (i=imports                     {m.setImports (i);}
         )? (a=assignment               {m.getAssignments().add(a);}
            )* ;

/* NSS 15/1/05: Added syntactic predicate */
obj_id_comp_lst returns [ASNOidComponentList o = new ASNOidComponentList()]
                                        {ASNDefinedValue d = null;
                                         ASNOidComponent i = null;}
    : L_BRACE ((LOWER (LOWER|NUMBER)) => 
               d=defined_value          {o.setDefinedValue (d);}
              )? 
      (i=obj_id_component               {o.getOidComponents().add(i);}
      )+ R_BRACE;

protected defined_value returns [ASNDefinedValue d = new ASNDefinedValue()]
    : (u:UPPER DOT                      {d.setExternalModule(u.getText());}
      )? 
      l:LOWER                           {d.setValueReference(l.getText());};

/* NSS 14/1/05: Checked against X.680 */
obj_id_component returns [ASNOidComponent o = new ASNOidComponent()]
    : n1:NUMBER                         {o.setNumber (Long.parseLong(n1.getText()));}
    | l:LOWER                           {o.setName (l.getText());}
        (L_PAREN n2:NUMBER R_PAREN      {o.setNumber (Long.parseLong(n2.getText()));}
        )?;

tag_default returns [int s=0]
    : s1:EXPLICIT_KW                    {s=ASNTag.EXPLICIT;} 
    | s2:IMPLICIT_KW                    {s=ASNTag.IMPLICIT;} 
    | s3:AUTOMATIC_KW                   {s=ASNTag.AUTOMATIC;};

exports returns [ASNExports e = new ASNExports()]
                                        {List l=null;}
    : EXPORTS_KW ( ( l=symbol_list      {e.setExports(l);}
                   )? | ALL_KW          {e.setAllExported(true);}
                 ) SEMI;

imports returns [List l = new Vector()]
                                        {ASNImports s=null;}
    : IMPORTS_KW (s=symbols_from_module {l.add(s);}
                 )* SEMI ;

assignment returns [ASNAssignment a = null]
                                        {ASNType t1=null,t2=null;
                                         ASNValue v=null;
                                         ASNMacroDefinition a3=null;
                                         String m=null;}
    : u1:UPPER ASSIGN_OP t1=type        {ASNTypeAssignment a1 = new ASNTypeAssignment(); 
                                         a1.setName (u1.getText());
                                         a1.setEntityType (t1);
                                         a = a1;}
    | l:LOWER t2=type ASSIGN_OP v=value  {ASNValueAssignment a2 = new ASNValueAssignment(); 
                                          a2.setName (l.getText());
                                          a2.setEntityType (t2);
                                          a2.setValue (v);
                                          a = a2;}
    |                                   {a3 = new ASNMacroDefinition (); a = a3;}
        (u2:UPPER                       {a3.setName (u2.getText());}
        | m=macroName                   {a3.setName (m);}
        ) "MACRO" ASSIGN_OP 
            BEGIN_KW (t:~(END_KW)       {a3.getTokens().add(t);}
                     )* END_KW ;

symbol_list returns [List l = new Vector()]
                                        {String s1=null,s2=null;}
    : s1=symbol                         {l.add(s1);}
      (COMMA s2=symbol                  {l.add(s2);}
      )* ;

symbols_from_module returns [ASNImports i = new ASNImports()]
                                        {List s = null; ASNOidComponentList o=null;
                                         ASNDefinedValue d=null;}
    : s=symbol_list FROM_KW u:UPPER     {i.setSymbols (s); i.setModuleName(u.getText());}
        ( o=obj_id_comp_lst             {i.setAssignedIdentifierOid (o);}
          | (defined_value) => d=defined_value  {i.setAssignedIdentifierDefined (d);}
        )? ;

symbol returns [String s=null]
    : u:UPPER                           {s=u.getText();}
    | l:LOWER                           {s=l.getText();}
    | s=macroName;

macroName returns [String s=null]
    : s1:OPERATION_KW                   {s=s1.getText();}
    | s2:ERROR_KW                       {s=s2.getText();}
    | s3:"BIND"                         {s=s3.getText();}
    | s4:"UNBIND"                       {s=s4.getText();}
    | s5:"APPLICATION-SERVICE-ELEMENT"  {s=s5.getText();}
    | s6:"APPLICATION-CONTEXT"          {s=s6.getText();}
    | s7:"EXTENSION"                    {s=s7.getText();}
    | s8:"EXTENSIONS"                   {s=s8.getText();}
    | s9:"EXTENSION-ATTRIBUTE"          {s=s9.getText();}
    | s10:"TOKEN"                       {s=s10.getText();}
    | s11:"TOKEN-DATA"                  {s=s11.getText();}
    | s12:"SECURITY-CATEGORY"           {s=s12.getText();}
    | s13:"OBJECT"                      {s=s13.getText();}
    | s14:"PORT"                        {s=s14.getText();}
    | s15:"REFINE"                      {s=s15.getText();}
    | s16:"ABSTRACT-BIND"               {s=s16.getText();}
    | s17:"ABSTRACT-UNBIND"             {s=s17.getText();}
    | s18:"ABSTRACT-OPERATION"          {s=s18.getText();}
    | s19:"ABSTRACT-ERROR"              {s=s19.getText();}
    | s20:"ALGORITHM"                   {s=s20.getText();}
    | s21:"ENCRYPTED"                   {s=s21.getText();}
    | s22:"SIGNED"                      {s=s22.getText();}
    | s23:"SIGNATURE"                   {s=s23.getText();}
    | s24:"PROTECTED"                   {s=s24.getText();}
    | s=smi_macros;

type returns [ASNType t = null]
    : t=built_in_type | t=defined_type | t=selection_type | t=macros_type | t=smi_type;

value returns [ASNValue v = null]
    : (TRUE_KW) => TRUE_KW              {v = new ASNLiteralValue (ASNLiteralValue.TRUE);}
     | (FALSE_KW) => FALSE_KW           {v = new ASNLiteralValue (ASNLiteralValue.FALSE);}
     | (NULL_KW) => NULL_KW             {v = new ASNLiteralValue (ASNLiteralValue.NULL);}
     | (C_STRING) => s1:C_STRING        {v = new ASNLiteralValue (s1.getText());}
     | (defined_value) => v=defined_value 
     | (signed_number) => v=signed_number
     | (choice_value) => v=choice_value 
     | (sequence_value) => v=sequence_value 
     | (sequenceof_value) => v=sequenceof_value 
     | (cstr_value) => v=cstr_value 
     | (obj_id_comp_lst) => v=obj_id_comp_lst 
     | (PLUS_INFINITY_KW) => s5:PLUS_INFINITY_KW    {v = new ASNLiteralValue (ASNLiteralValue.PLUS_INFINITY);} 
     | (MINUS_INFINITY_KW) => s6:MINUS_INFINITY_KW  {v = new ASNLiteralValue (ASNLiteralValue.MINUS_INFINITY);}; 

built_in_type returns [ASNType t = null]
    : t=any_type 
    | t=bit_string_type 
    | t=boolean_type 
    | t=character_str_type 
    | t=choice_type
    | t=embedded_type EMBEDDED_KW PDV_KW 
    | t=enum_type
    | t=external_type
    | t=integer_type
    | t=null_type
    | t=object_identifier_type
    | t=octetString_type
    | t=real_type
    | t=relativeOid_type
    | t=sequence_type
    | t=sequenceof_type
    | t=set_type
    | t=setof_type
    | t=tagged_type;

defined_type returns [ASNDefinedType d = new ASNDefinedType()]
                                        {ASNConstraint c=null;}
    : (u1:UPPER                         {d.setModuleReference (u1.getText());}
        DOT)? u2:UPPER                  {d.setTypeReference (u2.getText());}
        (c=constraint                   {d.setConstraint (c);}
        )? ;

selection_type returns [ASNSelectionType s = new ASNSelectionType()]
                                        {ASNType t=null;}
    : l:LOWER LESS t=type               {s.setIdentifier(l.getText());
                                         s.setSelectionType (t);};

any_type returns [ASNAnyType a = new ASNAnyType()]
    : ANY_KW (DEFINED_KW BY_KW l:LOWER  {a.setDefinedByIdentifier (l.getText());}
             )? ;

/* NSS 15/1/2005: Added syntactic predicate */
bit_string_type returns [ASNBitStringType b = new ASNBitStringType()]
                                            {List n=null;
                                             ASNConstraint c=null;}
    : BIT_KW STRING_KW ((L_BRACE namedNumber) => 
                        n=namedNumber_list  {b.setNamedNumberList (n);}
                       )? (c=constraint     {b.setConstraint (c);}
                          )? ;

boolean_type returns [ASNType b = new ASNType (ASNType.BOOLEAN)]
    : BOOLEAN_KW;

character_str_type returns [ASNCharacterStringType c = new ASNCharacterStringType()]
                                        {int ch=0; 
                                         ASNConstraint co=null;}
    : CHARACTER_KW STRING_KW 
    | ch=character_set                  {c.setCharacterSet (ch);}
        (co=constraint                  {c.setConstraint (co);}
        )? ;

choice_type returns [ASNChoiceType c = new ASNChoiceType()]
                                        {List l=null;}
    : CHOICE_KW L_BRACE 
        l=elementType_list R_BRACE      {c.setElementTypeList(l);};

embedded_type returns [ASNType e = new ASNType (ASNType.EMBEDDED)]
    : EMBEDDED_KW PDV_KW;

enum_type returns [ASNEnumType e = new ASNEnumType()]
                                        {List n=null;}
    : ENUMERATED_KW n=namedNumber_list  {e.setNamedNumberList(n);};

external_type returns [ASNType t = new ASNType (ASNType.EXTERNAL)]
    : EXTERNAL_KW;

/* NSS 15/1/05: Added syntactic predicate */
integer_type returns [ASNIntegerType i = new ASNIntegerType()]
                                        {List n=null;
                                         ASNConstraint c=null;}
    : INTEGER_KW ((L_BRACE namedNumber) =>
                  n=namedNumber_list    {i.setNamedNumberList (n);}
                  | c=constraint        {i.setConstraint (c);}
                 )? ;

null_type returns [ASNType n = new ASNType (ASNType.NULL)]
    : NULL_KW;

object_identifier_type returns [ASNType t = new ASNType (ASNType.OBJECTIDENTIFIER)]
    : OBJECT_KW IDENTIFIER_KW;

octetString_type returns [ASNOctetStringType o = new ASNOctetStringType()]
                                        {ASNConstraint c=null;}
    : OCTET_KW STRING_KW (c=constraint  {o.setConstraint (c);}
                         )? ;

real_type returns [ASNType t = new ASNType (ASNType.REAL)]
    : REAL_KW;

/* NSS 14/1/05: Will this work? I think not! This token detected is an UPPER */
relativeOid_type returns [ASNType t = new ASNType (ASNType.RELATIVEOID)]
    : "RELATIVE-OID";

sequence_type returns [ASNSequenceSetType s = new ASNSequenceSetType(ASNType.SEQUENCE)]
                                        {List e=null;}
    : SEQUENCE_KW L_BRACE 
        (e=elementType_list             {s.setElementTypeList (e);}
        )? R_BRACE ;

sequenceof_type returns [ASNSequenceSetOfType s = new ASNSequenceSetOfType(ASNType.SEQUENCEOF)]
                                        {ASNConstraint c=null;
                                         ASNType t=null;}
    : SEQUENCE_KW 
        (SIZE_KW c=constraint           {s.setSizeConstraint (c);}
        )? OF_KW t=type                 {s.setSubtype (t);};

set_type returns [ASNSequenceSetType s = new ASNSequenceSetType(ASNType.SET)]
                                        {List e=null;}
    : SET_KW L_BRACE 
        (e=elementType_list             {s.setElementTypeList (e);}
        )? R_BRACE;

setof_type returns [ASNSequenceSetOfType s = new ASNSequenceSetOfType(ASNType.SETOF)]
                                        {ASNConstraint c=null;
                                         ASNType t=null;}
    : SET_KW 
        (SIZE_KW c=constraint           {s.setSizeConstraint (c);}
        )? OF_KW t=type                 {s.setSubtype (t);};

tagged_type returns [ASNTagType t = new ASNTagType()]
                                        {int td=0;
                                         ASNTag ta=null;
                                         ASNType ty=null;}
    : ta=tag                            {t.setTag (ta);}    
        (td=tag_default                 {t.setTagDefault (td);}
        )? ty=type                      {t.setSubtype (ty);};

namedNumber_list returns [List l = new Vector()]
                                        {ASNNamedNumber n1=null,n2=null;}
    : L_BRACE n1=namedNumber            {l.add(n1);}
        (COMMA n2=namedNumber           {l.add(n2);}
        )* R_BRACE;

constraint returns [ASNConstraint c = new ASNConstraint()]
                                        {ASNElementSetRange es=null;
                                         ASNException exc=null;}
    : L_PAREN (es=element_set_specs     {c.setElementSetSpecs (es);}
              )? (exc=exception_spec     {c.setExceptionSpec (exc);}
                 )? R_PAREN;

character_set returns [int cs=0]
    : BMP_STR_KW                        {cs=ASNCharacterStringType.BMP;}
    | GENERALIZED_TIME_KW               {cs=ASNCharacterStringType.GENERALIZEDTIME;}
    | GENERAL_STR_KW                    {cs=ASNCharacterStringType.GENERAL;}
    | GRAPHIC_STR_KW                    {cs=ASNCharacterStringType.GRAPHIC;}
    | IA5_STRING_KW                     {cs=ASNCharacterStringType.IA5;}
    | ISO646_STR_KW                     {cs=ASNCharacterStringType.ISO646;}
    | NUMERIC_STR_KW                    {cs=ASNCharacterStringType.NUMERIC;}
    | PRINTABLE_STR_KW                  {cs=ASNCharacterStringType.PRINTABLE;}
    | TELETEX_STR_KW                    {cs=ASNCharacterStringType.TELETEX;}
    | T61_STR_KW                        {cs=ASNCharacterStringType.T61;}
    | UNIVERSAL_STR_KW                  {cs=ASNCharacterStringType.UNIVERSAL;}
    | UTF8_STR_KW                       {cs=ASNCharacterStringType.UTF8;}
    | UTC_TIME_KW                       {cs=ASNCharacterStringType.UTC_TIME;}
    | VIDEOTEX_STR_KW                   {cs=ASNCharacterStringType.VIDEOTEX;}
    | VISIBLE_STR_KW                    {cs=ASNCharacterStringType.VISIBLE;};

elementType_list returns [List l = new Vector()]
                                        {ASNElementType e1=null,e2=null;}
    : e1=elementType                    {l.add(e1);}
        (COMMA e2=elementType           {l.add(e2);}
        )* ;

tag returns [ASNTag t = new ASNTag()]
                                        {String c=null;
                                         ASNClassNumber cl=null;}
    : L_BRACKET (c=clazz                {t.setTagType (c);}
                )? cl=class_NUMBER      {t.setTagNumber (cl);}
        R_BRACKET;

clazz returns [String c = null]
    : s1:UNIVERSAL_KW                   {c = s1.getText();} 
    | s2:APPLICATION_KW                 {c = s2.getText();}  
    | s3:PRIVATE_KW                     {c = s3.getText();};

/* NSS 14/1/05: 'defined_value' not 'LOWER' */
class_NUMBER returns [ASNClassNumber c = new ASNClassNumber()]
                                        {ASNDefinedValue d=null;}
    : n:NUMBER                          {c.setNumber (Long.parseLong(n.getText()));}
    | d=defined_value                   {c.setDefinedValue (d);};

/* NSS 15/1/05: Added syntactic predicates; removed 'SEMI' */
operation_macro returns [ASNOperationMacro o = new ASNOperationMacro()]
                                        {ASNType t1=null,t2=null;
                                         List e=null,l=null;}
    : "OPERATION" 
        (ARGUMENT_KW ((LOWER) => 
                      l1:LOWER          {o.setArgumentIdentifier (l1.getText());}
                     )? t1=type         {o.setArgumentType (t1);}
        )? 
        ( (RESULT_KW) => RESULT_KW 
            ((LOWER) => ((LOWER) => 
               l2:LOWER                 {o.setResultIdentifier (l2.getText());}
              )? t2=type                {o.setResultType (t2);}
            )? 
        )? 
        ( (ERRORS_KW) => ERRORS_KW L_BRACE 
            (e=operation_errorlist      {o.setErrorList (e);}
            )? R_BRACE )? 
        ( (LINKED_KW) => LINKED_KW L_BRACE 
            (l=linkedOp_list            {o.setLinkedOperationList (l);}
            )? R_BRACE )? ;

/* NSS 15/1/05: Added syntactic predicate */
error_macro returns [ASNErrorsMacro e = new ASNErrorsMacro()]
                                        {ASNType t=null;}
    : ERROR_KW ( PARAMETER_KW 
                    ((LOWER) =>
                     l:LOWER            {e.setIdentifier (l.getText());}
                    )? t=type           {e.setSubtype (t);}
               )? ;

/* SMI processing - a bunch of macros defined in RFC 1155 and RFC 2578 for SMI v1 and v2 respectively */
/* Adapted/added by Nigel Sheridan-Smith 12 January 2005 */

macros_type returns [ASNType t = null]
    : t=operation_macro 
    | t=error_macro 
    | t=objecttype_macro 
    | t=moduleidentity_macro 
    | t=objectidentity_macro 
    | t=notificationtype_macro 
    | t=textualconvention_macro 
    | t=objectgroup_macro 
    | t=notificationgroup_macro 
    | t=modulecompliance_macro 
    | t=agentcapabilities_macro 
    | t=traptype_macro;

smi_macros returns [String s=null]
    : s1:"OBJECT-TYPE"                  {s=s1.getText();}
    | s2:"MODULE-IDENTITY"              {s=s2.getText();}
    | s3:"OBJECT-IDENTITY"              {s=s3.getText();}
    | s4:"NOTIFICATION-TYPE"            {s=s4.getText();}
    | s5:"TEXTUAL-CONVENTION"           {s=s5.getText();}
    | s6:"OBJECT-GROUP"                 {s=s6.getText();}
    | s7:"NOTIFICATION-GROUP"           {s=s7.getText();}
    | s8:"MODULE-COMPLIANCE"            {s=s8.getText();}
    | s9:"AGENT-CAPABILITIES"           {s=s9.getText();}
    | s10:"TRAP-TYPE"                   {s=s10.getText();};

/* NSS 12-13/1/05: SMI types - some of these are standard 'textual conventions' which can replace BITS */
/* NSS 13/1/05: Added 'LOWER' since some PIBs can't handle it */
smi_type returns [SMIType t = null]
    : "BITS"                            {t = new SMIType (SMIType.SMI_BITS);}
    | INTEGER_KW                        {t = new SMIType (SMIType.SMI_INTEGER);}
    | OCTET_KW STRING_KW                {t = new SMIType (SMIType.SMI_OCTETSTRING);}
    | OBJECT_KW IDENTIFIER_KW           {t = new SMIType (SMIType.SMI_OID);}
    | u:UPPER                           {t = new SMIType (u.getText());}; 

/* SMI v2: Sub-typing - defined in RFC 1902 section 7.1 and appendix C and RFC 1904 */
smi_subtyping [SMIType t]
                                        {SMIRange r1=null,r2=null,r3=null,r4=null;}
    : L_PAREN r1=subtype_range          {t.getRanges().add(r1);}
        (BAR r2=subtype_range           {t.getRanges().add(r2);}
        )* R_PAREN
    | L_PAREN "SIZE" L_PAREN            {t.setSizeConstraint(true);}
        r3=subtype_range                {t.getRanges().add(r3);}
        (BAR r4=subtype_range           {t.getRanges().add(r4);}
        )* R_PAREN R_PAREN;

subtype_range returns [SMIRange r = new SMIRange()]
                                        {SMIRangeValue v1=null,v2=null;}
    : v1=subtype_value                  {r.setLowerValue (v1);}
        (DOTDOT v2=subtype_value        {r.setUpperValue (v2);}
        )? ;

subtype_value returns [SMIRangeValue v = new SMIRangeValue()]
    : (m:MINUS                          {v.setMinus (true);}
      )? n:NUMBER                       {v.setNumber (Long.parseLong(n.getText()));}
    | b:B_STRING                        {v.setBinaryString (b.getText());}
    | h:H_STRING                        {v.setHexString (h.getText());};               

/* SMI v1/2 and SPPI: Object-type macro */
objecttype_macro returns [SMIObjectTypeMacro o = new SMIObjectTypeMacro()]
                                                        {SMIType t1=null,t2=null;
                                                         ASNType t3=null;
                                                         List n=null,i3=null,i5=null,b=null;
                                                         int pa=0,ma=0,st=0;
                                                         ASNValue v1=null,v2=null,v3=null,v4=null,i4=null,v5=null,v6=null;
                                                         SMINamedBit i1=null,i2=null;}
    : "OBJECT-TYPE" "SYNTAX" 
        ( (smi_type L_BRACE) => 
            t1=smi_type n=objecttype_macro_namedbits    {o.setSyntax (t1); o.setNamedBits (n);}
        | (smi_type) => 
            t2=smi_type (smi_subtyping[t2])?            {o.setSyntax (t2);}
        | t3=type                                       {o.setSyntax (t3);}
        ) 
        ("UNITS" u1:C_STRING                            {o.setUnits (u1.getText());}
        )? 
        ( ("MAX-ACCESS"                                 {o.setAccessType (SMIObjectTypeMacro.MAXACCESS);}
           | "ACCESS"                                   {o.setAccessType (SMIObjectTypeMacro.ACCESS);}
          ) pa=objecttype_macro_accesstypes             {o.setMibAccess (pa);}
         | "PIB-ACCESS"                                 {o.setAccessType (SMIObjectTypeMacro.PIBACCESS);}   /* Only in SPPI; Optional */
            ma=objecttype_macro_pibaccess               {o.setPibAccess (ma);}
        )?              
        ("PIB-REFERENCES" L_BRACE v1=value               {o.setPibReferences (v1);}
            R_BRACE)?                                                                                       /* Only in SPPI */
        ("PIB-TAG" L_BRACE v2=value                     {o.setPibTag (v2);}
            R_BRACE)?                                                                                       /* Only in SPPI */
        "STATUS" st=objecttype_macro_statustypes        {o.setStatus (st);}
        ( ("DESCRIPTION") => 
          "DESCRIPTION" c1:C_STRING                     {o.setDescription (c1.getText());}
        )?                                                                                                  /* Optional only for SMIv1 */
        ("INSTALL-ERRORS" 
            L_BRACE i1=objecttype_macro_error           {o.getInstallErrors().add(i1);}
            (COMMA i2=objecttype_macro_error            {o.getInstallErrors().add(i2);}
            )* R_BRACE)?                                                                                    /* Only in SPPI */
	( "REFERENCE" c2:C_STRING                       {o.setReference (c2.getText());}
        )? 
	( (~("PIB-INDEX")) => 
                "INDEX" i3=objecttype_macro_index       {o.setMibIndex (i3);}
          | "AUGMENTS" i4=objecttype_macro_augments     {o.setMibAugments (i4);}
          | "PIB-INDEX" L_BRACE v3=value R_BRACE        {o.setPibIndex (v3);}                               /* Only in SPPI */
          | "EXTENDS" L_BRACE v4=value R_BRACE          {o.setPibExtends (v4);}                             /* Only in SPPI */
        )? 
        ( "INDEX" i5=objecttype_macro_index             {o.setMibIndex (i5);}
        )?                                                                                                  /* Only in SPPI - replicated from above */
        ( "UNIQUENESS" L_BRACE (v5=value                {o.getUniquenessValues().add(v5);}
            (COMMA v6=value                             {o.getUniquenessValues().add(v6);}
            )* )? R_BRACE)?                                                                                 /* Only in SPPI */
	( ("DEFVAL") => "DEFVAL" L_BRACE 
        ( (L_BRACE LOWER (COMMA | R_BRACE)) => 
            b=objecttype_macro_bitsvalue                {o.setDefaultValueBits (b);}
           | v5=value                                   {o.setDefaultValue (v5);}
        ) 
        R_BRACE )? ;

protected objecttype_macro_accesstypes returns [int a = 0]
    : l:LOWER                                           {if (l.getText().equals("read-only"))           a = SMIObjectTypeMacro.READONLY; 
                                                         else if (l.getText().equals("read-write"))     a = SMIObjectTypeMacro.READWRITE;
                                                         else if (l.getText().equals("write-only"))     a = SMIObjectTypeMacro.WRITEONLY;
                                                         else if (l.getText().equals("read-create"))    a = SMIObjectTypeMacro.READCREATE;
                                                         else if (l.getText().equals("not-accessible")) a = SMIObjectTypeMacro.NOTACCESSIBLE;
                                                         else if (l.getText().equals("accessible-for-notify"))  a = SMIObjectTypeMacro.ACCESSIBLEFORNOTIFY;
                                                         else throw new SemanticException("Invalid OBJECT-TYPE access type for MIB");};

protected objecttype_macro_pibaccess returns [int p = 0]
    : l:LOWER                                           {if (l.getText().equals("install"))             p = SMIObjectTypeMacro.INSTALL;
                                                         else if (l.getText().equals("notify"))         p = SMIObjectTypeMacro.NOTIFY;
                                                         else if (l.getText().equals("install-notify")) p = SMIObjectTypeMacro.INSTALLNOTIFY;
                                                         else if (l.getText().equals("report-only"))    p = SMIObjectTypeMacro.REPORTONLY;
                                                         else throw new SemanticException("Invalid OBJECT-TYPE access type for PIB");};

protected objecttype_macro_statustypes returns [int s = 0]
    : l:LOWER                                           {if (l.getText().equals("mandatory"))           s = SMIObjectTypeMacro.MANDATORY;
                                                         else if (l.getText().equals("optional"))       s = SMIObjectTypeMacro.OPTIONAL;
                                                         else if (l.getText().equals("obsolete"))       s = SMIObjectTypeMacro.OBSOLETE;
                                                         else if (l.getText().equals("current"))        s = SMIObjectTypeMacro.CURRENT;
                                                         else if (l.getText().equals("deprecated"))     s = SMIObjectTypeMacro.DEPRECATED;
                                                         else throw new SemanticException("Invalid OBJECT-TYPE status type");};

// 'typeorvaluelist' in original ASN.1 grammar between braces
objecttype_macro_index returns [List l = new Vector ()]
                                                        {SMIIndexType i1=null,i2=null;}
    : L_BRACE i1=objecttype_macro_indextype             {l.add(i1);}
        (COMMA i2=objecttype_macro_indextype            {l.add(i2);}
        )* R_BRACE;       

objecttype_macro_indextype returns [SMIIndexType i = new SMIIndexType()]
                                                        {ASNValue v=null;}
    : ("IMPLIED"                                        {i.setImplied (true);}
      )? v=value                                        {i.setValue (v);};

objecttype_macro_augments returns [ASNValue v=null]
    : L_BRACE v=value R_BRACE;  

/* NSS 13/1/05: Added LOWER *and* UPPER for a PIB */
objecttype_macro_namedbits returns [List l = new Vector()]
    : L_BRACE l1:LOWER L_PAREN n1:NUMBER R_PAREN        {SMINamedBit nb1 = new SMINamedBit(); 
                                                         nb1.setName (l1.getText()); 
                                                         nb1.setNumber (Long.parseLong (n1.getText()));}
        (COMMA l2:LOWER L_PAREN n2:NUMBER R_PAREN       {SMINamedBit nb2 = new SMINamedBit(); 
                                                         nb2.setName (l2.getText()); 
                                                         nb2.setNumber (Long.parseLong (n2.getText()));}
        )* R_BRACE;     

objecttype_macro_bitsvalue returns [List b = new Vector()]
    : L_BRACE l1:LOWER                                  {b.add(l1.getText());}
        (COMMA l2:LOWER                                 {b.add(l2.getText());}
        )* R_BRACE; 
    
objecttype_macro_error returns [SMINamedBit n = new SMINamedBit()]
    : l:LOWER L_PAREN nu:NUMBER R_PAREN                 {n.setName (l.getText()); n.setNumber (Long.parseLong(nu.getText()));};

/* SMI v2 and SPPI: Module-identity macro */
moduleidentity_macro returns [SMIModuleIdentityMacro m = new SMIModuleIdentityMacro()]
                                                        {SMICategories c1=null;
                                                         SMIRevision r=null;}
    : "MODULE-IDENTITY" 
        ("SUBJECT-CATEGORIES" L_BRACE 
            c1=moduleidentity_macro_categories          {m.setCategories (c1);} 
        R_BRACE)?                                                                                           /* Only in SPPI */
        "LAST-UPDATED" c2:C_STRING                      {m.setLastUpdated (c2.getText());} 
        "ORGANIZATION" c3:C_STRING                      {m.setOrganization (c3.getText());}
        "CONTACT-INFO" c4:C_STRING                      {m.setContactInfo (c4.getText());}
        "DESCRIPTION" c5:C_STRING                       {m.setDescription (c5.getText());}
        (r=moduleidentity_macro_revision                {m.getRevisions().add (r);}
        )* ;

moduleidentity_macro_revision returns [SMIRevision r = new SMIRevision ()]
    : "REVISION" c1:C_STRING                            {r.setRevision (c1.getText());} 
        "DESCRIPTION" c2:C_STRING                       {r.setDescription (c2.getText());};

moduleidentity_macro_categories returns [SMICategories c = new SMICategories ()]
                                                        {SMINamedBit c2=null,c3=null;}
    : l:LOWER                                           {if (l.getText().equals ("all")) c.setAllCategories(true);
                                                         else throw new SemanticException ("Category must be 'ALL' or followed by a number in parentheses.");} 
    | c2=moduleidentity_macro_categoryid                {c.getCategories().add(c2);}
        (COMMA c3=moduleidentity_macro_categoryid       {c.getCategories().add(c3);}
        )*;
moduleidentity_macro_categoryid returns [SMINamedBit n = new SMINamedBit()]
    : l:LOWER L_PAREN nu:NUMBER R_PAREN                 {n.setName (l.getText());
                                                         n.setNumber (Long.parseLong(nu.getText()));};
 
/* SMI v2 and SPPI: Object-identity macro */
objectidentity_macro returns [SMIObjectIdentityMacro o = new SMIObjectIdentityMacro()]
                                                        {int s=0;}                                                         
    : "OBJECT-IDENTITY" 
        "STATUS" s=objectidentity_macro_statustypes     {o.setStatus (s);}
        "DESCRIPTION" c1:C_STRING                       {o.setDescription (c1.getText());} 
        ("REFERENCE" c2:C_STRING                        {o.setReference (c2.getText());}
        )? ;

protected objectidentity_macro_statustypes returns [int s=0]
    : l:LOWER                                           {if (l.getText().equals("current"))         s = SMIObjectIdentityMacro.CURRENT; 
                                                         else if (l.getText().equals("deprecated")) s = SMIObjectIdentityMacro.DEPRECATED; 
                                                         else if (l.getText().equals("obsolete"))   s = SMIObjectIdentityMacro.OBSOLETE; 
                                                         else throw new SemanticException("Invalid OBJECT-IDENTITY status type");};


/* SMI v2: Notification-type macro */
notificationtype_macro returns [SMINotificationTypeMacro n = new SMINotificationTypeMacro()]
                                                        {ASNValue v1=null,v2=null;
                                                         int s=0;}
    : "NOTIFICATION-TYPE" 
        ("OBJECTS" L_BRACE v1=value                     {n.getObjects().add(v1);}
            (COMMA v2=value                             {n.getObjects().add(v2);}
            )* R_BRACE)? 
        "STATUS" s=notificationtype_macro_status        {n.setStatus (s);}
        "DESCRIPTION" c1:C_STRING                       {n.setDescription (c1.getText());}
        ("REFERENCE" c2:C_STRING                        {n.setReference (c2.getText());}
        )? ;

protected notificationtype_macro_status returns [int s=0]
    : l:LOWER                                           {if (l.getText().equals("current"))         s = SMINotificationTypeMacro.CURRENT;  
                                                         else if (l.getText().equals("deprecated")) s = SMINotificationTypeMacro.DEPRECATED;
                                                         else if (l.getText().equals("obsolete"))   s = SMINotificationTypeMacro.OBSOLETE;
                                                         else throw new SemanticException("Invalid NOTIFICATION-TYPE status type");};

/* SMI v2 and SPPI: Textual convention */
textualconvention_macro returns [SMITextualConventionMacro t = new SMITextualConventionMacro()]
                                                        {SMINamedBit n1=null,n2=null;
                                                         int s1=0;
                                                         SMIType s2=null;
                                                         ASNType t1=null;}
    : "TEXTUAL-CONVENTION" 
        ("DISPLAY-HINT" c1:C_STRING                     {t.setDisplayHint (c1.getText());}
        )? 
        "STATUS" s1=textualconvention_macro_status      {t.setStatus (s1);}
        "DESCRIPTION" c2:C_STRING                       {t.setDescription (c2.getText());}
        ("REFERENCE" c3:C_STRING                        {t.setReference (c3.getText());}
        )? 
        "SYNTAX" ( (smi_type L_BRACE) => 
                    s2=smi_type L_BRACE                 {t.setSyntax (s2);}
                    n1=textualconvention_macro_namedbit                 {t.getSyntaxNamedBits().add (n1);}
                        (COMMA n2=textualconvention_macro_namedbit      {t.getSyntaxNamedBits().add (n2);}
                        )* R_BRACE 
                   | t1=type                            {t.setSyntax (t1);}
                 );

protected textualconvention_macro_status returns [int s=0]
    : l:LOWER                                           {if (l.getText().equals("current"))         s = SMITextualConventionMacro.CURRENT; 
                                                         else if (l.getText().equals("deprecated")) s = SMITextualConventionMacro.DEPRECATED;
                                                         else if (l.getText().equals("obsolete"))   s = SMITextualConventionMacro.OBSOLETE;
                                                         else throw new SemanticException("Invalid TEXTUAL-CONVENTION status type");};

textualconvention_macro_namedbit returns [SMINamedBit n = new SMINamedBit()]
    : l:LOWER                                           {n.setName (l.getText());}
        L_PAREN (m:MINUS                                {n.setMinus (true);}
                )? 
        nu:NUMBER R_PAREN                               {n.setNumber (Long.parseLong (nu.getText()));};

/* SMI v2 and SPPI: Object group */
objectgroup_macro returns [SMIObjectGroupMacro o = new SMIObjectGroupMacro ()]
                                                        {ASNValue v1=null,v2=null;
                                                         int s=0;}
    : "OBJECT-GROUP" "OBJECTS" 
        L_BRACE v1=value                                {o.getObjects().add(v1);}
            (COMMA v2=value                             {o.getObjects().add(v2);}
            )* R_BRACE 
        "STATUS" s=objectgroup_macro_status             {o.setStatus (s);}
        "DESCRIPTION" c1:C_STRING                       {o.setDescription (c1.getText());}
        ("REFERENCE" c2:C_STRING                        {o.setReference (c2.getText());}
        )? ;

objectgroup_macro_status returns [int s=0]
    : l:LOWER                                           {if (l.getText().equals("current"))         s = SMIObjectGroupMacro.CURRENT;
                                                         else if (l.getText().equals("deprecated")) s = SMIObjectGroupMacro.DEPRECATED;
                                                         else if (l.getText().equals("obsolete"))   s = SMIObjectGroupMacro.OBSOLETE;
                                                         else throw new SemanticException("Invalid OBJECT-GROUP status type");};
 
/* SMI v2: Notification group*/
notificationgroup_macro returns [SMINotificationGroupMacro n = new SMINotificationGroupMacro()]
                                                        {ASNValue v1=null,v2=null;
                                                         int s=0;}
    : "NOTIFICATION-GROUP" "NOTIFICATIONS" 
        L_BRACE v1=value                                {n.getNotifications().add(v1);}
            (COMMA v2=value                             {n.getNotifications().add(v2);}
            )* R_BRACE 
        "STATUS" s=notificationgroup_macro_status       {n.setStatus (s);}
        "DESCRIPTION" c1:C_STRING                       {n.setDescription (c1.getText());}
        ("REFERENCE" c2:C_STRING                        {n.setReference (c2.getText());}
        )? ;

notificationgroup_macro_status returns [int s=0]: 
    l:LOWER                                             {if (l.getText().equals("current"))         s = SMINotificationGroupMacro.CURRENT; 
                                                         else if (l.getText().equals("deprecated")) s = SMINotificationGroupMacro.DEPRECATED;
                                                         else if (l.getText().equals("obsolete"))   s = SMINotificationGroupMacro.OBSOLETE;
                                                         else throw new SemanticException("Invalid NOTIFICATION-GROUP status type");};
 
/* SMI v2 and SPPI: Module compliance */
modulecompliance_macro returns [SMIModuleComplianceMacro m = new SMIModuleComplianceMacro()]
                                                        {int s=0;
                                                         SMIModuleCompliance mc=null;}
    : "MODULE-COMPLIANCE" 
        "STATUS" s=modulecompliance_macro_status        {m.setStatus (s);}
        "DESCRIPTION" c1:C_STRING                       {m.setDescription (c1.getText());}
        ("REFERENCE" c2:C_STRING                        {m.setReference (c2.getText());}
        )? (mc=modulecompliance_macro_module            {m.getModules().add(mc);}
           )+ ;

modulecompliance_macro_status returns [int s=0]
    : l:LOWER                                           {if (l.getText().equals("current"))         s = SMIModuleComplianceMacro.CURRENT;  
                                                         else if (l.getText().equals("deprecated")) s = SMIModuleComplianceMacro.DEPRECATED;
                                                         else if (l.getText().equals("obsolete"))   s = SMIModuleComplianceMacro.OBSOLETE;
                                                         else throw new SemanticException("Invalid MODULE-COMPLIANCE status type");};

modulecompliance_macro_module returns [SMIModuleCompliance m = new SMIModuleCompliance()]
                                                        {ASNValue v1=null,v2=null,v3=null;
                                                         SMICompliance c=null;}
    : "MODULE" ((UPPER) =>
                u:UPPER                                 {m.setModuleName (u.getText());}
            ((value) => v1=value                                   {m.setValue (v1);}
                      )? )? 
        ("MANDATORY-GROUPS" L_BRACE v2=value            {m.getMandatoryGroups().add(v2);}
            (COMMA v3=value                             {m.getMandatoryGroups().add(v3);}
            )* R_BRACE)?
        (c=modulecompliance_macro_compliance            {m.getCompliances().add (c);}
        )* ;

modulecompliance_macro_compliance returns [SMICompliance c = new SMICompliance()]
                                                        {ASNValue v1=null,v2=null;
                                                         SMISyntax s1=null,s2=null;
                                                         int a1=0,a2=0;}
    :                                                   {c.setComplianceType (SMICompliance.GROUP);}
      "GROUP" v1=value                                  {c.setGroup (v1);}
        "DESCRIPTION" c2:C_STRING                       {c.setDescription (c2.getText());}
    |                                                   {c.setComplianceType (SMICompliance.OBJECT);}
        "OBJECT" v2=value                               {c.setObject (v2);}
        ("SYNTAX" s1=modulecompliance_macro_syntax              {c.setSyntax (s1);}
        )? 
        ("WRITE-SYNTAX" s2=modulecompliance_macro_syntax        {c.setWriteSyntax (s2);}
        )?                                                                                                  /* Only in SMI v2 */
        ("MIN-ACCESS" a1=modulecompliance_macro_access          {c.setMinAccess (a1);}
        )? 
        ("PIB-MIN-ACCESS" a2=modulecompliance_macro_pibaccess   {c.setPibMinAccess (a2);}
        )?                                                                                                  /* Only in SPPI */
        "DESCRIPTION" c3:C_STRING                       {c.setDescription (c3.getText());};

modulecompliance_macro_syntax returns [SMISyntax s = new SMISyntax()]
                                                        {SMIType t1=null,t2=null;
                                                         SMINamedBit n1=null,n2=null;
                                                         ASNType t3=null;}
    : (smi_type L_BRACE) => 
        t1=smi_type L_BRACE                             {s.setSubtype (t1);}
        n1=modulecompliance_macro_namedbit              {s.getSubtypeNamedBits ().add(n1);}
        (COMMA n2=modulecompliance_macro_namedbit       {s.getSubtypeNamedBits ().add(n2);}
        )* R_BRACE
    | (smi_type) => t2=smi_type (smi_subtyping[t2])?    {s.setSubtype (t2);}
    | t3=type                                           {s.setSubtype (t3);};

modulecompliance_macro_namedbit returns [SMINamedBit n = new SMINamedBit()]
    : l:LOWER L_PAREN nu:NUMBER R_PAREN                 {n.setName (l.getText());
                                                         n.setNumber (Long.parseLong (nu.getText()));};

modulecompliance_macro_access returns [int a=0]
    : l:LOWER                                           {if (l.getText().equals("not-accessible"))              a = SMIModuleComplianceMacro.NOTACCESSIBLE;
                                                         else if (l.getText().equals("accessible-for-notify"))  a = SMIModuleComplianceMacro.ACCESSIBLEFORNOTIFY;
                                                         else if (l.getText().equals("read-only"))              a = SMIModuleComplianceMacro.READONLY;
                                                         else if (l.getText().equals("read-write"))             a = SMIModuleComplianceMacro.READWRITE;
                                                         else if (l.getText().equals("read-create"))            a = SMIModuleComplianceMacro.READCREATE;
                                                         else throw new SemanticException("Invalid MODULE-COMPLIANCE access type for MIB");};

modulecompliance_macro_pibaccess returns [int p=0]
    : l:LOWER                                           {if (l.getText().equals("not-accessible"))      p = SMIModuleComplianceMacro.NOTACCESSIBLE;
                                                         else if (l.getText().equals("install"))        p = SMIModuleComplianceMacro.INSTALL;
                                                         else if (l.getText().equals("notify"))         p = SMIModuleComplianceMacro.NOTIFY;
                                                         else if (l.getText().equals("install-notify")) p = SMIModuleComplianceMacro.INSTALLNOTIFY;
                                                         else if (l.getText().equals("report-only"))    p = SMIModuleComplianceMacro.REPORTONLY;
                                                         else throw new SemanticException("Invalid MODULE-COMPLIANCE access type for PIB");};

/* SMI v2: Agent capabilities */
agentcapabilities_macro returns [SMIAgentCapabilitiesMacro a = new SMIAgentCapabilitiesMacro()]
                                                        {int s=0;
                                                         SMIAgentCapabilitiesModule m=null;}
    : "AGENT-CAPABILITIES" 
        "PRODUCT-RELEASE" c1:C_STRING                   {a.setProductRelease (c1.getText());}
        "STATUS" s=agentcapabilities_macro_status       {a.setStatus (s);}
        "DESCRIPTION" c2:C_STRING                       {a.setDescription (c2.getText());}
        ("REFERENCE" c3:C_STRING                        {a.setReference (c3.getText());}
        )? (m=agentcapabilities_macro_module            {a.getModules().add(m);}
           )*;

agentcapabilities_macro_status returns [int s=0]
    : l:LOWER                                           {if (l.getText().equals("current"))         s = SMIAgentCapabilitiesMacro.CURRENT; 
                                                         else if (l.getText().equals("obsolete"))   s = SMIAgentCapabilitiesMacro.OBSOLETE;
                                                         else throw new SemanticException("Invalid AGENT-CAPABILITIES status type");};

agentcapabilities_macro_module returns [SMIAgentCapabilitiesModule a = new SMIAgentCapabilitiesModule()]
                                                        {ASNValue v1=null,v2=null,v3=null;
                                                         SMIVariation v4=null;}
    : "SUPPORTS" l:LOWER                                {a.setModuleName (l.getText());}
        (v1=value                                       {a.setValue (v1);}
        )? 
        "INCLUDES" L_BRACE v2=value                     {a.getIncludes().add (v2);}
            (COMMA v3=value                             {a.getIncludes().add (v3);}
            )* R_BRACE 
        (v4=agentcapabilities_macro_variation           {a.getVariations().add (v4);}
        )*;

agentcapabilities_macro_variation returns [SMIVariation v = new SMIVariation()]
                                                        {ASNValue v1=null,v2=null,v3=null,v4=null;
                                                         SMISyntax s1=null,s2=null;
                                                         int a1=0,a2=0;}
    :   "VARIATION" v1=value                            {v.setVariationValue (v1);}
        ("SYNTAX" s1=agentcapabilities_macro_syntax     {v.setSyntax (s1);}
        )? 
        ("WRITE-SYNTAX" s2=agentcapabilities_macro_syntax   {v.setWriteSyntax (s2);}
        )? 
        ("ACCESS" a1=agentcapabilities_macro_access     {v.setAccess (a1);}
        )? 
        ("CREATION-REQUIRES" L_BRACE v2=value           {v.getCreationRequires().add(v2);}
            (COMMA v3=value                             {v.getCreationRequires().add(v3);}
            )* R_BRACE)? 
        ("DEFVAL" L_BRACE ( L_BRACE (l1:LOWER           {v.getDefaultValueIdentifiers().add(l1.getText());}
                                    )? (COMMA l2:LOWER  {v.getDefaultValueIdentifiers().add(l2.getText());}
                                       )* R_BRACE) 
                            | v4=value                  {v.setDefaultValue (v4);}
                          )? 
        "DESCRIPTION" c1:C_STRING                       {v.setDescription (c1.getText());};

agentcapabilities_macro_syntax returns [SMISyntax s = new SMISyntax()]
                                                        {SMIType t1=null,t2=null;
                                                         ASNType t3=null;
                                                         SMINamedBit n1=null,n2=null;}
    : (smi_type L_BRACE) => 
            t1=smi_type L_BRACE                         {s.setSubtype (t1);}
        n1=agentcapabilities_macro_namedbit             {s.getSubtypeNamedBits().add (n1);}
            (COMMA n2=agentcapabilities_macro_namedbit  {s.getSubtypeNamedBits().add (n2);}
            )* R_BRACE
    | (smi_type) => t2=smi_type (smi_subtyping[t2])?    {s.setSubtype (t2);}
    | t3=type                                           {s.setSubtype (t3);}; 

agentcapabilities_macro_access returns [int a=0]
    : l:LOWER                                           {if (l.getText().equals("not-implemented"))             a = SMIAgentCapabilitiesMacro.NOTIMPLEMENTED;
                                                         else if (l.getText().equals("accessible-for-notify"))  a = SMIAgentCapabilitiesMacro.ACCESSIBLEFORNOTIFY;
                                                         else if (l.getText().equals("read-only"))              a = SMIAgentCapabilitiesMacro.READONLY;
                                                         else if (l.getText().equals("read-write"))             a = SMIAgentCapabilitiesMacro.READWRITE;
                                                         else if (l.getText().equals("read-create"))            a = SMIAgentCapabilitiesMacro.READCREATE;
                                                         else if (l.getText().equals("write-only"))             a = SMIAgentCapabilitiesMacro.WRITEONLY;
                                                         else throw new SemanticException("Invalid AGENT-CAPABILITIES access type");};

agentcapabilities_macro_namedbit returns [SMINamedBit n = new SMINamedBit()]
    : l:LOWER L_PAREN nu:NUMBER R_PAREN                 {n.setName (l.getText());
                                                         n.setNumber (Long.parseLong (nu.getText()));};


/* SMI v1: Trap types */
traptype_macro returns [SMITrapTypeMacro t = new SMITrapTypeMacro()]
                                                        {ASNValue v1=null,v2=null,v3=null,v4=null,v5=null;}
    : "TRAP-TYPE" "ENTERPRISE" v1=value                 {t.setEnterprise (v1);}
        ("VARIABLES" L_BRACE v2=value                   {t.getVariables().add (v2);}
            (COMMA v3=value                             {t.getVariables().add (v3);}
            )* R_BRACE)? 
        (("DESCRIPTION") => "DESCRIPTION" v4=value      {t.setDescription (v4);}
        )? 
        ("REFERENCE" v5=value                           {t.setReference (v5);}
        )? ;

operation_errorlist returns [List l = new Vector()]
                                        {ASNTypeOrValue t1=null,t2=null;}
    : t1=typeorvalue                    {l.add(t1);}
        (COMMA t2=typeorvalue           {l.add(t2);}        
        )* ;

linkedOp_list returns [List l = new Vector()]
                                        {ASNTypeOrValue t1=null,t2=null;}
    : t1=typeorvalue                    {l.add(t1);}
        (COMMA t2=typeorvalue           {l.add(t2);}        
        )* ;

typeorvalue returns [ASNTypeOrValue tv = new ASNTypeOrValue()]
                                        {ASNType t=null;
                                         ASNValue v=null;}
    : (type) => t=type                  {tv.setType (t);}
    | v=value                           {tv.setValue (v);};

// ERROR HERE in ASN.1 grammar? '*' was only applied to 'typeorvalue'
typeorvaluelist returns [List l = new Vector()]
                                        {ASNTypeOrValue t1=null,t2=null;}
    : t1=typeorvalue                    {l.add(t1);}
        (COMMA t2=typeorvalue           {l.add(t2);}        
        )* ;

/* NSS 15/1/05: Added syntactic predicate */
elementType returns [ASNElementType e = new ASNElementType()]
                                        {ASNTag t1=null;
                                         int t2=0;
                                         ASNType t3=null,t4=null;
                                         ASNValue v1=null;}
    :                                   {e.setType (ASNElementType.TAGGEDTYPEVALUE);}
        l:LOWER                         {e.setIdentifier (l.getText());}
            ((L_BRACKET (NUMBER|UPPER|LOWER)) =>
             t1=tag                     {e.setTag (t1);}
            )? (t2=tag_default          {e.setTagDefault (t2);}
               )? t3=type               {e.setSubtype (t3);}
        (OPTIONAL_KW                    {e.setOptional(true);}
        | DEFAULT_KW                    {e.setDefault(true);}
            v1=value                    {e.setDefaultValue (v1);}
        )? 
    | COMPONENTS_KW OF_KW t4=type       {e.setType (ASNElementType.COMPONENTSOF);
                                         e.setSubtype (t4);}; 

namedNumber returns [ASNNamedNumber n = new ASNNamedNumber()]
                                        {ASNValue s=null,d=null;}
    : l:LOWER L_PAREN                   {n.setName (l.getText());}
        (s=signed_number                {n.setValue (s);}
        | d=defined_value) R_PAREN      {n.setValue (d);};

signed_number returns [ASNLiteralValue v = new ASNLiteralValue(ASNLiteralValue.NUMBER)]
    : (m:MINUS                          {v.setMinus(true);}
      )? n:NUMBER                       {v.setNumberValue(Long.parseLong(n.getText()));};                      

element_set_specs returns [ASNElementSetRange e = new ASNElementSetRange()]
                                        {ASNConstraintElement e1=null,e2=null;}
    : e1=element_set_spec               {e.setLeftElement (e1);}
        (COMMA d:DOTDOTDOT              {e.setEllipsis (true);}
        )? (COMMA e2=element_set_spec   {e.setRightElement (e2);}
           )? ;

exception_spec returns [ASNException e = new ASNException()]
                                        {ASNValue s=null,d=null,v=null;
                                         ASNType t=null;}
    : EXCLAMATION 
        ( (signed_number) => 
            s=signed_number             {e.setValue (s);}
        | (defined_value) => 
            d=defined_value             {e.setValue (d);}
        | t=type COLON v=value          {e.setType (t);
                                         e.setValue (v);}
        );

element_set_spec returns [ASNConstraintElement e = new ASNConstraintElement()]
                                        {ASNConstraintElement e1 = new ASNConstraintElement(),e2=null,c=null;
                                         ASNConstraintElement i1=null,i2=null;}
    : i1=intersections                  {e1.setOperand(i1);}
                                        {e.getOperations().add (e1);}
        (                               {e2 = new ASNConstraintElement();}
          (BAR | UNION_KW)              {e2.setOperator(ASNConstraintElement.UNION);}
          i2=intersections              {e2.setOperand(i2);
                                         e.getOperations().add (e2);}
        )* 
    | ALL EXCEPT c=constraint_elements  {e.setAllExceptConstraint (true);
                                         e.setConstraintElement (c);};

intersections returns [ASNConstraintElement e = new ASNConstraintElement()]
                                                {ASNConstraintElement c1=null,c2=null,c3=null,c4=null,e1=null,e2=null;}
    :                                           {e1 = new ASNConstraintElement(ASNConstraintElement.OPERATION);}
      c1=constraint_elements                    {e1.setOperand (c1);}
        (EXCEPT c2=constraint_elements          {e1.setConstraintElement (c2);}
        )?                                      {e.getOperations().add(e1);}
        (                                       {e2 = new ASNConstraintElement(ASNConstraintElement.OPERATION);}
            (INTERSECTION | INTERSECTION_KW)    {e2.setOperator(ASNConstraintElement.INTERSECTION);}
            c3=constraint_elements              {e2.setOperand (c3);}
            (EXCEPT c4=constraint_elements      {e2.setConstraintElement (c4);}
            )?                                  {e.getOperations().add(e2);}
            )* ;

constraint_elements returns [ASNConstraintElement c = new ASNConstraintElement()]
                                        {ASNValue v1=null,v3=null;
                                         ASNValueRange v2=null;
                                         ASNConstraint c1=null,c2=null,c3=null;
                                         ASNConstraintElement e=null;
                                         ASNType t1=null;
                                         List t2=null;}
    : (value) => v1=value               {c.setType (ASNConstraintElement.VALUE);
                                         c.setValue (v1);}
    | (value_range) => v2=value_range   {c.setType (ASNConstraintElement.VALUERANGE);
                                         c.setValueRange (v2);}
    | SIZE_KW c1=constraint             {c.setType (ASNConstraintElement.SIZECONSTRAINT);
                                         c.setConstraint (c1);}
    | FROM_KW c2=constraint             {c.setType (ASNConstraintElement.FROMCONSTRAINT);
                                         c.setConstraint (c2);}
    | L_PAREN e=element_set_spec        {c.setType (ASNConstraintElement.ELEMENTSET);
                                         c.setElementSet (e);}
        R_PAREN 
    |                                   {c.setType (ASNConstraintElement.INCLUDETYPE);}
        (INCLUDES                       {c.setIncludes (true);}
        )? t1=type                      {c.setConstraintType (t1); }
    | PATTERN_KW v3=value               {c.setType (ASNConstraintElement.PATTERN);
                                         c.setValue (v3);}
    | WITH_KW (                                 {c.setType (ASNConstraintElement.WITHCOMPONENT);}
                COMPONENT_KW c3=constraint      {c.setConstraint (c3);} 
              |                                 {c.setType (ASNConstraintElement.WITHCOMPONENTS);}
                COMPONENTS_KW L_BRACE 
                    (DOTDOTDOT COMMA            {c.setEllipsis (true);}
                    )? 
                    t2=type_constraint_list     {c.setTypeConstraintList (t2);}
                    R_BRACE);

value_range returns [ASNValueRange r = new ASNValueRange()]
                                        {ASNValue v1=null,v2=null;}
    : (v1=value                         {r.setLowerValue (v1);}
      | MIN_KW                          {r.setMinValue (true);}
      ) (LESS                           {r.setLessThan (true);}
        )? DOTDOT (LESS
                  )? (v2=value          {r.setUpperValue (v2);}
                     | MAX_KW           {r.setMaxValue (true);}
                     );

type_constraint_list returns [List l = new Vector ()]
                                        {ASNConstraintElement n1=null,n2=null;}
    : n1=named_constraint               {l.add(n1);}
        (COMMA n2=named_constraint      {l.add(n2);}
        )* ;

named_constraint returns [ASNConstraintElement e = new ASNConstraintElement()]
                                        {ASNConstraint c=null;}
    :                                   {e.setType (ASNConstraintElement.NAMEDCONSTRAINT);}
        l:LOWER                         {e.setConstraintName (l.getText());}
        (c=constraint                   {e.setConstraint (c);}
        )? (PRESENT_KW                  {e.setPresent (true);}
           | ABSENT_KW                  {e.setAbsent (true);}
           | OPTIONAL_KW                {e.setOptional (true);}
           )? ;

choice_value returns [ASNChoiceValue v = new ASNChoiceValue()]
                                        {ASNValue va=null;}
    : l:LOWER                           {v.setIdentifier(l.getText());}
        (COLON                          {v.setColon (true);}
        )? 
        va=value                        {v.setValue (va);};

sequence_value returns [ASNSequenceValue v = new ASNSequenceValue()]
                                        {ASNNamedValue n1=null,n2=null;}
    : L_BRACE (n1=named_value           {v.getNamedValues().add(n1);}
              )? 
        (COMMA n2=named_value           {v.getNamedValues().add(n2);}
        )* R_BRACE;

sequenceof_value returns [ASNSequenceOfValue v = new ASNSequenceOfValue()]
                                        {ASNValue v1=null,v2=null;}
    : L_BRACE (v1=value                 {v.getValues().add(v1);}
              )? (COMMA v2=value        {v.getValues().add(v2);}
                 )* R_BRACE;

cstr_value returns [ASNValue v = null]
    : (H_STRING) => h:H_STRING          {v = new ASNLiteralValue (ASNLiteralValue.HSTRING, h.getText());}
          | (B_STRING) => b:B_STRING    {v = new ASNLiteralValue (ASNLiteralValue.BSTRING, b.getText());}
          | L_BRACE 
            ( (id_list) => 
                v=id_list              
              | (char_defs_list) => 
                v=char_defs_list
              | v=tuple_or_quad
            ) R_BRACE;

id_list returns [ASNIdentifierListValue l = new ASNIdentifierListValue()]
    : l1:LOWER                          {l.getIdentifiers().add(l1.getText());}
        (COMMA l2:LOWER                 {l.getIdentifiers().add(l2.getText());}
        )* ;

char_defs_list returns [ASNCharDefinitionListValue c = new ASNCharDefinitionListValue()]
                                        {ASNCharacterDefinition c1=null,c2=null;}
    : c1=char_defs                      {c.getCharacterDefinitions().add(c1);} 
        (COMMA c2=char_defs             {c.getCharacterDefinitions().add(c2);}
        )* ;

//ERROR: no R_BRACE required here
tuple_or_quad returns [ASNTupleQuadValue l = new ASNTupleQuadValue()]
                                        {ASNLiteralValue s1=null,s2=null,s3=null,s4=null;}
    : s1=signed_number                  {l.setNumber1 (s1);}
        COMMA s2=signed_number          {l.setNumber2 (s2);}
        (                                 {l.setQuad (true);}
            COMMA s3=signed_number      {l.setNumber3 (s3);}
            COMMA s4=signed_number      {l.setNumber4 (s4);}
        )? ;

/* NSS 15/1/05: Simplified to tuple/quad */
char_defs returns [ASNCharacterDefinition c = new ASNCharacterDefinition()]
                                        {ASNTupleQuadValue t=null;
                                         ASNDefinedValue d=null;}
    : c1:C_STRING                       {c.setType(ASNCharacterDefinition.STRING);
                                         c.setString (c1.getText());}
    | L_BRACE t=tuple_or_quad R_BRACE   {c.setType(ASNCharacterDefinition.TUPLEQUAD);
                                         c.setTupleOrQuad (t);}
    | d=defined_value                   {c.setType(ASNCharacterDefinition.DEFINEDVALUE);
                                         c.setDefinedValue (d);};

named_value returns [ASNNamedValue v = new ASNNamedValue()]
                                        {ASNValue va=null;}
    : l:LOWER va=value                  {v.setName (l.getText());
                                         v.setValue (va);};
