package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.up.pokedex.network.PokeApi
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getStringExtra("pokemon")

        val pokemonImage: ImageView = findViewById(R.id.pokeImage)
        val pokemonName: TextView = findViewById(R.id.pokeName)
        val pokemonHeight: TextView = findViewById(R.id.pokeHeight)
        val pokemonWeight: TextView = findViewById(R.id.pokeWeight)
        val chipGroupT: ChipGroup = findViewById(R.id.pokeTypes)
        val chipGroupS: ChipGroup = findViewById(R.id.pokeStats)
        val chipGroupA: ChipGroup = findViewById(R.id.pokeAbilities)
        val chipGroupM: ChipGroup = findViewById(R.id.pokeMoves)

        PokeApi().getPokemonByName(pokemon!!){
                pokemon ->

            if(pokemon != null) {

                val id = pokemon.id
                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
                Picasso.get().load(url).into(pokemonImage)
                pokemonName.text = pokemon.name
                pokemonWeight.text = pokemon.weight.toString()
                pokemonHeight.text = pokemon.height.toString()

                pokemon.types.forEach{
                    Createchip(it.type.name, chipGroupT);

                }

                pokemon.stats.forEach{
                    Createchip(it.stat.name, chipGroupS);

                }

                pokemon.abilities.forEach{
                    Createchip(it.ability.name, chipGroupA);

                }

                pokemon.moves.forEach{
                    Createchip(it.move.name, chipGroupM);

                }
            }
        }
    }

    fun Createchip(valor : String, ChipGroup : ChipGroup){
        val chip = Chip(this);
        chip.setText(valor);

        ChipGroup.addView(chip);
    }

}
