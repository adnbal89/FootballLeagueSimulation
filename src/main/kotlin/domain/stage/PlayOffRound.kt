package domain.stage

import data.model.Match
import data.model.QualificationPairing
import data.model.Team
import domain.draw.DrawPot
import domain.draw.KnockoutDrawPot
import domain.generator.KnockoutFixtureGenerator
import domain.runner.MatchRunner
import domain.util.Constants

class PlayOffRound : KnockoutStage {
    private lateinit var pairings: List<QualificationPairing>
    private lateinit var drawPot: DrawPot<QualificationPairing>
    private val matchRunner: MatchRunner = MatchRunner()
    private lateinit var fixtureGenerator: KnockoutFixtureGenerator


    override fun drawKnockoutPairings(teamList: List<Team>,pairCount: Int, teamCountPerKnockout: Int) {
        drawPot = KnockoutDrawPot()
        this.pairings =
            drawPot.simulateDraw(teamList, pairCount, teamCountPerKnockout)
    }

    override fun simulateExtraTimeAndPenalties() {
        TODO("Not yet implemented")
    }

    override fun generateKnockoutFixtures(isFinalStage : Boolean) {
        fixtureGenerator = KnockoutFixtureGenerator()
        pairings.forEach {
            val teams = it.getTeams()
            val fixture = fixtureGenerator.generateFixture(teams, isFinalStage)
            it.setFixture(fixture)
        }
    }

    override fun simulate() {
        pairings.forEach { pair ->
            pair.getFixture().getMatches().forEach { match ->
                match.score = matchRunner.run(match).score
            }
        }
    }

    override fun isCompleted(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getMatches(): List<Match> {
        return pairings.flatMap { it.getFixture().getMatches() }
    }

    override fun getQualifiedTeams(): List<Team> {
        val qualifiedTeams = mutableListOf<Team>()

        pairings.forEach {
            val firstTeamTotalGoals = it.getFixture().getMatches()[0].score.homeGoalCount + it.getFixture()
                .getMatches()[1].score.awayGoalCount
            val secondTeamTotalGoals = it.getFixture().getMatches()[0].score.awayGoalCount + it.getFixture()
                .getMatches()[1].score.homeGoalCount

            if (firstTeamTotalGoals > secondTeamTotalGoals) {
                qualifiedTeams.add(it.getFixture().getMatches()[0].homeTeam)
            } else if (firstTeamTotalGoals < secondTeamTotalGoals) {
                qualifiedTeams.add(it.getFixture().getMatches()[0].awayTeam)
            } else {
                //if aggregates are equal, them pick a random qualified team.
                qualifiedTeams.add(it.getFixture().getMatches().random().homeTeam)
            }
        }
        return qualifiedTeams
    }

    override fun simulateDraw(teamList: List<Team>) {
        TODO("Not yet implemented")
    }


}