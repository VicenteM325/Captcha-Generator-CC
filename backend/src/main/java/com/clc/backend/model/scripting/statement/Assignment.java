package com.clc.backend.model.scripting.statement;

import com.clc.backend.model.scripting.Instruction;

/**
 *
 * @author vicente
 */

public class Assignment implements Instruction {

    private String variable;
    private String expresion;

    public Assignment(String variable, String expresion) {
        this.variable = variable;
        this.expresion = expresion;
    }

    public Assignment() {
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}