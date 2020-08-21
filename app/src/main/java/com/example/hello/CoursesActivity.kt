package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_courses.*
import androidx.recyclerview.widget.LinearLayoutManager as LinearLayoutManager1

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        rvCourses.id = LinearLayoutManager1(this.baseContext)
        val coursesRecyclerViewAdapter = CoursesRecyclerViewAdapter(coursesList = listOf(

            Courses(10,"Python",110,"Grade","Excellent"),
            Courses(20,"Kotlin",120,"Grade","Excellent"),
            Courses(30,"Javascript",130,"Grade","Excellent"),
            Courses(40,"UI/UX Development",140,"Grade","Excellent"),
            Courses(50,"React",150,"Grade","Excellent"),
            Courses(60,"Navigating",160,"Grade","Excellent"),
            Courses(70,"Proffessional development",170,"Grade","Excellent"),
            Courses(80,"UI/UX Design",180,"Grade","Excellent"),
            Courses(90,"Entreprenuership",190,"Grade","Excellent"),
            Courses(100,"Hardware Design",200,"Grade","Excellent"),
            Courses(110,"Hardware Electronics",210,"Grade","Excellent")


        ))
        rvCourses.id= coursesRecyclerViewAdapter

        fetchCourses()
    }

    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer " + accessToken)
        coursesCall.enqueue(object : Callback<CoursesResponse> {
            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CoursesResponse>,
                response: Response<CoursesResponse>
            ) {
                if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<Course>
                    var coursesAdapter = CoursesAdapter(courseList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}
    }
}


