package com.clc.backend.model;

/**
 *
 * @author vicente
 */
public class Captcha {

    private String id;
    private String name;
    private String link;
    private String use;
    private String hits;
    private String faults;
    private String lastDate;

    public Captcha(String id, String name, String use, String hits, String faults, String lastDate) {
        this.id = id;
        this.name = name;
        this.use = use;
        this.hits = hits;
        this.faults = faults;
        this.lastDate = lastDate;
    }

    public Captcha() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        setLink("http://localhost:8080/captchas/" + id + ".html");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getFaults() {
        return faults;
    }

    public void setFaults(String faults) {
        this.faults = faults;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}