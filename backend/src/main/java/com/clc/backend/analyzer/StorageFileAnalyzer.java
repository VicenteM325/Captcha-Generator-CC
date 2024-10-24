package com.clc.backend.analyzer;

import com.clc.backend.analizadores.lexico.StorageLexer;
import com.clc.backend.analizadores.sintactico.StorageParser;
import java.io.Reader;
import java.util.List;
import com.clc.backend.model.Captcha;

/**
 *
 * @author vicente
 */
public class StorageFileAnalyzer {
    private StorageLexer lex;
    private StorageParser parser;

    public StorageFileAnalyzer() {
    }
    
    public List<Captcha> analyzeData(Reader reader) {
        try {
            lex = new StorageLexer(reader);
            parser = new StorageParser(lex);
            
            parser.parse();
            return parser.getCaptchas();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}