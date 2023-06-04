package domain.stage

import data.model.Team
import domain.util.GroupNames

interface GroupStage : Stage {
    fun getGroups(): Map<GroupNames, List<Team>>
    fun updateStandings()
    fun simulateDraw(teamList: List<Team>) // draw simulation

}