package com.clc.backend.model.scripting.statement;

import java.util.List;
import com.clc.backend.model.scripting.Instruction;
import com.clc.backend.model.scripting.TipoDato;

/**
 *
 * @author vicente
 */

public class SimpleStatement implements Instruction {

    private TipoDato type;
    private boolean isGlobal;
    private List<String> variables;

    public SimpleStatement(TipoDato type, boolean isGlobal, List<String> variables) {
        this.type = type;
        this.isGlobal = isGlobal;
        this.variables = variables;
    }

    public SimpleStatement() {
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
}