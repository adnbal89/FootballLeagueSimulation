package domain.stage

import data.model.Fixture
import data.model.Match
import data.model.Team
import domain.draw.DrawPot
import domain.runner.MatchRunner
import domain.util.Constants
import domain.generator.GroupFixtureGenerator
import domain.util.GroupNames

class GroupRound(
    private val matchRunner: MatchRunner,
    private val drawPot: DrawPot<Group>
) : GroupStage {
    private lateinit var groups: List<Group>

    override fun getGroups(): List<Group> {
        return groups
    }

    override fun simulateDraw(teamList: List<Team>) {
        this.groups =
            drawPot.simulateDraw(teamList, Constants.GROUP_COUNT, Constants.TEAM_COUNT_PER_GROUP)
    }

    override fun simulate() {
        groups.forEach { group ->
            group.getFixture().getMatches().forEach { match ->
                match.score = matchRunner.run(match).score
                group.getStanding().updateStandingByMatchScore(
                    match = match
                )
            }
        }
    }

    override fun isCompleted(): Boolean {
        var isCompleted = true

        //check if every team has played max num of matches in its group
        groups.forEach { group ->
            group.getStanding().getTeamStandings().forEach { teamStanding ->
                isCompleted = (teamStanding.playedMatchesCount < (Constants.TEAM_COUNT_PER_GROUP - 1) * 2)
            }
        }
        return isCompleted
    }

}