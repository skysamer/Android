package com.example.collectionset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var set= mutableSetOf<String>()
        set.add("jan")
        set.add("feb")
        set.add("mar")
        set.add("jan")

        Log.d("Collection", "Set: ${set}")

        set.remove("feb")
        Log.d("Collection", "Set: ${set}")
    }
}