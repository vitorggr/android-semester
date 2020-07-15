package com.example.prova3.Models

data class Cemiterio(
    var id : String,
    var geometry_name : String,
    var type : String,
    var properties : PropertieCemiterio,
    var NOME_LOGRADOURO : String,
    var NUMERO_IMOVEL : Int,
    var NOME : String,
    var ID_EQ_NEC : Int,
    var CATEGORIA : String,
    var NOME_POPULAR : String

)