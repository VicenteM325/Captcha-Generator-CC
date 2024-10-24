package com.clc.backend.generator;

import com.clc.backend.model.tags.head.Head;
import com.clc.backend.model.tags.head.Title;

/**
 *
 * @author vicente
 */
public class HeadGenerator extends Generator {
    
    private Head head;

    public HeadGenerator(Head head) {
        this.head = head;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        head.getEtiquetas().forEach(e -> {
            if (e instanceof Title) {
                Title t = (Title) e;
                addLine("<title>"+t.getTitle()+"</title>", 0);
            }
        });
        
        return htmlCode.toString();
    }
    
    
}