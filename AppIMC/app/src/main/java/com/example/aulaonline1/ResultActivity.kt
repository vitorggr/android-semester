package com.example.aulaonline1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aulaonline1.R.string.abaixo
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var peso = intent.getDoubleExtra("peso", 0.0)
        var altura = intent.getDoubleExtra("altura",0.0)
        var imc =  peso / (altura * altura)

            if (imc <= 17){
                resultado.text = getString(R.string.muitoabaixo)

            }else if (imc <= 18.49){
                resultado.text = getString(R.string.abaixo)
            }else if(imc <= 24.99){
                resultado.text = getString(R.string.normal)
            }else if(imc <= 29.9){
                resultado.text = getString(R.string.acima)
            }else if(imc <= 34.99){
                resultado.text = getString(R.string.obesidadeI)
            }else if(imc <= 40){
                resultado.text = getString(R.string.obesidadeII)
            } else {
                resultado.text = getString((R.string.obesidadeIII))
            }


    }
}
