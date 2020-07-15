package br.com.ead.recyclerviewhorizontal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(var context: Context, var list: List<Response>) :
    RecyclerView.Adapter<Adapter.ViewHolderAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolderAdapter(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        holder.bind(context, list[position])
    }

    class ViewHolderAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(context: Context, item: Response) {

            var title = itemView.findViewById<TextView>(R.id.title)
            var subtitle = itemView.findViewById<TextView>(R.id.subtitle)
            var image = itemView.findViewById<ImageView>(R.id.image)
            Glide.with(context).load(item.image).into(image)
            title.text = item.title
            subtitle.text = item.subtitle


        }
    }

}

