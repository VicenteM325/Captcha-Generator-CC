package com.clc.backend.model.tags.body;

import java.util.List;
import com.clc.backend.model.tags.Parametro;
import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Div extends TextTag {
    
    private List<Tag> etiquetas;

    public Div(List<Tag> etqiuetas, String text, List<Parametro> parametros) {
        super(text);
        this.etiquetas = etqiuetas;
        initParameters(parametros);
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros.add(new Parametro("class", "row"));
        super.parametros.add(new Parametro("color", "black"));
        super.parametros.add(new Parametro("background", "white"));
        
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}
