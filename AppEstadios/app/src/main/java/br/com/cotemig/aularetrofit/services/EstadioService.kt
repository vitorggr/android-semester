package br.com.cotemig.aularetrofit.services

import br.com.cotemig.aularetrofit.models.ListaEstadio
import retrofit2.Call
import retrofit2.http.GET

interface EstadioService {

    @GET("estadio")
    fun getEstadios() : Call<ListaEstadio>

//    @GET("jogador")
//    fun getJogadores() : Call<ListaEstadio>

}