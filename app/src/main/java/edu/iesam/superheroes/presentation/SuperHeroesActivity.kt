package edu.iesam.superheroes.presentation

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.superheroes.R
import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroesActivity : AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroes)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()

        val superheroes = viewModel.viewCreated()
        bindData(superheroes)
    }

    private fun bindData(superHeroes: List<SuperHeroe>) {
        findViewById<TextView>(R.id.superHero_id_1).text = superHeroes[0].id
        findViewById<TextView>(R.id.superHero_name_1).text = superHeroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[0].id)
        }

        findViewById<TextView>(R.id.superHero_id_2).text = superHeroes[1].id
        findViewById<TextView>(R.id.superHero_name_2).text = superHeroes[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[1].id)
        }

        findViewById<TextView>(R.id.superHero_id_3).text = superHeroes[2].id
        findViewById<TextView>(R.id.superHero_name_3).text = superHeroes[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[2].id)
        }

        findViewById<TextView>(R.id.superHero_id_4).text = superHeroes[2].id
        findViewById<TextView>(R.id.superHero_name_4).text = superHeroes[2].name
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            navigateToSuperHeroDetail(superHeroes[2].id)
        }
    }

    private fun navigateToSuperHeroDetail(superHeroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
    }
}