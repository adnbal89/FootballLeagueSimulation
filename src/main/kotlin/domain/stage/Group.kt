package domain.stage

import data.model.Fixture
import data.model.Match
import data.model.Standing
import data.model.Team

class Group(val name: String) {
    private var teams: MutableList<Team> = mutableListOf()
    private lateinit var standing: Standing
    private lateinit var fixture: Fixture

    fun addTeam(team: Team) {
        teams.add(team)
    }

    fun removeTeam(team: Team) {
        teams.remove(team)
    }

    fun setAllTeams(teamsList: MutableList<Team>){
        this.teams =  teamsList
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

    /*fun getFixture(): Fixture {
        return fixture
    }

    fun setFixture(fixture: Fixture) {
        this.fixture = fixture
    }*/

    fun getGroupName(): String {
        return name
    }
}
