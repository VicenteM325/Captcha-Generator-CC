package com.clc.backend.model.tags.body;

import java.util.List;
import com.clc.backend.model.tags.Parametro;

/**
 *
 * @author vicente
 */
public class Button extends TextTag {

    public Button(String text, List<Parametro> parametros) {
        super(text);
        initParametros(parametros);
    }

    private void initParametros(List<Parametro> parametros) {
        super.parametros.add(new Parametro("color", "white"));
        super.parametros.add(new Parametro("background", "black"));
        super.parametros.add(new Parametro("onclick", ""));

        parametros.forEach(p -> {
            Parametro aux = find(p.getName());

            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });
    }
}
