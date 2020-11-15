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


        GlobalScope.launch (Dispatchers.IO){
            Log.d(Constant.TAG, "Thread launched in Coroutine: ${Thread.currentThread().name}")


            val displayRes=doNetworkRequest()


            //this method will switch the coroutine from the background thread to the main thread
            //allows results to be passed from background thread to the main thread
            withContext(Dispatchers.Main){

                textall.text=displayRes

            }



        }




         Log.d(Constant.TAG, "Thread launched in main2 thread: ${Thread.currentThread().name}")
    }



    suspend fun  doNetworkRequest(): String{
        delay(6000L)

        return "The test will display after 6 seconds"

    }


}