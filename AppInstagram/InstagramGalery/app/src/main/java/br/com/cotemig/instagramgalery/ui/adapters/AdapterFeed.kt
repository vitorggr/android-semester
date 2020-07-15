package br.com.cotemig.instagramgalery.ui.adapters

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.instagramgalery.R
import br.com.cotemig.instagramgalery.models.Post
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class AdapterFeed(var context: Context, var list: List<Post>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_feed, null)

        var avatar = view.findViewById<ImageView>(R.id.avatar)
        var username = view.findViewById<TextView>(R.id.username)
        var galeria = view.findViewById<RecyclerView>(R.id.galeria)

        Glide.with(context).load(list[position].avatar).apply(
            RequestOptions().transform(RoundedCorners(16.px))
        ).into(avatar)

        username.text = list[position].user

        //RecyclerView
        galeria.adapter = AdapterGaleria(context, list[position].gallery)
        galeria.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL, false
        )

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(galeria)
        return view
    }

    val Int.dp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()
    val Int.px: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

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