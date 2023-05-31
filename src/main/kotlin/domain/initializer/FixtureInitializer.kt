package domain.initializer

import data.model.Fixture
import data.model.Match

class FixtureInitializer(
    private val matchList: List<Match>,
) : Initializer<Fixture> {
    private lateinit var fixture: Fixture
    override fun initialize(name: String): Fixture {
        fixture = Fixture()

        matchList.forEach { match ->
            fixture.addMatch(match)
        }

        return fixture
    }
}


/*
group.getTeams().forEachIndexed { index1, team1 ->
    group.getTeams().forEachIndexed { index2, team2 ->
        if (team1 != team2) {
            val match = Match(team1, team2, LocalDateTime.now(), Score(), group)
            fixture.addMatch(match)
        }
    }
}*/
