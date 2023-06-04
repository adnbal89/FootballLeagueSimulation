package domain.initializer

import data.model.Match
import data.model.Team
import domain.stage.Group
import java.time.LocalDateTime

class MatchInitializer(
    private val homeTeam: Team,
    private val awayTeam: Team,
    private val dateTime: LocalDateTime,
) : Initializer<Match> {
    override fun initialize(name: String): Match {
        return Match(homeTeam, awayTeam, dateTime)
    }
}