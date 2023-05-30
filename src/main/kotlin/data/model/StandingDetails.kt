package data.model

data class StandingDetails(
    val playedMatchesCount: Int = 0,
    val winCount: Int = 0,
    val drawCount: Int = 0,
    val lostCount: Int = 0,
    val forGoalsCount: Int = 0,
    val againstGoalsCount: Int = 0,
    val goalDifference: Int = 0,
    var points: Int = 0
) {
    fun calculatePoints() {
        points = winCount * 3 + drawCount
    }
}