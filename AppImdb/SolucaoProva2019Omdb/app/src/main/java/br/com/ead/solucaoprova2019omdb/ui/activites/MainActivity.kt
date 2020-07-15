package br.com.ead.solucaoprova2019omdb.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ead.solucaoprova2019omdb.R
import br.com.ead.solucaoprova2019omdb.models.OmdbResponse
import br.com.ead.solucaoprova2019omdb.services.RetrofitInitializer
import br.com.ead.solucaoprova2019omdb.ui.adapters.EpisodeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getEpisodes()
    }

    fun getEpisodes() {

        var s = RetrofitInitializer().serviceOmdb()

        var call = s.getEpisodes("Dark", "1", "2f5cfd66")

        call.enqueue(object : retrofit2.Callback<OmdbResponse> {

            override fun onResponse(call: Call<OmdbResponse>?, response: Response<OmdbResponse>?) {

                response?.let {

                    if (it.code() == 200) {

                        name.text = it.body().Title

                        listEpisodes.adapter = EpisodeAdapter(this@MainActivity, it.body().Episodes)

                        Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_LONG).show()

                    }

                }


            }

            override fun onFailure(call: Call<OmdbResponse>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Erro", Toast.LENGTH_LONG).show()
            }

        })

    }
}
