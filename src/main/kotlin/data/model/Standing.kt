package data.model

class Standing {
    private val teamStandings: MutableList<TeamStanding> = mutableListOf()

    fun addTeam(team: Team) {
        val teamStanding = TeamStanding(team)
        teamStandings.add(teamStanding)
    }

    private fun findTeamStanding(team: Team): TeamStanding {
        return teamStandings.first {
            it.team == team
        }
    }

    fun getTeamStandings(): List<TeamStanding> {
        return teamStandings.sortedByDescending {
            it.points
        }
    }

    fun updateStandingByMatchScore(match: Match) {
        val homeTeamStanding = findTeamStanding(match.homeTeam)
        val awayTeamStanding = findTeamStanding(match.awayTeam)
        val homeGoals = match.score.homeGoalCount
        val awayGoals = match.score.awayGoalCount

        homeTeamStanding.playedMatchesCount++
        awayTeamStanding.playedMatchesCount++

        if (homeGoals > awayGoals) {
            homeTeamStanding.winCount++
            awayTeamStanding.lostCount++

        } else if (awayGoals > homeGoals) {
            homeTeamStanding.lostCount++
            awayTeamStanding.winCount++

        } else {
            homeTeamStanding.drawCount++
            awayTeamStanding.drawCount++

        }

        homeTeamStanding.forGoalsCount += homeGoals
        homeTeamStanding.againstGoalsCount += awayGoals

        awayTeamStanding.forGoalsCount += awayGoals
        awayTeamStanding.againstGoalsCount += homeGoals
    }

}

