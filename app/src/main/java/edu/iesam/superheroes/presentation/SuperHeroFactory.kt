package edu.iesam.superheroes.presentation

import android.content.Context
import edu.iesam.superheroes.data.SuperHeroDataRepository
import edu.iesam.superheroes.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.superheroes.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.superheroes.domain.GetSuperHeroUseCase
import edu.iesam.superheroes.domain.GetSuperHeroesUseCase

class SuperHeroFactory(private val context: Context) {
    private val superHeroMockRemote = SuperHeroMockRemoteDataSource()
    private val superHeroLocal = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository = SuperHeroDataRepository(superHeroLocal, superHeroMockRemote)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroesViewModel {
        return SuperHeroesViewModel(getSuperHeroesUseCase)
    }

    fun buildSuperHeroDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }

}