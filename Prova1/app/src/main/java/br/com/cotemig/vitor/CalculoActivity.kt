package br.com.cotemig.vitor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculo.*

class CalculoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)

        calcular.setOnClickListener(){
            calcular()
        }

    }

    fun calcular() {
        var intent = Intent(this,ResultActivity::class.java)
        var veiculo  = intent.getDoubleExtra("veiculo", 0.0)
        var ipva :Double
        var valor :Double = 0.0

        if (veiculo.equals("Automóveis, veículos de uso misto e utilitários")){
            ipva = 4.0;
            intent.putExtra("ipva", ipva)

        } else if(veiculo.equals("Caminhonetes de carga")){
            ipva = 3.0
            intent.putExtra("ipva", ipva)
        }else if(veiculo.equals("Automóveis, veículos de uso misto e utilitários com autorização para transporte")){
            ipva = 2.0
            intent.putExtra("ipva", ipva)
        }else if(veiculo.equals("Motocicletas")){
            ipva = 2.0
            intent.putExtra("ipva", ipva)
        }else if(veiculo.equals("Veículos de locadoras")){
            ipva = 1.0
            intent.putExtra("ipva", ipva)
        }else{
            ipva = 1.0
            intent.putExtra("ipva", ipva)
        }

        var aux =  valor.toString().toDouble()
        intent.putExtra("valor",aux)
        startActivity(intent)
    }
}
