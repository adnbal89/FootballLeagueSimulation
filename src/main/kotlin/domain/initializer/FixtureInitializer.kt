package domain.initializer

import data.model.Fixture
import data.model.Group
import data.model.Match
import data.model.Score
import java.time.LocalDateTime

class FixtureInitializer(
    private val groupList: List<Group>,
) : Initializer<Fixture> {
    private lateinit var fixture: Fixture
    override fun initialize(): Fixture {
        fixture = Fixture()

        groupList.forEach { group ->
            group.getTeams().forEachIndexed { index1, team1 ->
                group.getTeams().forEachIndexed { index2, team2 ->
                    if (team1 != team2) {
                        val match = Match(team1, team2, LocalDateTime.now(), Score())
                        fixture.addMatch(match)
                    }
                }
            }
        }
        return fixture
    }
}