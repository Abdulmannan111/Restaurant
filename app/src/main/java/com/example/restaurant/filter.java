package com.example.restaurant;

public class filter { private float rating;
    private int phone;

    private String name ;
    private String location ;
    private String des ;


    public filter() {
        name="";
        location="";
        des="";
    }

    public int get_phone() {
        return phone;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }
    public String getDes() {
        return des;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setphone(int phone) {
        this.phone = phone;
    }

    public void setRating(float Rating) {
        this.rating = Rating;
    }
}
