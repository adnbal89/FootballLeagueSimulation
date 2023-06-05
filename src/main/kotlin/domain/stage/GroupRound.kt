package domain.stage

import data.model.Fixture
import data.model.Match
import data.model.Team
import domain.runner.MatchRunner
import domain.util.Constants
import domain.util.DrawPot
import domain.util.GroupFixtureGenerator
import domain.util.GroupNames

class GroupRound : GroupStage {
    private lateinit var groups: List<Group>
    private val drawPot: DrawPot = DrawPot()
    private val matchRunner: MatchRunner = MatchRunner()
    private lateinit var fixtureGenerator: GroupFixtureGenerator

    override fun getGroups(): List<Group> {
        return groups
    }

    override fun simulateDraw(teamList: List<Team>) {
        this.groups = drawPot.simulateDraw(teamList, Constants.GROUP_COUNT, Constants.TEAM_COUNT_PER_GROUP)
    }

    override fun simulate() {
        groups.forEach { group ->
            group.getFixture().getMatches().forEach { match ->
                match.score = matchRunner.run(match).score
                group.getStanding().updateMatchResult(
                    homeTeam = match.homeTeam,
                    awayTeam = match.awayTeam,
                    homeGoals = match.score.homeGoalCount,
                    awayGoals = match.score.awayGoalCount
                )
            }
        }
    }

    override fun isCompleted(): Boolean {
        var isCompleted = true

        //check if every team has played max matches in its group
        groups.forEach { group ->
            group.getStanding().getTeamStandings().forEach { teamStanding ->
                isCompleted = (teamStanding.playedMatchesCount < (Constants.TEAM_COUNT_PER_GROUP - 1) * 2)
            }
        }
        return isCompleted
    }

    override fun getMatches(): List<Match> {
        val matchList = arrayListOf<Match>()
        groups.forEach {
            matchList.addAll(it.getFixture().getMatches())
        }
        return matchList
    }

    override fun generateGroupFixtures() {
        fixtureGenerator = GroupFixtureGenerator()

        groups.forEach {
            val teams = it.getTeams()
            val fixture = fixtureGenerator.generateFixture(teams)
            it.setFixture(fixture)
        }
    }

    override fun getQualifiedTeams(): List<Team> {
        val qualifiedTeams = arrayListOf<Team>()
        groups.forEach { group ->
            group.getStanding().getTeamStandings().take(2).forEach { teamStanding ->
                qualifiedTeams.add(teamStanding.team)
            }
        }

        return qualifiedTeams
    }

    override fun getFixtureByGroupName(groupName: String): Fixture {
        return groups.first { it.name == groupName }.getFixture()
    }

    override fun getMatchesByGroup(groupName: GroupNames): List<Match> {
        return groups.first { it.name == groupName.name }.getFixture().getMatches()
    }
}