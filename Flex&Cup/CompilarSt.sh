#!/bin/bash
 echo Compilando Lexer...
 java -jar jflex-full-1.9.1.jar storageLexer.flex
 echo ---------------------
 echo Compilando Parser...
 java -jar java-cup-11b.jar -parser StorageParser -symbols StorageSym storageParser.cup

 mv StorageLexer.java ~/NetBeansProjects/Captcha-Generator-CC/backend/src/main/java/com/clc/backend/analizadores/lexico/
 mv StorageParser.java StorageSym.java ~/NetBeansProjects/Captcha-Generator-CC/backend/src/main/java/com/clc/backend/analizadores/sintactico/