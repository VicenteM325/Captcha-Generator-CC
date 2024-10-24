package com.clc.backend.model.scripting;

import java.util.List;

/**
 *
 * @author vicente
 */
public class Process {
    
    private String name;
    private List<Instruction> instructions;

    public Process(String name, List<Instruction> instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}