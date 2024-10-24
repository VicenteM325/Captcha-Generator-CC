package com.clc.backend.generator.body;

import com.clc.backend.generator.Generator;
import com.clc.backend.generator.body.scripting.ProcessGenerator;
import java.util.List;
import com.clc.backend.model.scripting.Process;
import com.clc.backend.model.tags.body.Scripting;

/**
 *
 * @author vicente
 */
public class ScriptingGenerator extends Generator {
    
    private final Scripting script;

    public ScriptingGenerator(Scripting script) {
        this.script = script;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        addLine("<script>", 0);
        generateProcesos(script.getOnload(), script.getProcesos());
        addLine("</script>", 0);
        
        return htmlCode.toString();
    }

    private void generateProcesos(Process onload, List<Process> procesos) {
        ProcessGenerator processG = new ProcessGenerator();
        
        if (onload != null) {
            processG.setProcess(onload);
            addLine(processG.generate(), 0);
        }
        
        procesos.forEach(p -> {
            processG.setProcess(p);
            addLine(processG.generate(), 0);
        });
    }

}
