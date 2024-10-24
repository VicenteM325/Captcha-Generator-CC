package com.clc.backend.generator.body;

import com.clc.backend.model.tags.body.Span;

/**
 *
 * @author vicente
 */
public class SpanGenerator extends TextTagGenerator {
    
    private final Span span;

    public SpanGenerator(Span span) {
        super(span);
        this.span = span;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();

        addLine("<span style=\"" + getStyles() + "\" id=\"" + textTag.getParameterValue("id") + "\">" + textTag.getText().trim() + "</span>", 0);

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());
        
        styles.append(" color:").append(span.getParameterValue("color")).append(";");
        
        return styles.toString();
    }
    
    

}