package com.example.hello

import android.bluetooth.BluetoothHidDevice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import layout.ApiClient
import layout.ApiInterface
import layout.RegistrationResponse
import layout.RequestBody

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegister.setOnClickListener {
            val intent = Intent(baseContext, RegistrationActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            var userName = etUserName.text.toString()
            var password = etPassword.text.toString()
            Toast.makeText(baseContext, password, LENGTH_SHORT).show()


        }
    }
}

fun registerUser(requestBody: RequestBody) {
    var apiClient= ApiClient.buildService(ApiInterface::class.java)
    var registrationCall = apiClient.let(requestBody).also {
        var it = null.apply {
            enqueue(object : BluetoothHidDevice.Callback<RegistrationResponse> {
                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    var baseContext = null
                    Toast.makeText(baseContext, t.message, LENGTH_SHORT).show()
                }
        
                override fun onResponse(
                    call: Call<RegistrationResponse>,
        
                    response: Response<RegistrationResponse>
                ) = if (response.isSuccessful) {
                    var baseContext = null
                    val show: Any = Toast.makeText(
                        baseContext,
                        response.body()// TODO: 15-Aug-20  oast.LENGTH_LONG).show()
                                startActivity (Intent(baseContext, MainActivity::class.java))
                } else Toast.LENGTH_LONG.to().toString(), Toast.LENGTH_LONG).show()
        
                private fun startActivity(intent: Intent) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

private fun Any.let(block: RequestBody): Any {

}

private infix fun Any.startActivity(intent: Intent): Any {

}

class Response<T> {
    fun errorBody(): Any {
        TODO("Not yet implemented")
    }

    fun body(): Any {

    }

    var isSuccessful:

}

}

fun enqueue(any: Any) {

}

private infix fun Any.startActivity(intent: Intent): Any {

}

class Response<T> {
    fun body(): Any {
        TODO("Not yet implemented")
    }

    val isSuccessful: Boolean
    
    
    
}
