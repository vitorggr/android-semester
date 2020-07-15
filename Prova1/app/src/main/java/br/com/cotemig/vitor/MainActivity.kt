package br.com.cotemig.vitor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var elementos = ArrayList<String>()
        elementos.add("Automóveis, veículos de uso misto e utilitários")
        elementos.add("Caminhonetes de carga")
        elementos.add("Automóveis, veículos de uso misto e utilitários com autorização para transporte")
        elementos.add("Motocicletas")
        elementos.add("Veículos de locadoras")
        elementos.add("Ônibus, micro ônibus, caminhão, caminhão trator")

        listaVeiculos.adapter = VeiculosAdapter(this,elementos)

        listaVeiculos.setOnItemClickListener { parent, view, position, id ->

            var x = elementos[position]

            var intent = Intent(this,CalculoActivity::class.java)
            intent.putExtra("veiculo",x)
            startActivity(intent)

        }

    }


}
