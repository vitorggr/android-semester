package br.com.cotemig.instagramgalery.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import br.com.cotemig.instagramgalery.R
import br.com.cotemig.instagramgalery.models.Post
import br.com.cotemig.instagramgalery.services.RetrofitInitializer
import br.com.cotemig.instagramgalery.ui.adapters.AdapterFeed
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFeed()
    }

    fun getFeed() {

        var s = RetrofitInitializer().serviceFeed()

        var call = s.getFeed()

        call.enqueue(object : retrofit2.Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                response?.let {
                    if (it.code() == 200) {
                        listView.adapter = AdapterFeed(this@MainActivity, it.body())
                    }
                }
            }
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })
    }

}
