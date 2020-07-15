package br.com.ead.solucaoprova2019feed.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.ead.solucaoprova2019feed.R
import br.com.ead.solucaoprova2019feed.models.Post
import com.bumptech.glide.Glide

class FeedAdapter(var context: Context, var list: List<Post>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = LayoutInflater.from(context).inflate(R.layout.item_feed, null)

        var post = list[position]

        var avatar = view.findViewById<ImageView>(R.id.avatar)
        var image = view.findViewById<ImageView>(R.id.image)
        var likes = view.findViewById<TextView>(R.id.likes)
        var date = view.findViewById<TextView>(R.id.date)

        likes.text = post.curtidas.toString()
        date.text = post.data

        Glide.with(context).load(post.imagem).into(image)
        Glide.with(context).load(post.perfil).into(avatar)

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