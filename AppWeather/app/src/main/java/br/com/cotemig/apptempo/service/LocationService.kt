package br.com.cotemig.apptempo.service

import br.com.cotemig.apptempo.models.Location
import retrofit2.Call
import retrofit2.http.GET

interface LocationService {

    @GET("json/")
    fun getLocation(): Call<Location>

}