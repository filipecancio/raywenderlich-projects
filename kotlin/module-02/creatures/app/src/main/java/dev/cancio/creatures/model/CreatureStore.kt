package dev.cancio.creatures.model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object CreatureStore {

    private const val TAG = "CreatureStore"

    private lateinit var creatures: List<Creature>
    private lateinit var foods: List<Food>

    fun loadCreatures(context: Context){
        val gson = Gson()
        val json = loadJSONFromAsset("creatures.json", context)
        val listType = object : TypeToken<List<Creature>>() {}.type
        creatures = gson.fromJson(json, listType)
        creatures
            .filter { Favorites.isFavorite(it, context) }
            .forEach { it.isFavorite = true }
        Log.v(TAG, "Found ${creatures.size} creatures")
    }

    fun loadFoods(context: Context){
        val gson = Gson()
        val json = loadJSONFromAsset("foods.json", context)
        val listType = object : TypeToken<List<Food>>() {}.type
        foods = gson.fromJson(json, listType)
        Log.v(TAG, "Found ${foods.size} food items")
    }

    fun getCreatureById(id: Int) = creatures.firstOrNull { it.id == id }

    fun getFoodById(id: Int) = foods.firstOrNull { it.id == id }

    private fun loadJSONFromAsset(filename: String, context: Context): String? {
        var json: String? = null
        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        }catch (ex: IOException){
            Log.e(TAG, "Error reading from $filename", ex)
        }
        return json
    }
}