package edu.iesam.superheroes.data.remote

import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroMockRemoteDataSource {

    private val superHeroes = listOf(
        SuperHeroe("1", "superheroe1", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        SuperHeroe("2", "superheroe2", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        SuperHeroe("3", "superheroe3", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg"),
        SuperHeroe("4", "superheroe4", "https://pics.filmaffinity.com/the_sting-433653100-mmed.jpg")
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