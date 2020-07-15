package com.example.prova3.Services

import com.example.prova3.Models.Cemiterio
import com.example.prova3.Models.CemiterioResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CemiterioService {

    @GET("CEMITERIO_PUBLICO")
    fun getList() : Call<CemiterioResponse>


}