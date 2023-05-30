package domain.initializer

import data.model.Group
import data.model.Team

class GroupInitializer(private val teamList: List<Team>, private val teamCountPerGroup: Int) :
    Initializer<List<Group>> {

    override fun initialize(): List<Group> {
        var tempTeamList = teamList.toMutableList()

        val groupNamesList = GroupNames.values().take(teamList.size.div(teamCountPerGroup))
        val groupList = mutableListOf<Group>()

        groupNamesList.forEach {
            var group = Group(it.toString())

            while (group.getTeams().size < teamCountPerGroup) {
                val randomTeam = tempTeamList.random()
                group.addTeam(randomTeam)
                tempTeamList.remove(randomTeam)
            }
            groupList.add(group)
        }

        return groupList
    }
}

enum class GroupNames {
    A, B, C, D, E, F, G, H, I, J, K, L
}


