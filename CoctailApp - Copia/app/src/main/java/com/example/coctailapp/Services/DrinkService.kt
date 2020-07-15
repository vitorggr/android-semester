package com.example.coctailapp.Services

import com.example.coctailapp.Models.DrinkList
import com.example.coctailapp.Models.drink
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {

    @GET("search.php?")
    fun getAll(
        @Query("f") f : String
    ) : Call<DrinkList>

    @GET("lookup.php?")
    fun getById(
        @Query("i") i : Int
    ) : Call<drink>


    @GET("search.php?")
    fun getByName(
        @Query("s") i : String
    ) : Call<drink>

}
