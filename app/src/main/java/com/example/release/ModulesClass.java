package com.example.release;

public class ModulesClass {

    private String duration;
    private String order;
    private String title;
    private String url;

    public ModulesClass(String duration,String order,String title,String url){
        setDuration(duration);
        setOrder(order);
        setTitle(title);
        setUrl(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getDuration(){
        return duration;
    }

    public String getOrder(){
        return order;
    }
    public String getTitle(){
        return title;
    }

    public String getUrl(){
        return url;
    }

}
