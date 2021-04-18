package com.example.controlflowfor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(index in 1..10){
            Log.d("for", "현재 숫자: ${index}")
        }

        var array= arrayOf("jan", "feb", "mar", "apr", "may", "jun")
        for(index in 0 until array.size){
            Log.d("for", "현재 월: ${array.get(index)}")
        }

        for(index in 0..10 step 3){
            Log.d("for", "건너뛰기: ${index}")
        }

        for(index in 10 downTo 0){
            Log.d("for", "감소시키기: ${index}")
        }

        for(month in array){
            Log.d("for", "현재 월: ${month}")
        }
    }
}