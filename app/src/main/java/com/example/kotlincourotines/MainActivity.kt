package com.example.kotlincourotines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // GlobalScope.async {  } this could have been used but we are not returning any value from the coroutine
        GlobalScope.launch(Dispatchers.IO) {


            val time = measureTimeMillis {

                //when we want to return a value and make the coroutine to wait until the newtwork call is finished asyc / await should be used

                val ans1 = async {
                    netwaorCall1()
                }

                val ans2 = async {
                    netwaorCall2()
                }


                //await funtion is similar to join function when launch is used. It makes the coroutine to wait until the function finishes executing its job
                Log.d(Constant.TAG, "The Answer 1 is: ${ans1.await()}")
                Log.d(Constant.TAG, "The Answer 2 is: ${ans2.await()}")


                //alternative but inefficient method to do the same task
                /*
                *  val job1= launch{ ans1=netwaorCall1}
                *  val job2= launch{ ans2=netwaorCall2}
                * job1.join()
                * job2.join()
                * Log.d(Constant.TAG, "The Answer 1 is: ${ans1}")
                   Log.d(Constant.TAG, "The Answer 2 is: ${ans2}")
                *
                * */

            }

            Log.d(Constant.TAG, "The request took $time ms")

        }


    }


    suspend fun sequentialMethod() {
        val answer1 = netwaorCall1()
        val answer2 = netwaorCall2()


        Log.d(Constant.TAG, "The Answer 1 is: $answer1")
        Log.d(Constant.TAG, "The Answer 2 is: $answer2")
    }




    suspend fun netwaorCall1(): String {
        delay(3000L)

        return "one"
    }


    suspend fun netwaorCall2(): String {
        delay(3000L)

        return "two"
    }


}