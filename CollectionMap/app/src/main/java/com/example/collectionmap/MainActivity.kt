package com.example.collectionmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var map= mutableMapOf<String, String>()

        map.put("키1", "값1")
        map.put("키2", "값2")
        map.put("키3", "값3")

        var variable=map.get("키2")
        Log.d("Collection", "키2: ${variable}")

        map.put("키2", "두 번째 값 수정")
        Log.d("Collection", "키2: ${map.get("키2")}")
        map.remove("키2")
        Log.d("Collection", "키2: ${map.get("키2")}")

    }
}