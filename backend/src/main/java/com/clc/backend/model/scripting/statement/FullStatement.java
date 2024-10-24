package com.clc.backend.model.scripting.statement;

import java.util.List;
import com.clc.backend.model.scripting.Instruction;
import com.clc.backend.model.scripting.TipoDato;

/**
 *
 * @author vicente
 */
public class FullStatement implements Instruction {

    private TipoDato type;
    private boolean isGlobal;
    private List<String> variables;
    private String expresion;

    public FullStatement(TipoDato type, boolean isGlobal, List<String> variables, String expresion) {
        this.type = type;
        this.isGlobal = isGlobal;
        this.variables = variables;
        this.expresion = expresion;
    }

    public FullStatement() {
    }

    public TipoDato getType() {
        return type;
    }

    public void setType(TipoDato type) {
        this.type = type;
    }

    public boolean isIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public List<String> getVariables() {
        return variables;
    }

    public void setVariables(List<String> variables) {
        this.variables = variables;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}