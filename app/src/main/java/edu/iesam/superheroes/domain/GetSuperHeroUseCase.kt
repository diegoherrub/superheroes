package edu.iesam.superheroes.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(superHeroId: String): SuperHeroe? {
        return superHeroRepository.getSuperHero(superHeroId)
    }
}