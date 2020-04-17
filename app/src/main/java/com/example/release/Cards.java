package com.example.release;

public class Cards {
    private String cvv;
    private String experationDate;
    private String number;
    private String owner;


    public Cards(String cvv ,String experationDate,String number,String owner){
        setCvv(cvv);
        setExperationDate(experationDate);
        setNumber(number);
        setOwner(owner);
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExperationDate(String experationDate){
        this.experationDate = experationDate;
    }
    public String getExperationDate(){
        return experationDate;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber(){
        return number;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner(){
        return owner;
    }
}
