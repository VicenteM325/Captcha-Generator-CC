
package com.clc.backend.model.tags.body;

import java.util.List;
import com.clc.backend.model.tags.Parametro;
import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Select extends TextTag {
    
    private List<Tag> options;

    public Select(List<Tag> options, String text, List<Parametro> parametros) {
        super(text);
        this.options = options;
        initParameters(parametros);
    }

    public List<Tag> getOptions() {
        return options;
    }

    public void setOptions(List<Tag> options) {
        this.options = options;
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
