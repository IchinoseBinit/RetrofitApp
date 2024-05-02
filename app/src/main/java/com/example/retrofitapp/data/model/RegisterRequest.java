package com.example.retrofitapp.data.model;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("name")
    private String name;


    @SerializedName("location")
    private String location;

    @SerializedName("teacherCount")
    private int teachers;


    public RegisterRequest(String name, String location, int teachers) {
        this.name = name;
        this.location = location;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getTeachers() {
        return teachers;
    }
}
