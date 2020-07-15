package com.example.aulaonline1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcular.setOnClickListener(){
            calcular()
        }



    }

    fun calcular(){
        var p =  peso.text.toString().toDouble()
        var a = altura.text.toString().toDouble()

        var intent = Intent (this,ResultActivity::class.java)

        intent.putExtra("peso", p)
        intent.putExtra("altura",a)

        startActivity(intent)

    }
}
