package com.example.array

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var students=IntArray(10)
        var intArray= intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        var stringArray=Array(10, {item->""})

        var dayArray= arrayOf("mon", "tue", "wed", "thu", "fri","sat", "sun")

        students[0]=90
        students[1]=91
        students.set(5, 95)
        students.set(6, 96)

        intArray[6]=137
        intArray.set(9, 200)

        var seventhValue=intArray[6]
        Log.d("Array", "intArray[6]: ${seventhValue}")
        var tenthValue=intArray.get(9)
        Log.d("Array", "intArray[9]: ${tenthValue}")

        Log.d("Array", "dayArray[6]: ${dayArray[0]}")
        Log.d("Array", "dayArray[6]: ${dayArray.get(5)}")
    }
}