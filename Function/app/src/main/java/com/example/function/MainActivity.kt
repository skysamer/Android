package com.example.function

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun square(x:Int): Int{
            return x*x
        }

        fun printSum(x: Int, y: Int){
            Log.d("fun", "x+y = ${x+y}")
        }

        fun getPi(): Double{
            return 3.14
        }

        var squareResult= square(30)
        Log.d("fun", "30의 제곱: ${squareResult}")

        printSum(3, 5)

        val PI=getPi()

        Log.d("fun", "지름이 10인 원의 둘레: ${10*getPi()}")
    }
}