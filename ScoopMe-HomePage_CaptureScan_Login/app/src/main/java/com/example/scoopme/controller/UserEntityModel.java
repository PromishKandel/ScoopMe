package com.example.scoopme.controller;

public class UserEntityModel {

    private String Username;
    private String Password;
    private String Firstname;
    private String Lastname;


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }



    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }


    private int id;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public UserEntityModel(String Firstname,
                       String LastName,
                       String Username,
                       String Password)
    {
       this.Username = Username;
       this.Password = Password;
       this.Firstname = Firstname;
       this.Lastname = LastName;
    }
}

