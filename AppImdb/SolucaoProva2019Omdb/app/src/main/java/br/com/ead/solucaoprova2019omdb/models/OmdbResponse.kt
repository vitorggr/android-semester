package br.com.ead.solucaoprova2019omdb.models

data class OmdbResponse(

    var Title: String = "",
    var Season: String = "",
    var totalSeasons: String = "",
    var Episodes: List<Episode>

)