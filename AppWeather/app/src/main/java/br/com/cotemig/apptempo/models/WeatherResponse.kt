package br.com.cotemig.apptempo.models

data class WeatherResponse (
    var id: Int = 0,
    var name: String = "",
    var main: Weather,
    var coord: Coordinates
)