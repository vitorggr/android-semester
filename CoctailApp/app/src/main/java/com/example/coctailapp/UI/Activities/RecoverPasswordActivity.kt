package com.example.coctailapp.UI.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coctailapp.Models.Account
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.email
import kotlinx.android.synthetic.main.activity_recover_password.*
import retrofit2.Call
import retrofit2.Response

class RecoverPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)
        send.setOnClickListener {
            sendVerification()
        }

    }

    fun sendVerification() {

        var s = RetrofitInitializer().serviceLogin()
        var a : String = emailRecover.text.toString()
        var call = s.recoverPassword(a)

        call.enqueue(object : retrofit2.Callback<Account> {

            override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
                response?.let {
                    if (it.code() == 200) {
                        goLoginActivity()
                    } else {
                        goLoginActivity()
                        /*MaterialDialog.Builder(this@LoginActivity)
                            .theme(Resources.Theme.LIGHT)
                            .title(R.string.login_ops)
                            .content(R.string.login_message_error_login)
                            .positiveText(R.string.login_ok)
                            .show()*/

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
