package com.example.coctailapp.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coctailapp.Models.Account
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.email
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signup.setOnClickListener {
            signUp()
            goLoginActivity()
        }

    }

    fun signUp() {

        var s = RetrofitInitializer().serviceLogin()

        var a = Account()
        a.email = email.text.toString()
        a.password = password.text.toString()

        var call = s.signUp(a)

        call.enqueue(object : retrofit2.Callback<Account> {

            override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
                response?.let {
                    if (it.code() == 200) {
                        goLoginActivity()
                    } else {
                    }
                }
            }

            override fun onFailure(call: Call<Account>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })


    }

    fun goLoginActivity() {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
