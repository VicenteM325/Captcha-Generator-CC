package com.clc.backend.model.tags.head;

import java.util.ArrayList;
import java.util.List;
import com.clc.backend.model.tags.Parametro;
import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Link extends Tag {

    public Link(List<Parametro> parametros) {
        initParameters(parametros);
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros = new ArrayList();
        super.parametros.add(new Parametro("href", "http://www.google.com"));
        
        parametros.forEach(p -> {
            Parametro aux = find(p.getName());
            
            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}