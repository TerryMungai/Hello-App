package com.example.hello

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.telecom.Call
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_courses.*
import layout.ApiClient
import layout.ApiInterface
import javax.security.auth.callback.Callback
import androidx.recyclerview.widget.LinearLayoutManager as LinearLayoutManager1
import com.example.hello.CoursesResponse as ExampleHelloCoursesResponse

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        var courseList = listOf<Course>(
            Course("1", "Python", "PY 101", "James Neumann", "Python Intro"),
            Course("2", "Android", "AND 201", "Anne Elson", "Android development training"),
            Course("3", "Database", "DB 304", "Kamwe Wema", "Database administration and development"),
            Course("4", "Network", "DIS 202", "Betty Crocker", "Netwok Config for modern apps")
        )
        rvCourses.id = LinearLayoutManager1(this.baseContext)
        rvCourses.id = CoursesAdapter(courseList)

        fetchCourses()
    }

    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.toString("Bearer " + accessToken).also {
            it.forEach(object : Callback<ExampleHelloCoursesResponse> {
                fun onFailure(
                    call: Call<ExampleHelloCoursesResponse>,
                    t: Throwable
                ) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                fun onResponse(
                    call: Call<ExampleHelloCoursesResponse>,
                    response: Response<ExampleHelloCoursesResponse>
                ): Unit = if (response.isSuccessful) {
                    var courseList = response.body()?.
                            as List<Course>
                    var coursesAdapter = CoursesAdapter(courseList)
                    rvCourses.id = LinearLayoutManager1(@CoursesActivity.baseContext)
                    rvCourses.id = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            })
        }
    }

    annotation class baseContext

    private fun CoursesAdapter(courseList: List<Course>): Int {

    }

    class Response<T> {
        val isSuccessful: Boolean
            get() {
                TODO()
            }

        fun errorBody(): Any {

        }

        fun body(): Any {

        }

    }
}

private fun Any.toString(s: String): String {

}

private fun String.forEach(action: Any) {

}
