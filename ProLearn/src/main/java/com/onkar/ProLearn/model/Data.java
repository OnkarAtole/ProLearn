package com.onkar.ProLearn.model;

public class Data {
    private String Name;
    private String Email;
    private String Password;

    // No-arg constructor (required by Firestore)
    public Data() {
    }

    // Constructor with parameters
    public Data(String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    // Getter and Setter for Name
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    // Getter and Setter for Password
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
