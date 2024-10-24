package com.clc.backend.generator.body;

import com.clc.backend.model.tags.body.TextArea;

/**
 *
 * @author vicente
 */
public class TextAreaGenerator extends TextTagGenerator {
    
    private final TextArea textArea;

    public TextAreaGenerator(TextArea textArea) {
        super(textArea);
        this.textArea = textArea;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        htmlCode.append("<textarea rows=\"").append(textArea.getParameterValue("rows")).append("\" ");
        htmlCode.append("cols=\"").append(textArea.getParameterValue("cols")).append("\" ");
        htmlCode.append("style=\"").append(getStyles()).append("\" ");
        htmlCode.append("id=\"").append(textArea.getParameterValue("id")).append("\">");
        htmlCode.append("</textarea>");

        return htmlCode.toString();
    }

}