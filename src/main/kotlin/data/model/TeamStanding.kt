package data.model

data class TeamStanding(
    val team: Team,
    var playedMatchesCount: Int = 0,
    var winCount: Int = 0,
    var drawCount: Int = 0,
    var lostCount: Int = 0,
    var forGoalsCount: Int = 0,
    var againstGoalsCount: Int = 0
) {
    val points: Int
        get() = winCount * 3 + drawCount

    val goalDifference: Int
        get() = forGoalsCount - againstGoalsCount
}