package domain.stage

import data.model.Fixture
import data.model.Match
import data.model.Team
import domain.util.Constants
import domain.util.DrawPot
import domain.util.GroupNames
import java.util.*

class GroupRound : GroupStage {
    private var groups: Map<GroupNames, List<Team>>
    private val drawPot: DrawPot

    init {
        groups = EnumMap(GroupNames::class.java)
        drawPot = DrawPot()
    }

    override fun getGroups(): Map<GroupNames, List<Team>> {
        return groups
    }

    override fun updateStandings() {
        TODO("Not yet implemented")
    }

    override fun simulateDraw(teamList: List<Team>) {
        this.groups = drawPot.simulateDraw(teamList, Constants.GROUP_COUNT, Constants.TEAM_COUNT_PER_GROUP)
    }

    override fun simulate() {
        TODO("Not yet implemented")
    }

    override fun isCompleted(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getMatches(): List<Match> {
        TODO("Not yet implemented")
    }

    override fun generateFixtures(): Fixture {
        TODO("Not yet implemented")
    }

    override fun getQualifiedTeams(): List<Team> {
        TODO("Not yet implemented")
    }
}