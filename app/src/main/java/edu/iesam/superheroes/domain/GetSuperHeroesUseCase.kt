package edu.iesam.superheroes.domain

class GetSuperHeroesUseCase(private val superHeroRepository: SuperHeroRepository) {
    operator fun invoke(): List<SuperHeroe> {
        return superHeroRepository.getSuperHeroes()
    }
}