package br.com.ead.solucaoprova2019feed.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.ead.solucaoprova2019feed.R
import br.com.ead.solucaoprova2019feed.models.Post
import br.com.ead.solucaoprova2019feed.services.RetrofitInitializer
import br.com.ead.solucaoprova2019feed.ui.adapters.FeedAdapter
import kotlinx.android.synthetic.main.activity_feed.*
import retrofit2.Call
import retrofit2.Response

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        getFeed()
    }

    fun getFeed() {

        var s = RetrofitInitializer().serviceFeed()

        var call = s.getFeed()

        call.enqueue(object : retrofit2.Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {

                response?.let{

                    if(it.code() == 200){

                        listFeed.adapter = FeedAdapter(this@FeedActivity, it.body())

                    }

                }

            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {

                Toast.makeText(this@FeedActivity, "Erro", Toast.LENGTH_LONG).show()

            }

        })


    }
}
