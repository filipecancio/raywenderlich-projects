package dev.cancio.creatures.model

import android.content.Context
import com.google.gson.Gson

object Favorites {
    private const val KEY_FAVORITES = "KEY_FAVORITES"
    private val gson = Gson()

    private var favorites: MutableList<Int>? = null

    fun isFavorite(creature: Creature, context: Context): Boolean {
        return getFavorites(context)?.contains(creature.id) == true
    }

    fun addFavorite(creature: Creature, context: Context){}
    fun removeFavorite(creature: Creature, context: Context){}
    private fun getFavorites(context: Context): MutableList<Int>? {
        return favorites
    }
    private fun saveFavorites(key: String, list: List<Int>, context: Context){}
    private fun sharedPrefs(context: Context){}
}