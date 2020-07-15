package br.com.cotemig.instagramgalery.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.cotemig.instagramgalery.R
import br.com.cotemig.instagramgalery.ui.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(HomeFragment.newInstance(0, "Dirceu"), "Home")

    }

    fun setFragment(f: Fragment, name: String) {
        // iniciando a transação para trocar de tela (fragment)
        val ft = supportFragmentManager.beginTransaction()
        // trocando o fragment f com nome name no content
        ft.replace(R.id.content, f, name)
        // adicionando fragment na pilha de "voltar"
        ft.addToBackStack(name)
        // confirmando a troca de fragment
        ft.commit()
    }

}
