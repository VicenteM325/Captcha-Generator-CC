package com.clc.backend.model.tags.body;

import java.util.ArrayList;
import com.clc.backend.model.tags.Parametro;
import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class TextTag extends Tag {

    private String text;

    public TextTag(String text) {
        this.text = text;
        initParameters();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void initParameters() {
        super.parametros = new ArrayList();
        super.parametros.add(new Parametro("id", "default"));
        super.parametros.add(new Parametro("font-size", "12px"));
        super.parametros.add(new Parametro("font-family", "Verdana"));
        super.parametros.add(new Parametro("text-align", "left"));
    }
}