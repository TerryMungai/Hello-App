package Models

import com.example.hello.Course
import layout.SerializedName

class CoursesResponse {

    data class CoursesResponse(
        @SerializedName("courses") var courses: List<Course>
    )
}

class Course {

}
