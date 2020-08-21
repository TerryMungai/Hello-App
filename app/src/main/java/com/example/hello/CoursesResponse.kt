package com.example.hello

import layout.SerializedName

class CoursesResponse {

    data class CoursesResponse(
        @SerializedName("courses") var courses: List<Course>
    )
}

class Course {

}
