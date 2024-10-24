#!/bin/bash
 echo Compilando Lexer...
 java -jar jflex-full-1.9.1.jar lexer.flex
 echo ---------------------
 echo Compilando Parser...
 java -jar java-cup-11b.jar -parser Parser -symbols Sym parser.cup

 mv Lexer.java ~/NetBeansProjects/Captcha-Generator-CC/backend/src/main/java/com/clc/backend/analizadores/lexico/
 mv Parser.java Sym.java ~/NetBeansProjects/Captcha-Generator-CC/backend/src/main/java/com/clc/backend/analizadores/sintactico/