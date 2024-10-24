package com.clc.backend.model;

import com.clc.backend.model.scripting.TipoDato;

/**
 *
 * @author vicente
 */
public class TypeToken extends Token {

    private TipoDato type;

    public TypeToken(TipoDato type, int linea, int columna, String lexema) {
        super(linea, columna, lexema);
        this.type = type;
    }

    public TipoDato getType() {
        return type;
    }

    public void setType(TipoDato type) {
        this.type = type;
    }
}
