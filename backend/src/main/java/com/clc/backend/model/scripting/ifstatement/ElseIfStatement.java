package com.clc.backend.model.scripting.ifstatement;

import java.util.List;
import com.clc.backend.model.scripting.Instruction;

/**
 *
 * @author vicente
 */

public class ElseIfStatement implements IfType {

    private String condition;
    private List<Instruction> instructions;

    public ElseIfStatement(String condition, List<Instruction> instructions) {
        this.condition = condition;
        this.instructions = instructions;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }
}