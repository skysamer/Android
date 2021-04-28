package com.example.aclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

data class DataUser(var name: String, var age: Int)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var DataUser=DataUser("Michael", 25)
        Log.d("DataClass", "DataUser: ${DataUser.toString()}")
    }
}