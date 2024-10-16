package edu.iesam.superheroes.domain

interface SuperHeroRepository {
    fun findAll(): List<SuperHeroe>
}