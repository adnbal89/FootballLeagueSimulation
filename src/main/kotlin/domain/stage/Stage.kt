package domain.stage

import data.model.Fixture
import data.model.Match
import data.model.Team


interface Stage {
    fun simulate()
    fun isCompleted(): Boolean
    fun getMatches(): List<Match>
    fun generateFixtures(): Fixture
    fun getQualifiedTeams(): List<Team>
}