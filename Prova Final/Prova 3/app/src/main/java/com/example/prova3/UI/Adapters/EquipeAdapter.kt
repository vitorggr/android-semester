package com.example.prova3.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.prova3.Models.Equipe
import com.example.prova3.Models.EquipeResponse
import com.example.prova3.Models.PropertieEquipe
import com.example.prova3.R

public class EquipeAdapter (var context : Context, var listEquipe :List<Equipe>): BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_equipe,null)

        var geometry = view.findViewById<TextView>(R.id.geometry)
        geometry.text = listEquipe[position].geometry_name

        var type = view.findViewById<TextView>(R.id.type)
        type.text = listEquipe[position].type

        var letra_imovel = view.findViewById<TextView>(R.id.propetie_letra)
        letra_imovel.text = listEquipe[position].properties.LETRA_IMOVEL

        var tipo_logradouro = view.findViewById<TextView>(R.id.propertie_logradouro)
        tipo_logradouro.text = listEquipe[position].properties.TIPO_LOGRADOURO

        var nome_logradouro = view.findViewById<TextView>(R.id.nome_logradouro)
        nome_logradouro.text = listEquipe[position].NOME_LOGRADOURO

        var endereco = view.findViewById<TextView>(R.id.endereco_completo)
        endereco.text = listEquipe[position].COMPL_ENDERECO

        var nome = view.findViewById<TextView>(R.id.nome)
        nome.text = listEquipe[position].NOME

        var categoria = view.findViewById<TextView>(R.id.categoria)
        categoria.text = listEquipe[position].CATEGORIA

        var numero = view.findViewById<TextView>(R.id.numero)
        numero.text = listEquipe[position].NUMERO_IMOVEL

        var orgao = view.findViewById<TextView>(R.id.orgao)
        orgao.text = listEquipe[position].ORGAO_RESPONSAVEL

        return view;
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listEquipe.size
    }
}