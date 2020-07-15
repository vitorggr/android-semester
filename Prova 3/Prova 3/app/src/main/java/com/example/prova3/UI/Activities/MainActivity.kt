package com.example.prova3.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova3.R
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaEquipe.setOnClickListener{
            var intent = Intent(this,EquipeActivity::class.java)
            startActivity(intent)
        }

        listaCemiterios.setOnClickListener {
            var intent = Intent(this,CemiterioActivity::class.java)
            startActivity(intent)
        }
    }


}
