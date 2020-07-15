package com.example.prova3.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova3.Models.EquipeResponse
import com.example.prova3.R
import com.example.prova3.Services.RetrofitInitializer
import com.example.prova3.UI.Activities.MainActivity
import com.example.prova3.UI.Adapters.EquipeAdapter
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class EquipeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_list, container, false)
        getList()
        return view
    }

    private fun getList() {
        var activity = context as MainActivity
        var s = RetrofitInitializer().serviceEquipe()
        var call = s.getList()
        call.enqueue(object : retrofit2.Callback<EquipeResponse> {
            override fun onResponse(call: Call<EquipeResponse>?, response: Response<EquipeResponse>?) {
                response?.let {
                    if (it.code() == 200) {
                        lista.adapter = EquipeAdapter(activity, it.body().features)
                    }
                }
            }
            override fun onFailure(call: Call<EquipeResponse>?, t: Throwable?) {
            }
        })
    }

}