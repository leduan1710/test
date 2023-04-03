package com.example.lequangduan20110619_bt6_retrofit.model;

import java.io.Serializable;

public class UserModel implements Serializable {
    private int id;
    private String username = "";
    private String message;
    private boolean error;
    private  String password = "";
    private String email = "";
    private String gender = "";
    private String images = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public UserModel(String username, String email, String gender, String images, boolean error, String message) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.images = images;
        this.message = message;
        this.error = error;
    }

    public UserModel(String username, String password, String email, String gender) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public UserModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }
    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
