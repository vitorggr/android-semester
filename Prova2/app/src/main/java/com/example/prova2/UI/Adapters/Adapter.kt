package com.example.prova2.UI.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.prova2.Models.Competition
import com.example.prova2.R

//Nessa lista o aplicativo deve apresentar uma lista com o nome do campeonato, o país a qual ele pertence,
//a data inicial e final.

class Adapter (var context: Context,var list : List<Competition>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view =LayoutInflater.from(context).inflate(R.layout.item,null)
        var competition = list[position]
        var name = view.findViewById<TextView>(R.id.nome)
        var pais = view.findViewById<TextView>(R.id.pais)
        var dtI = view.findViewById<TextView>(R.id.dtInicial)
        var dtF = view.findViewById<TextView>(R.id.dtFinal)

        name.text = competition.name
        pais.text = competition.area.name
        dtI.text = competition.currentSeason.startDate
        dtF.text = competition.currentSeason.endDate

        return view;
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }

}
