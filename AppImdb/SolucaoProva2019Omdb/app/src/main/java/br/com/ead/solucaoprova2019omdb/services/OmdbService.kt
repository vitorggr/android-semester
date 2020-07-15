package br.com.ead.solucaoprova2019omdb.services

import br.com.ead.solucaoprova2019omdb.models.OmdbResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbService {

    @GET("default.aspx")
    fun getEpisodes(@Query("t") t : String,
                   @Query("Season") Season : String,
                   @Query("apikey") apikey : String) : Call<OmdbResponse>

}