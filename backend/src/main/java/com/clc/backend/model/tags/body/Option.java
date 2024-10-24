package com.clc.backend.model.tags.body;

import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Option extends Tag {

    private String text;

    public Option(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
