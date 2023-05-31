package data.model

import domain.util.GroupNames

class League {
    private lateinit var name: String
    private lateinit var level: Enum<LeagueLevel>
    private val groupList: MutableList<Group> = mutableListOf()


    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getLevel(): String {
        return level.name
    }

    fun setLevel(level: LeagueLevel) {
        this.level = level
    }

    fun addGroup(group: Group) {
        groupList.forEach { group ->
            GroupNames.values().forEach { groupName ->
                group.getGroupName()
            }

        }
        groupList.add(group)
    }

    fun removeGroup(group: Group) {
        groupList.remove(group)
    }
}
