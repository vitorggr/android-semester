package com.example.prova3.UI.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prova3.Models.EquipeResponse
import com.example.prova3.R
import com.example.prova3.Services.RetrofitInitializer
import com.example.prova3.UI.Adapters.EquipeAdapter
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class EquipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        getList()
    }

    fun getList(){
        var s = RetrofitInitializer().serviceEquipe()
        var call = s.getList()
        call.enqueue(object : retrofit2.Callback<EquipeResponse> {
            override fun onResponse(call: Call<EquipeResponse>?, response: Response<EquipeResponse>?) {
                response?.let {
                    if (it.code() == 200) {
                        // listaEquipe.adapter = EquipeAdapter(this@EquipeActivity, it.body().features)
                    }
                }
            }
            override fun onFailure(call: Call<EquipeResponse>?, t: Throwable?) {
            }
        })
    }

}