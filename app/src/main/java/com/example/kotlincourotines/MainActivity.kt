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

            delay(3000L)//similar to the sleep function in threads used to delay the coroutine for 3 s. Will only delay the sepecifc coroutine and not the entire thread
            Log.d(Constant.TAG, "Thread launched in Coroutine: ${Thread.currentThread().name}")

                //The coroutine is also terminated when the main thread terminates
        }

         Log.d(Constant.TAG, "Thread launched in main2 thread: ${Thread.currentThread().name}")
    }



}