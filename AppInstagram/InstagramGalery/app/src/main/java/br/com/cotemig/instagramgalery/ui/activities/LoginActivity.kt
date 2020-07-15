package br.com.cotemig.instagramgalery.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.instagramgalery.R
import br.com.cotemig.instagramgalery.services.RetrofitInitializer
import br.com.cotemig.instagramgalery.models.Account
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth()
    }

    fun auth(){
        var s = RetrofitInitializer().serviceAccount()
        var a = Account()
        a.email = email.text.toString()
        a.password = password.text.toString()
        var call = s.auth(a)

        call.enqueue(object : retrofit2.Callback<Account>{

            override fun onFailure(call: Call<Account>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Account>?, response: Response<Account>?) {
                response?.let{
                        if(it.code() == 200){
                            // TODO: salvar os dados do usuario para login automatico
                            goMainActivity()
                        }else{
                            MaterialDialog.Builder(this@LoginActivity)
                                .theme(Theme.LIGHT)
                                .title("Ops")
                                .content("Usuario ou senha invalidos")
                                .positiveText("OK")
                                .show()
                        }
                }
            }
        })
    }

    fun goMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun saveAccountData(a : Account){
        //TODO: salvar os dados do usuario para login automatico
    }


}
