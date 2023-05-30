package data.model

class Standing(
    val group: Group
) {
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

    fun updateMatchResult(homeTeam: Team, awayTeam: Team, homeGoals:Int, awayGoals:Int){
        val homeTeamStanding = findTeamStanding(homeTeam)
        val awayTeamStanding = findTeamStanding(awayTeam)

        homeTeamStanding.playedMatchesCount++
        awayTeamStanding.playedMatchesCount++

        if(homeGoals > awayGoals) {
            homeTeamStanding.winCount++
            awayTeamStanding.lostCount++

        }else if(awayGoals > homeGoals){
            homeTeamStanding.lostCount++
            awayTeamStanding.winCount++

        }else {
            homeTeamStanding.drawCount++
            awayTeamStanding.drawCount++

        }

        homeTeamStanding.forGoalsCount += homeGoals
        homeTeamStanding.againstGoalsCount += awayGoals

        awayTeamStanding.forGoalsCount += awayGoals
        awayTeamStanding.againstGoalsCount += homeGoals
    }

}

