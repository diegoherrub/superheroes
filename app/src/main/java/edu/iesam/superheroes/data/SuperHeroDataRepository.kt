package edu.iesam.superheroes.data

import edu.iesam.superheroes.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.superheroes.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.superheroes.domain.SuperHeroRepository
import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroDataRepository(
    private val local: SuperHeroXmlLocalDataSource,
    private val mockRemoteDataSource: SuperHeroMockRemoteDataSource
): SuperHeroRepository {
    
    override fun getSuperHero(superHeroId: String): SuperHeroe? {
        val localSuperHero = local.findById(superHeroId)
        if(localSuperHero == null) {
            mockRemoteDataSource.getSuperHero(superHeroId)?.let {
                local.save(it)
                return it
            }
        }
        return localSuperHero
    }

    override fun getSuperHeroes(): List<SuperHeroe> {
        val superheroesFromLocal = local.findAll()
        if(superheroesFromLocal.isEmpty()) {
            val superHeroesFromRemote = mockRemoteDataSource.getSuperHeroes()
            local.saveAll(superHeroesFromRemote)
            return superHeroesFromRemote
        } else {
            return superheroesFromLocal
        }
    }

}