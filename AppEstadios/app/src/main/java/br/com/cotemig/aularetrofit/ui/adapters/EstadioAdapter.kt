package br.com.cotemig.aularetrofit.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.aularetrofit.R
import br.com.cotemig.aularetrofit.models.Estadio
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class EstadioAdapter(var context: Context, var list: List<Estadio>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = LayoutInflater.from(context).inflate(R.layout.item_estadio, null)

        var name = view.findViewById<TextView>(R.id.name)
        name.text = list[position].nome

        var estado = view.findViewById<TextView>(R.id.estado)
        estado.text = list[position].estado

        var image = view.findViewById<ImageView>(R.id.image)

        Glide.with(context).load(list[position].foto).into(image)

        return view

    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }
}