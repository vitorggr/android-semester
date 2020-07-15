package com.example.prova3.UI.Activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova3.Models.CemiterioResponse
import com.example.prova3.R
import com.example.prova3.Services.RetrofitInitializer
import com.example.prova3.UI.Adapters.CemiterioAdapter
import kotlinx.android.synthetic.main.activity_cemiterios.*
import retrofit2.Call
import retrofit2.Response

class CemiterioActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cemiterios)
        //getList()
    }

    /*fun getList(){
        var s = RetrofitInitializer().serviceCemiterio()
        var call = s.getList()
        call.enqueue(object : retrofit2.Callback<CemiterioResponse> {
            override fun onResponse(call: Call<CemiterioResponse>?, response: Response<CemiterioResponse>?) {
                response?.let {
                    if (it.code() == 200) {
                       // lista.adapter = CemiterioAdapter(this@CemiterioActivity,it.body())
                       // lista.layoutManager = LinearLayoutManager(
                        //    this@CemiterioActivity,
                         //   LinearLayoutManager.HORIZONTAL,false
                        )
                    }
                }
            }
            override fun onFailure(call: Call<CemiterioResponse>?, t: Throwable?) {
                Toast.makeText(this@CemiterioActivity, "Deu ruim", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }*/
}


