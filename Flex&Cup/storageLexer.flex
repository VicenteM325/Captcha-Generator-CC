package com.clc.backend.analizadores.lexico;

import java_cup.runtime.Symbol;
import static com.clc.backend.analizadores.sintactico.StorageSym.*;

%%

%class StorageLexer
%public
%cup
%unicode
%line
%column

%{

    private Symbol symbol(int type){
        return new Symbol(type, yytext());
    }

%}

%eofval{
    return new Symbol(EOF, "Fin de linea");
%eofval}

ENTERO = "\""(0|([1-9][0-9]*))"\""
FECHA = "\""\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])"\""
VALUE = "\""[^ '\"']*"\""
LITERAL = "\""[^"\""]*"\""

%%

<YYINITIAL> "\"captchas\""  { return symbol(CAPTCHAS); }
<YYINITIAL> "\"id\""        { return symbol(ID); }
<YYINITIAL> "\"name\""      { return symbol(NAME); }
<YYINITIAL> "\"use\""       { return symbol(USE); }
<YYINITIAL> "\"hits\""      { return symbol(HITS); }
<YYINITIAL> "\"faults\""    { return symbol(FAULTS); }
<YYINITIAL> "\"lastDate\""  { return symbol(LAST_DATE); }

<YYINITIAL> {
    ":"                     { return symbol(COLON); }
    ","                     { return symbol(COMMA); }
    "{"                     { return symbol(OPEN_BRACE); }
    "}"                     { return symbol(CLOSE_BRACE); }
    "["                     { return symbol(OPEN_BRACKET); }
    "]"                     { return symbol(CLOSE_BRACKET); }
    (\s)                    { /*Ignorar*/ }
}

<YYINITIAL> {ENTERO}        { return symbol(ENTERO); }
<YYINITIAL> {FECHA}         { return symbol(FECHA); }
<YYINITIAL> {VALUE}         { return symbol(VALUE); }
<YYINITIAL> {LITERAL}       { return symbol(LITERAL); }

[^]                         { System.out.println("Error: " + yytext()); }