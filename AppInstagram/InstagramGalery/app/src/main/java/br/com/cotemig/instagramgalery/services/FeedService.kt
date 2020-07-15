package br.com.cotemig.instagramgalery.services

import br.com.cotemig.instagramgalery.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface FeedService {

    @GET("feed")
    fun getFeed() : Call<List<Post>>

}