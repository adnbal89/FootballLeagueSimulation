package data.model

import java.time.LocalDateTime

data class Match(
    val homeTeam: Team,
    val awayTeam: Team,
    val date: LocalDateTime,
    var score: Score = Score(),
    var group: Group
) {
    val stadium: Stadium = homeTeam.stadium
}
