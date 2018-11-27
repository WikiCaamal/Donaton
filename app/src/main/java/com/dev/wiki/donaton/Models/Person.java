package com.dev.wiki.donaton.Models;

public class Person {
    private Integer id;
    private String name;
    private String lastName;
    private String user;
    private String email;
    private String password;

    public Person(Integer id, String name, String lastName, String user, String email, String password){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public Person(String name, String lastName, String user, String email, String password){
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
