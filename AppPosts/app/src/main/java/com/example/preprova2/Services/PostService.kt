package com.example.preprova2.Services


import retrofit2.http.GET
import com.example.preprova2.Models.Post
import retrofit2.Call

interface PostService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}