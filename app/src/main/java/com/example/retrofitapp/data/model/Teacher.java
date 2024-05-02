package com.example.retrofitapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Teacher {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("teachers")
    private String teacherCount;

//    {
//        "id": "1",
//            "name": "Adarsha",
//            "address": "Dharan",
//            "teacher_count": "10"
//    },

}
