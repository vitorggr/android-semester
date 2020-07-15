package com.example.aula2_autenticacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener(){
            loginClick()
        }


    }



    fun loginClick(){


        if (email.text.toString().equals("vitor") &&
                password.text.toString().equals("senha")){
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}
