package com.clc.backend.generator.body;

import com.clc.backend.generator.Generator;
import com.clc.backend.model.tags.body.TextTag;

/**
 *
 * @author vicente
 */
public abstract class TextTagGenerator extends Generator {
    
    protected TextTag textTag;

    public TextTagGenerator(TextTag textTag) {
        this.textTag = textTag;
    }

    protected String getStyles() {
        StringBuilder styles = new StringBuilder();
        
        styles.append("font-size:").append(textTag.getParameterValue("font-size")).append(";");
        styles.append(" font-family:").append(textTag.getParameterValue("font-family")).append(";");
        styles.append(" text-align:").append(textTag.getParameterValue("text-align")).append(";");
        
        return styles.toString();
    }
}