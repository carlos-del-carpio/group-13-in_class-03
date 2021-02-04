package com.example.group13_inclass03;
import java.io.Serializable;

//Class created to pass serialized object between activities
public class Profile implements Serializable {
    String name;
    String email;
    Integer id;
    String department;

    public Profile (String name, String email, Integer id, String department) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.department = department;
    }

    public Profile(){

    }
}
