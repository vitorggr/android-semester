package br.com.ead.solucaoprova2019omdb.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.ead.solucaoprova2019omdb.R
import br.com.ead.solucaoprova2019omdb.models.Episode

class EpisodeAdapter(var context: Context, var episodes: List<Episode>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_episode, null)

        var name = view.findViewById<TextView>(R.id.name)
        var rating = view.findViewById<TextView>(R.id.rating)

        name.text = episodes[position].Title
        rating.text = episodes[position].imdbRating

        return view
    }

    override fun getItem(position: Int): Any {
        return ""
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return episodes.size
    }
}