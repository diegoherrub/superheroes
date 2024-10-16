package edu.iesam.superheroes.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.superheroes.R
import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.superheroes_file_xml), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(superHeroe: SuperHeroe) {
        val editor = sharedPref.edit()
        editor.putString(superHeroe.id, gson.toJson(superHeroe))
        editor.apply()
    }

    fun saveAll(superHeroes: List<SuperHeroe>) {
        val editor = sharedPref.edit()
        superHeroes.forEach { superHeroe ->
            editor.putString(superHeroe.id, gson.toJson(superHeroe))
        }
        editor.apply()
    }

    fun findById(superHeroId: String): SuperHeroe? {
        return sharedPref.getString(superHeroId, null)?.let { superhero ->
            gson.fromJson(superhero, SuperHeroe::class.java)
        }
    }

    fun findAll(): List<SuperHeroe> {
        val superHeroes = ArrayList<SuperHeroe>()
        val mapSuperHeroes = sharedPref.all
        mapSuperHeroes.values.forEach { jsonSuperHero ->
            val superHero = gson.fromJson(jsonSuperHero as String, SuperHeroe::class.java)
            superHeroes.add(superHero)
        }
        return superHeroes
    }
}