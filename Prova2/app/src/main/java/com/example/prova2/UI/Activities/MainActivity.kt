package com.example.prova2.UI.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prova2.Models.Competition
import com.example.prova2.Models.CompetitionResponse
import com.example.prova2.R
import com.example.prova2.Service.RetrofitInitializer
import com.example.prova2.UI.Adapters.Adapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCompetitions()
    }

    fun getCompetitions(){

        var s = RetrofitInitializer().service()
        var call = s.getCompetitions()

        call.enqueue(object : retrofit2.Callback<CompetitionResponse>{


            override fun onResponse(
                call: Call<CompetitionResponse>?,
                response: Response<CompetitionResponse>?
            ) {
                response?.let {

                    if (it.code() == 200) {

                        list.adapter = Adapter(this@MainActivity, it.body().competitions)
                    }
                }
            }

            override fun onFailure(call: Call<CompetitionResponse>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Deu ruim", Toast.LENGTH_LONG)
                    .show()
            }

        })

    }

}
