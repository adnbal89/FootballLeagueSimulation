import data.model.Group
import data.model.Stadium
import data.model.Team
import domain.date.DateAdvancer
import domain.initializer.FixtureInitializer
import domain.initializer.GroupInitializer
import java.util.*

fun main() {
    val dateAdvancer = DateAdvancer(Calendar.getInstance().time)

    println(dateAdvancer.advanceDate(2))
    val teamList = arrayListOf(
        Team("Galatasaray", "TR", "GS", Stadium("ASY", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Real Madrid", "ESP", "RM", Stadium("ASY", "MAD", 50000), arrayListOf(), hashMapOf()),
        Team("Man City", "ENG", "MC", Stadium("ASY", "MAN", 50000), arrayListOf(), hashMapOf()),
        Team("Man Utd", "ENG", "MU", Stadium("ASY", "MAN", 50000), arrayListOf(), hashMapOf()),
        Team("Liverpool", "ENG", "LIV", Stadium("ASY", "LIV", 50000), arrayListOf(), hashMapOf()),
        Team("Inter", "IT", "INT", Stadium("ASY", "MIL", 50000), arrayListOf(), hashMapOf()),
        Team("Milan", "IT", "MIL", Stadium("ASY", "MIL", 50000), arrayListOf(), hashMapOf()),
        Team("Basel", "SUI", "BAS", Stadium("ASY", "BAS", 50000), arrayListOf(), hashMapOf()),
        Team("Bayern FC", "GER", "BAY", Stadium("ASY", "MUN", 50000), arrayListOf(), hashMapOf()),
        Team("Borussia Dortmund", "GER", "BOR", Stadium("DOR", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Chelsea", "ENG", "CHE", Stadium("ASY", "CHE", 50000), arrayListOf(), hashMapOf()),
        Team("Juventus", "IT", "JUV", Stadium("ASY", "TOR", 50000), arrayListOf(), hashMapOf()),
        Team("Beşiktaş", "TR", "BJK", Stadium("ASY", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Porto", "POR", "POR", Stadium("ASY", "POR", 50000), arrayListOf(), hashMapOf()),
        Team("Leipzig", "GER", "LEI", Stadium("ASY", "LEI", 50000), arrayListOf(), hashMapOf()),
        Team("Ajax", "NED", "AJX", Stadium("ASY", "AMS", 50000), arrayListOf(), hashMapOf()),
        Team("Feyenoord", "NED", "FEY", Stadium("ASY", "ROT", 50000), arrayListOf(), hashMapOf()),
        Team("Club Brugge", "BEL", "CBU", Stadium("ASY", "BRU", 50000), arrayListOf(), hashMapOf()),
        Team("Paris Saint Germain", "PSG", "GS", Stadium("PAR", "IST", 50000), arrayListOf(), hashMapOf()),
        Team("Lyon", "TR", "LYO", Stadium("ASY", "LYO", 50000), arrayListOf(), hashMapOf()),
    )

    var groupA = Group("A")
    var groupB = Group("B")
    var groupC = Group("C")
    var groupD = Group("D")
    var groupE = Group("E")

    val groupList = arrayListOf<Group>(groupA, groupB, groupC, groupD, groupE)
    val groupInitializer = GroupInitializer(teamList, 4)
    
    println(groupInitializer.initialize().iterator().forEach { group ->
        group.getTeams().forEach {
            println("group " + group.name + " " + it)
        }
    })

    val fixtureInitializer = FixtureInitializer(groupList)

    fixtureInitializer.initialize().getMatches().iterator().forEach {
        print("${it.homeTeam.name} - ${it.awayTeam.name}")
        println()
    }

}