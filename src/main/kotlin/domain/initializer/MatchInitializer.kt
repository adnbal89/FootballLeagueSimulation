package domain.initializer

import data.model.Group
import data.model.Match
import data.model.Team
import java.time.LocalDateTime

class MatchInitializer(
    private val homeTeam: Team,
    private val awayTeam: Team,
    private val dateTime: LocalDateTime,
    private val group: Group
) : Initializer<Match> {
    override fun initialize(): Match {
        return Match(homeTeam, awayTeam, dateTime, group = group)
    }
}