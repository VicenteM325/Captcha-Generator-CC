package com.clc.backend.model.tags.body;

import java.util.List;
import com.clc.backend.model.tags.Parametro;

/**
 *
 * @author vicente
 */
public class Span extends TextTag {

    public Span(String text, List<Parametro> parametros) {
        super(text);
        initParameters(parametros);
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros.add(new Parametro("color", "black"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}