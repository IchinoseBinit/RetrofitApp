package com.example.retrofitapp.data.model;

import com.google.gson.annotations.SerializedName;

public class TeacherRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    @SerializedName("teacherCount")
    private int teacherCount;

    public TeacherRequest(String name, String location, int teacherCount) {
        this.name = name;
        this.location = location;
        this.teacherCount = teacherCount;
    }
}
