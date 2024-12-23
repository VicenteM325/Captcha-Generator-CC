package com.clc.backend.model.scripting;

/**
 *
 * @author vicente
 */
public class VariableTS {

    private String id;
    private TipoDato tipo;
    private String mode;
    private String process;
    private Object value;

    public VariableTS(String id, TipoDato tipo, String mode, String process, Object value) {
        this.id = id;
        this.tipo = tipo;
        this.mode = mode;
        this.process = process;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo.name().toLowerCase();
    }

    public void setTipo(TipoDato tipo) {
        this.tipo = tipo;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
}
