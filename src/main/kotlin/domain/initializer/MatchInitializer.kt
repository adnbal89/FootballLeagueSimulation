package domain.initializer

import domain.stage.Group
import data.model.Match
import data.model.Team
import java.time.LocalDateTime

class MatchInitializer(
    private val homeTeam: Team,
    private val awayTeam: Team,
    private val dateTime: LocalDateTime,
    private val group: Group
) : Initializer<Match> {
    override fun initialize(name: String): Match {
        return Match(homeTeam, awayTeam, dateTime)
    }
}