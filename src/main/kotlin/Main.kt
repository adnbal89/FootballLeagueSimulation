import data.model.*
import domain.date.DateAdvancer
import domain.initializer.FixtureInitializer
import domain.initializer.GroupInitializer
import domain.runner.MatchRunner
import java.util.*

fun main() {
    val dateAdvancer = DateAdvancer(Calendar.getInstance().time)

    println(dateAdvancer.advanceDate(2))

    //TEAM
    val teamList = arrayListOf(
        Team("Galatasaray", "TR", "GSR", Stadium("ASY", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Real Madrid", "ESP", "RMA", Stadium("ASY", "MAD", 50000), arrayListOf(), hashMapOf()),
        Team("Man City", "ENG", "MAC", Stadium("ASY", "MAN", 50000), arrayListOf(), hashMapOf()),
        Team("Man Utd", "ENG", "MAN", Stadium("ASY", "MAN", 50000), arrayListOf(), hashMapOf()),
        Team("Liverpool", "ENG", "LIV", Stadium("ASY", "LIV", 50000), arrayListOf(), hashMapOf()),
        Team("Inter", "IT", "INT", Stadium("ASY", "MIL", 50000), arrayListOf(), hashMapOf()),
        Team("Milan", "IT", "MIL", Stadium("ASY", "MIL", 50000), arrayListOf(), hashMapOf()),
        Team("Basel", "SUI", "BAS", Stadium("ASY", "BAS", 50000), arrayListOf(), hashMapOf()),
        Team("Bayern FC", "GER", "BAY", Stadium("ASY", "MUN", 50000), arrayListOf(), hashMapOf()),
        Team("B Dortmund", "GER", "BOR", Stadium("DOR", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Chelsea", "ENG", "CHE", Stadium("ASY", "CHE", 50000), arrayListOf(), hashMapOf()),
        Team("Juventus", "IT", "JUV", Stadium("ASY", "TOR", 50000), arrayListOf(), hashMapOf()),
        Team("Beşiktaş", "TR", "BJK", Stadium("ASY", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Porto", "POR", "POR", Stadium("ASY", "POR", 50000), arrayListOf(), hashMapOf()),
        Team("Leipzig", "GER", "LEI", Stadium("ASY", "LEI", 50000), arrayListOf(), hashMapOf()),
        Team("Ajax", "NED", "AJX", Stadium("ASY", "AMS", 50000), arrayListOf(), hashMapOf()),
        Team("Feyenoord", "NED", "FEY", Stadium("ASY", "ROT", 50000), arrayListOf(), hashMapOf()),
        Team("Club Brugge", "BEL", "CBU", Stadium("ASY", "BRU", 50000), arrayListOf(), hashMapOf()),
        Team("PSGermain", "PSG", "PSG", Stadium("PAR", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Lyon", "TR", "LYO", Stadium("ASY", "LYO", 50000), arrayListOf(), hashMapOf()),
    )

    //GROUP
    val groupInitializer = GroupInitializer(teamList, 4)
    val groupList = groupInitializer.initialize()

    println(groupInitializer.initialize().iterator().forEach { group ->
        println(group.name)
        group.getTeams().forEach { team ->
            println(team.name)
        }
        println()
    })


    //FIXTURE
    val fixtureInitializer = FixtureInitializer(groupList)
    val fixture = fixtureInitializer.initialize()

    fixture.getMatches().groupBy {
        it.group
    }.forEach { (t, u) ->
        println(t.name)
        u.forEach {
            print("${it.homeTeam.name} - ${it.awayTeam.name}")
            println()
        }
        println()
    }

    // STANDING
    var standingList = arrayListOf<Standing>()

    groupList.forEach { group ->
        val standing = Standing(group)
        group.getTeams().forEach { team ->
            standing.addTeam(team)
        }
        standingList.add(standing)
    }


    //Match Runner
    val matchRunner = MatchRunner()
    fixture.getMatches().forEach {
        it.score = matchRunner.run(it).score
        standingList.first { st ->
            st.group == it.group
        }.updateMatchResult(it.homeTeam, it.awayTeam, it.score.homeGoalCount, it.score.awayGoalCount)
    }

    fixture.getMatches().forEach {
        println("${it.homeTeam.name} : ${it.score.homeGoalCount} - ${it.awayTeam.name} : ${it.score.awayGoalCount}  ")
    }


    standingList.forEach {
        println(it.group.name)
        it.getTeamStandings().forEach { ts ->
            println("${ts.team.nameShort}  -  ${ts.playedMatchesCount} - ${ts.winCount} - ${ts.drawCount} - ${ts.lostCount} - ${ts.forGoalsCount} - ${ts.againstGoalsCount} - ${ts.goalDifference} - ${ts.points}")
        }
        println()
    }


}
