package com.clc.backend.model.scripting;

/**
 *
 * @author vicente
 */
public class Function implements Instruction {

    private String name;
    private String parameter;

    public Function(String name, String parameter) {
        this.name = name;
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}