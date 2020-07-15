package br.com.cotemig.aularetrofit.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.aularetrofit.R
import br.com.cotemig.aularetrofit.models.ListaEstadio
import br.com.cotemig.aularetrofit.services.RetrofitInitializer
import br.com.cotemig.aularetrofit.ui.adapters.EstadioAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getEstadios()
    }

    fun getEstadios() {

        var s = RetrofitInitializer().serviceEstadio()

        var call = s.getEstadios()

        call.enqueue(object : retrofit2.Callback<ListaEstadio> {

            override fun onResponse(call: Call<ListaEstadio>?, response: Response<ListaEstadio>?) {

                response?.let {

                    if (it.code() == 200) {

                        listEstadios.adapter = EstadioAdapter(this@MainActivity, it.body().lista)

                    }

                }




                // comparativo entre o response?.let e o if(response != null)

//                if (response != null){
//                    if(response.code() == 200){
//
//                    }
//                }

            }

            override fun onFailure(call: Call<ListaEstadio>?, t: Throwable?) {

                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()

            }

        })

    }
}
