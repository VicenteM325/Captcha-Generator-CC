
package com.clc.backend.model.tags.body;


import java.util.List;
import com.clc.backend.model.scripting.Process;
import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Scripting extends Tag {

    private Process Onload;
    private List<Process> procesos;

    public Scripting(Process Onload, List<Process> procesos) {
        this.Onload = Onload;
        this.procesos = procesos;
    }

    public Scripting(Process Onload) {
        this.Onload = Onload;
    }

    public Scripting(List<Process> procesos) {
        this.procesos = procesos;
    }

    public Scripting() {
    }

    public List<Process> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Process> procesos) {
        this.procesos = procesos;
    }

    public Process getOnload() {
        return Onload;
    }

    public void setOnload(Process Onload) {
        this.Onload = Onload;
    }
}