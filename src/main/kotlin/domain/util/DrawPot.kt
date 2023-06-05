package domain.util

import data.model.Standing
import data.model.Team
import domain.stage.Group

class DrawPot {
    fun simulateDraw(teamList: List<Team>, groupCount: Int, teamCountPerGroup: Int): List<Group> {
        val groupList = mutableListOf<Group>()
        val tempTeamList = teamList.toMutableList()

        GroupNames.values().take(groupCount).forEach { groupName ->
            val group = Group(name = groupName.name)
            val groupStanding = Standing()

            for (i in 0 until teamCountPerGroup) {
                val pickedTeam = tempTeamList.random()
                group.addTeam(pickedTeam)
                groupStanding.addTeam(pickedTeam)
                //to ensure singularity.
                tempTeamList.remove(pickedTeam)
            }
            group.setStanding(groupStanding)
            groupList.add(group)
        }

        return groupList
    }

}