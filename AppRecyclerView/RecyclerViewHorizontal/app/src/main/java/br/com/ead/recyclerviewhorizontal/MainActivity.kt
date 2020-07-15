package br.com.ead.recyclerviewhorizontal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var l : ArrayList<Response> = arrayListOf()
        l.add(Response(R.drawable.undraw_add_to_cart_vkjp,"Choose your desire product","Contrary to popular belief, Lorem Ipsum is not simply random text"))
        l.add(Response(R.drawable.undraw_on_the_way_ldaq,"Complete your shopping","Contrary to popular belief, Lorem Ipsum is not simply random text"))
        l.add(Response(R.drawable.undraw_successful_purchase_uyin_1,"Get product at your door","Contrary to popular belief"))


        list.adapter = Adapter(this, l)
        list.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(list)
        list.addItemDecoration(LinePagerIndicatorDecoration())


    }
}
