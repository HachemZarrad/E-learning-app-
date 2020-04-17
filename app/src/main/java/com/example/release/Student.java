package com.example.release;

public class Student extends Users {

    private String post;
    private CatalogClass ownCourses;
    private CatalogClass favouriteCourses;

    public Student(String id, String name, String phoneNumber, String country, String email) {
        super(id, name, phoneNumber, country, email);
        setPost();

    }

    public CatalogClass getOwnCourses() {
        return ownCourses;
    }

    public void setOwnCourses(CatalogClass ownCourses) {
        this.ownCourses = ownCourses;
    }

    public CatalogClass getFavouriteCourses() {
        return favouriteCourses;
    }

    public void setFavouriteCourses(CatalogClass favouriteCourses) {
        this.favouriteCourses = favouriteCourses;
    }

    public void setPost() {
        post = "Student";
    }

    public String getPost(){
        return post;
    }
}
