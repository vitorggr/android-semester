package br.com.ead.solucaoprova2019feed.services

import br.com.ead.solucaoprova2019feed.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface ServiceFeed {

    @GET("feed/prova")
    fun getFeed() : Call<List<Post>>

}