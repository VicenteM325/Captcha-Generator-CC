%{
    // Código de inicio, para inicializar cualquier cosa necesaria
    function Captcha() {
        this.id = "";
        this.name = "";
        this.use = 0;
        this.hits = 0;
        this.faults = 0;
        this.lastDate = "";
    }

    let captchasList = [];
    let tempCaptcha = new Captcha();
%}

// Definición de tokens
%token CAPTCHAS ID NAME USE HITS FAULTS LAST_DATE
%token COLON COMMA OPEN_BRACE CLOSE_BRACE OPEN_BRACKET CLOSE_BRACKET
%token FECHA ENTERO VALUE LITERAL

// Definición del lexer
%lex
%%
\s+                   /* ignorar espacios en blanco */
\"captchas\"         return 'CAPTCHAS';
\"id\"               return 'ID';
\"name\"             return 'NAME';
\"use\"              return 'USE';
\"hits\"             return 'HITS';
\"faults\"           return 'FAULTS';
\"lastDate\"         return 'LAST_DATE';
":"                  return 'COLON';
","                  return 'COMMA';
"{"                  return 'OPEN_BRACE';
"}"                  return 'CLOSE_BRACE';
"["                  return 'OPEN_BRACKET';
"]"                  return 'CLOSE_BRACKET';
\"[0-9]+\"           return 'ENTERO';
\"[0-9]{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])\" return 'FECHA';
\"[^ "\"]*\"         return 'VALUE';
\"[^"]*\"            return 'LITERAL';
.                    yytext = 'Error: ' + yytext;
%%
/lex

// Definición del parser
%%
inicio
    : OPEN_BRACE CAPTCHAS COLON OPEN_BRACKET captchas CLOSE_BRACKET CLOSE_BRACE
        { return captchasList; }
    ;

captchas
    : captcha COMMA captchas
        { captchasList.push(tempCaptcha); tempCaptcha = new Captcha(); }
    | captcha
        { captchasList.push(tempCaptcha); tempCaptcha = new Captcha(); }
    ;

captcha
    : OPEN_BRACE params CLOSE_BRACE
        {
            captchasList.push(tempCaptcha);
            tempCaptcha = new Captcha();
        }
    ;

params
    : params COMMA param
    | param
    ;

param
    : ID COLON VALUE
        { tempCaptcha.id = yytext.replace(/"/g, ""); }
    | NAME COLON VALUE
        { tempCaptcha.name = yytext.replace(/"/g, ""); }
    | USE COLON ENTERO
        { tempCaptcha.use = parseInt(yytext.replace(/"/g, "")); }
    | HITS COLON ENTERO
        { tempCaptcha.hits = parseInt(yytext.replace(/"/g, "")); }
    | FAULTS COLON ENTERO
        { tempCaptcha.faults = parseInt(yytext.replace(/"/g, "")); }
    | LAST_DATE COLON FECHA
        { tempCaptcha.lastDate = yytext.replace(/"/g, ""); }
    ;

value
    : VALUE
        { $$ = yytext; }
    | LITERAL
        { $$ = yytext; }
    ;
%%

// Función de manejo de errores
parser.yy = {}; // Crear un contexto para manejar errores
parser.yy.onError = function (msg, hash) {
    console.error("Syntax error: ", msg, " at line: ", hash.line);
};

