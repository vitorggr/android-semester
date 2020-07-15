package com.example.prova3.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova3.Models.CemiterioResponse
import com.example.prova3.Models.EquipeResponse
import com.example.prova3.R
import com.example.prova3.Services.RetrofitInitializer
import com.example.prova3.UI.Activities.MainActivity
import com.example.prova3.UI.Adapters.CemiterioAdapter
import com.example.prova3.UI.Adapters.EquipeAdapter
import kotlinx.android.synthetic.main.activity_cemiterios.*
import kotlinx.android.synthetic.main.activity_list.*
import retrofit2.Call
import retrofit2.Response

class CemiterioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_cemiterios, container, false)
        getList()
        return view
    }

    fun getList(){
        var activity = context as MainActivity
        var s = RetrofitInitializer().serviceCemiterio()
        var call = s.getList()
        call.enqueue(object : retrofit2.Callback<CemiterioResponse> {
            override fun onResponse(call: Call<CemiterioResponse>?, response: Response<CemiterioResponse>?) {
                response?.let {
                    if (it.code() == 200) {
                        listCemiterios.adapter = CemiterioAdapter(activity,it.body())
                        listCemiterios.layoutManager = LinearLayoutManager(
                            activity,
                            LinearLayoutManager.HORIZONTAL,false
                        )
                    }
                }
            }
            override fun onFailure(call: Call<CemiterioResponse>?, t: Throwable?) {
                Toast.makeText(activity, "Deu ruim", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

}