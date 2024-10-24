package com.clc.backend.generator;

import com.clc.backend.generator.body.BodyGenerator;
import com.clc.backend.generator.body.scripting.TableHtmlCode;
import com.clc.backend.model.tags.CC;
import com.clc.backend.model.tags.body.Body;
import com.clc.backend.model.tags.head.Head;

/**
 *
 * @author vicente
 */
public class HtmlGenerator extends Generator {
    
    private final CC cc;

    public HtmlGenerator(CC cc) {
        this.cc = cc;
    }

    @Override
    public String generate() {
    htmlCode = new StringBuilder();
    
    addLine("<!DOCTYPE html>", 0);
    addLine("<html>", 0);
    
    // head
    addLine("<head>", 1);
    addLine("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">", 2);

    Generator headG = new HeadGenerator((Head) cc.getHead());
    addLine(headG.generate(), 2);
    
    // extras css
    addLine("<link rel=\"stylesheet\" href=\"/css/bootstrap.css\">", 2);
    addLine("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\">", 2);
    addLine("</head>", 1);
    
    // body
    addLine("<body style=\"background:" + ((Body) cc.getBody()).getParameterValue("background") + "\">", 1);
    addLine(TableHtmlCode.getCode(), 2);
    
    Generator bodyG = new BodyGenerator((Body) cc.getBody());
    addLine(bodyG.generate(), 2);
    
    // extras js
    addLine("<script src=\"/js/jquery-3.6.0.js\"></script>", 2);
    addLine("<script src=\"/js/popper.js\"></script>", 2);
    addLine("<script src=\"/js/bootstrap.js\"></script>", 2);
    addLine("</body>", 1);
    
    addLine("</html>", 0);
    
    return htmlCode.toString();
}
     
}