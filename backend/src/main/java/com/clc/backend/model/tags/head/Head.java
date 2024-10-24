package com.clc.backend.model.tags.head;


import java.util.List;
import com.clc.backend.model.tags.Tag;
/**
 *
 * @author vicente
 */
public class Head extends Tag {

    private List<Tag> etiquetas;

    public Head(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }
}