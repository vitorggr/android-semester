package com.example.coctailapp.UI.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.coctailapp.Models.Account
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            auth()
        },1500)
    }


    fun goLoginActivity(){
        var intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goHomeActivity(){
        var intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun auth() {

        var preferences = getSharedPreferences("my_prefs_data", Context.MODE_PRIVATE)
        var bool = preferences.getBoolean("bool",false)
        var user = preferences.getString("user","")
        var pass = preferences.getString("password","")


        if (bool.equals(true)) {

            var s = RetrofitInitializer().serviceLogin()

            var a = Account()
            a.email = user.toString()
            a.password = pass.toString()

            var call = s.auth(a)

            call.enqueue(object : retrofit2.Callback<Account> {

                override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
                    response?.let {
                        if (it.code() == 200) {
                            goHomeActivity()
                        } else {
                            goLoginActivity()
                        }
                    }
                }

                override fun onFailure(call: Call<Account>?, t: Throwable?) {
                    TODO("Not yet implemented")
                }

            })

        }
        else{
            goLoginActivity()
        }
    }



}
