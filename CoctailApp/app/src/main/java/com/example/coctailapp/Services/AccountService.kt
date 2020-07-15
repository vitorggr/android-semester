package com.example.coctailapp.Services

import com.example.coctailapp.Models.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountService {

    @POST("account/auth")
    fun auth(@Body account: Account) : Call<Account>

    @POST("account")
    fun signUp(@Body account: Account) : Call<Account>

    @POST("account/forgot")
    fun recoverPassword(@Body email: String) : Call<Account>

}