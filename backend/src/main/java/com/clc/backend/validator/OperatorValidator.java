package com.clc.backend.validator;

import com.clc.backend.model.scripting.Expresion;
import com.clc.backend.model.scripting.TipoDato;

/**
 *
 * @author vicente
 */
public abstract class OperatorValidator {
    
    protected Expresion expr = new Expresion(null);

    public abstract Expresion validate(Expresion expr1, Expresion expr2);
    
    protected void setExpresion(TipoDato tipoDato) {
        expr = new Expresion(tipoDato);
    }
    
    protected void setTipos(Expresion expr2, TipoDato dataTypes[]) {
        switch (expr2.getTipo()) {
            case INTEGER -> setExpresion(dataTypes[0]);
            case STRING -> setExpresion(dataTypes[1]);
            case DECIMAL -> setExpresion(dataTypes[2]);
            case CHAR -> setExpresion(dataTypes[3]);
            case BOOLEAN -> setExpresion(dataTypes[4]);
        }
    }
}