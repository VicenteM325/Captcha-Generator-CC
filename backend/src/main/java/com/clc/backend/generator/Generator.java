package com.clc.backend.generator;

/**
 *
 * @author vicente
 */
public abstract class Generator {

    protected StringBuilder htmlCode;
    
    public abstract String generate();
    
    protected void addLine(String s, int tabulaciones) {

        for (int i = 0; i < tabulaciones; i++) {
            htmlCode.append("    ");
        }

        htmlCode.append(s).append("\n");
    }
}
