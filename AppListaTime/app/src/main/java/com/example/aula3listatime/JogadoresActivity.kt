package com.example.aula3listatime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_jogadores.*

class JogadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogadores)

        var time = intent.getStringExtra("timeselecionado")

        var elementos = ArrayList<String>()

        if(time.equals("Galo")){
            elementos.add("Victor ")
            elementos.add("Tardelli")
        }else if (time.equals("Cruzeiro")){
            elementos.add("Maurício")
            elementos.add("Marcelo Moreno")
        }else {
            elementos.add("Random")
            elementos.add("Aleatorio")
        }

        listaJogadores.adapter = JogadorAdapter(this,elementos)

    }


}
