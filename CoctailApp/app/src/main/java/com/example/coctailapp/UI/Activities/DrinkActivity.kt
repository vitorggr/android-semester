package com.example.coctailapp.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.coctailapp.Models.DrinkList
import com.example.coctailapp.R
import com.example.coctailapp.Services.RetrofitInitializer
import com.example.coctailapp.UI.Adapters.DrinkAdapter
import kotlinx.android.synthetic.main.activity_drink.*
import kotlinx.android.synthetic.main.item_drink.*
import kotlinx.android.synthetic.main.item_drink.view.*
import kotlinx.android.synthetic.main.item_drink.view.ingredient1
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response

class DrinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)
        getDrinkById()
    }

    fun getDrinkById(){
        var id = intent.getStringExtra("drinkselecionado")
        var s = RetrofitInitializer().serviceDrinks()
        var call = s.getById(id)

        call.enqueue(object : retrofit2.Callback<DrinkList> {
            override fun onResponse(call: Call<DrinkList>?, response: Response<DrinkList>?) {
                response?.let {
                    if (it.code() == 200) {
                        drinkDetail.adapter = DrinkAdapter(this@DrinkActivity, it.body().drinks)
                       /* setContentView(R.layout.item_drink)
                        ingredient1.setOnClickListener{
                            var parametro = findViewById<TextView>(R.id.ingredient1).text.toString()
                            var intent = Intent(this@DrinkActivity,IngredientActivity::class.java)
                            intent.putExtra("ingredient",parametro)
                            startActivity(intent)
                        }
                        ingredient2.setOnClickListener{
                            var parametro = findViewById<TextView>(R.id.ingredient2).text.toString()
                            var intent = Intent(this@DrinkActivity,IngredientActivity::class.java)
                            intent.putExtra("ingredient",parametro)
                            startActivity(intent)
                        }
                        drinkDetail.ingredient3?.setOnClickListener{
                            var parametro = findViewById<TextView>(R.id.ingredient3).text.toString()
                            var intent = Intent(this@DrinkActivity,IngredientActivity::class.java)
                            intent.putExtra("ingredient",parametro)
                            startActivity(intent)
                        }
                        drinkDetail.ingredient4?.setOnClickListener{
                            var parametro = findViewById<TextView>(R.id.ingredient4).text.toString()
                            var intent = Intent(this@DrinkActivity,IngredientActivity::class.java)
                            intent.putExtra("ingredient",parametro)
                            startActivity(intent)
                        }
                        drinkDetail.ingredient5?.setOnClickListener{
                            var parametro = findViewById<TextView>(R.id.ingredient5).text.toString()
                            var intent = Intent(this@DrinkActivity,IngredientActivity::class.java)
                            intent.putExtra("ingredient",parametro)
                            startActivity(intent)
                        }*/
                    }
                }
            }


            override fun onFailure(call: Call<DrinkList>?, t: Throwable?) {
            }
        })
    }



}
