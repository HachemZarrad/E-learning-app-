package com.example.release;

public class CatalogClass {

    private String creationDate;
    private String descprition;
    private String duration;
    private String keywords;
    private ModulesClass modules;
    private String owner;
    private String subject;
    private String title;
    private String updateDate;


    public CatalogClass(String creationDate, String descprition, String duration, String keywords, ModulesClass modules, String owner, String subject, String title, String updateDate) {
        this.creationDate = creationDate;
        this.descprition = descprition;
        this.duration = duration;
        this.keywords = keywords;
        this.modules = modules;
        this.owner = owner;
        this.subject = subject;
        this.title = title;
        this.updateDate = updateDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescprition() {
        return descprition;
    }

    public void setDescprition(String descprition) {
        this.descprition = descprition;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public ModulesClass getModules() {
        return modules;
    }

    public void setModules(ModulesClass modules) {
        this.modules = modules;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
