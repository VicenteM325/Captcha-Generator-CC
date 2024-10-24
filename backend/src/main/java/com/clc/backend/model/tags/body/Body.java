package com.clc.backend.model.tags.body;

import java.util.ArrayList;
import java.util.List;
import com.clc.backend.model.tags.Parametro;
import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Body extends Tag {
    
    private List<Tag> etiquetas;

    public Body(List<Tag> etiquetas, List<Parametro> parametros) {
        this.etiquetas = etiquetas;
        initParameters(parametros);
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros = new ArrayList();
        super.parametros.add(new Parametro("background", "white"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }

}