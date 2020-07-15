package br.com.cotemig.aulaapi1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.aulaapi1.R
import br.com.cotemig.aulaapi1.models.ListaJogador
import br.com.cotemig.aulaapi1.services.RetrofitInitializer
import br.com.cotemig.aulaapi1.ui.adapters.JogadorAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getJogadores()


    }


    fun getJogadores() {
        var s = RetrofitInitializer().serviceJogador()

        var call = s.getJogadores()

        call.enqueue(object : retrofit2.Callback<ListaJogador> {

                override fun onResponse(
                    call: Call<ListaJogador>?,
                    response: Response<ListaJogador>?
                ) {

                    response?.let {

                        if (it.code() == 200) {
                            list.adapter = JogadorAdapter(this@MainActivity, it.body().lista)
                        }
                    }
                }

                override fun onFailure(call: Call<ListaJogador>?, t: Throwable?) {
                    Toast.makeText(this@MainActivity, "Deu ruim", Toast.LENGTH_LONG)
                        .show()
                }



        })
    }


}

