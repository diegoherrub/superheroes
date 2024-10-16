package edu.iesam.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
): ViewModel() {

    fun viewCreated(superHeroId: String): SuperHeroe? {
        return getSuperHeroUseCase.invoke(superHeroId)
    }
}