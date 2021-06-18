package dev.cancio.creatures.model

data class Creature (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val nickname: String,
    val image: String,
    val planet: String,
    val foods: List<Int>,
    var isFavorite: Boolean = false
        ){

    val fullName: String
        get() = "$firstName $lastName"

    val uri: String
        get() = "drawable/$image"

    val thumbnail: String
        get() = "drawable/thumbnail_$image"
}