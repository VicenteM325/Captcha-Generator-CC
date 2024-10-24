package com.clc.backend.model.scripting.ifstatement;


import java.util.List;
import com.clc.backend.model.scripting.Instruction;

/**
 *
 * @author vicente
 */
public class ElseStatement implements IfType {
    
    private List<Instruction> instructions;

    public ElseStatement() {
    }

    public ElseStatement(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
}