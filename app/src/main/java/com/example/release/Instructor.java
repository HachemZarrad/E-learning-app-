package com.example.release;

public class Instructor extends Users {

    private String speciality;
    private String post;
    private CatalogClass ownCourses;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Instructor(String id, String name, String phoneNumber, String country, String email, String speciality) {
        super(id, name, phoneNumber, country, email);
        this.speciality = speciality;
        setPost();

    }

    public CatalogClass getOwnCourses() {
        return ownCourses;
    }

    public void setOwnCourses(CatalogClass ownCourses) {
        this.ownCourses = ownCourses;
    }

    public void setPost() {
        post ="Instructor";
    }
    public String getPost(){
        return post;
    }
}
