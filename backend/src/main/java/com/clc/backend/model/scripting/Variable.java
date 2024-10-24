package com.clc.backend.model.scripting;

/**
 *
 * @author vicente
 */
public class Variable {
    
    private String id;
    private TipoDato type;
    private boolean hasValue;

    public Variable(String id, TipoDato type, boolean hasValue) {
        this.id = id;
        this.type = type;
        this.hasValue = hasValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoDato getType() {
        return type;
    }

    public void setType(TipoDato type) {
        this.type = type;
    }

    public boolean getHasValue() {
        return hasValue;
    }

    public void setHasValue(boolean hasValue) {
        this.hasValue = hasValue;
    }
}