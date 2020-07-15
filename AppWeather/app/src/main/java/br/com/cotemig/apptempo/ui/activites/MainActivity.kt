package br.com.cotemig.apptempo.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.cotemig.apptempo.R
import br.com.cotemig.apptempo.models.Location
import br.com.cotemig.apptempo.models.WeatherResponse
import br.com.cotemig.apptempo.service.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // obtendo localização do usuário baseado no IP
        getLocation()

    }

    fun getLocation() {
        var s = RetrofitInitializer().serviceLocation()

        var call = s.getLocation()

        call.enqueue(object : retrofit2.Callback<Location> {
            override fun onResponse(call: Call<Location>?, response: Response<Location>?) {
                response?.let {

                    if (it.code() == 200) {

                        Toast.makeText(
                            this@MainActivity,
                            it.body().city,
                            Toast.LENGTH_LONG
                        ).show()

                        getWeather(it.body().city)
                    }

                }
            }

            override fun onFailure(call: Call<Location>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun getWeather(city: String) {

        var s = RetrofitInitializer().serviceWeather()

        var call = s.getWeather(city, "7489ef6eb644acdd47a1ce5776d531bd", "metric")

        call.enqueue(object : retrofit2.Callback<WeatherResponse> {

            override fun onResponse(
                call: Call<WeatherResponse>?,
                response: Response<WeatherResponse>?
            ) {

                response?.let {

                    if (it.code() == 200) {
                        temperatura.text = it.body().main.temp.toString()
                    }

                }

            }

            override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }

        })

    }
}
