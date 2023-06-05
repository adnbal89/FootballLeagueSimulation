package data.model

import domain.stage.Group
import domain.util.QualifyingNames

class League(
    private val name: String,
    private var level: Enum<LeagueLevel>
) {
    private val groupList: MutableList<Group> = mutableListOf()
    private val qualifyingLast16Stage: QualifyingStage = QualifyingStage(QualifyingNames.Last16.name)
    private val qualifyingQuarterFinalStage: QualifyingStage = QualifyingStage(QualifyingNames.QuarterFinal.name)
    private val qualifyingSemiFinalStage: QualifyingStage = QualifyingStage(QualifyingNames.SemiFinal.name)
    private val qualifyingFinalStage: QualifyingStage = QualifyingStage(QualifyingNames.Final.name)


    fun addGroup(group: Group) {
        groupList.add(group)
    }

    fun removeGroup(group: Group) {
        groupList.remove(group)
    }
}
