package com.clc.backend.model.tags.body;

import java.util.ArrayList;
import java.util.List;
import com.clc.backend.model.tags.Parametro;
import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Img extends Tag {

    public Img(List<Parametro> parametros) {
        initParameters(parametros);
    }

    private void initParameters(List<Parametro> parametros) {
        super.parametros = new ArrayList();
        super.parametros.add(new Parametro("src", "https://cdn.lifehack.org/wp-content/uploads/2015/01/Fed-up-with-Distorted-Texts-for-Verification-Google-Is-Offering-New-CAPTCHA.jpg"));
        super.parametros.add(new Parametro("width", "200px"));
        super.parametros.add(new Parametro("height", "200px"));
        super.parametros.add(new Parametro("alt", "Imagen de prueba"));
        super.parametros.add(new Parametro("id", "default"));

        parametros.forEach(p -> {
            Parametro aux = find(p.getName());

            if (aux != null) {
                aux.setValue(p.getValue());
            }
        });

    }
}
