package com.example.prova3.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.prova3.Models.Cemiterio
import com.example.prova3.Models.CemiterioResponse
import com.example.prova3.Models.PropertieCemiterio
import com.example.prova3.R

class CemiterioAdapter(var context: Context, var list: CemiterioResponse) : RecyclerView.Adapter<CemiterioAdapter.ViewHolderAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cemiterio, parent, false)
        return ViewHolderAdapter(view)
    }

    override fun getItemCount(): Int {
        return list.features.size
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        holder.bind(context, list.features[position])
    }

    class ViewHolderAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(context: Context, item: Cemiterio) {

            var geometry = itemView.findViewById<TextView>(R.id.geometry)
            geometry.text = item.geometry_name

            var type = itemView.findViewById<TextView>(R.id.type)
            type.text = item.type

            var letra = itemView.findViewById<TextView>(R.id.propertie_letra)
            letra.text = item.properties.LETRA_IMOVEL

            var telefone = itemView.findViewById<TextView>(R.id.propertie_telefone)
            telefone.text = item.properties.TELEFONE_PRINCIPAL

            var tipo = itemView.findViewById<TextView>(R.id.propertie_tipo)
            tipo.text = item.properties.TIPO_LOGRADOURO

           /* var logradouro = itemView.findViewById<TextView>(R.id.nome_logradouro)
            logradouro.text = item.NOME_LOGRADOURO

            var numero = itemView.findViewById<TextView>(R.id.numero)
            numero.text = item.NUMERO_IMOVEL.toString()

            var nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = item.NOME

            var categoria = itemView.findViewById<TextView>(R.id.categoria)
            categoria.text = item.CATEGORIA

            var nomepopular = itemView.findViewById<TextView>(R.id.nomepopular)
            nomepopular.text = item.NOME_POPULAR*/

        }
    }
}