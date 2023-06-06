package domain.generator

import data.model.Fixture
import data.model.Match
import data.model.Score
import data.model.Team
import java.time.LocalDateTime

class GroupFixtureGenerator : FixtureGenerator {
    private lateinit var fixture: Fixture
    override fun generateFixture(list: List<Team>, isFinalStage :Boolean): Fixture {
        fixture = Fixture()

        list.forEachIndexed { index1, team1 ->
            list.forEachIndexed { index2, team2 ->
                if (team1 != team2) {
                    val match = Match(team1, team2, LocalDateTime.now(), Score())
                    fixture.addMatch(match)
                }
            }
        }
        return fixture
    }
}