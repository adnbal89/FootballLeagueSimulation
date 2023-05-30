package data.model

class Group(
    val name: String,
) {
    private val teams: MutableList<Team> = mutableListOf()

    fun addTeam(team: Team) {
        teams.add(team)
    }

    fun removeTeam(team: Team) {
        teams.remove(team)
    }

    fun getTeams(): List<Team> {
        return teams
    }

}
