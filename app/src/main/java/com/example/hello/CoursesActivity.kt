package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_courses.*

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        rvCourses.LayoutManager = LinearLayoutManager(baseContext)
        val coursesRecyclerViewAdapter = CoursesRecyclerViewAdapter(coursesList = listOf(

            Courses(1,"Kotlin",90 "Grade","Very good"),
            Courses(2,"Python",80,"Grade","Very good"),
            Courses(3,"UI/UX design",60,"Grade","Very good"),
            Courses(4,"UI/UX development",80,"Grade","Excellent"),
            Courses(5,"Javascript",50,"Grade","good"),
            Courses(6,"Hardware Design",70,"Grade","Very good"),
            Courses(7,"Professional development",60,"Grade","Very good"),
            Courses(8,"UI/UX Design",70,"Grade","Excellent"),
            Courses(9,"Entrepreneurship",50,"Grade","good"),
            Courses(10,"Navigating your journey",60,"Grade","good"),
            Courses(11,"Hardware Electronics",70,"Grade","Excellent")


        ))
        rvCourses.adapter=coursesRecyclerViewAdapter
    }
}
    
