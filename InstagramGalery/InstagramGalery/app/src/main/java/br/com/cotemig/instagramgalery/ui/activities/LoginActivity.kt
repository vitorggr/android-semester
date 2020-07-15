package br.com.cotemig.instagramgalery.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.cotemig.instagramgalery.R
import br.com.cotemig.instagramgalery.models.Account
import br.com.cotemig.instagramgalery.services.RetrofitInitializer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            auth()
        }
    }

    fun auth() {

        var s = RetrofitInitializer().serviceAccount()

        var a = Account()
        a.email = email.text.toString()
        a.password = password.text.toString()

        var call = s.auth(a)

        call.enqueue(object : retrofit2.Callback<Account> {

            override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
                response?.let {
                    if (it.code() == 200) {

                        saveAccountData(it.body())

                        goMainActivity()

                    } else {

                        MaterialDialog.Builder(this@LoginActivity)
                            .theme(Theme.LIGHT)
                            .title(R.string.login_ops)
                            .content(R.string.login_message_error_login)
                            .positiveText(R.string.login_ok)
                            .show()

                    }
                }
            }

            override fun onFailure(call: Call<Account>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })


    }

    fun saveAccountData(a: Account) {
        // TODO: salvar os dados do usuário para login automático
//        email.text = a.email
//        Glide.with(this).load(a.picture).into(avatar)
//        save(a.email)
//        save(a.password)
    }

    fun goMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
