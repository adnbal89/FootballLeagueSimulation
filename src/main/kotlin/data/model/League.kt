package data.model

import domain.stage.Group
import domain.util.GroupNames
import domain.util.QualifyingNames

class League {
    private lateinit var name: String
    private lateinit var level: Enum<LeagueLevel>
    private val groupList: MutableList<Group> = mutableListOf()
    private val qualifyingLast16Stage: QualifyingStage = QualifyingStage(QualifyingNames.Last_16.name)
    private val qualifyingQuarterFinalStage: QualifyingStage = QualifyingStage(QualifyingNames.Quarter_Final.name)
    private val qualifyingSemiFinalStage: QualifyingStage = QualifyingStage(QualifyingNames.Semi_Final.name)
    private val qualifyingFinalStage: QualifyingStage = QualifyingStage(QualifyingNames.Final.name)


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
