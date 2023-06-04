package domain.stage

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator
import data.model.Fixture
import data.model.Match
import data.model.Team
import domain.runner.MatchRunner
import domain.util.Constants
import domain.util.DrawPot
import domain.util.GroupFixtureGenerator
import domain.util.GroupNames
import java.util.*

class GroupRound : GroupStage {
    private lateinit var groups: List<Group>
    private val drawPot: DrawPot
    private val matchRunner: MatchRunner
    private lateinit var fixtureGenerator: GroupFixtureGenerator
    private lateinit var groupStageFixture: Fixture

    init {
        drawPot = DrawPot()
        matchRunner = MatchRunner()
    }

    override fun getGroups(): List<Group> {
        return groups
    }

    override fun updateStandings() {
        TODO("Not yet implemented")
    }


    override fun simulateDraw(teamList: List<Team>) {
        this.groups = drawPot.simulateDraw(teamList, Constants.GROUP_COUNT, Constants.TEAM_COUNT_PER_GROUP)
    }

    override fun simulate() {
    }

    override fun isCompleted(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getMatches(): List<Match> {
        TODO("Not yet implemented")
    }

    override fun generateFixtures() {
        fixtureGenerator = GroupFixtureGenerator()

        groups.forEach {
            val teams = it.getTeams()
            val fixture = fixtureGenerator.generateFixture(teams)
            it.setFixture(fixture)
        }
    }

    override fun getQualifiedTeams(): List<Team> {
        TODO("Not yet implemented")
    }

    override fun getFixtureByGroupName(groupName: String): Fixture {
        val groupStageFixture = groups.first {
            it.name == groupName
        }.getFixture()

        return groupStageFixture
    }
}