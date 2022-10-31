package com.telran.model;


public class User {


    private String name;

    public String getName() {
        return name;
    }

    private  String lastname;

    public String getLastname() {
        return lastname;
    }

    private  String email;

    public String getEmail() {
        return email;
    }

    private  String phone;

    public String getPhone() {
        return phone;
    }

    private  String date;

    public String getDate() {
        return date;
    }

    private  String path;

    public String getPath() {
        return path;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User setDate(String date) {
        this.date = date;
        return this;
    }

    public User setFile(String path) {
        this.path = path;
        return this;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }
}
