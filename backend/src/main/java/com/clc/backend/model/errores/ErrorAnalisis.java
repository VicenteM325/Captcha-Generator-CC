package com.clc.backend.model.errores;

import java.io.Serializable;

/**
 *
 * @author vicente
 */
public class ErrorAnalisis implements Serializable {

    private String lexema;
    private int linea;
    private int columna;
    private TipoError tipoError;
    private String descripcion;
    private String solucion;

    public ErrorAnalisis(int linea, int columna, TipoError tipoError, String descripcion, String solucion) {
        this.linea = linea;
        this.columna = columna;
        this.tipoError = tipoError;
        this.descripcion = descripcion;
        this.solucion = solucion;
    }

    public ErrorAnalisis() {
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public TipoError getTipoError() {
        return tipoError;
    }

    public void setTipoError(TipoError tipoError) {
        this.tipoError = tipoError;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
}
