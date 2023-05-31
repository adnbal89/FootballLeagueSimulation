package data.model

class Group(val name: String) {


    private val teams: MutableList<Team> = mutableListOf()
    private lateinit var standing: Standing
    private lateinit var fixture: Fixture

    fun addTeam(team: Team) {
        teams.add(team)
    }

    fun removeTeam(team: Team) {
        teams.remove(team)
    }

    fun getTeams(): List<Team> {
        return teams
    }

    fun setStanding(standing: Standing) {
        this.standing = standing
    }

    fun getStanding(): Standing {
        return standing
    }

    fun getFixture(): Fixture {
        return fixture
    }

    fun setFixture(fixture: Fixture) {
        this.fixture = fixture
    }

    fun getGroupName(): String {
        return name
    }

}
