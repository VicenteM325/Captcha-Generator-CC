package com.clc.backend.analyzer;

import com.clc.backend.analizadores.lexico.Lexer;
import com.clc.backend.analizadores.sintactico.Parser;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import com.clc.backend.model.errores.ErrorAnalisis;
import com.clc.backend.model.scripting.VariableTS;
import com.clc.backend.model.tags.CC;

/**
 *
 * @author vicente
 */
public class CCAnalyzer {

    private String inputText;
    private Lexer lexer;
    private Parser parser;
    private List<ErrorAnalisis> errores = new ArrayList();

    public CCAnalyzer(String inputText) {
        this.inputText = inputText;
    }
    
    public void analyze() {
        try {
            StringReader reader = new StringReader(inputText);
            lexer = new Lexer(reader);
            parser = new Parser(lexer);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public CC getCc() {
        return (CC) parser.getCC();
    }

    public List<ErrorAnalisis> getErrores() {
        errores.addAll(lexer.getErrores());
        errores.addAll(parser.getErrores());
        return errores;
    }
    
    public List<VariableTS> getVariables() {
        return parser.getVariables();
    }
}