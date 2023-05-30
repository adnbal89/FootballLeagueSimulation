package data.model

data class League(
    val name: String,
    val level: Enum<LeagueLevel>,
    val groupList: List<Group>
)
