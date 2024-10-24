package com.clc.backend.generator.body;

import com.clc.backend.generator.Generator;
import java.util.List;
import com.clc.backend.model.tags.Tag;
import com.clc.backend.model.tags.body.Body;
import com.clc.backend.model.tags.body.Br;
import com.clc.backend.model.tags.body.Button;
import com.clc.backend.model.tags.body.Div;
import com.clc.backend.model.tags.body.H1;
import com.clc.backend.model.tags.body.Img;
import com.clc.backend.model.tags.body.Input;
import com.clc.backend.model.tags.body.P;
import com.clc.backend.model.tags.body.Scripting;
import com.clc.backend.model.tags.body.Select;
import com.clc.backend.model.tags.body.Span;
import com.clc.backend.model.tags.body.TextArea;

/**
 *
 * @author vicente
 */
public class BodyGenerator extends Generator {
    
    private final Body body;

    public BodyGenerator(Body body) {
        this.body = body;
    }

    @Override
    public String generate() {
        htmlCode = new StringBuilder();
        
        generateTags(body.getEtiquetas());
        
        return htmlCode.toString();
    }
    
    private void generateTags(List<Tag> tags){
        tags.forEach(e -> {
            if (e instanceof Span) {
                Span s = (Span) e;
                Generator spanG = new SpanGenerator(s);
                addLine(spanG.generate(), 0);
            } else if (e instanceof Input) {
                Input i = (Input) e;
                Generator inputG = new InputGenerator(i);
                addLine(inputG.generate(), 0);
            } else if (e instanceof TextArea) {
                TextArea ta = (TextArea) e;
                Generator textAG = new TextAreaGenerator(ta);
                addLine(textAG.generate(), 0);
            } else if (e instanceof Select) {
                Select s = (Select) e;
                Generator selectG = new SelectGenerator(s);
                addLine(selectG.generate(), 0);
            } else if (e instanceof Div) {
                Div d = (Div) e;
                Generator divG = new DivGenerator(d);
                addLine(divG.generate(), 0);
                generateTags(d.getEtiquetas());
                addLine("</div>", 0);
            } else if (e instanceof Img) {
                Img i = (Img) e;
                Generator imgG = new ImgGenerator(i);
                addLine(imgG.generate(), 0);
            } else if (e instanceof Br) {
                addLine("<br>", 0);
            } else if (e instanceof Button) {
                Button b = (Button) e;
                Generator buttonG = new ButtonGenerator(b);
                addLine(buttonG.generate(), 0);
            } else if (e instanceof H1) {
                H1 h = (H1) e;
                Generator h1G = new H1Generator(h);
                addLine(h1G.generate(), 0);
            } else if (e instanceof P) {
                P pp = (P) e;
                Generator pG = new PGenerator(pp);
                addLine(pG.generate(), 0);
            } else if (e instanceof Scripting) {
                Scripting s = (Scripting) e;
                Generator scriptG = new ScriptingGenerator(s);
                addLine(scriptG.generate(), 0);
            }
        });
    }

}