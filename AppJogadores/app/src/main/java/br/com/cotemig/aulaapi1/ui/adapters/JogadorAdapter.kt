
package br.com.cotemig.aulaapi1.ui.adapters;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.aulaapi1.R
import br.com.cotemig.aulaapi1.models.Jogador
import com.bumptech.glide.Glide

public class JogadorAdapter (var context : Context, var list :List<Jogador>):BaseAdapter(){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_jogador,null)

        var name = view.findViewById<TextView>(R.id.name)
        name.text = list[position].nome

        var time = view.findViewById<TextView>(R.id.time)
        time.text = list[position].time

        var image = view.findViewById<ImageView>(R.id.image)

        Glide
            .with(context)
            .load(list[position].foto)
            .into(image)

        return view

    }

    override fun getItem(position: Int): Any {
       return position

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
       return list.size
    }


}
