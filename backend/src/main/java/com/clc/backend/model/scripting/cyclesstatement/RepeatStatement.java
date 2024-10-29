package com.clc.backend.model.scripting.cyclesstatement;


import java.util.List;
import com.clc.backend.model.scripting.Instruction;
/**
 *
 * @author vicente
 */
public class RepeatStatement implements Instruction {
    private String varInicio; 
    private List<Instruction> instructions;  
    private String limit;

    public RepeatStatement(String varInicio, List<Instruction> instructions, String limit) {
        this.varInicio = varInicio;
        this.instructions = instructions;
        this.limit = limit;
    }

    public String getVarInicio() {
        return varInicio;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public String getLimit() {
        return limit;
    }
}