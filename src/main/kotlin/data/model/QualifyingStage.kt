package data.model

class QualifyingStage(private val name: String) {

    private val teams: MutableList<Team> = mutableListOf()
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

    fun getFixture(): Fixture {
        return fixture
    }

    fun setFixture(fixture: Fixture) {
        this.fixture = fixture
    }

    fun getStageName(): String {
        return name
    }

}