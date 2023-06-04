import data.model.Team
import domain.stage.GroupRound
import domain.util.DrawPot

fun main() {
    var tempTeamList = Team.teamList.toMutableList()
    val groupStage = GroupRound()
    groupStage.simulateDraw(tempTeamList)
    groupStage.generateFixtures()


    groupStage.getGroups().forEach {group ->
        println(group.name)
        group.getFixture().getMatches().forEach { match ->
            println("${match.homeTeam.name} - ${match.awayTeam.name}")
        }
    }





    /*val groupCount = 5

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


    //GROUP STANDING OVERVIEW BEFORE MATCHES PLAYED
    groupList.forEach {
        println()
        println(it.name)
        it.getStanding().getTeamStandings().forEach { ts ->
            println("${ts.team.nameShort}  -  ${ts.playedMatchesCount} - ${ts.winCount} - ${ts.drawCount} - ${ts.lostCount} - ${ts.forGoalsCount} - ${ts.againstGoalsCount} - ${ts.goalDifference} - ${ts.points}")

        }
    }

    //GROUP FIXTURE OVERVIEW
    groupList.forEach { group ->
        println()
        println(group.name)
        group.getFixture().getMatches().forEach {
            println("${it.homeTeam.name} - ${it.awayTeam.name} ")
        }
    }

    //GROUP MATCHES RUNNING
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


    //ON TO QUALIFYING STAGE
    val last16QualifiersList = mutableListOf<Team>()
    val QuarterFİnalQualifiersList = mutableListOf<Team>()
    val SemiFinalQualifiersList = mutableListOf<Team>()
    val FinalQualifiersList = mutableListOf<Team>()

    groupList.forEach { group ->
        val qualifiedTeam1 = group.getStanding().getTeamStandings()[0].team
        val qualifiedTeam2 = group.getStanding().getTeamStandings()[1].team

        last16QualifiersList.add(qualifiedTeam1)
        last16QualifiersList.add(qualifiedTeam2)
    }
    println()
    println("Qualifiers")
    last16QualifiersList.forEach {
        println(it.name)
    }

    val qualifyingInitializer = QualifyingInitializer()
    qualifyingInitializer.setTeamList(last16QualifiersList)
    val qualifyingStage = qualifyingInitializer.initialize(QualifyingNames.Last_16.name)

    println()
    println(qualifyingStage.getStageName())
    qualifyingStage.getFixture().getMatches().forEach {
        println(" ${it.homeTeam.name}  -  ${it.awayTeam.name}")

    }

    groupList.forEach { group ->
        qualifyingStage.getFixture().getMatches().forEach { match ->
            match.score = matchRunner.run(match).score
        }
    }

    println()
    println("Scores")

    var tempQualifierMatches = qualifyingStage.getFixture().getMatches().toMutableList()
    val qualifierCalculator = QualifierCalculator()
    var qualifiedTeams = mutableListOf<Team>()

    while (tempQualifierMatches.isNotEmpty()) {

        qualifiedTeams.add(qualifierCalculator.calculateQualifiedTeam(tempQualifierMatches.take(2)))
        tempQualifierMatches.removeAll(tempQualifierMatches.take(2))
    }

    qualifyingStage.getFixture().getMatches().forEach { match ->
        println("${match.homeTeam.name} - ${match.awayTeam.name} : ${match.score.homeGoalCount} - ${match.score.awayGoalCount}")
    }

    println()
    println("Qualified to Quarter Finals")
    qualifiedTeams.forEach { team ->
        println("${team.name} ")

    }

*/
}
