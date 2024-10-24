package com.clc.backend.generator.body;

import com.clc.backend.model.tags.body.Button;

/**
 *
 * @author vicente
 */
public class ButtonGenerator extends TextTagGenerator {
    
    private final Button button;

    public ButtonGenerator(Button button) {
        super(button);
        this.button = button;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        htmlCode.append("<button type=\"button\" class=\"btn\" ");
        htmlCode.append("style=\"").append(getStyles()).append("\" ");
        htmlCode.append("id=\"").append(button.getParameterValue("id"));
        htmlCode.append("\" onclick=\"").append(button.getParameterValue("onclick"));
        htmlCode.append("();\" >");
        htmlCode.append(button.getText());
        htmlCode.append("</button>");

        return htmlCode.toString();
    }

    @Override
    protected String getStyles() {
        StringBuilder styles = new StringBuilder(super.getStyles());
        
        styles.append(" color:").append(button.getParameterValue("color")).append(";");
        styles.append(" background:").append(button.getParameterValue("background")).append(";");
        
        return styles.toString();
    }
}