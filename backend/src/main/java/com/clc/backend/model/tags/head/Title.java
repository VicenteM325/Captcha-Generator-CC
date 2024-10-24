package com.clc.backend.model.tags.head;


import com.clc.backend.model.tags.Tag;

/**
 *
 * @author vicente
 */
public class Title extends Tag {

    private String title;

    public Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}