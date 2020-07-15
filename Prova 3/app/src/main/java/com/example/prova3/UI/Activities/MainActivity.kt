package com.example.prova3.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.prova3.R
import com.example.prova3.UI.Fragments.CemiterioFragment
import com.example.prova3.UI.Fragments.EquipeFragment
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(EquipeFragment(), "Lista Equipe")
        setFragment(CemiterioFragment(),"Lista Cemitérios")

        listaEquipe.setOnClickListener{
            callFragment("home_button_estacao_onibus")
        }
        listaCemiterios.setOnClickListener{
            callFragment("home_button_centro_refencia")
        }
    }

    private fun callFragment(s: String) {
        if(s == "listaEquipe")
        {
            setFragment(EquipeFragment(), "Lista Equipe")
        } else if( s == "listaCemiterios"){
            setFragment(CemiterioFragment(), "Lista Cemitérios")
        }

    }

    fun setFragment(f: Fragment, name: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_frame, f, name)
        ft.addToBackStack(name)
        ft.commit()
    }


}
