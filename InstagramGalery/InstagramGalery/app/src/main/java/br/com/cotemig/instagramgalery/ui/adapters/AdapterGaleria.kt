package br.com.cotemig.instagramgalery.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.instagramgalery.R
import br.com.cotemig.instagramgalery.models.Image
import com.bumptech.glide.Glide

class AdapterGaleria(var context: Context, var gallery: List<Image>) :
    RecyclerView.Adapter<AdapterGaleria.ViewGallery>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewGallery {
        val view = LayoutInflater.from(context).inflate(R.layout.item_galeria, parent, false)
        return ViewGallery(view)
    }

    override fun getItemCount(): Int {
        return gallery.size
    }

    override fun onBindViewHolder(holder: ViewGallery, position: Int) {
        holder.bind(context, gallery[position])
    }

    class ViewGallery(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(context: Context, i: Image) {

            var image = itemView.findViewById<ImageView>(R.id.image)
            Glide.with(context).load(i.image).into(image)

        }

    }

}