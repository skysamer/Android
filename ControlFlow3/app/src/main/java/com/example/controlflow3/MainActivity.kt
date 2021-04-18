package com.example.controlflow3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ageOfMichael=10
        when(ageOfMichael){
           in 10..19->{
                Log.d("when", "마이클은 10대")
            }
            !in 10..19->{
                Log.d("when", "마이클은 10대가 아님")
            }
            else->{
                Log.d("when", "마이클 나이 확정 불가.")
            }
        }
    }
}