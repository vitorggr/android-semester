package br.com.cotemig.instagramgalery.services

import br.com.cotemig.instagramgalery.models.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountService {

    @POST("account/auth")
    fun auth(@Body account: Account) : Call<Account>

}