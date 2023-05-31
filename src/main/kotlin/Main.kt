import data.model.Group
import data.model.Team
import domain.date.DateAdvancer
import domain.initializer.GroupInitializer
import domain.runner.MatchRunner
import domain.util.Constants
import domain.util.GroupNames
import java.util.*

fun main() {
    val groupCount = 5

    val dateAdvancer = DateAdvancer(Calendar.getInstance().time)
    println(dateAdvancer.advanceDate(2))
    val matchRunner = MatchRunner()

    var tempTeamList = Team.teamList.toMutableList()

    val groupInitializer = GroupInitializer()
    val groupList = mutableListOf<Group>()

    //GROUP CREATION
    GroupNames.values().take(Constants.GROUP_COUNT).forEach {
        groupInitializer.setTeamList(tempTeamList.take(4))
        val group = groupInitializer.initialize(it.name)
        groupList.add(group)
        tempTeamList.removeAll(tempTeamList.take(4))
    }


    //GROUP TEAM OVERVIEW
    println(groupList.forEach { group ->
        println()
        println(group.name)
        group.getTeams().forEach { team ->
            println(team.name)
        }
    })


    //GROUP STANDING OVERVIEW
    groupList.forEach {
        println()
        println(it.name)
        it.getStanding().getTeamStandings().forEach { ts ->
            println("${ts.team.nameShort}  -  ${ts.playedMatchesCount} - ${ts.winCount} - ${ts.drawCount} - ${ts.lostCount} - ${ts.forGoalsCount} - ${ts.againstGoalsCount} - ${ts.goalDifference} - ${ts.points}")

        }
    }

    groupList.forEach { group ->
        println()
        println(group.name)
        group.getFixture().getMatches().forEach {
            println("${it.homeTeam.name} - ${it.awayTeam.name} ")
        }
    }

    groupList.forEach { group ->
        group.getFixture().getMatches().forEach { match ->
            match.score = matchRunner.run(match).score
            group.getStanding()
                .updateMatchResult(match.homeTeam, match.awayTeam, match.score.homeGoalCount, match.score.awayGoalCount)
        }
    }

    //GROUP STANDING OVERVIEW AFTER MATCHES PLAYED
    groupList.forEach {
        println()
        println(it.name)
        it.getStanding().getTeamStandings().forEach { ts ->
            println("${ts.team.nameShort}  -  ${ts.playedMatchesCount} - ${ts.winCount} - ${ts.drawCount} - ${ts.lostCount} - ${ts.forGoalsCount} - ${ts.againstGoalsCount} - ${ts.goalDifference} - ${ts.points}")

        }
    }


}
