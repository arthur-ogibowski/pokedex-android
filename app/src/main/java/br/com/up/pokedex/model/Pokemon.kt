package br.com.up.pokedex.model

data class Pokemon(
    val url : String,
    val id: Int,
    val name : String,
    val height: Float,
    val weight: Float,
    val types: List<Type>,
    val abilities: List<Abilities>,
    val stats: List<Stats>,
    val moves: List<Moves>

)

data class Type(
    val type: Name
)

data class Name(
    val name: String
)

data class Stats(
    val stat: Name
)
data class Abilities(
    val ability: Name
)
data class Moves(
    val move: Name
)





