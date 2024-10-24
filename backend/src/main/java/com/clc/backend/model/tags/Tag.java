package com.clc.backend.model.tags;

import java.util.List;

/**
 *
 * @author vicente
 */
public abstract class Tag {

    protected List<Parametro> parametros;
    
    protected Parametro find(String name){
        Parametro param = null;
        for (Parametro p: parametros) {
            if (name.equals(p.getName())) {
                param = p;
            }
        }
        
        return param;
    }
    
    //public abstract String generateHtml();
    
    public List<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }
    
    public String getParameterValue(String name) {
        String value = null;
        for (Parametro p: parametros) {
            if (p.getName().equals(name)) {
                value = p.getValue();
            }
        }
        
        return value;
    }
    
    public Parametro getParameter(String name) {
        Parametro value = null;
        for (Parametro p: parametros) {
            if (p.getName().equals(name)) {
                value = p;
            }
        }
        
        return value;
    }
}