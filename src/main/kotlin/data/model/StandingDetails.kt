package data.model

data class Result(
    val playedMatchesCount: Int,
    val winCount: Int,
    val drawCount: Int,
    val lostCount: Int,
    val forGoalsCount: Int,
    val againstGoalsCount: Int,
    val goalDifference: Int,
    val points: Int
)