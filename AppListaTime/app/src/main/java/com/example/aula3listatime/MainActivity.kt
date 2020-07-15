package com.example.aula3listatime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var elementos = ArrayList<String>()
        elementos.add("Galo")
        elementos.add("Cruzeiro")
        elementos.add("America")
        elementos.add("Vila Nova")

        listaDeTimes.adapter = TimeAdapter(this,elementos)

        listaDeTimes.setOnItemClickListener { parent, view, position, id ->

            var x = elementos[position]

            var intent = Intent(this,JogadoresActivity::class.java)
            intent.putExtra("timeselecionado",x)
            startActivity(intent)

        }

    }


}
