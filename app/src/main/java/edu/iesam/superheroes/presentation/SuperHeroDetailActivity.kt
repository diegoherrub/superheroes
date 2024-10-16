package edu.iesam.superheroes.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.superheroes.R
import edu.iesam.superheroes.app.extensions.loadUrl
import edu.iesam.superheroes.domain.SuperHeroe

class SuperHeroDetailActivity: AppCompatActivity() {

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroe_detail)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()

        getSuperHeroId()?.let { superHeroId ->
            viewModel.viewCreated(superHeroId)?.let {superHero ->
                bindData(superHero)
            }
        }
    }

    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superHero: SuperHeroe) {
        val imageView = findViewById<ImageView>(R.id.urlImage)
        imageView.loadUrl(superHero.urlImage)
    }

    companion object {
        val KEY_SUPERHERO_ID = "key_superhero_id"

        fun getIntent(context: Context, superHeroId: String): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superHeroId)
            return intent
        }
    }
}