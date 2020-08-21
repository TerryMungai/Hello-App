package com.example.hello

import layout.ApiClient
import layout.ApiInterface
import layout.RequestBody

class LoginResponse {
    fun loginUser(requestBody: RequestBody){
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val loginCall = apiClient.loginStudent(requestBody)

        loginCall.enqueue(object :Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    var accessToken = response.body()?.accessToken
                    var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.apply()
                    val intent = Intent(baseContext, CoursesActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
}