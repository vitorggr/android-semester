package br.com.cotemig.instagramgalery.models

data class Post(

    var id: String = "",
    var date: String = "",
    var image: String = "",
    var description: String = "",
    var avatar: String = "",
    var user: String = "",
    var local: String = "",
    var gallery: List<Image>,
    var likes: List<String>

)