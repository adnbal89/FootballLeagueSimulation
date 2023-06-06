import data.model.Team
import domain.draw.GroupDrawPot
import domain.draw.KnockoutDrawPot
import domain.generator.GroupFixtureGenerator
import domain.league.ChampionsLeague
import domain.runner.MatchRunner
import domain.stage.GroupRound
import domain.stage.PlayOffRound
import domain.util.Constants
import domain.util.GroupNames
import domain.util.QualifyingNames

fun main() {
    val tempTeamList = Team.teamList.toMutableList()
    val championsLeague = ChampionsLeague()
    val fixtureGenerator = GroupFixtureGenerator()
    val matchRunner = MatchRunner()
    val drawPot = GroupDrawPot()

    val groupStage = GroupRound(fixtureGenerator, matchRunner, drawPot)
    groupStage.simulateDraw(tempTeamList)
    groupStage.generateGroupFixtures()


    groupStage.getGroups().forEach { group ->
        println(group.name)
        group.getFixture().getMatches().forEach { match ->
            println("${match.homeTeam.name} - ${match.awayTeam.name}")
        }
    }

    println()
    groupStage.getFixtureByGroupName(GroupNames.B.name).getMatches().forEach {
        println(it.homeTeam.name + " - " + it.awayTeam.name)
    }

    println()

    groupStage.simulate()
    groupStage.getQualifiedTeams().forEach {
        println(it.name)
    }

    val playOffRound = PlayOffRound()
    playOffRound.drawKnockoutPairings(
        groupStage.getQualifiedTeams(),
        Constants.KNOCKOUT_LAST16_PAIR_COUNT,
        Constants.TEAM_COUNT_PER_KNOCKOUT
    )
    playOffRound.generateKnockoutFixtures(isFinalStage = false)
    println()

    playOffRound.getMatches().forEach {
        println(it.homeTeam.name + " - " + it.awayTeam.name)
    }
    playOffRound.simulate()
    println()
    playOffRound.getQualifiedTeams().forEach {
        println(it.name)
    }

    println()

    val playOffRoundQuarterFinal = PlayOffRound()
    playOffRoundQuarterFinal.drawKnockoutPairings(
        playOffRound.getQualifiedTeams(),
        Constants.KNOCKOUT_QUARTER_FINAL_PAIR_COUNT,
        Constants.TEAM_COUNT_PER_KNOCKOUT
    )
    playOffRoundQuarterFinal.generateKnockoutFixtures(isFinalStage = false)
    println()
    playOffRoundQuarterFinal.getMatches().forEach {
        println(it.homeTeam.name + " - " + it.awayTeam.name)
    }
    playOffRoundQuarterFinal.simulate()
    println()
    playOffRoundQuarterFinal.getQualifiedTeams().forEach {
        println(it.name)
    }


    val playOffRoundSemiFinal = PlayOffRound()
    playOffRoundSemiFinal.drawKnockoutPairings(
        playOffRoundQuarterFinal.getQualifiedTeams(),
        Constants.KNOCKOUT_SEMI_FINAL_PAIR_COUNT,
        Constants.TEAM_COUNT_PER_KNOCKOUT
    )
    playOffRoundSemiFinal.generateKnockoutFixtures(isFinalStage = false)
    println()
    playOffRoundSemiFinal.getMatches().forEach {
        println(it.homeTeam.name + " - " + it.awayTeam.name)
    }
    playOffRoundSemiFinal.simulate()
    println()
    playOffRoundSemiFinal.getQualifiedTeams().forEach {
        println(it.name)
    }

    val playOffFinal = PlayOffRound()
    playOffFinal.drawKnockoutPairings(
        playOffRoundSemiFinal.getQualifiedTeams(),
        Constants.KNOCKOUT_FINAL_PAIR_COUNT,
        Constants.TEAM_COUNT_PER_KNOCKOUT
    )
    playOffFinal.generateKnockoutFixtures(isFinalStage = true)
    println()
    playOffFinal.getMatches().forEach {
        println(it.homeTeam.name + " - " + it.awayTeam.name)
    }
    playOffFinal.simulate()
    println()
    playOffFinal.getMatches().forEach {
        println(it.score)
    }
}
