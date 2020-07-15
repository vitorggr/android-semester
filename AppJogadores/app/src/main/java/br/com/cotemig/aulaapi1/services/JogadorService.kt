package br.com.cotemig.aulaapi1.services
import br.com.cotemig.aulaapi1.models.ListaJogador;
import retrofit2.Call
import retrofit2.http.GET

interface JogadorService {

    @GET("jogador")
    fun getJogadores(): Call<ListaJogador>

}