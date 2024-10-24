package com.clc.backend.model.scripting;

/**
 *
 * @author vicente
 */
public class Expresion {

    private TipoDato tipo;
    private String text;

    public Expresion(TipoDato tipo, String text) {
        this.tipo = tipo;
        this.text = text;
    }

    public Expresion(TipoDato tipo) {
        this.tipo = tipo;
    }

    public TipoDato getTipo() {
        return tipo;
    }

    public void setTipo(TipoDato tipo) {
        this.tipo = tipo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
