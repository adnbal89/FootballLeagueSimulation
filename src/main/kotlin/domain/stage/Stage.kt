package domain.stage

import data.model.Fixture
import data.model.Match
import data.model.Team


interface Stage {
    fun simulate()
    fun isCompleted(): Boolean
    fun getMatches(): List<Match>
    fun generateFixtures()
    fun getQualifiedTeams(): List<Team>
    fun simulateDraw(teamList: List<Team>) // draw simulation

}