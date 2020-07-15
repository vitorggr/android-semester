package com.example.preprova2.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.preprova2.Models.Post
import com.example.preprova2.R
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter (var context: Context,var posts : List<Post>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_post,null)
        var id = view.findViewById<TextView>(R.id.id)
        var title = view.findViewById<TextView>(R.id.title)

        id.text = posts[position].id.toString()
        title.text = posts[position].title

        return view
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return posts.size
    }
}