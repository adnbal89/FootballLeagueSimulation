package data.model

data class Team(
    val name: String,
    val country: String,
    val nameShort: String,
    val stadium: Stadium,
    val squad: List<Player>,
    val previousResults: HashMap<League, Match>
)
