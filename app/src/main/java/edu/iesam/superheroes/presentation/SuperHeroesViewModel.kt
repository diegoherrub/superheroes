package edu.iesam.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.superheroes.domain.GetSuperHeroesUseCase
import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroesViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase
): ViewModel() {
    fun viewCreated(): List<SuperHeroe> {
        return getSuperHeroesUseCase.invoke()
    }
}