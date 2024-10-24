package com.clc.backend.analizadores.lexico;

import java.util.ArrayList;
import java.util.List;
import com.clc.backend.model.errores.ErrorAnalisis;
import com.clc.backend.model.errores.TipoError;
import com.clc.backend.model.scripting.TipoDato;
import com.clc.backend.model.Token;
import com.clc.backend.model.TypeToken;
import static com.clc.backend.analizadores.sintactico.Sym.*;

import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%cup
%unicode
%line
%column

%{
    private List<ErrorAnalisis> errores = new ArrayList();
    private StringBuilder literal = new StringBuilder();

    private Symbol symbol(int type){
        return new Symbol(type, new Token(yyline, yycolumn, yytext()));
    }

    private Symbol symbol(int type, TipoDato tipoDato) {
        return new Symbol(type, new TypeToken(tipoDato, yyline, yycolumn, yytext()));
    }

    private Symbol symbol(int type, TipoDato tipoDato, String text) {
        String textLiteral = text + "\"";
        literal = new StringBuilder();
        return new Symbol(type, new TypeToken(tipoDato, yyline, yycolumn, textLiteral));
    }

    private void addLexicError(){
        String descripcion = "La palabra " + yytext() + " no es valida";
        String solucion = "Revisar las palabras aceptadas por el lenguaje";
        ErrorAnalisis errorA = new ErrorAnalisis(yyline + 1, yycolumn + 1, TipoError.LEXICO, descripcion, solucion);
        errorA.setLexema(yytext());

        if (!errores.isEmpty()) {
            ErrorAnalisis e = errores.get(errores.size() - 1);

            if ((errorA.getColumna() - e.getColumna()) == 1) {
                e.setLexema(e.getLexema() + errorA.getLexema());
                e.setColumna(errorA.getColumna());
                e.setDescripcion("La palabra " + e.getLexema() + " no es valida");
            }else {
                errores.add(errorA);
            }
        } else {
            errores.add(errorA);
        }
    }

    public List<ErrorAnalisis> getErrores() {
        return this.errores;
    }
%}

%eofval{
    return new Symbol(EOF, new Token(yyline, yycolumn, "Fin de linea"));
%eofval}

ENTERO = (0|([1-9][0-9]*))
ENTERO2 = (0|(-)?([1-9][0-9]*))
DECIMAL = (0|(-)?([1-9][0-9]*)(\.(0|([0-9]*[1-9]){1,4})))

//* Regexs for comments
LINE_COMMENT = "!!"[^\n]*
BLOCK_COMMENT = "<!--"~"-->"

//* Regexs for parameters
URL = (https?:\/\/)?([\da-z\.-]+)\.([\/\w \.-]*)*\/?
COLOR = #([a-fA-F0-9]{6}|[a-fA-F0-9]{3})
SIZE = {ENTERO}(px)
WH_VAL = {ENTERO}("%")
IDPARAM = [_$-][\w$-]*
NAMEPARAM = [:letter:][\w $-]*

PROCESS_NAME = "PROCESS_"[\w]*
IDVAR = [:letter:][\w]*

%state TAG
%state PARAMETER
%state VALUE
%state SCRIPTING
%state LITERALS
%state DATOSCRIPTING

%%

//* Etiquetas
<TAG> [cC]_[cC][cC]                               { return symbol(C_CC); }
<TAG> [cC]_[hH][eE][aA][dD]                       { return symbol(C_HEAD); }
<TAG> [cC]_[tT][iI][tT][lL][eE]                   { return symbol(C_TITLE); }
<TAG> [cC]_[lL][iI][nN][kK]                       { return symbol(C_LINK); }
<TAG> [cC]_[bB][oO][dD][yY]                       { return symbol(C_BODY); }
<TAG> [cC]_[sS][pP][aA][mM]                       { return symbol(C_SPAM); }
<TAG> [cC]_[iI][nN][pP][uU][tT]                   { return symbol(C_INPUT); }
<TAG> [cC]_[tT][eE][xX][tT][aA][rR][eE][aA]       { return symbol(C_TEXTAREA); }
<TAG> [cC]_[sS][eE][lL][eE][cC][tT]               { return symbol(C_SELECT); }
<TAG> [cC]_[oO][pP][tT][iI][oO][nN]               { return symbol(C_OPTION); }
<TAG> [cC]_[dD][iI][vV]                           { return symbol(C_DIV); }
<TAG> [cC]_[iI][mM][gG]                           { return symbol(C_IMG); }
<TAG> [cC]_[bB][rR]                               { return symbol(C_BR); }
<TAG> [cC]_[bB][uU][tT][tT][oO][nN]               { return symbol(C_BUTTON); }
<TAG> [cC]_[hH]1                                  { return symbol(C_H1); }
<TAG> [cC]_[pP]                                   { return symbol(C_P); }
<TAG> [cC]_[sS][cC][rR][iI][pP][tT][iI][nN][gG]   { yybegin(SCRIPTING); return symbol(C_SCRIPTING); }
<SCRIPTING> [cC]_[sS][cC][rR][iI][pP][tT][iI][nN][gG]   { yybegin(TAG); return symbol(C_SCRIPTING); }

// Parametros
<PARAMETER> "href"          { return symbol(HREF); }
<PARAMETER> "background"    { return symbol(BACKGROUND); }
<PARAMETER> "color"         { return symbol(COLOR); }
<PARAMETER> "font-size"     { return symbol(FONT_SIZE); }
<PARAMETER> "font-family"   { return symbol(FONT_FAMILY); }
<PARAMETER> "text-align"    { return symbol(TEXT_ALIGN); }
<PARAMETER> "type"          { return symbol(TYPE); }
<PARAMETER> "id"            { return symbol(ID); }
<PARAMETER> "name"          { return symbol(NAME); }
<PARAMETER> "cols"          { return symbol(COLS); }
<PARAMETER> "rows"          { return symbol(ROWS); }
<PARAMETER> "class"         { return symbol(CLASS); }
<PARAMETER> "src"           { return symbol(SRC); }
<PARAMETER> "width"         { return symbol(WIDTH); }
<PARAMETER> "height"        { return symbol(HEIGHT); }
<PARAMETER> "alt"           { return symbol(ALT); }
<PARAMETER> "onclick"       { return symbol(ONCLICK); }

// Colores
<VALUE> "black"         { return symbol(BLACK); }
<VALUE> "olive"         { return symbol(OLIVE); }
<VALUE> "teal"          { return symbol(TEAL); }
<VALUE> "red"           { return symbol(RED); }
<VALUE> "blue"          { return symbol(BLUE); }
<VALUE> "marron"        { return symbol(MARRON); }
<VALUE> "navy"          { return symbol(NAVY); }
<VALUE> "gray"          { return symbol(GRAY); }
<VALUE> "lime"          { return symbol(LIME); }
<VALUE> "fuchsia"       { return symbol(FUCHSIA); }
<VALUE> "green"         { return symbol(GREEN); }
<VALUE> "purple"        { return symbol(PURPLE); }
<VALUE> "silver"        { return symbol(SILVER); }
<VALUE> "yellow"        { return symbol(YELLOW); }
<VALUE> "aqua"          { return symbol(AQUA); }

// Fuentes
<VALUE> "Courier"       { return symbol(COURIER); }
<VALUE> "Verdana"       { return symbol(VERDANA); }
<VALUE> "Arial"         { return symbol(ARIAL); }
<VALUE> "Geneva"        { return symbol(GENEVA); }
<VALUE> "sans-serif"    { return symbol(SANS_SERIF); }

// Alineaciones
<VALUE> "left"          { return symbol(LEFT); }
<VALUE> "center"        { return symbol(CENTER); }
<VALUE> "right"         { return symbol(RIGHT); }
<VALUE> "justify"       { return symbol(JUSTIFY); }

// Tipos Input
<VALUE> "text"          { return symbol(TEXT); }
<VALUE> "number"        { return symbol(NUMBER); }
<VALUE> "radio"         { return symbol(RADIO); }
<VALUE> "checkbox"      { return symbol(CHECKBOX); }

//* Div classes
<VALUE> "column"        { return symbol(COLUMN); }
<VALUE> "row"           { return symbol(ROW); }

//* CLC
<SCRIPTING> "ON_LOAD"       { return symbol(ON_LOAD); }
<SCRIPTING> "@global"       { return symbol(GLOBAL_MODE); }

//* Tipos de datos
<SCRIPTING> "integer"       { return symbol(INTEGER, TipoDato.INTEGER); }
<SCRIPTING> "decimal"       { return symbol(DECIMAL, TipoDato.DECIMAL); }
<SCRIPTING> "boolean"       { return symbol(BOOLEAN, TipoDato.BOOLEAN); }
<SCRIPTING> "char"          { return symbol(CHAR, TipoDato.CHAR); }
<SCRIPTING> "string"        { return symbol(STRING, TipoDato.STRING); }
<SCRIPTING> "true"          { return symbol(TRUE, TipoDato.BOOLEAN); }
<SCRIPTING> "false"         { return symbol(FALSE, TipoDato.BOOLEAN); }

// Funciones especiales
<SCRIPTING> "ASC"                   { return symbol(ASC, TipoDato.STRING); }
<SCRIPTING> "DESC"                  { return symbol(DESC, TipoDato.STRING); }
<SCRIPTING> "LETPAR_NUM"            { return symbol(LETPAR_NUM, TipoDato.STRING); }
<SCRIPTING> "LETIMPAR_NUM"          { return symbol(LETIMPAR_NUM, TipoDato.STRING); }
<SCRIPTING> "REVERSE"               { return symbol(REVERSE, TipoDato.STRING); }
<SCRIPTING> "CARACTER_ALEATORIO"    { return symbol(CARACTER_ALEATORIO, TipoDato.CHAR); }
<SCRIPTING> "NUM_ALEATORIO"         { return symbol(NUM_ALEATORIO, TipoDato.INTEGER); }
<SCRIPTING> "ALERT_INFO"            { return symbol(ALERT_INFO); }
<SCRIPTING> "EXIT"                  { return symbol(EXIT); }
<SCRIPTING> "REDIRECT"              { return symbol(REDIRECT); }
<SCRIPTING> "getElemenById"        { return symbol(ELEMENT_BY_ID, TipoDato.STRING); }

// Bloques y estructuras de control
<SCRIPTING> "INIT"          { return symbol(INIT); }
<SCRIPTING> "END"           { return symbol(END); }
<SCRIPTING> "IF"            { return symbol(IF); }
<SCRIPTING> "THEN"          { return symbol(THEN); }
<SCRIPTING> "ELSE"          { return symbol(ELSE); }
<SCRIPTING> "REPEAT"        { return symbol(REPEAT); }
<SCRIPTING> "HUNTIL"        { return symbol(HUNTIL); }
<SCRIPTING> "WHILE"         { return symbol(WHILE); }
<SCRIPTING> "THENWHILE"     { return symbol(THENWHILE); }
<SCRIPTING> "INSERT"        { return symbol(INSERT);}

<YYINITIAL, TAG, PARAMETER, VALUE, SCRIPTING> {
    {LINE_COMMENT}          { /**Ignorar*/ }
    {BLOCK_COMMENT}         { /**Ignorar*/ }
    (\s)+                   { /**Ignorar*/ }
}

<YYINITIAL> {
    "<"             { yybegin(TAG); return symbol(LESS_THAN); }
    [^<]+           { return symbol(TEXT_TAG); }
}

<TAG> {
    ">"             { yybegin(YYINITIAL); return symbol(GREATER_THAN); }
    "["             { yybegin(PARAMETER); return symbol(OPEN_BRACKET); }
    "/"             { return symbol(SLASH); }
}

<PARAMETER> {
    "]"             { yybegin(TAG); return symbol(CLOSE_BRACKET); }
    ("\""|"“"|"”")  { yybegin(VALUE); return symbol(QOUTE_MARK); }
    "="             { return symbol(ASSIGN); }
}

<VALUE> {
    ("\""|"“"|"”")  { yybegin(PARAMETER); return symbol(QOUTE_MARK); }
    "("             { return symbol(OPEN_ROUND_BRACKET); }
    ")"             { return symbol(CLOSE_ROUND_BRACKET); }
}

<SCRIPTING> {
    "("             { return symbol(OPEN_ROUND_BRACKET); }
    ")"             { return symbol(CLOSE_ROUND_BRACKET); }
    "["             { return symbol(OPEN_BRACKET); }
    "]"             { return symbol(CLOSE_BRACKET); }
    "{"             { return symbol(OPEN_BRACE); }
    "}"             { return symbol(CLOSE_BRACE); }
    "="             { return symbol(ASSIGN); }
    ","             { return symbol(COMMA); }
    ":"             { return symbol(COLON); }
    ";"             { return symbol(SEMI); }
    ("\""|"“"|"”")  { literal.append("\""); yybegin(LITERALS); }
    ("'"|"‘"|"’")   { yybegin(DATOSCRIPTING); }

    // Operadores relacionales
    "=="            { return symbol(EQUAL_TO); }
    "!="            { return symbol(NOT_EQTUAL_TO); }
    "<"             { return symbol(LESS_THAN); }
    ">"             { return symbol(GREATER_THAN); }
    "<="            { return symbol(LESS_THAN_OR_EQUAL_TO); }
    ">="            { return symbol(GREATER_THAN_OR_EQUAL_TO); }

    // Operadores logicos
    "||"            { return symbol(OR); }
    "&&"            { return symbol(AND); }
    "!"             { return symbol(NOT); }

    // Operadores aritmeticos
    "+"             { return symbol(PLUS); }
    "-"             { return symbol(MINUS); }
    "*"             { return symbol(TIMES); }
    "/"             { return symbol(DIVIDE); }
}

<LITERALS> {
    ("\""|"“"|"”")  { yybegin(SCRIPTING); return symbol(LITERAL, TipoDato.STRING, literal.toString()); }
    [^'\"']+        { literal.append(yytext()); }
}

<DATOSCRIPTING> {
    ("'"|"‘"|"’")       { yybegin(SCRIPTING); }
    [^"'""‘""’"]{1}     { return symbol(CHAR_VAL, TipoDato.CHAR); }
    [^"'""‘""’"][^"'""‘""’"]+    { return symbol(DATOSCRIPT); }
}

<VALUE> {URL}                       { return symbol(URL); }
<VALUE> {COLOR}                     { return symbol(COLOR_VALUE); }
<VALUE> {SIZE}                      { return symbol(SIZE); }
<VALUE> {WH_VAL}                    { return symbol(WH_VAL); }
<VALUE> {PROCESS_NAME}              { return symbol(PROCESS_NAME); }
<VALUE> {IDPARAM}                   { return symbol(ID_PARAM); }
<VALUE> {ENTERO}                    { return symbol(ENTERO); }
<VALUE> {NAMEPARAM}                 { return symbol(NAME_PARAM); }

<SCRIPTING> {PROCESS_NAME}              { return symbol(PROCESS_NAME); }
<SCRIPTING> {IDVAR}                     { return symbol(ID_VAR); }
<SCRIPTING> {ENTERO2}                   { return symbol(ENTERO2, TipoDato.INTEGER); }
<SCRIPTING> {DECIMAL}                   { return symbol(DECIMAL_VAL, TipoDato.DECIMAL); }

[^]                                     { addLexicError(); }