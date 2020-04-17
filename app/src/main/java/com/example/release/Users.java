package com.example.release;

public class Users {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String country;
    private String password;





    public Users(String id ,String name,String phoneNumber,String country,String email){
        setId(id);
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setCountry(country);
        setPassword();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setPassword(){
        password = "Content unavailable";
    }
    public String getPassword(){
        return password;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
