package com.example.coctailapp.Services

import com.example.coctailapp.Models.DrinkDetail
import com.example.coctailapp.Models.DrinkList
import com.example.coctailapp.Models.IngredientList
import com.example.coctailapp.Models.drink
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {

   // Essa API possui endpoints de listagem por categoria e ingredientes,pesquisa por nome,filtragem por categoria e consulta por detalhes de determinado drink por ID

    @GET("search.php?")
    fun getAll(
        @Query("f") f : String
    ) : Call<DrinkList>

    @GET("lookup.php?")
    fun getById(
        @Query("i") i : String
    ) : Call<DrinkList>

    @GET("search.php?")
    fun getByName(
        @Query("s") i : String
    ) : Call<DrinkList>

    @GET("filter.php?")
    fun getByIngredient(
        @Query("i") i : String
    ) : Call<DrinkList>

    @GET("filter.php?")
    fun getByCategorie(
        @Query("c") c : String
    ) : Call<DrinkList>

    @GET("search.php?")
    fun getIngredientByName(
        @Query("i") c : String
    ) : Call<IngredientList>

}
