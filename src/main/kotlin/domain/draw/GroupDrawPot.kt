package domain.draw

import data.model.Standing
import data.model.Team
import domain.stage.Group
import domain.util.GroupNames


class GroupDrawPot : DrawPot<Group> {
        override fun simulateDraw(teamList: List<Team>, potCount: Int, teamCountPerPot: Int): List<Group> {
            val groupList = mutableListOf<Group>()
            val tempTeamList = teamList.toMutableList()

            GroupNames.values().take(potCount).forEach { groupName ->
                val group = Group(name = groupName.name)
                val groupStanding = Standing()

                for (i in 0 until teamCountPerPot) {
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