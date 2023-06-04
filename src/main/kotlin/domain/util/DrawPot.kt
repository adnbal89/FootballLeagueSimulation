package domain.util

import data.model.Team

class DrawPot {
    fun simulateDraw(teamList: List<Team>, groupCount: Int, teamCountPerGroup: Int): Map<GroupNames, List<Team>> {
        val groupTeamMap = HashMap<GroupNames, List<Team>>()

        val tempTeamList = teamList.toMutableList()

            GroupNames.values().take(groupCount).forEach { groupName ->
                val drawnTeamList = mutableListOf<Team>()
                for (i in 0 until teamCountPerGroup) {
                    val pickedTeam = tempTeamList.random()
                    drawnTeamList.add(pickedTeam)
                    //to ensure singularity.
                    tempTeamList.remove(pickedTeam)
                }

                groupTeamMap[groupName] = drawnTeamList
            }


        return groupTeamMap
    }

}