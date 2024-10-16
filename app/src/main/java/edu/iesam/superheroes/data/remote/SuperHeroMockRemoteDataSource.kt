package edu.iesam.superheroes.data.remote

import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroMockRemoteDataSource {

    private val superHeroes = listOf(
        SuperHeroe("1", "superheroe1", "https://www.google.es"),
        SuperHeroe("2", "superheroe2", "https://www.google.es"),
        SuperHeroe("3", "superheroe3", "https://www.google.es"),
        SuperHeroe("4", "superheroe4", "https://www.google.es"),
    )

    fun getSuperHeroes(): List<SuperHeroe> {
        return superHeroes
    }

    fun getSuperHero(superHeroId: String): SuperHeroe? {
        return superHeroes.firstOrNull { superHero ->
            superHero.id == superHeroId
        }
    }

}