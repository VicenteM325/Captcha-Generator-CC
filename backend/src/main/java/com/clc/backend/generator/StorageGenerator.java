package com.clc.backend.generator;

import java.util.List;
import com.clc.backend.model.Captcha;

/**
 *
 * @author vicente
 */
public class StorageGenerator {

    private final List<Captcha> listC;
    private StringBuilder text;

    public StorageGenerator(List<Captcha> listC) {
        this.listC = listC;
    }

    public String generate() {
        text = new StringBuilder();

        addLine("{", 0);
        addLine("\"captchas\" : [", 1);
        listC.forEach(c -> {
            addLine("{", 2);
            addLine("\"id\" : \"" + c.getId() + "\",", 3);
            addLine("\"name\" : \"" + c.getName()+ "\",", 3);
            addLine("\"use\" : \"" + c.getUse()+ "\",", 3);
            addLine("\"hits\" : \"" + c.getHits()+ "\",", 3);
            addLine("\"faults\" : \"" + c.getFaults()+ "\",", 3);
            addLine("\"lastDate\" : \"" + c.getLastDate()+ "\"", 3);
            addLine("},", 2);
        });
        text.deleteCharAt(text.lastIndexOf(","));
        addLine("]", 1);
        addLine("}", 0);

        return text.toString();
    }
    
    protected void addLine(String s, int tabulaciones) {

        for (int i = 0; i < tabulaciones; i++) {
            text.append("    ");
        }

        text.append(s).append("\n");
    }
}