package com.clc.backend.generator.body;

import com.clc.backend.generator.Generator;
import com.clc.backend.model.tags.body.Img;

/**
 *
 * @author vicente
 */
public class ImgGenerator extends Generator {
    
    private Img img;

    public ImgGenerator(Img img) {
        this.img = img;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        htmlCode.append("<img src=\"").append(img.getParameterValue("src")).append("\"");
        htmlCode.append(" class=\"rounded\" ").append("alt=\"").append(img.getParameterValue("alt")).append("\" ");
        htmlCode.append("width=\"").append(img.getParameterValue("width")).append("\" ");
        htmlCode.append("height=\"").append(img.getParameterValue("height")).append("\"");
        htmlCode.append("id=\"").append(img.getParameterValue("id")).append("\">");
        
        return htmlCode.toString();
    }

}