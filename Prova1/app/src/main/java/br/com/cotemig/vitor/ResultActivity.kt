package br.com.cotemig.vitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        var ipva = intent.getDoubleExtra("ipva",0.0)
        var valor = intent.getDoubleExtra("valor",0.0)
        var resultado = (valor * ipva) /100
        var parcelamento = resultado/3


    }

}

//tres parcelas