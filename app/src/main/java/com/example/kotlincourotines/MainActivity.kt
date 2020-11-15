package com.example.kotlincourotines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        Log.d(Constant.TAG, "Before Run blocking: ")

        //this function will affect the main thread. It is used for launching coroutines in the main thread
        // can be used to launch parallel coroutines
        runBlocking {

            Log.d(Constant.TAG, "Thread launched in main thread: ${Thread.currentThread().name}")

            Log.d(Constant.TAG, "Start of Run blocking: ")


            launch(Dispatchers.IO) {

                delay(3000)

                Log.d(Constant.TAG, "Coroutine 1: ")

               /* withContext(Dispatchers.IO){
                    textall.text="I am the Beast"
                }*/

            }



            launch(Dispatchers.IO) {

                delay(3000)

                Log.d(Constant.TAG, "Coroutine 2: ")

            }




            delay(6000L)
        }

        Log.d(Constant.TAG, "End of  Run blocking: ")




          Log.d(Constant.TAG, "Thread launched in main2 thread: ${Thread.currentThread().name}")
    }


    //sample function for simple couroutine calls
    fun simpleCoRoutineCall(){
        //the coroutines life is tied to the application life duration. Simplest way to launch a coroutine
        GlobalScope.launch {

            delay(3000L)//similar to the sleep function in threads used to delay the coroutine for 3 s. Will only delay the sepecifc coroutine and not the entire thread
            Log.d(Constant.TAG, "Thread launched in Coroutine: ${Thread.currentThread().name}")

            //The coroutine is also terminated when the main thread terminates
        }
    }


}