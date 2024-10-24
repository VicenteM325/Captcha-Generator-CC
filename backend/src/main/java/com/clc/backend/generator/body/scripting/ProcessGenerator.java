package com.clc.backend.generator.body.scripting;

import com.clc.backend.generator.Generator;
import java.util.Collections;
import java.util.List;
import com.clc.backend.model.scripting.Function;
import com.clc.backend.model.scripting.Instruction;
import com.clc.backend.model.scripting.Process;
import com.clc.backend.model.scripting.ifstatement.ElseIfStatement;
import com.clc.backend.model.scripting.ifstatement.ElseStatement;
import com.clc.backend.model.scripting.ifstatement.IfStatement;
import com.clc.backend.model.scripting.statement.Assignment;
import com.clc.backend.model.scripting.statement.FullStatement;
import com.clc.backend.model.scripting.statement.SimpleStatement;

/**
 *
 * @author vicente
 */
public class ProcessGenerator extends Generator {

    private Process process;

    public ProcessGenerator() {
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        if (process.getName().contains("ON_LOAD")) {
            addLine(process.getName() + "();", 0);
        }
        htmlCode.append("function ").append(process.getName()).append("() {\n");
        generateInstructions(process.getInstructions());
        addLine("increaseNoExecs(\"" + process.getName() + "\");", 0);
        addLine("updateTableData();", 0);
        addLine("}", 0);

        return htmlCode.toString();
    }

    private void generateInstructions(List<Instruction> instructions) {
        instructions.forEach(i -> {
            if (i instanceof FullStatement) {
                FullStatement fs = (FullStatement) i;
                String global = (fs.isIsGlobal()) ? "@global" : "-";
                fs.getVariables().forEach(v -> {
                    htmlCode.append("\taddVar('").append(fs.getType().name().toLowerCase())
                            .append("', '").append(v).append("', ").append(fs.getExpresion())
                            .append(", '").append(global).append("', '").append(process.getName())
                            .append("', 0").append(");\n");
                });
            } else if (i instanceof SimpleStatement) {
                SimpleStatement ss = (SimpleStatement) i;
                String global = (ss.isIsGlobal()) ? "@global" : "-";
                ss.getVariables().forEach(v -> {
                    htmlCode.append("\taddVar('").append(ss.getType().name().toLowerCase())
                            .append("', '").append(v).append("', ").append("null")
                            .append(", '").append(global).append("', '").append(process.getName())
                            .append("', 0").append(");\n");
                });
            } else if (i instanceof Assignment) {
                Assignment a = (Assignment) i;
                htmlCode.append("\tsetValue('").append(a.getVariable()).append("' , '")
                        .append(process.getName())
                        .append("', ").append(a.getExpresion()).append(");\n");
            } else if (i instanceof IfStatement) {
                IfStatement is = (IfStatement) i;
                htmlCode.append("\tif (").append(is.getCondition()).append(") {\n");
                generateInstructions(is.getInstructions());
                htmlCode.append("\n\t} ");
                if (!is.getIfTypes().isEmpty()) {
                    Collections.reverse(is.getIfTypes());
                    is.getIfTypes().forEach(it -> {
                        if (it instanceof ElseIfStatement) {
                            ElseIfStatement elseIf = (ElseIfStatement) it;
                            htmlCode.append("else if (").append(elseIf.getCondition()).append(") {\n");
                            generateInstructions(elseIf.getInstructions());
                            htmlCode.append("\n\t} ");
                        } else if (it instanceof ElseStatement) {
                            ElseStatement elseS = (ElseStatement) it;
                            htmlCode.append("else {\n");
                            generateInstructions(elseS.getInstructions());
                            addLine("\n\t}", 0);
                        }
                    });
                }
                addLine("", 0);
            } else if (i instanceof Function) {
                Function f = (Function) i;
                htmlCode.append("\n").append(f.getName()).append(f.getParameter()).append(";\n");
            }
        });
    }

}