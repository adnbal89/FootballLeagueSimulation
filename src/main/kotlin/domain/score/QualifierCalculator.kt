package domain.score

import data.model.Match
import data.model.Team

class QualifierCalculator {

    fun calculateQualifiedTeam(matchList: List<Match>): Team {
        val firstTeam = matchList[0].homeTeam
        val secondTeam = matchList[0].awayTeam

        var firstTeamTotalGoals = 0
        var secondTeamTotalGoals = 0

        firstTeamTotalGoals = matchList[0].score.homeGoalCount + matchList[1].score.awayGoalCount
        secondTeamTotalGoals = matchList[0].score.awayGoalCount + matchList[1].score.homeGoalCount


        return if (firstTeamTotalGoals >= secondTeamTotalGoals) {
            return firstTeam
        } else
            return secondTeam

    }


}