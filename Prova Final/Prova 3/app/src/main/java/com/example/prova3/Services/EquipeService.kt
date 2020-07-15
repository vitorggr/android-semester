package com.example.prova3.Services

import com.example.prova3.Models.CemiterioResponse
import com.example.prova3.Models.EquipeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface EquipeService {
    @GET("EQUIP_HAB_CREAR")
    fun getList() : Call<EquipeResponse>
}