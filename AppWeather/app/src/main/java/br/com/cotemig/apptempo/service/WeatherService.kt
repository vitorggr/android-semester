package br.com.cotemig.apptempo.service

import br.com.cotemig.apptempo.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun getWeather(
        @Query("q") q: String,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): Call<WeatherResponse>

}