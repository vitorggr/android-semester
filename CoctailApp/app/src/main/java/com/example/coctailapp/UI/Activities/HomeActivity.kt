package com.example.coctailapp.UI.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.coctailapp.Models.DrinkList
import com.example.coctailapp.Models.drink
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import com.example.coctailapp.UI.Adapters.DrinkListAdapter
import com.example.coctailapp.UI.Adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_drink_list.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.lista
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getThumbs()
        lista_drinks_name.setOnClickListener {
            showListByName()
            var name = findViewById<EditText>(R.id.name)
            name.text.clear()
        }
        lista_ingredientes.setOnClickListener {
            showListByIngredient()
            var ingredient = findViewById<EditText>(R.id.ingredient)
            ingredient.text.clear()
        }
        list_categorias.setOnClickListener {
            var intent = Intent(this,CategoriesActivity::class.java)
            startActivity(intent)

        }
        logout.setOnClickListener{
            logout()
        }
    }


    fun getThumbs(){

        var s = RetrofitInitializer().serviceDrinks()

        var call = s.getAll("a")

        call.enqueue(object : retrofit2.Callback<DrinkList> {
            override fun onResponse(call: Call<DrinkList>?, response: Response<DrinkList>?) {
                response?.let {
                    if (it.code() == 200) {
                        lista.adapter = RecyclerViewAdapter(this@HomeActivity,it.body())
                        lista.layoutManager = LinearLayoutManager(
                            this@HomeActivity,
                            LinearLayoutManager.HORIZONTAL, false
                        )

                        val snapHelper = PagerSnapHelper()
                        snapHelper.attachToRecyclerView(lista)
                        changeThumbs(lista,24,0)

                    }
                }
            }

            override fun onFailure(call: Call<DrinkList>?, t: Throwable?) {
            }

        })
    }

    fun changeThumbs(list: RecyclerView, max: Int, position: Int) {

        if (position < max) {

            Handler().postDelayed({
                list.scrollToPosition(position)
                changeThumbs(list, max, position + 1)
            }, 2200)

        } else {
            changeThumbs(list, max, 0)
        }
    }

    fun showListByIngredient(){
        var parametro = findViewById<EditText>(R.id.ingredient).text.toString()
        var intent = Intent(this,DrinkListByIngredientActivity::class.java)
        intent.putExtra("ingredient",parametro)
        startActivity(intent)
    }

    fun showListByName() {
        var parametro = findViewById<EditText>(R.id.name).text.toString()
        var intent = Intent(this,DrinkListByNameActivity::class.java)
        intent.putExtra("drink", parametro)
        startActivity(intent)
    }

    fun logout(){
            val preferences = getSharedPreferences("my_prefs_data", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("user",null);
            editor.putString("password",null);
            editor.putBoolean("bool", false)
            editor.commit()
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }



