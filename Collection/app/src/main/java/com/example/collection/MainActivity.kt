package com.example.collection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mutableList= mutableListOf("mon", "tue", "wed")
        mutableList.add("thu")

        Log.d("Collection", "mutableList[0]: ${mutableList.get(0)}")
        Log.d("Collection", "mutableList[1]: ${mutableList.get(1)}")

        var stringList= mutableListOf<String>()

        stringList.add("월")
        stringList.add("화")
        stringList.add("수")

        stringList.set(1, "요일 변경")

        Log.d("Collection", "stringList[1]: ${stringList.get(1)}")
        stringList.removeAt(1)
        Log.d("Collection", "stringList[1]: ${stringList.get(1)}")
    }
}