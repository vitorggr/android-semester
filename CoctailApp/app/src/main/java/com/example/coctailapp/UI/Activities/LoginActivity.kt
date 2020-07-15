package com.example.coctailapp.UI.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coctailapp.Models.Account
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        register.setOnClickListener{
            var intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            auth()
        }

        recover.setOnClickListener {
            var intent = Intent(this,RecoverPasswordActivity::class.java)
            startActivity(intent)
        }

    }

    fun auth() {

        var s = RetrofitInitializer().serviceLogin()

        var a = Account()
        a.email = email.text.toString()
        a.password = password.text.toString()

        var call = s.auth(a)

        call.enqueue(object : retrofit2.Callback<Account> {

            override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
                response?.let {
                    if (it.code() == 200) {
                        saveAccountData()
                        goHomeActivity()
                    } else {

                    }
                }
            }

            override fun onFailure(call: Call<Account>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })


    }

    fun saveAccountData() {
                val preferences = getSharedPreferences("my_prefs_data", Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("user",email.text.toString());
                editor.putString("password",password.text.toString());
                editor.putBoolean("bool", true)
                editor.commit()
    }


    fun goHomeActivity() {
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}
