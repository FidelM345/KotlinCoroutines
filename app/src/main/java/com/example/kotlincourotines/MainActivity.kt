package com.example.kotlincourotines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //the coroutine returns a job
        val job=GlobalScope.launch (Dispatchers.Default){

            //withTimeout(5000L){}//used to start a coroutine and cancel it within th specified time time. when ued no need for using run blocking

            repeat(5){

                Log.d(Constant.TAG, "coroutine is still working..........: ")
                delay(2000L)
            }

        }



        runBlocking {
            job.join()// acts like the delay function

            Log.d(Constant.TAG, "continue with main thread")
        }

        Log.d(Constant.TAG, "you are in the main thread")


       //  Log.d(Constant.TAG, "Thread launched in main2 thread: ${Thread.currentThread().name}")
    }




}