package com.example.kotlincourotines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await


//for firebase to work the data class must be given default values
data class Person(val name:String="",
                  val age: Int =0
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tutorialDocument=Firebase.firestore.collection("coroutine").
                document("tutorial")


        val peter=Person("Peter", 27)


        GlobalScope.launch (Dispatchers.IO){
            delay(3000L)
            //we use the await function on firebase tasks so that the coroutine will wait for the task to finish b4 it proceeds
            tutorialDocument.set(peter).await() // await() instead of snapshot

           val person=tutorialDocument.get().await().toObject(Person::class.java)


            withContext(Dispatchers.Main){

                textall.text=person.toString()
            }



        }






    }





}