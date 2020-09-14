package com.example.hello

import layout.SerializedName

class Student (
    @SerializedName("student_id") var studentId: String,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("email") var email: String,
    @SerializedName("phone_number") var phoneNumber: String,
    @SerializedName(value:"password_number") var password: String,
    @SerializedName("image_url") var imageUrl: String
)