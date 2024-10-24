package com.clc.backend.model.scripting.ifstatement;

import java.util.List;
import com.clc.backend.model.scripting.Instruction;

/**
 *
 * @author vicente
 */
public class IfStatement implements Instruction {

    private String condition;
    private List<Instruction> instructions;
    private List<IfType> ifTypes;

    public IfStatement(String condition, List<Instruction> instructions, List<IfType> ifTypes) {
        this.condition = condition;
        this.instructions = instructions;
        this.ifTypes = ifTypes;
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

    public List<IfType> getIfTypes() {
        return ifTypes;
    }

    public void setIfTypes(List<IfType> ifTypes) {
        this.ifTypes = ifTypes;
    }
}