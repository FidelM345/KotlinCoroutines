package com.example.kotlincourotines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener {


            //unlike the Global scope the coroutine will be terminated as soon as we go to another activity
            lifecycleScope.launch {

                while (true) {
                    delay(1000L)
                    Log.d(Constant.TAG, "Coroutine still running.........: ")
                }

            }


            GlobalScope.launch {
                delay(5000L)
                //we use the @Second activity becoz this is taking place inside a coroutine
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }



        }






    }


}