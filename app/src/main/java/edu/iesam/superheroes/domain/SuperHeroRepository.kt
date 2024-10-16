package edu.iesam.superheroes.domain

interface SuperHeroRepository {

    fun getSuperHeroes(): List<SuperHeroe>
    fun getSuperHero(superHeroId: String): SuperHeroe?
}