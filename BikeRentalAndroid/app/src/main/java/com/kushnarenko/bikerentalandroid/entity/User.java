package com.kushnarenko.bikerentalandroid.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;

    private String email;

    private String name;

    private String password;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User fromJson(String json) throws JSONException {
        User u = null;
        if (!json.isEmpty()) {
            JSONObject jsonObject = new JSONObject(json);
            u=new User();
            u.setId(jsonObject.getLong("id"));
            u.setName(jsonObject.getString("name"));
            u.setPassword(jsonObject.getString("password"));
            u.setEmail(jsonObject.getString("email"));
        }
        return u;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}