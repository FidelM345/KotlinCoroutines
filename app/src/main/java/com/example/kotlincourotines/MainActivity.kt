package com.example.kotlincourotines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //the coroutines life is tied to the application life duration. Simplest way to launch a coroutine
        GlobalScope.launch {
            val request1=networkRequest1()
            val request2=networkRequest2()

            //the suspend functions will both take 6s to launch becoz they are all started from the same coroutine
            Log.d(Constant.TAG, request1)
            Log.d(Constant.TAG, request2)

        }

    }



    suspend fun networkRequest1(): String {
        delay(3000L)

        return "My first Network request"
    }

    suspend fun networkRequest2(): String {
        delay(3000L)

        return "My second Network request"
    }


}