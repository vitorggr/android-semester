package com.example.prova2.Service

import com.example.prova2.Models.Competition
import com.example.prova2.Models.CompetitionResponse
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("competition")
    fun getCompetitions(): Call<CompetitionResponse>

}