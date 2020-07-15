package com.example.preprova2.UI.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.preprova2.Models.Post
import com.example.preprova2.R
import com.example.preprova2.Services.RetrofitInitializer
import com.example.preprova2.UI.Adapters.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }

    fun getPosts(){
        var s = RetrofitInitializer().service()
        var call = s.getPosts()
        call.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {

                response?.let{
                    if(it.code() == 200){
                        list.adapter = PostAdapter(this@MainActivity,it.body())
                    }
                }

                Toast.makeText(this@MainActivity,"ok",Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity,"erro",Toast.LENGTH_LONG).show()
            }

        })


    }



}


